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
public class Reservation {

    private String licensePlate;
    private String name;
    private String permit;
    private int spot;
    private int day;

    public String getPlate() {
        return licensePlate;
    }

    public String getName() {
        return name;
    }

    public String getPermit() {
        return permit;
    }

    private void setPlate(String pl) {
        licensePlate = pl;
    }

    private void setName(String n) {
        name = n;
    }

    private void setPermit(String p) {
        permit = p;
    }

    public void setSpot(int s) {
        spot = s;
    }

    public void setDay(int d) {
        day = d;
    }

    private String postfix(int i) {//1st 2nd 3rd ect
        if (i == 1 || i == 21 || i == 31) {
            return "st";
        } else if (i == 2 || i == 22) {
            return "nd";
        } else if (i == 3 || i == 23) {
            return "rd";
        } else {
            return "th";
        }
    }

    public Reservation(String n, String plate, String permitNum) {
        setPlate(plate);
        setName(n);
        setPermit(permitNum);
    }

    @Override
    public String toString() {
        return "Parking spot #: " + spot
                + "\n Reserved by: " + name
                + "\n On the: " + day + postfix(day)
                + "\n License Plate: " + licensePlate
                + "\n Permit ID: " + permit;
    }

}
//go thru each posibility, ask if has res, if so print it
//maybe ask for confirmation of given information before reserving in main class
