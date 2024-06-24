/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.baseActions;

/**
 *
 * @author JD Morales
 */
public class EmpAllowances {
    private int id;
    private float basicSalary;
    private float riceAllowance;
    private float phoneAllowance;
    private float clothingAllowance;
    private float grossSemiMonthlyRate;
    private float hourlyRate;
    private float totalAllowance;
    
    public EmpAllowances(int id) {
        this.id = id;
    } 
    
    public EmpAllowances(int id,float riceAllowance, float phoneAllowance, float clothingAllowance) {
        this.id = id;
        this.riceAllowance = riceAllowance;
        this.phoneAllowance = phoneAllowance;
        this.clothingAllowance = clothingAllowance;
    }

    public EmpAllowances(int id, float basicSalary,float riceAllowance, float phoneAllowance, float clothingAllowance,
             float grossSemiMonthlyRate, float hourlyRate) {
        this.id = id;
        this.basicSalary = basicSalary;
        this.riceAllowance = riceAllowance;
        this.phoneAllowance = phoneAllowance;
        this.clothingAllowance = clothingAllowance;  
        this.grossSemiMonthlyRate = grossSemiMonthlyRate;
        this.hourlyRate = hourlyRate;
    }    
    
    public EmpAllowances() {
    }   
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    
     public float getBasicSalary() {
        return basicSalary;
    }

    public void setBasicSalary(float basicSalary) {
        this.basicSalary = basicSalary;
    }    
    
     public float getRiceAllowance() {
        return riceAllowance;
    }

    public void setRiceAllowance(float riceAllowance) {
        this.riceAllowance = riceAllowance;
    }

    
    public float getPhoneAllowance() {
        return phoneAllowance;
    }

    public void setPhonAllowance(float phoneAllowance) {
        this.phoneAllowance = phoneAllowance;
    }

    public float getClothingAllowance() {
        return clothingAllowance;
    }

    public void setClothingAllowance(float clothingAllowance) {
        this.clothingAllowance = clothingAllowance;
    }

     public float getGrossSemiMonthlyRate() {
        return grossSemiMonthlyRate;
    }

    public void setGrossSemiMonthlyRate(float grossSemiMonthlyRate) {
        this.grossSemiMonthlyRate = grossSemiMonthlyRate;
    }
    
     public float getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(float hourlyRate) {
        this.hourlyRate = hourlyRate;
    }    

    public float getTotalAllowance() {
        return totalAllowance;
    }

    public void setTotalAllowance(float totalAllowance) {
        this.totalAllowance = totalAllowance;
    }      
}
