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
public class ParkingLot {
    
    private final String parkingLotName;
    
    private final Parking_Spot lot[];
    private final int max; //how many parking spots there are, might not need later on
    
    
    
    public void addReservation(){ //parameters to be added later        
        //unwritten so far
        // make a reservation
    }
    
    public String getLotName() {
        return parkingLotName;
    }
    
    public boolean spotsAvailbleAtTimeAndDay(int day, int time){
        //check if a reservation can be made at such and such day/time    !unwritten!
        return true;
    }
    
    private static boolean isLeapYear(int year) {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, year);
        return cal.getActualMaximum(Calendar.DAY_OF_YEAR) > 365;
    }
    
    public ParkingLot(int spots, String lotName){
        
        String month = Calendar.getInstance().getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.getDefault());
        int year = Calendar.getInstance().get(Calendar.YEAR);
        int m;
        if (isLeapYear(year) && Calendar.getInstance().get(Calendar.MONTH) == 1) {
            m = 0;
        } else {
            m = Calendar.getInstance().get(Calendar.MONTH)+1;
        }
        
        Parking_Spot p;
                
        lot = new Parking_Spot[spots];
        for (int i = 0; i < spots; i++) {//initializes all the parking spots
            p = new Parking_Spot(i+1, m, month);
            lot[i] = p;
        }
        parkingLotName = lotName;
        max = spots;
    }
    
    //maybe more methods later as needed
    //isEmpty nd isFull are useless in this iteration(reservations based on an interface instead of keeping track of the parking lot with some sort of scanner), their usablity has been taken over by spotsAvailbleAtTimeAndDay
}
