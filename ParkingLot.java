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
public class ParkingLot {
    
    private final String parkingLotName;    
    private final Parking_Spot lot[];
    
    public void addReservation(Reservation R, int T1){ //only one time slot reservation      
        //unwritten so far
        // make a reservation
    }
    
    public void addReservation(Reservation r, int T1, int T2){ // two or more reservations(will be in a row)
        
    }
    
    public String getLotName() {
        return parkingLotName;
    }
    
    public boolean spotsAvailbleAtTimeAndDay(int day, int time){
        //check if a reservation can be made at such and such day/time    !unwritten!
        return true;
    }
    
    public ParkingLot(int spots, String lotName){
        Parking_Spot p;
                
        lot = new Parking_Spot[spots];
        for (int i = 0; i < spots; i++) {//initializes all the parking spots
            p = new Parking_Spot(i+1);
            lot[i] = p;
        }
        parkingLotName = lotName;
    }
    
    public void parkingSpotsToString(){
        System.out.println("Parking lot: " + this.getLotName());
        for (int i = 0; i < lot.length; i++) {
            lot[i].update();
            lot[i].spotToString();
        }
    }
    
    public void checkParkingSpot(int i){
        for (int j = 0; j < lot.length; j++) {
            if (lot[j].getID() == i) {
                lot[j].spotToString();
                break;
            }
        }
    }
    
    //maybe more methods later as needed
    //isEmpty nd isFull are useless in this iteration(reservations based on an interface instead of keeping track of the parking lot with some sort of scanner), their usablity has been taken over by spotsAvailbleAtTimeAndDay
}
