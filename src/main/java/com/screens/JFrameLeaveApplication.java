/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.screens;


import DBConnection.DBConnection;
import com.baseActions.EmpActions;
import com.baseActions.EmpAttendance;
import com.baseActions.EmpDetails;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;




/**
 *
 * @author Charm
 */
public class JFrameLeaveApplication extends javax.swing.JFrame {
    
    /**
     * Creates new form JFrameLeaveApplication
     */
    public JFrameLeaveApplication() {
        initComponents();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setResizable(false);
        customBoxReasons ();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    private void buttonVisibility() {
      String designation = EmpAttendance.UserDesignation;
      if (designation.equals("Employee")) {
          jButton4Approve.setVisible(false);
          jButton5Reject.setVisible(false);
      }else{
          jButton4Approve.setVisible(true);
          jButton5Reject.setVisible(true);
      }
  }
    
    private void customBoxReasons() {
        // Initialize JComboBox for month selection
        ArrayList<String> reason = new ArrayList<>();
        reason.add("Sick Leave");
        reason.add("Vacation Leave");
        reason.add("Compensatory Time-Off");
        reason.add("Leave From Previous Year");
        reason.add("Maternity/Paternity Leave");

        for (String reasons : reason) {
        jComboBox1LeaveReason.addItem(reasons); 
        }
    
        ArrayList<String> leavestatus = new ArrayList<>();
        leavestatus.add("Pending");
        leavestatus.add("Approved");
        leavestatus.add("Rejected");

        for (String whatstatus : leavestatus) {
        jComboBox1StatusSelection.addItem(whatstatus);  
        }
    }

    private void fillEmployeeDetails(int id) {
        // Load the connection
        DBConnection.loadConnection();
        // Create an instance of EmpActions to fetch employee details
        EmpActions empInfo = new EmpActions();
        EmpDetails empDetails = empInfo.returnAllDataToTextField(id);
        // Populate the UI components with employee details
        if (empDetails != null) {
            jTextField1LastName.setText(empDetails.getLastName());
            jTextField1EmpFirstName.setText(empDetails.getFirstName());
            jTextField2ImmSupervisor.setText(empDetails.getImmediateSupervisor());
            jTextField3Position.setText(empDetails.getPosition());
        } else {
            JOptionPane.showMessageDialog(this, "Employee not found");
        }
    }

 
    private void fillLeaveStatusTable() {
        try {
            // Load the connection
            DBConnection.loadConnection();

            // Clear existing rows
            DefaultTableModel model = (DefaultTableModel) jTable1LeaveStatusTable.getModel();
            model.setRowCount(0);

            // Retrieve leave status data from the database
            String query = "SELECT LeaveID, LeaveStatus, DateFiled, DateFrom, DateTo, ReasonForLeave, Notes, EmpID FROM leaves";

            try (PreparedStatement ps = DBConnection.con.prepareStatement(query);
                 ResultSet rs = ps.executeQuery()) {

                // Populate the table with retrieved data
                while (rs.next()) {
                    int leaveID = rs.getInt("LeaveID");
                    String leaveStatus = rs.getString("LeaveStatus");
                    Date dateFiled = rs.getDate("DateFiled");
                    Date dateFrom = rs.getDate("DateFrom");
                    Date dateTo = rs.getDate("DateTo");
                    String reasonForLeave = rs.getString("ReasonForLeave");
                    String notes = rs.getString("Notes");
                    int empID = rs.getInt("EmpID");

                    // Add data to the table
                    model.addRow(new Object[]{leaveID, leaveStatus, dateFiled, dateFrom, dateTo, reasonForLeave, notes, empID});
                }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error retrieving leave status: " + ex.getMessage());
        }      
    }
    
    private void fillLeaveStatusTable(String selectedStatus) {
    try {
        // Load the connection
        DBConnection.loadConnection();

        // Clear existing rows
        DefaultTableModel model = (DefaultTableModel) jTable1LeaveStatusTable.getModel();
        model.setRowCount(0);

        // Retrieve leave status data from the database based on selectedStatus
        String query = "SELECT LeaveID, LeaveStatus, DateFiled, DateFrom, DateTo, ReasonForLeave, Notes, EmpID FROM leaves WHERE LeaveStatus = ?";

        try (PreparedStatement ps = DBConnection.con.prepareStatement(query)) {
            ps.setString(1, selectedStatus);
            try (ResultSet rs = ps.executeQuery()) {
                // Populate the table with retrieved data
                while (rs.next()) {
                    int leaveID = rs.getInt("LeaveID");
                    String leaveStatus = rs.getString("LeaveStatus");
                    Date dateFiled = rs.getDate("DateFiled");
                    Date dateFrom = rs.getDate("DateFrom");
                    Date dateTo = rs.getDate("DateTo");
                    String reasonForLeave = rs.getString("ReasonForLeave");
                    String notes = rs.getString("Notes");
                    int empID = rs.getInt("EmpID");

                    // Add data to the table
                    model.addRow(new Object[]{leaveID, leaveStatus, dateFiled, dateFrom, dateTo, reasonForLeave, notes, empID});
                }
            }
        }
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(this, "Error retrieving leave status: " + ex.getMessage());
    }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelHeader = new javax.swing.JPanel();
        labelCompany = new java.awt.Label();
        labelLogo = new javax.swing.JLabel();
        jButton1Home = new javax.swing.JButton();
        jButton2LeaveRequest = new javax.swing.JButton();
        jButton3Logout = new javax.swing.JButton();
        jPanelFooter = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1ELRForm = new javax.swing.JLabel();
        jTextField1EmpFirstName = new javax.swing.JTextField();
        jTextField2ImmSupervisor = new javax.swing.JTextField();
        jTextField3Position = new javax.swing.JTextField();
        jLabel2FullName = new javax.swing.JLabel();
        jLabel3ImmSupervisor = new javax.swing.JLabel();
        jLabel8Position = new javax.swing.JLabel();
        jLabel9LeaveDate = new javax.swing.JLabel();
        jLabel10From = new javax.swing.JLabel();
        jDateChooser1d1DateTo = new com.toedter.calendar.JDateChooser();
        jLabel12To = new javax.swing.JLabel();
        jDateChooser1d2DateFrom = new com.toedter.calendar.JDateChooser();
        jLabel13LeaveReason = new javax.swing.JLabel();
        jComboBox1LeaveReason = new javax.swing.JComboBox<>();
        jLabel14Notes = new javax.swing.JLabel();
        jTextField4Notes = new javax.swing.JTextField();
        jButton6Submit = new javax.swing.JButton();
        jTextField1LastName = new javax.swing.JTextField();
        jLabel1EmpId = new javax.swing.JLabel();
        jTextField2EmpID = new javax.swing.JTextField();
        jButton1Search = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1LeaveStatusTable = new javax.swing.JTable();
        jButton4Approve = new javax.swing.JButton();
        jButton5Reject = new javax.swing.JButton();
        jComboBox1StatusSelection = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(99, 93, 255));

        jPanelHeader.setBackground(new java.awt.Color(147, 145, 255));

        labelCompany.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        labelCompany.setForeground(new java.awt.Color(255, 255, 255));
        labelCompany.setText("MotorPH");

        labelLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/LOGO_icon.png"))); // NOI18N
        labelLogo.setText("jLabel1");
        labelLogo.setMaximumSize(new java.awt.Dimension(172, 119));
        labelLogo.setMinimumSize(new java.awt.Dimension(172, 119));
        labelLogo.setPreferredSize(new java.awt.Dimension(172, 192));

        javax.swing.GroupLayout jPanelHeaderLayout = new javax.swing.GroupLayout(jPanelHeader);
        jPanelHeader.setLayout(jPanelHeaderLayout);
        jPanelHeaderLayout.setHorizontalGroup(
            jPanelHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelHeaderLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelCompany, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelHeaderLayout.setVerticalGroup(
            jPanelHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelHeaderLayout.createSequentialGroup()
                .addGroup(jPanelHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelHeaderLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(labelLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelHeaderLayout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(labelCompany, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButton1Home.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton1Home.setText("HOME");
        jButton1Home.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1HomeActionPerformed(evt);
            }
        });

        jButton2LeaveRequest.setBackground(new java.awt.Color(99, 93, 255));
        jButton2LeaveRequest.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton2LeaveRequest.setForeground(new java.awt.Color(255, 255, 255));
        jButton2LeaveRequest.setText("LEAVE REQUEST");

        jButton3Logout.setBackground(new java.awt.Color(232, 19, 19));
        jButton3Logout.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton3Logout.setForeground(new java.awt.Color(255, 255, 255));
        jButton3Logout.setText("LOGOUT");
        jButton3Logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3LogoutActionPerformed(evt);
            }
        });

        jPanelFooter.setBackground(new java.awt.Color(147, 145, 255));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Office Hours: 8:00AM - 5:00PM");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Office Address: 5th Flr., The World Center #330 Sen. Gil Puyat Ave., Makati City, Manila, Philippines");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Office Phone Number: +63-2-754-7000");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Office Email: support@motorph.com");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Group 1");

        jLabel21.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("Section : A1101");

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("MO-IT103 - Computer Programming 2");

        javax.swing.GroupLayout jPanelFooterLayout = new javax.swing.GroupLayout(jPanelFooter);
        jPanelFooter.setLayout(jPanelFooterLayout);
        jPanelFooterLayout.setHorizontalGroup(
            jPanelFooterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelFooterLayout.createSequentialGroup()
                .addGap(103, 103, 103)
                .addGroup(jPanelFooterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4)
                    .addComponent(jLabel7)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 362, Short.MAX_VALUE)
                .addGroup(jPanelFooterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel21, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel18, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(86, 86, 86))
        );
        jPanelFooterLayout.setVerticalGroup(
            jPanelFooterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelFooterLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanelFooterLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.setBackground(new java.awt.Color(233, 227, 232));

        jLabel1ELRForm.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1ELRForm.setText("EMPLOYEE LEAVE REQUEST FORM");

        jLabel2FullName.setText("EMPLOYEE FULL NAME:");

        jLabel3ImmSupervisor.setText("IMMEDIATE SUPERVISOR:");

        jLabel8Position.setText("POSITION:");

        jLabel9LeaveDate.setText("LEAVE DATE:");

        jLabel10From.setText("FROM:");

        jLabel12To.setText("TO:");

        jLabel13LeaveReason.setText("REASON FOR LEAVE:");

        jLabel14Notes.setText("NOTES:");

        jButton6Submit.setBackground(new java.awt.Color(99, 93, 255));
        jButton6Submit.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton6Submit.setForeground(new java.awt.Color(255, 255, 255));
        jButton6Submit.setText("SUBMIT");
        jButton6Submit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6SubmitActionPerformed(evt);
            }
        });

        jLabel1EmpId.setText("EMPLOYEE ID");

        jButton1Search.setBackground(new java.awt.Color(99, 93, 255));
        jButton1Search.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton1Search.setForeground(new java.awt.Color(255, 255, 255));
        jButton1Search.setText("SEARCH");
        jButton1Search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1SearchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(140, 140, 140)
                .addComponent(jButton6Submit, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel14Notes, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel13LeaveReason, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel3ImmSupervisor, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jTextField2ImmSupervisor)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jDateChooser1d1DateTo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                                    .addComponent(jTextField4Notes)
                                    .addComponent(jComboBox1LeaveReason, 0, 150, Short.MAX_VALUE)
                                    .addComponent(jDateChooser1d2DateFrom, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                                    .addComponent(jTextField3Position, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jTextField1EmpFirstName, javax.swing.GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE)
                                        .addComponent(jTextField2EmpID))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jTextField1LastName)
                                        .addComponent(jButton1Search, javax.swing.GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)))))
                        .addGap(16, 16, 16))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1EmpId, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel8Position, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel9LeaveDate, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel12To, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel10From, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2FullName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(110, 110, 110))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1ELRForm, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(94, 94, 94))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel1ELRForm)
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1EmpId)
                    .addComponent(jTextField2EmpID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1Search))
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2FullName)
                    .addComponent(jTextField1EmpFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField1LastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField2ImmSupervisor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3ImmSupervisor))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField3Position, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8Position))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jDateChooser1d2DateFrom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel10From)
                        .addComponent(jLabel9LeaveDate)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jDateChooser1d1DateTo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12To))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox1LeaveReason, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13LeaveReason))
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField4Notes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14Notes))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton6Submit)
                .addGap(22, 22, 22))
        );

        jTable1LeaveStatusTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "LEAVE ID", "LEAVE STATUS", "DATE FILED", "DATE FROM", "DATE TO", "REASON FOR LEAVE", "NOTES", "EMP ID"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, false, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1LeaveStatusTable.setSelectionBackground(new java.awt.Color(204, 204, 204));
        jTable1LeaveStatusTable.getTableHeader().setReorderingAllowed(false);
        jTable1LeaveStatusTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1LeaveStatusTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1LeaveStatusTable);

        jButton4Approve.setBackground(new java.awt.Color(99, 93, 255));
        jButton4Approve.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton4Approve.setForeground(new java.awt.Color(255, 255, 255));
        jButton4Approve.setText("APPROVE");
        jButton4Approve.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ApproveActionPerformed(evt);
            }
        });

        jButton5Reject.setBackground(new java.awt.Color(232, 19, 19));
        jButton5Reject.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton5Reject.setForeground(new java.awt.Color(255, 255, 255));
        jButton5Reject.setText("REJECT");
        jButton5Reject.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5RejectActionPerformed(evt);
            }
        });

        jComboBox1StatusSelection.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1StatusSelectionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelHeader, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanelFooter, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton1Home, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton4Approve)
                        .addGap(18, 18, 18)
                        .addComponent(jButton5Reject)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jComboBox1StatusSelection, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton2LeaveRequest, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton3Logout, javax.swing.GroupLayout.PREFERRED_SIZE, 388, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanelHeader, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1Home)
                    .addComponent(jButton2LeaveRequest)
                    .addComponent(jButton3Logout))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton5Reject)
                            .addComponent(jButton4Approve)
                            .addComponent(jComboBox1StatusSelection, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 432, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelFooter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
   
    private void jButton1HomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1HomeActionPerformed
        JFrameHome jFrameHome = new JFrameHome();
        jFrameHome.setVisible(true); // Show the home frame
        this.dispose(); // Close the payroll frame

    }//GEN-LAST:event_jButton1HomeActionPerformed

    private void jButton3LogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3LogoutActionPerformed
        new JFrameLogin().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton3LogoutActionPerformed

    private void jButton1SearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1SearchActionPerformed
        try {
            int id = Integer.parseInt(jTextField2EmpID.getText());
            fillEmployeeDetails(id);
            fillLeaveStatusTable(); // Call the method to fill the leave status table
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Invalid Employee ID");
        }
    }//GEN-LAST:event_jButton1SearchActionPerformed

    private void jButton6SubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6SubmitActionPerformed
    Connection con = null;
    PreparedStatement ps = null;

    try {
        // Retrieve input values
        Date dateFrom = jDateChooser1d2DateFrom.getDate();
        Date dateTo = jDateChooser1d1DateTo.getDate();
        String reason = jComboBox1LeaveReason.getSelectedItem().toString();
        String notes = jTextField4Notes.getText();
        int empID = Integer.parseInt(jTextField2EmpID.getText());

        // Check for null dates
        if (dateFrom == null || dateTo == null) {
            JOptionPane.showMessageDialog(null, "Please select valid dates.");
            return; // Exit the method if dates are null
        }

        // Check if dateFrom is before the current date
        Date currentDate = new Date();
        // Check if dateFrom is before the current date, except for Sick Leave
        if (!reason.equalsIgnoreCase("Sick Leave") && dateFrom.before(currentDate)) {
            JOptionPane.showMessageDialog(null, "Date From cannot be before the current date.");
            return; // Exit the method if dateFrom is before the current date
        }

        // Check if dateTo is before the current date
        if (!reason.equalsIgnoreCase("Sick Leave") && dateTo.before(currentDate)) {
            JOptionPane.showMessageDialog(null, "Date To cannot be before the current date.");
            return; // Exit the method if dateTo is before the current date
        }

        // Check if dateTo is before dateFrom
        if (dateTo.before(dateFrom)) {
            JOptionPane.showMessageDialog(null, "Date To cannot be before Date From.");
            return; // Exit the method if dateTo is before dateFrom
        }
        
        // Additional rule for Sick Leave
        if (reason.equalsIgnoreCase("Sick Leave")) {
            if (dateFrom.after(currentDate) || dateTo.after(currentDate)) {
                JOptionPane.showMessageDialog(null, "For Sick Leave, only previous and current dates are acceptable.");
                return;
            }
        }
        
        // Get connection
        con = DBConnection.getConnection();

        // Check if there are existing leave applications for the specified date range for the current employee
        if (isLeaveApplicationExists(con, dateFrom, dateTo, empID)) {
            JOptionPane.showMessageDialog(null, "Leave application already exists for the specified date range.");
            return; // Exit the method if leave application already exists
        }

        // Get current date
        java.sql.Timestamp dateFiled = new java.sql.Timestamp(currentDate.getTime());

        // Insert leave details into database
        String query = "INSERT INTO leaves (LeaveStatus, DateFiled, DateFrom, DateTo, ReasonForLeave, Notes, EmpID) "
                     + "VALUES (?, ?, ?, ?, ?, ?, ?)";

        // Prepare and execute the SQL statement
        ps = con.prepareStatement(query);

        // Set parameter values
        ps.setString(1, "PENDING"); // Default value for LeaveStatus
        ps.setTimestamp(2, dateFiled);
        ps.setDate(3, new java.sql.Date(dateFrom.getTime()));
        ps.setDate(4, new java.sql.Date(dateTo.getTime()));
        ps.setString(5, reason);
        ps.setString(6, notes);
        ps.setInt(7, empID);

        // Execute the update statement
        int rowsAffected = ps.executeUpdate();
        if (rowsAffected > 0) {
            JOptionPane.showMessageDialog(null, "Leave application submitted successfully.");
            fillLeaveStatusTable();
        } else {
            JOptionPane.showMessageDialog(null, "Failed to submit leave application.");
        }
    } catch (SQLException | NumberFormatException e) {
        JOptionPane.showMessageDialog(null, "Error submitting leave application: " + e.getMessage());
    }
}

    // Function to check if there are existing leave applications for the specified date range for a specific employee
    private boolean isLeaveApplicationExists(Connection con, Date dateFrom, Date dateTo, int empID) {
        String query = "SELECT COUNT(*) FROM leaves WHERE EmpID = ? AND ((DateFrom <= ? AND DateTo >= ?) OR (DateFrom >= ? AND DateTo <= ?) OR (DateFrom <= ? AND DateTo >= ?))";
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            // Prepare and execute the SQL statement
            ps = con.prepareStatement(query);

            // Set parameter values
            ps.setInt(1, empID);
            ps.setDate(2, new java.sql.Date(dateTo.getTime()));
            ps.setDate(3, new java.sql.Date(dateFrom.getTime()));
            ps.setDate(4, new java.sql.Date(dateFrom.getTime()));
            ps.setDate(5, new java.sql.Date(dateTo.getTime()));
            ps.setDate(6, new java.sql.Date(dateFrom.getTime()));
            ps.setDate(7, new java.sql.Date(dateTo.getTime()));

            // Execute the query
            rs = ps.executeQuery();
            rs.next();
            int count = rs.getInt(1);
            return count > 0;
        } catch (SQLException e) { // Handle the exception 
            return false;
        } 
    }//GEN-LAST:event_jButton6SubmitActionPerformed

    private void jTable1LeaveStatusTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1LeaveStatusTableMouseClicked

        if (evt.getClickCount() == 1) {
            // Get the selected row index
            int selectedRowIndex = jTable1LeaveStatusTable.getSelectedRow();
    }
    }//GEN-LAST:event_jTable1LeaveStatusTableMouseClicked
           
    private void jButton4ApproveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ApproveActionPerformed
                                            
        // Get the selected row index
        int selectedRow = jTable1LeaveStatusTable.getSelectedRow();

        // Check if a row is selected
        if (selectedRow != -1) {
            // Get the LeaveID from the selected row
            int leaveID = (int) jTable1LeaveStatusTable.getValueAt(selectedRow, 0);

            // Load the connection
            DBConnection.loadConnection();

            // Update the leave status
            String query = "UPDATE leaves SET LeaveStatus = 'APPROVED' WHERE LeaveID = ?";
            try (Connection con = DBConnection.con;
                PreparedStatement ps = con.prepareStatement(query)) {
                ps.setInt(1, leaveID);
                int rowsAffected = ps.executeUpdate();

                // Check if the update was successful
                if (rowsAffected > 0) {
                    JOptionPane.showMessageDialog(this, "Leave request approved successfully.");

                    // Refresh the leave status table
                    fillLeaveStatusTable();
                } else {
                    JOptionPane.showMessageDialog(this, "Failed to approve leave request.");
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Error updating leave status: " + ex.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(this, "Please select a leave request to approve.");
        }

    }//GEN-LAST:event_jButton4ApproveActionPerformed

    private void jButton5RejectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5RejectActionPerformed
        // Get the selected row index
        int selectedRow = jTable1LeaveStatusTable.getSelectedRow();

        // Check if a row is selected
        if (selectedRow != -1) {
            // Get the LeaveID from the selected row
            int leaveID = (int) jTable1LeaveStatusTable.getValueAt(selectedRow, 0);

            // Load the connection
            DBConnection.loadConnection();

            // Update the leave status
            String query = "UPDATE leaves SET LeaveStatus = 'REJECTED' WHERE LeaveID = ?";
            try (Connection con = DBConnection.con;
                PreparedStatement ps = con.prepareStatement(query)) {
                ps.setInt(1, leaveID);
                int rowsAffected = ps.executeUpdate();

                // Check if the update was successful
                if (rowsAffected > 0) {
                    JOptionPane.showMessageDialog(this, "Leave request rejected.");

                    // Refresh the leave status table
                    fillLeaveStatusTable();
                } else {
                    JOptionPane.showMessageDialog(this, "Failed to approve leave request.");
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Error updating leave status: " + ex.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(this, "Please select a leave request to approve.");
        }
    }//GEN-LAST:event_jButton5RejectActionPerformed

    private void jComboBox1StatusSelectionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1StatusSelectionActionPerformed
       // Retrieve the selected status from the combo box
        String selectedStatus = (String) jComboBox1StatusSelection.getSelectedItem();

        fillLeaveStatusTable(selectedStatus);

    }//GEN-LAST:event_jComboBox1StatusSelectionActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFrameLeaveApplication.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFrameLeaveApplication().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1Home;
    private javax.swing.JButton jButton1Search;
    private javax.swing.JButton jButton2LeaveRequest;
    private javax.swing.JButton jButton3Logout;
    private javax.swing.JButton jButton4Approve;
    private javax.swing.JButton jButton5Reject;
    private javax.swing.JButton jButton6Submit;
    private javax.swing.JComboBox<String> jComboBox1LeaveReason;
    private javax.swing.JComboBox<String> jComboBox1StatusSelection;
    private com.toedter.calendar.JDateChooser jDateChooser1d1DateTo;
    private com.toedter.calendar.JDateChooser jDateChooser1d2DateFrom;
    private javax.swing.JLabel jLabel10From;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12To;
    private javax.swing.JLabel jLabel13LeaveReason;
    private javax.swing.JLabel jLabel14Notes;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel1ELRForm;
    private javax.swing.JLabel jLabel1EmpId;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel2FullName;
    private javax.swing.JLabel jLabel3ImmSupervisor;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8Position;
    private javax.swing.JLabel jLabel9LeaveDate;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanelFooter;
    private javax.swing.JPanel jPanelHeader;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1LeaveStatusTable;
    private javax.swing.JTextField jTextField1EmpFirstName;
    private javax.swing.JTextField jTextField1LastName;
    private javax.swing.JTextField jTextField2EmpID;
    private javax.swing.JTextField jTextField2ImmSupervisor;
    private javax.swing.JTextField jTextField3Position;
    private javax.swing.JTextField jTextField4Notes;
    private java.awt.Label labelCompany;
    private javax.swing.JLabel labelLogo;
    // End of variables declaration//GEN-END:variables

}
