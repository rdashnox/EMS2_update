/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.screens;
import DBConnection.DBConnection;
/**
 *
 * @author JD Morales
 */
public class MotorPH_EMS2 {

    public static void main(String[] args) {
        //System.out.println("Hello World!");
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new JFrameHome().setVisible(true);
                new JFrameLogin().setVisible(true);
                //new JFrameEmpInfo().setVisible(true);
                //new JFrameEmpPayroll().setVisible(true);
                DBConnection.loadConnection();
            }
            
        });        
    }
}
