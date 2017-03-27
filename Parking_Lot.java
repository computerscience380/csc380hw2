/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.csc380homework;

/**
 *
 * @author Sean McGrath
 */
public class Parking_Lot {

    private String parkingLotName;
    private Parking_Spot lot[];

    public boolean addReservation(Reservation R, int day, String T1) { //only one time slot reservation      
        for (int i = 0; i < lot.length; i++) {
            if(lot[i].spotsAvailbleAtTimeAndDay(day, T1)){
                lot[i].reserve(R, day, T1);
                System.out.println("Your reservation has been set at parking spot number " + lot[i].getID() + "at time " + T1 + " on day " + day + " of this month");
                return true;
            }
        }
        return false;
    }

    public void addReservation(Reservation r, int day, String T1, String T2) { // two or more reservations(will be in a row)

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

    public void parkingSpotsToString() {
        System.out.println("Parking lot: " + this.getLotName());
        for (int i = 0; i < lot.length; i++) {
            lot[i].update();
           // lot[i].spotToString();
        }
    }

    public void checkParkingSpot(int i, int d) {
        for (int j = 0; j < lot.length; j++) {
            if (lot[j].getID() == i) {
                lot[j].printResInfo(d);
                break;
            }
        }
    }

    //maybe more methods later as needed
    //isEmpty nd isFull are useless in this iteration(reservations based on an interface instead of keeping track of the parking lot with some sort of scanner), their usablity has been taken over by spotsAvailbleAtTimeAndDay
}
