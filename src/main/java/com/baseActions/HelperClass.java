/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.baseActions;

/**
 *
 * @author JD Morales
 */
import java.time.YearMonth;
import java.time.LocalDate;

public class HelperClass {

    /**
     * Get the last day of the month for a given month and year.
     *
     * @param year  the year
     * @param month the month (1-12)
     * @return the last day of the month as a LocalDate
     */
    public static LocalDate getLastDayOfMonth(int month, int year) {
        YearMonth yearMonth = YearMonth.of(year, month);
        return yearMonth.atEndOfMonth();
    }
    
    public static LocalDate getFirstDayOfMonth(int month, int year) {
        YearMonth yearMonth = YearMonth.of(year, month);
        return yearMonth.atDay(1);
    }    

//    public static void main(String[] args) {
//        // Example usage
//        int year = 2024;
//        int month = 6; // June
//
//        LocalDate lastDay = getLastDayOfMonth(year, month);
//        System.out.println("The last day of " + month + "/" + year + " is " + lastDay);
//    }
}
