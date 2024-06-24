/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.baseActions;

/**
 *
 * @author JD Morales
 */
public class EmpDeductions {
    private int id;
    private float basicSalary;
    private float pagIBIGContribution;
    private float philHealthContribution;
    private float sssContribution;
    private float withholdingTax;
    private float totalDeductions;
    
    public EmpDeductions(int id) {
        this.id = id;
    } 

    public EmpDeductions(int id, float basicSalary,float pagIBIGContribution, float philHealthContribution, float sssContribution,
             float withholdingTax, float totalDeductions) {
        this.id = id;
        this.basicSalary = basicSalary;
        this.pagIBIGContribution = pagIBIGContribution;
        this.philHealthContribution = philHealthContribution;
        this.sssContribution = sssContribution;  
        this.withholdingTax = withholdingTax;
        this.totalDeductions = totalDeductions;
    }    
    
    public EmpDeductions() {
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
    
     public float getPagIBIG() {
        return pagIBIGContribution;
    }

    public void setPagIBIG(float pagIBIGContribution) {
        this.pagIBIGContribution = pagIBIGContribution;
    }

    
    public float getPhilHealth() {
        return philHealthContribution;
    }

    public void setPhilHealth(float philHealthContribution) {
        this.philHealthContribution = philHealthContribution;
    }

    public float getSSS() {
        return sssContribution;
    }

    public void setSSS(float sssContribution) {
        this.sssContribution = sssContribution;
    }

     public float getWithholdingTax() {
        return withholdingTax;
    }

    public void setWithholdingTax(float withholdingTax) {
        this.withholdingTax = withholdingTax;
    }
    
     public float getTotalDeductions() {
        return totalDeductions;
    }

    public void setTotalDeductions(float totalDeductions) {
        this.totalDeductions = totalDeductions;
    }    
    
}
