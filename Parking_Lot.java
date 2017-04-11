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
public class Parking_Lot {//maybe allow requesting a specific spot? (then check if avaiable and if not say something, if so then add it)

    private String parkingLotName;
    private Parking_Spot lot[];

    public void displayRes() {
        //
    }

    public int addReservation(Reservation r, int day, int T1, int T2) { // two or more reservations(will be in a row)
        for (int i = 0; i < lot.length; i++) {
            if (lot[i].spotsAvailble(day, T1, T2)) {
                lot[i].reserve(r, day, T1, T2);
                return lot[i].getID();
            }
        }
        return -1;
    }

    public String getLotName() {
        return parkingLotName;
    }

    public boolean spotsAvailble(int day, int T1, int T2) {
        //check if a reservation can be made at such and such day/time   
        for (int i = 0; i < lot.length; i++) {
            lot[i].update();
            if (lot[i].spotsAvailble(day, T1, T2)) {
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
}
