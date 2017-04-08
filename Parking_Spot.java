/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.csc380homework;

import java.util.Calendar;
import java.util.Locale;

/**
 *
 * @author Sean McGrath
 */
public class Parking_Spot {

    private final int spotID;
    private String month;
    public Day_res days[];

    public void update() {
        if (!this.getMonth().equals(Calendar.getInstance().getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.getDefault()))) { //check whether is on right month
            System.out.println("Updating parking spot " + this.getID());
            month = Calendar.getInstance().getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.getDefault());
            this.setDays(Calendar.getInstance().getActualMaximum(Calendar.DAY_OF_MONTH));
        }
    }

    public String getMonth() {
        return month;
    }

    private void setDays(int d) {
        days = new Day_res[d];
        Day_res temp;
        
        for (int i = 0; i < d; i++) {//initialize all days
            temp = new Day_res(i+1);
            days[i] = temp;
        }
    }

    public int getDays() {
        return days.length;
    }

    public Parking_Spot(int iD) {//id # of spots from 1 to whatever the max is set to when lot is created
        spotID = iD;
        month = Calendar.getInstance().getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.getDefault());
        this.setDays(Calendar.getInstance().getActualMaximum(Calendar.DAY_OF_MONTH));
    }

    public void reserve(Reservation r,int d ,String T1) {
        days[d].create_Res(r, T1);
    }

    public void reserve(Reservation r,int d ,String T1, String T2) {
        days[d].create_Res(r, T1, T2);
    }

    public int getID() {
        return spotID;
    }

    public boolean spotsAvailbleAtTimeAndDay(int d, String time) {
        return days[d].can_Res(time);
    }

    public boolean spotsAvailbleAtTimeAndDay(int d, String T1, String T2) {
        return days[d].can_Res(T1, T2);
    }
    
    public boolean c(){
        for (int i = 0; i < days.length; i++) {
            if (days[i].can_Res("12:00 am", "11:59 pm")) {
                return true;
            }
        }
        return false;
    }
    
    public void displayRes(){
        String postFix;
        boolean c = false;
        
        
        System.out.println("  Month: " + this.getMonth());
        
        for (int i = 0; i < this.getDays(); i++) {
            if (days[i].getDay() == 1 || days[i].getDay() == 21 || days[i].getDay() == 31) {
                postFix = "st";
            } else if (days[i].getDay() == 2 || days[i].getDay() == 22) {
                postFix = "nd";
            } else if (days[i].getDay() == 3 || days[i].getDay() == 23) {
                postFix = "rd";
            } else {
                postFix = "th";
            }
            
            
            if (!days[i].can_Res("12:00 am", "11:59 pm")) {
                System.out.println("   The " + days[i].getDay() + postFix);
                days[i].displayRes();
                c = true;
            } 
        }
        if (!c) {
                System.out.println("   No reservations in this parking spot for this month  ");
        }
    }
}
