/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.baseActions;

import DBConnection.DBConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
/**
 *
 * @author JD Morales
 */
public class UserAuthentication {
    MotorPH_String QueryString = new MotorPH_String();
    // Create a method that will determine if the user exists in the DB. If it does, return 1. Else, return 0.
    
    public List<EmpDetails> userLogin(String Email, String Password){        
        List<EmpDetails> list = new ArrayList<>();
        //JOptionPane.showMessageDialog(null, "This is the userLogin method");
        try {
            PreparedStatement ps = DBConnection.con.prepareStatement(QueryString.userLoginSearch);
            ps.setString(1, Email);
            ps.setString(2, Password);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new EmpDetails(
                        rs.getInt("Id"),
                        rs.getInt(QueryString.FirstLogin),
                        rs.getString(QueryString.designation),
                        rs.getString(QueryString.firstName),
                        rs.getString(QueryString.lastName),
                        rs.getDate(QueryString.birthDay),
                        rs.getString(QueryString.email),
                        rs.getString(QueryString.position)
                ));

            }
            
            if (!list.isEmpty()){
                 JOptionPane.showMessageDialog(null, "User Authenticated!");
                   // These EmpAttendance static fields will be accessible anywhere in the project. No need to instantiate.
                 EmpAttendance.UserID = list.get(0).getId();
                 EmpAttendance.UserFirstLogin = list.get(0).getFirstLogin();
                 EmpAttendance.UserDesignation = list.get(0).getDesignation();
                 EmpAttendance.UserFirstName = list.get(0).getFirstName();
                 EmpAttendance.UserLastName = list.get(0).getLastName();
                 EmpAttendance.UserBirthday = list.get(0).getBirthday();
                 EmpAttendance.UserEmail = list.get(0).getEmail();
                 EmpAttendance.UserPosition = list.get(0).getPosition();
                 
//                 JOptionPane.showMessageDialog(null, "User Authentication Static variables:" + EmpAttendance.UserID +
//                         "\n First Login: " + EmpAttendance.UserFirstLogin + "\n Designation: " + EmpAttendance.UserDesignation);
                 
            }
        } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "" + e);
        }    
    return list;
}
    
    public void updateDefaultPassword(String securityQuestion, String securityAnswer, String newPassword, Integer empId) {
        try {

            // Update the database with the new security question, answer, and password
            PreparedStatement updatePs = DBConnection.con.prepareStatement(QueryString.updateDefaultPassword);
            updatePs.setString(1, securityQuestion);
            updatePs.setString(2, securityAnswer);
            updatePs.setString(3, newPassword);
            // I used the EmpID instead
            updatePs.setInt(4, empId);
            //updatePs.setString(4, Bal.EmpEmail); // Assuming Bal.EmpEmail contains the email of the employee
            updatePs.executeUpdate();

            // Show success message
            JOptionPane.showMessageDialog(null, "Your security details and password have been updated successfully!");
            //updatePs.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "" + e);
        }

    }


    public int updatePassword(String newPassword, String email, String oldPassword) {
        int rowsAffected = 0;
        try {
            // Update password in the database
            //String updatePassword = "UPDATE motorphdb SET Password = ? WHERE Email = ?";
            PreparedStatement updatePs = DBConnection.con.prepareStatement(QueryString.updatePassword);
            updatePs.setString(1, newPassword);
            updatePs.setString(2, email);
            updatePs.setString(3, oldPassword);
            rowsAffected = updatePs.executeUpdate();
            //updatePs.close();
            
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "An error occurred while updating password. Please try again.");
        }
        return rowsAffected; 
    }
    
    public String forgetPassword(String securityQuestion, String securityAnswer, String email) {
        String currentPassword = null;
        try {
            //String query = "SELECT * FROM motorphdb WHERE Email = ?";
            PreparedStatement ps = DBConnection.con.prepareStatement(QueryString.searchByEmail);
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                String storedEmail = rs.getString("Email");
                String storedSecurityQuestion = rs.getString("Security Question");
                String storedSecurityAnswer = rs.getString("Security Answer");

                if (email.equals(storedEmail) && securityQuestion.equals(storedSecurityQuestion) && securityAnswer.equals(storedSecurityAnswer)) {
                    currentPassword = rs.getString("Password"); // Retrieve the current password to this value

                } else {
                    JOptionPane.showMessageDialog(null, "Security question or answer is incorrect.");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Email not found or Security question or answer is incorrect.");
            }
            //ps.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "An error occurred while retrieving password. Please try again. \n" + ex);
        }
        return currentPassword;
    }
    
    
    
}
    

