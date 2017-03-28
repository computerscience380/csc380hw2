/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.csc380homework;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Sean McGrath
 */
public class Parking_Lot {//maybe allow requesting a specific spot? (then check if avaiable and if not say something, if so then add it)

    private String parkingLotName;
    private Parking_Spot lot[];

    public void addReservation(Reservation R, int day, String T1) { //only one time slot reservation      
        for (int i = 0; i < lot.length; i++) {
            if(lot[i].spotsAvailbleAtTimeAndDay(day, T1)){
                lot[i].reserve(R, day, T1);
                System.out.println("Your reservation has been set at parking spot number " + lot[i].getID() + " from " + T1 + " to " + roundOff(T1) + " on day " + day + " of this month");
                break;
            }
        }
    }

    public void addReservation(Reservation r, int day, String T1, String T2) { // two or more reservations(will be in a row)
        for (int i = 0; i < lot.length; i++) {
            if(lot[i].spotsAvailbleAtTimeAndDay(day, T1, T2)){
                lot[i].reserve(r, day, T1, T2);
                System.out.println("Your reservation has been set at parking spot number " + lot[i].getID() + " from " + T1 + " to " + T2 + " on day " + day + " of this month");
                break;
            }
        }
    }

    public String getLotName() {
        return parkingLotName;
    }

    public boolean spotsAvailbleAtTimeAndDay(int day, String T1) {
        //check if a reservation can be made at such and such day/time    
        for (int i = 0; i < lot.length; i++) {
            lot[i].update();
            if (lot[i].spotsAvailbleAtTimeAndDay(day, T1)) {
                return true;
            }
        }
        return false;
    }

    public boolean spotsAvailbleAtTimeAndDay(int day, String T1, String T2) {
        //check if a reservation can be made at such and such day/time   
        for (int i = 0; i < lot.length; i++) {
            lot[i].update();
            if (lot[i].spotsAvailbleAtTimeAndDay(day, T1, T2)) {
                return true;
            }
        }
        return false;
    }

    public Parking_Lot(int spots, String lotName) {
        Parking_Spot p;

        lot = new Parking_Spot[spots];
        for (int i = 0; i < spots; i++) {//initializes all the parking spots
            p = new Parking_Spot(i + 1);
            lot[i] = p;
        }
        parkingLotName = lotName;
    }
    
    public static String roundOff(String time) {
        String pattern = "^([1-9]|1[0-2]):([0-5][0-9]) ([APap][mM]$)";
        Pattern r = Pattern.compile(pattern);
        Matcher ma = r.matcher(time);
        if (ma.matches()) {
            int m = Integer.parseInt(ma.group(2));
            m = m+29;
            String fin = ma.group(1)+ ":" + m + " " + ma.group(3);
            return fin;
        } else {
            System.out.println("ERROR: BAD INPUT");
            return time;
        }
    }
    //maybe more methods later as needed
    //isEmpty nd isFull are useless in this iteration(reservations based on an interface instead of keeping track of the parking lot with some sort of scanner), their usablity has been taken over by spotsAvailbleAtTimeAndDay
}
