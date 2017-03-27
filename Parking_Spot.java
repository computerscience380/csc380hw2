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
            System.out.println("Updating parking spot");
            month = Calendar.getInstance().getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.getDefault());
            this.setDays(Calendar.getInstance().getActualMaximum(Calendar.DAY_OF_MONTH));
        } else {
            System.out.println("Parking spot already up to date");
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
        System.out.println(days[d]);
        return days[d].can_Res(time);
    }

    public boolean spotsAvailbleAtTimeAndDay(int d, String T1, String T2) {
        return days[d].can_Res(T1, T2);
    }
    
    public void printResInfo(int d){
      //  System.out.println(days[d].???);
    }

}
