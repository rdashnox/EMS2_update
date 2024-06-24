/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.baseActions;

import DBConnection.DBConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import javax.swing.JOptionPane;
/**
 *
 * @author JD Morales
 */
public class EmpAttendance {
    MotorPH_String QueryString = new MotorPH_String();
    
    // Retrieve user info
    public static int UserID = 0;
    public static String UserFirstName = "";
    public static String UserLastName = "";
    public static Date UserBirthday;
    public static String UserEmail = "";
    public static String UserDesignation = "";
    public static int UserFirstLogin = 0;
    public static String UserPosition = "";

    public long calcMinutesWorked = 0;
    public long calcOvertimeMinutes = 0;
    public long calcUndertimeMinutes = 0;    
    

// This will be called from the Payroll Summary JFrame
public List<AttendanceTrack> getTimesheetByIDandDate(int empID, int selectedMonth, int currentYear){
    List<AttendanceTrack> listAttendance = new ArrayList<>();
    
    // Get the startOfMonth and endOfMonth for the given year
    LocalDate firstDayOfMonth = HelperClass.getFirstDayOfMonth(selectedMonth, currentYear);
    LocalDate lastDayOfMonth = HelperClass.getLastDayOfMonth(selectedMonth, currentYear);
    
        try {
            // Search by ID and Month
            PreparedStatement ps = DBConnection.con.prepareStatement(QueryString.DisplayLogInfoByIDandDate);
            ps.setInt(1, empID);
            ps.setDate(2, java.sql.Date.valueOf(firstDayOfMonth));
            ps.setDate(3,  java.sql.Date.valueOf(lastDayOfMonth));
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                listAttendance.add(new AttendanceTrack(
                        rs.getInt(QueryString.id),
                        rs.getDate(QueryString.logDate),
                        rs.getTime(QueryString.logTime),
                        rs.getString(QueryString.status)
                ));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error searching employees: " + e.getMessage());
        }
        return listAttendance;
}    

public void calculateTotalHoursWorked(List<AttendanceTrack> empTimesheet, int selectedMonth, int currentYear) {
    //long totalMillisWorked = 0;

    
    // Create an instance of the WorkHoursCalculator
    WorkHoursCalculator workHoursCalc = new WorkHoursCalculator();

    for (AttendanceTrack attendance : empTimesheet) {
        // For each Logged in record, get the corresponding Logged out record
        if (attendance.getStatus().equalsIgnoreCase("Logged in")) {
            Optional<AttendanceTrack> loggedOutRecord = empTimesheet.stream()
                    .filter(b -> b.getLogdate().equals(attendance.getLogdate()) && b.getStatus().equalsIgnoreCase("Logged out"))
                    .findFirst();

            // Only calcuate those records with both Log-in and Log-out records
            if (loggedOutRecord.isPresent()) {
                String logDate = String.valueOf(attendance.getLogdate());
                LocalDate ldLogindate = LocalDate.parse(logDate);
                //LocalDate ldLogindate = logDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                String logInTime = String.valueOf(attendance.getLogtime());
                LocalTime ltLogInTime = LocalTime.parse(logInTime);
                //LocalTime ltLogInTime = logInTime.toInstant().atZone(ZoneId.systemDefault()).toLocalTime();
                String logOutTime = String.valueOf(loggedOutRecord.get().getLogtime());
                LocalTime ltLogOutTime = LocalTime.parse(logOutTime);
                //LocalTime ltLogOutTime = logOutTime.toInstant().atZone(ZoneId.systemDefault()).toLocalTime();

                workHoursCalc.addWorkTime(ldLogindate, ltLogInTime, ltLogOutTime);
                //workHoursCalc.addWorkTime(logDate, LogInTime, LogOutTime);
            }
        }
        
        workHoursCalc.calculateMonthlyWorkHours(selectedMonth, currentYear);
        // Get the calculated values after calling the method
        calcMinutesWorked = workHoursCalc.calcMinutesWorked;
        calcOvertimeMinutes = workHoursCalc.calcOvertimeMinutes;
        calcUndertimeMinutes = workHoursCalc.calcUndertimeMinutes;
    }
}



  

    public EmpDetails retrieveUserInfo(int id) {
        EmpDetails empDetails = null;
        try (PreparedStatement ps = DBConnection.con.prepareStatement(QueryString.userSearchById)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    empDetails = new EmpDetails(
                            rs.getInt(Integer.parseInt(QueryString.id)),
                            rs.getString(QueryString.lastName),
                            rs.getString(QueryString.firstName),
                            rs.getDate(QueryString.birthDay),
                            rs.getString(QueryString.email),
                            rs.getString(QueryString.position),
                            rs.getString(QueryString.designation)
                    );
                }
                
                UserID = empDetails.getId();
                UserFirstName = empDetails.getFirstName();
                UserLastName = empDetails.getLastName();
                UserBirthday = empDetails.getBirthday();
                UserEmail = empDetails.getEmail();
                UserDesignation = empDetails.getDesignation();
                
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error in retrieving info: " + e.getMessage());
        }
        return empDetails;
    }

    public static void saveTimeInToDatabase(Date dateString, Time time) {
        
        try {
        //loadConnection();
        int id = EmpAttendance.UserID;
        String query = "INSERT INTO attendance (AttID, ID, LogDate, LogTime, Status) VALUES (NULL, ?, ?, ?, ?)";
        PreparedStatement ps = DBConnection.con.prepareStatement(query);
        ps.setInt(1, id); // Assuming ID is an integer
         ps.setDate(2, new java.sql.Date(dateString.getTime()));
        ps.setTime(3, time);// Assuming LogDate is a string
        ps.setString(4, "Logged in"); // Assuming Status is a string
        ps.executeUpdate();
        ps.close();
        JOptionPane.showMessageDialog(null, "TIME-IN time saved successfully!");
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error in saving TIME-IN time: " + e.getMessage());
    }
        
    }
    public static void saveTimeOutToDatabase(Date dateString, Time time) {
        
        try {
        //loadConnection();
        int id = EmpAttendance.UserID;
        String query = "INSERT INTO attendance (AttID, ID, LogDate, LogTime, Status) VALUES (NULL, ?, ?, ?, ?)";
        PreparedStatement ps = DBConnection.con.prepareStatement(query);
        ps.setInt(1, id); // Assuming ID is an integer
         ps.setDate(2, new java.sql.Date(dateString.getTime()));
        ps.setTime(3, time);// Assuming LogDate is a string
        ps.setString(4, "Logged out"); // Assuming Status is a string
        ps.executeUpdate();
        ps.close();
        JOptionPane.showMessageDialog(null, "TIME-OUT time saved successfully!");
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error in saving Check-OUT time: " + e.getMessage());
    }
}

    public static boolean hasCheckedIn(int value, Date dateString, Time timeString) {
        try {
        //loadConnection();
        String query = "SELECT COUNT(*) FROM attendance WHERE ID = ? AND LogDate = ? AND LogTime = ?";
        PreparedStatement ps = DBConnection.con.prepareStatement(query);
        ps.setInt(1, EmpAttendance.UserID);
         ps.setDate(2, new java.sql.Date(dateString.getTime()));
         ps.setTime(3, timeString);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            int count = rs.getInt(1);
            return count > 0;
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error in checking TIME-IN status: " + e.getMessage());
    }
    return false;
    }
    public static boolean hasCheckedOut(int value, Date dateString, Time timeString) {
        try {
        //loadConnection();
        String query = "SELECT COUNT(*) FROM attendance WHERE ID = ? AND LogDate = ? AND LogTime = ?";
        PreparedStatement ps = DBConnection.con.prepareStatement(query);
        ps.setInt(1, EmpAttendance.UserID);
        ps.setDate(2, new java.sql.Date(dateString.getTime()));
        ps.setTime(3, timeString);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            int count = rs.getInt(1);
            return count > 0;
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error in checking TIME-OUT status: " + e.getMessage());
    }
    return false;
    }
}
    

