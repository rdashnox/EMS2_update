/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.baseActions;

import java.sql.Time;
import java.util.Date;

/**
 *
 * @author JD Morales
 */
public class LeavesTrack {
    private int LeaveId;
    private String LeaveStatus;
    private Date DateFiled;
    private Date DateFrom;
    private Date DateTo;
    private String ReasonForLeave;
    private String Notes;
    private int EmpId;

    public LeavesTrack(int employeeId) {
        this.EmpId = employeeId;
    }
    
    public LeavesTrack() {
    }

    // Getter-Setter properties below
    
    public int getLeaveId() {
        return LeaveId;
    }

    public void setLeaveId(int leaveId) {
        this.LeaveId = leaveId;
    }       
    
    public String getLeaveStatus() {
        return LeaveStatus;
    }

    public void setLeaveStatus(String leaveStatus) {
        this.LeaveStatus = leaveStatus;
    }    
    
    public Date getDateFiled() {
        return DateFiled;
    }

    public void setDateFiled(Date dateFiled) {
        this.DateFiled = dateFiled;
    }        
    
    public Date getDateFrom() {
        return DateFrom;
    }

    public void setDateFrom(Date dateFrom) {
        this.DateFrom = dateFrom;
    }        
    
    public Date getDateTo() {
        return DateTo;
    }

    public void setDateTo(Date dateTo) {
        this.DateTo = dateTo;
    }     

    public String getReasonForLeave() {
        return ReasonForLeave;
    }

    public void setReasonForLeave(String reasonForLeave) {
        this.ReasonForLeave = reasonForLeave;
    }  
    
    
    public String getNotes() {
        return Notes;
    }

    public void setNotes(String notes) {
        this.Notes = notes;
    }   

    public int getEmpId() {
        return EmpId;
    }

    public void setEmpId(int empId) {
        this.EmpId = empId;
    }
    
}
