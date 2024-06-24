/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DBConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author JD Morales
 */
public class DBConnection {
    public static Connection con = null;

    public static void loadConnection() {
        String url = "jdbc:mysql://localhost:3306/emp_msdb2";
        String root = "root";
        String pass = "mYSQLDASH/4*";
        int count = 0;

        try {
            con = DriverManager.getConnection(url, root, pass);

            if (con != null) {
                if (count == 0){
                //JOptionPane.showMessageDialog(null, "Welcome to Motor PH");
                count = 1;
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error in Database" + e);
        }
    }
    
    public static Connection getConnection() {
        if (con == null) {
            loadConnection(); // Establish the connection if it's not already established
        }
        return con;
}    
    
}
