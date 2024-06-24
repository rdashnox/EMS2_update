/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.baseActions;

import DBConnection.DBConnection;
import com.baseActions.EmpDetails;
import java.awt.HeadlessException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author JD Morales
 */

// This class will contain all of the methods needed to CREATE, READ (Search Employee), UPDATE, and DELETE employee records

public class EmpActions {
    MotorPH_String searchQuery = new MotorPH_String();

    public List<EmpDetails> loadData() {
        List<EmpDetails> list = new ArrayList<>();
        try {
            PreparedStatement ps = DBConnection.con.prepareStatement(searchQuery.loadData);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new EmpDetails(
                        //rs.getInt(Integer.parseInt(searchQuery.id)),
                        rs.getInt(searchQuery.id),
                        rs.getString(searchQuery.lastName),
                        rs.getString(searchQuery.firstName),
                        rs.getDate(searchQuery.birthDay),
                        rs.getString(searchQuery.email),                
                        rs.getString(searchQuery.password),
                        rs.getString(searchQuery.designation),
                        rs.getString(searchQuery.address),                        
                        rs.getString(searchQuery.phoneNumber),                        

                        rs.getString(searchQuery.SSS),                        
                        rs.getString(searchQuery.philHealth),                        
                        rs.getString(searchQuery.tin),                        
                        rs.getString(searchQuery.pagIbig),                        
                        
                        rs.getString(searchQuery.status),                        
                        rs.getString(searchQuery.position),                        
                        rs.getString(searchQuery.immediateSupervisor),                        
                        
                        rs.getInt(searchQuery.FirstLogin)
                ));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "" + e);
        }
        return list;
    }

    public void insertDataAddEmp(EmpDetails empDetails) {
        try {
            // Verify if the Email already exists in the DB            
            PreparedStatement verifyEmail = DBConnection.con.prepareStatement(searchQuery.searchByEmail);
            verifyEmail.setString(1, empDetails.getEmail());
            ResultSet rsExist = verifyEmail.executeQuery();            
            
            if(rsExist.next() == true){
                JOptionPane.showMessageDialog(null, "Email address is already in use. \n Provide a different one.");
            } else {
            
            PreparedStatement ps = DBConnection.con.prepareStatement(searchQuery.insertDataAddEmp);
            ps.setString(1, empDetails.getLastName());
            ps.setString(2, empDetails.getFirstName());
            ps.setObject(3, empDetails.getBirthday());
            ps.setString(4, empDetails.getEmail());
            // Since it's a new employee, set the default password.
            ps.setString(5, "abcd1234");
            ps.setString(6, empDetails.getDesignation());
            ps.setString(7, empDetails.getAddress());
            ps.setString(8, empDetails.getPhoneNumber());
            ps.setString(9, empDetails.getSSS());
            ps.setString(10, empDetails.getPhilHealth());
            ps.setString(11, empDetails.getTIN());
            ps.setString(12, empDetails.getPagIbig());
            ps.setString(13, empDetails.getSatus());
            ps.setString(14, empDetails.getPosition());
            ps.setString(15, empDetails.getImmediateSupervisor());
            // No need to set the FirstLogin value since the insertDataAddEmp query will take care of it
            //ps.setInt(16, 1);

            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Employee Successfully Added");
        }} catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "" + e);
        }
    }

    public EmpDetails returnAllDataToTextField(int id) {
        EmpDetails empDetailsList = new EmpDetails();
        try {
            PreparedStatement ps = DBConnection.con.prepareStatement(searchQuery.searchByID);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                    empDetailsList.setId(rs.getInt(searchQuery.id));
                    empDetailsList.setLastName(rs.getString(searchQuery.lastName));
                    empDetailsList.setFirstName(rs.getString(searchQuery.firstName));
                    empDetailsList.setBirthday(rs.getDate(searchQuery.birthDay));
                    empDetailsList.setEmail(rs.getString(searchQuery.email));
                    empDetailsList.setPassword(rs.getString(searchQuery.password));
                    empDetailsList.setDesignation(rs.getString(searchQuery.designation));
                    empDetailsList.setAddress(rs.getString(searchQuery.address));
                    empDetailsList.setPhoneNumber(rs.getString(searchQuery.phoneNumber));
                    
                    empDetailsList.setSSS(rs.getString(searchQuery.SSS));
                    empDetailsList.setPhilHealth(rs.getString(searchQuery.philHealth));
                    empDetailsList.setTIN(rs.getString(searchQuery.tin));
                    empDetailsList.setPagIbig(rs.getString(searchQuery.pagIbig));
                    
                    empDetailsList.setStatus(rs.getString(searchQuery.status));
                    empDetailsList.setPosition(rs.getString(searchQuery.position));
                    empDetailsList.setImmediateSupervisor(rs.getString(searchQuery.immediateSupervisor));
                    
                    empDetailsList.setFirstLogin(rs.getInt(searchQuery.FirstLogin));
                }
            else {
                JOptionPane.showMessageDialog(null, "No record selected");
            }
        } catch (SQLException e) {
            // handle the exception
        }
        return empDetailsList;
    }

    // Rename method to updateEmpDetails
    // Remove password field
    // Add the missing fields such as Address
    public void updateEmpDetails(EmpDetails empDetails) {
        try {
            PreparedStatement ps = DBConnection.con.prepareStatement(searchQuery.updateEmpDetails);
            
            ps.setString(1, empDetails.getLastName());
            ps.setString(2, empDetails.getFirstName());
            ps.setObject(3, empDetails.getBirthday());
            ps.setString(4, empDetails.getEmail());
            ps.setString(5, empDetails.getDesignation());
            
            ps.setString(6, empDetails.getAddress());
            ps.setString(7, empDetails.getPhoneNumber());
            ps.setString(8, empDetails.getSSS());
            ps.setString(9, empDetails.getPhilHealth());
            ps.setString(10, empDetails.getTIN());
            
            ps.setString(11, empDetails.getPagIbig());
            ps.setString(12, empDetails.getSatus());
            ps.setString(13, empDetails.getPosition());
            ps.setString(14, empDetails.getImmediateSupervisor());
            ps.setInt(15, empDetails.getId());

            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Record has been updated");

        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, "" + e);
        }
    }

    public void deleteEmployee(int empID) {
        try {
            PreparedStatement ps = DBConnection.con.prepareStatement(searchQuery.DeleteByID);
            ps.setInt(1, empID);
            ps.execute();
            JOptionPane.showMessageDialog(null, "Record has been deleted");
            
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, "" + e);
        }
    }    
    
    
    public List<EmpDetails> searchEmployee(String keyword) {
        //EmpDetails bean = null;
        List<EmpDetails> list = new ArrayList<>();
        try {
            // Search by ID, FirstName, and LastName
            PreparedStatement ps = DBConnection.con.prepareStatement(searchQuery.searchEmployee);
            ps.setString(1, keyword);
            ps.setString(2, "%" + keyword + "%");
            ps.setString(3, "%" + keyword + "%");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                list.add(new EmpDetails(
                        rs.getInt(searchQuery.id),
                        rs.getString(searchQuery.lastName),
                        rs.getString(searchQuery.firstName),
                        rs.getString(searchQuery.SSS),
                        rs.getString(searchQuery.philHealth),
                        rs.getString(searchQuery.tin),
                        rs.getString(searchQuery.pagIbig)
                ));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error searching employees: " + e.getMessage());
        }
        return (List<EmpDetails>) list;
    }

    
  
}
