/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.baseActions;

import DBConnection.DBConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author JD Morales
 */
public class BenefitsCalculator {
   
    /**
     * Calculate Pag-IBIG contribution based on basic salary.
     *
     * @param basicSalary the basic salary of the employee
     * @return the Pag-IBIG contribution as a String
     */
    private int id = 0;
    private float empbasicSalary = (float) 0.00;
    private float empGrossSalary = (float) 0.00;
    
    private float pagIBIGContribution = (float) 0.00;
    private float philHealthContribution = (float) 0.00;
    private float sssContribution = (float) 0.00;
    private float withholdingTax = (float) 0.00;
    private float totalDeductions = (float) 0.00;
    
    private float riceAllowance = (float) 0.00;
    private float phoneAllowance = (float) 0.00;
    private float clothingAllowance = (float) 0.00;
    private float totalAllowances = (float) 0.00;

    MotorPH_String searchAllowance = new MotorPH_String();    

    public BenefitsCalculator(int empID, float empGrossSalary ) {
        this.id = empID;
        this.empGrossSalary = empGrossSalary;
    }    
    
    
    public BenefitsCalculator(int empID ) {
        this.id = empID;
        // Retrieve all allowances based on empID. Then, set the basicSalary variable's value.
        GetAllEmpAllowances(empID);
    }

    
    public BenefitsCalculator() {
    }


    // Get all allowances from a single participant. Then, assign the salary to a variable (empbasicSalary).
    public EmpAllowances GetAllEmpAllowances(int id) {
        EmpAllowances empAllowance = new EmpAllowances();
        try {
            PreparedStatement ps = DBConnection.con.prepareStatement(searchAllowance.searchAllowanceByID);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                    empAllowance.setId(rs.getInt(searchAllowance.id));
                    empAllowance.setBasicSalary(rs.getFloat(searchAllowance.basicSalary));
                    empAllowance.setRiceAllowance(rs.getFloat(searchAllowance.riceAllowance));
                    empAllowance.setPhonAllowance(rs.getFloat(searchAllowance.phoneAllowance));
                    empAllowance.setClothingAllowance(rs.getFloat(searchAllowance.clothingAllowance));
                    empAllowance.setHourlyRate(rs.getFloat(searchAllowance.hourlyRate));                    
                        }
            else {
                JOptionPane.showMessageDialog(null, "No record retrieved");
            }
            
            if (empAllowance.getBasicSalary() > (float) 0.00 ){
                this.empbasicSalary = empAllowance.getBasicSalary();
                this.riceAllowance = empAllowance.getRiceAllowance();
                this.phoneAllowance = empAllowance.getPhoneAllowance();
                this.clothingAllowance = empAllowance.getClothingAllowance();
                empAllowance.setTotalAllowance(this.riceAllowance 
                        + this.phoneAllowance + this.clothingAllowance);
                
                this.totalAllowances = empAllowance.getTotalAllowance();
                        
            }
        } catch (SQLException e) {
            // handle the exception
        }
        return empAllowance;
    }


    
    public EmpDeductions CalculateDeductions(float empGrossSalary){
        this.pagIBIGContribution = calculatePagIBIGContribution(empGrossSalary);
        this.philHealthContribution = calculatePhilHealthContribution(empGrossSalary);
        this.sssContribution = calculateSSSContribution(empGrossSalary);
        // remember to replace empbasicSalary with gross salary
        this.withholdingTax = calculateWithholdingTax(empGrossSalary);
        this.totalDeductions = this.pagIBIGContribution + this.philHealthContribution + 
        this.sssContribution + this.withholdingTax;           
        
        EmpDeductions deductableItems = new EmpDeductions(
                this.id, this.empGrossSalary, this.pagIBIGContribution, this.philHealthContribution,
                this.sssContribution, this.withholdingTax, this.totalDeductions
        );

        return deductableItems;
    }
    

    public float calculatePagIBIGContribution(float Salary) {

        float employeeContributionRate;
        float employerContributionRate;

        if (Salary >= 1000 && Salary <= 1500) {
            employeeContributionRate = 0.01f; // 1%
            employerContributionRate = 0.02f; // 2%
        } else {
            employeeContributionRate = 0.02f; // 2%
            employerContributionRate = 0.02f; // 2%
        }

        float pagIBIGContribution = Salary * (employeeContributionRate + employerContributionRate);

        if (pagIBIGContribution > 100) {
            pagIBIGContribution = 100; // Maximum contribution amount is 100
        }

        return pagIBIGContribution;
    }

    /**
     * Calculate PhilHealth contribution based on basic salary.
     *
     * @param Salary the basic salary of the employee
     * @return the PhilHealth contribution as a String
     */
    public float calculatePhilHealthContribution(float Salary) {

        float premiumRate = 0.03f; // Premium rate is 3%
        float monthlyPremium = 0;

        if (Salary <= 10000) {
            monthlyPremium = 300;
        } else if (Salary > 10000 && Salary <= 59999.99) {
            monthlyPremium = Salary * premiumRate;
            if (monthlyPremium < 300) {
                monthlyPremium = 300;
            } else if (monthlyPremium > 1800) {
                monthlyPremium = 1800;
            }
        } else if (Salary >= 60000) {
            monthlyPremium = 1800;
        }

        float philHealthContribution = monthlyPremium * 0.5f; // Employee's share is 50%
        
        return philHealthContribution;
    }

    /**
     * Calculate SSS contribution based on basic salary.
     *
     * @param basicSalary the basic salary of the employee
     * @return the SSS contribution as a String
     */
    public float calculateSSSContribution(float Salary) {
        float sssContribution = (float) 0.00;

        if (Salary < 3250) {
            sssContribution = (float) 135.00;
        } else if (Salary >= 3250 && Salary <= 24750) {
            float[] salaryRanges = {3250, 3750, 4250, 4750, 5250, 5750, 6250, 6750, 7250, 7750, 8250, 8750, 9250,
                    9750, 10250, 10750, 11250, 11750, 12250, 12750, 13250, 13750, 14250, 14750, 15250, 15750, 16250,
                    16750, 17250, 17750, 18250, 18750, 19250, 19750, 20250, 20750, 21250, 21750, 22250, 22750, 23250,
                    23750, 24250, 24750};

            float[] contributions = {135.00f, 157.50f, 180.00f, 202.50f, 225.00f, 247.50f, 270.00f, 292.50f, 315.00f,
                    337.50f, 360.00f, 382.50f, 405.00f, 427.50f, 450.00f, 472.50f, 495.00f, 517.50f, 540.00f, 562.50f,
                    585.00f, 607.50f, 630.00f, 652.50f, 675.00f, 697.50f, 720.00f, 742.50f, 765.00f, 787.50f, 810.00f,
                    832.50f, 855.00f, 877.50f, 900.00f, 922.50f, 945.00f, 967.50f, 990.00f, 1012.50f, 1035.00f, 1057.50f,
                    1080.00f, 1102.50f, 1125.00f};

            for (int i = 0; i < salaryRanges.length - 1; i++) {
                if (Salary >= salaryRanges[i] && Salary < salaryRanges[i + 1]) {
                    sssContribution = contributions[i];
                    break;
                }
            }
        } else {
            sssContribution = (float) 1125.00;
        }

        return sssContribution;
    }

    /**
     * Calculate withholding tax based on taxable income.
     *
     * @param taxableIncome the taxable income of the employee
     * @return the withholding tax as a float
     */
    public float calculateWithholdingTax(float taxableIncome) {
        float withholdingTax = 0.0f;

        if (taxableIncome <= 20833) {
            withholdingTax = 0.0f; // No tax
        } else if (taxableIncome > 20833 && taxableIncome <= 33333) {
            withholdingTax = (taxableIncome - 20833) * 0.20f;
        } else if (taxableIncome > 33333 && taxableIncome <= 66667) {
            withholdingTax = 2500 + (taxableIncome - 33333) * 0.25f;
        } else if (taxableIncome > 66667 && taxableIncome <= 166667) {
            withholdingTax = 10833.33f + (taxableIncome - 66667) * 0.30f;
        } else if (taxableIncome > 166667 && taxableIncome <= 666667) {
            withholdingTax = 40833.33f + (taxableIncome - 166667) * 0.32f;
        } else if (taxableIncome > 666667) {
            withholdingTax = 200833.33f + (taxableIncome - 666667) * 0.35f;
        }

        return withholdingTax;
    }    
}
