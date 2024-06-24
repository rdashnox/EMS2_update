/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.baseActions;

/**
 *
 * @author JD Morales
 */
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.Map;

public class WorkHoursCalculator {
    public static final int REGULAR_WORK_HOURS = 8;
    private static final int REGULAR_WORK_MINUTES = REGULAR_WORK_HOURS * 60;
    
    public long calcMinutesWorked = 0;
    public long calcOvertimeMinutes = 0;
    public long calcUndertimeMinutes = 0;

    // Store work times for each day
    private Map<LocalDate, LocalTime[]> workTimes = new HashMap<>();

    // Add work times for a specific day
    public void addWorkTime(LocalDate date, LocalTime startTime, LocalTime endTime) {
        workTimes.put(date, new LocalTime[]{startTime, endTime});
    }

    // Calculate total minutes worked in a day
    public long calculateMinutesWorked(LocalTime startTime, LocalTime endTime) {
        return ChronoUnit.MINUTES.between(startTime, endTime);
    }

    // Calculate total hours and minutes worked in a month
    public void calculateMonthlyWorkHours(int month, int year) {
        long totalMinutesWorked = 0;
        long totalOvertimeMinutes = 0;
        long totalUndertimeMinutes = 0;

        LocalDate startDate = LocalDate.of(year, month, 1);
        LocalDate endDate = startDate.withDayOfMonth(startDate.lengthOfMonth());

        for (LocalDate date = startDate; !date.isAfter(endDate); date = date.plusDays(1)) {
            if (workTimes.containsKey(date)) {
                LocalTime[] times = workTimes.get(date);
                long minutesWorked = calculateMinutesWorked(times[0], times[1]);

                totalMinutesWorked += minutesWorked;
                // Deducted the 1 hour break between the Time-in and Time-out
                totalMinutesWorked -= 60;

                if (minutesWorked > REGULAR_WORK_MINUTES) {
                    totalOvertimeMinutes += (minutesWorked - REGULAR_WORK_MINUTES);
                } else if (minutesWorked < REGULAR_WORK_MINUTES) {
                    totalUndertimeMinutes += (REGULAR_WORK_MINUTES - minutesWorked);
                }
            }
        }

        System.out.println("Total hours worked: " + totalMinutesWorked / 60 + " hours and " + totalMinutesWorked % 60 + " minutes");
        System.out.println("Overtime: " + totalOvertimeMinutes / 60 + " hours and " + totalOvertimeMinutes % 60 + " minutes");
        System.out.println("Undertime: " + totalUndertimeMinutes / 60 + " hours and " + totalUndertimeMinutes % 60 + " minutes");
        
        calcMinutesWorked = totalMinutesWorked;
        calcOvertimeMinutes = totalOvertimeMinutes;
        calcUndertimeMinutes = totalUndertimeMinutes;
    }

//    public static void main(String[] args) {
//        WorkHoursCalculator calculator = new WorkHoursCalculator();
//
//        // Example usage
//        calculator.addWorkTime(LocalDate.of(2024, 6, 1), LocalTime.of(9, 0), LocalTime.of(17, 0));  // 8 hours
//        calculator.addWorkTime(LocalDate.of(2024, 6, 2), LocalTime.of(9, 0), LocalTime.of(18, 0));  // 9 hours
//        calculator.addWorkTime(LocalDate.of(2024, 6, 3), LocalTime.of(10, 0), LocalTime.of(15, 0)); // 5 hours
//        calculator.addWorkTime(LocalDate.of(2024, 6, 4), LocalTime.of(8, 30), LocalTime.of(16, 30)); // 8 hours
//        // Add more work times as needed
//
//        calculator.calculateMonthlyWorkHours(2024, 6);
//    }
}
