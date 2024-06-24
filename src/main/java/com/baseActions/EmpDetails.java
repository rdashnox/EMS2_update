/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.baseActions;

import java.util.Date;

/**
 *
 * @author JD Morales
 */
public class EmpDetails {

    private int id;
    private String lastName;
    private String firstName;
    private Date birthday;
    private String email;
    private String password;
    private String designation;
    private String address;
    private String phoneNumber;
    
    private String SSS;
    private String philHealth;
    private String tin;
    private String pagIbig;
    private String status;
    private String position;
    private String immediateSupervisor;
  
    private int firstLogin;
    
    // Overload the constructor with different parameter combinations
  
    public EmpDetails(int id, int FirstLogin, String designation) {
        //this.id = Integer.parseInt(id);
        this.id = id;
        this.firstLogin = FirstLogin;
        this.designation = designation;
        
    }

    
    public EmpDetails(int id, String lastName, String firstName, Date birthday, String email, String designation) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.birthday = birthday;
        this.email = email;
        this.designation = designation;
    }
    
    
    public EmpDetails(int id, String lastName, String firstName, Date birthday, String email, String password, String designation, String address) {
        
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.birthday = birthday;
        this.email = email;
        this.password = password;
        this.designation = designation;
        this.address = address;
        
    }

    public EmpDetails(int id, String lastName, String firstName, String SSS, String philHealth, String tin, String pagIbig) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.SSS = SSS;
        this.philHealth = philHealth;
        this.tin = tin;
        this.pagIbig = pagIbig;
    }    

    public EmpDetails(int id, int FirstLogin, String designation, String firstName, String lastName,  Date birthday, String email, String position) {
        this.id = id;
        this.firstLogin = FirstLogin;
        this.designation = designation;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthday;
        this.email = email;
        this.position = position;
    }    

    public EmpDetails(int id,
            String lastName,
            String firstName,
            Date birthday,
            String email,
            String designation,
            String address,
            String phoneNumber,
            String SSS,
            String philHealth,
            String tin,
            String pagIbig,
            String status,
            String position,
            String immediateSupervisor) {
                this.id = id;
                this.lastName = lastName;
                this.firstName = firstName;
                this.birthday = birthday;
                this.email = email;
                this.designation = designation;
                
                this.address = address;
                this.phoneNumber = phoneNumber;
                this.SSS = SSS;
                this.philHealth = philHealth;
                this.tin = tin;
                
                this.pagIbig = pagIbig;
                this.status = status;
                this.position = position;
                this.immediateSupervisor = immediateSupervisor;
    }     
    
    
    public EmpDetails(int id,
            String lastName,
            String firstName,
            Date birthday,
            String email,
            String password,
            String designation,
            String address,
            String phoneNumber,
            String SSS,
            String philHealth,
            String tin,
            String pagIbig,
            String status,
            String position,
            String immediateSupervisor,
            int firstLogin) {
                this.id = id;
                this.lastName = lastName;
                this.firstName = firstName;
                this.birthday = birthday;
                this.email = email;
                this.password = password;
                this.designation = designation;
                this.address = address;
                this.phoneNumber = phoneNumber;

                this.SSS = SSS;
                this.philHealth = philHealth;
                this.tin = tin;
                this.pagIbig = pagIbig;

                this.status = status;
                this.position = position;
                this.immediateSupervisor = immediateSupervisor;

                this.firstLogin = firstLogin;
    }     
    
    public EmpDetails() {

    }       

    public EmpDetails(int id, String lastName, String firstName, Date birthday, String email, String designation, String address) {
                this.id = id;
                this.lastName = lastName;
                this.firstName = firstName;
                this.birthday = birthday;
                this.email = email;
                this.designation = designation;
                this.address = address;
    }

//------------   #### SET PROPERTIES HERE ------############//

    public int getId() {
        return id;
    }

    public void setId(int id) {
        //this.id = Integer.parseInt(id);
        this.id = id;
    }

    
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }    

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }   

// Employee Benefits
    public String getSSS() {
        return SSS;
    }

    public void setSSS(String sss) {
        this.SSS = sss;
    }   
    
    public String getPhilHealth() {
        return philHealth;
    }

    public void setPhilHealth(String philhealth) {
        this.philHealth = philhealth;
    }      
    
    public String getTIN() {
        return tin;
    }

    public void setTIN(String TIN) {
        this.tin = TIN;
    }       

    public String getPagIbig() {
        return pagIbig;
    }

    public void setPagIbig(String pagibig) {
        this.pagIbig = pagibig;
    }        
    
// Other Employment Details 
    public String getSatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    
    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }    

    public String getImmediateSupervisor() {
        return immediateSupervisor;
    }

    public void setImmediateSupervisor(String immediatesupervisor) {
        this.immediateSupervisor = immediatesupervisor;
    }     
    
    public int getFirstLogin() {
        return firstLogin;
    }

    public void setFirstLogin(int firstLogin) {
        this.firstLogin = firstLogin;
    }    
    Object getDate() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    Object getlastName() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    Object getfirstName() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    
        
}
