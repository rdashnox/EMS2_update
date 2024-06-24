/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.baseActions;

/**
 *
 * @author CHAS
 */
public class MotorPH_String {
    //Queries
    // ADD new records
    String insertDataAddEmp = "INSERT INTO employee (`Last Name`, `First Name`, Birthday, Email, Password, Designation, address, `Phone Number`, `SSS #`, `Philhealth #`, `TIN #`, `Pag-ibig #`, Status, Position, `Immediate Supervisor`, FirstLogin) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, 1)";
    
    // READ-only or Retrieve records
    String loadData = "select * from employee";
    String searchEmployee = "SELECT * FROM employee WHERE ID = ? OR `Last Name` LIKE ? OR `First Name` LIKE ?";
    String displayEmployeeInfo = "SELECT `SSS #`, `Philhealth #`, `Pag-ibig #`, `TIN #` FROM employee WHERE ID = ?";
    //String userLoginSearch = "SELECT ID, `Last Name`, `First Name`, Birthday, Email, Designation, Position, FirstLogin FROM employee WHERE Email = ? AND Password = ?";
    String userLoginSearch = "SELECT * FROM employee WHERE Email = ? AND Password = ?";    
    String userSearchById = "SELECT ID, `Last Name`, `First Name`, Birthday, Email, Designation, Position, FirstLogin FROM employee WHERE ID = ? ORDER BY ID ASC LIMIT 1";
    String searchByEmail = "SELECT * FROM employee WHERE Email = ?";
    String searchByID = "SELECT * FROM employee WHERE ID = ?";    
    String searchAllowanceByID = "SELECT ID, `Basic Salary`, `Rice Subsidy`, `Phone Allowance`, `Clothing Allowance`, `Hourly Rate` FROM employee WHERE ID = ?";        
    String DisplayLogInfoByIDandDate= "select AttID, ID, LogDate, LogTime, Status from attendance where ID = ? AND LogDate between ? and ?";
    
    
    // UPDATE records
    String updateEmpDetails = "update employee set `Last Name` = ?, `First Name` = ?, Birthday = ?, Email = ?, Designation = ?, Address = ?, `Phone Number` = ?, `SSS #` = ?, `Philhealth #` = ?, `TIN #` = ?, `Pag-ibig #` = ?, Status = ?, Position = ?, `Immediate Supervisor` = ? WHERE ID = ?";
    String updateDefaultPassword = "UPDATE employee SET `Security Question` = ?, `Security Answer` = ?, Password = ?, FirstLogin = 0 WHERE ID = ?";      
    String updatePassword = "UPDATE employee SET Password = ? WHERE Email = ? AND Password = ?";    
    String returnAllDataToTextField = "update employee set `Last Name` = ?, `First Name` = ?, Birthday = ?, Email = ?, Password = ?, Designation = ? WHERE ID = ?";    

    // DELETE records
    String DeleteByID = "DELETE from employee where ID = ?";
    
    //Variables used to indicate the Index or Query result's column names when assigning values to the EmpDetails list.
    String id = "ID";
    String lastName = "Last Name";
    String firstName = "First Name";
    String birthDay  = "Birthday";
    String email = "Email";
    String password = "Password";
    String designation = "Designation";
    String address = "Address";
    String phoneNumber = "Phone Number";

    String SSS = "SSS #";
    String philHealth = "Philhealth #";
    String tin = "TIN #";
    String pagIbig = "Pag-ibig #";
    
    String status = "Status";
    String position = "Position";
    String immediateSupervisor = "Immediate Supervisor";
    String FirstLogin = "FirstLogin";        

    String basicSalary = "Basic Salary";
    String riceAllowance = "Rice Subsidy";
    String phoneAllowance = "Phone Allowance";
    String clothingAllowance = "Clothing Allowance";
    
    String hourlyRate = "Hourly Rate";    

    String logDate = "LogDate";
    String logTime = "LogTime";
    
}