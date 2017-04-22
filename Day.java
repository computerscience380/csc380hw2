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
public class Day {

    private int day;
    private Time_Frame[] frames;

    public Time_Frame[] reserve(Reservation r, int T1, int T2) {//go from first res to one less than last res like in can_Res(because T2 isnt a res its only a marker for hen reservations stop)
        for (int i = T1; i < T2; i++) {
            frames[i].reserve(r);
        }
        return frames;
    }

    public boolean can_Res(int timeStart, int timeEnd) { //check for conflicting reservation times
        boolean can = true;
        for (int i = timeStart; i < timeEnd; i++) {
            if (frames[i].hasRes()) {
                can = false;//can't
                break;
            }
        }
        return can;
    }

    private void setDay(int d) {
        day = d;
    }

    public int getDay() {
        return day;
    }

    public Day(int day) {
        this.frames = new Time_Frame[48];
        this.setDay(day);
        for (int i = 0; i < frames.length; i++) {
            frames[i] = new Time_Frame(i);
        }
    }

//    public Reservation[] getRes() {
//        Reservation[] rs = new Reservation[48];
//        int counter = 0;
//        for (Time_Frame frame : frames) {
//            if (frame.getRes() != null) {
//                Reservation r = frame.getRes();
//                rs[counter] = r;
//                counter++;
//            }
//        }
//        return rs;
//    }

    public boolean hasReservations() { //checks for ANY reservations
        for (Time_Frame frame : frames) {
            if (frame.hasRes()) {
                return true;
            }
        }
        return false;
    }

    public Time_Frame[] getFrames() {
        return frames;
    }
}
