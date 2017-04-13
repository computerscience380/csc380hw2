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
    private Time_Frame[] frames;//???

    public void create_Res(Reservation r, int T1, int T2) {//go from first res to one less than last res like in can_Res(because T2 isnt a res its only a marker for hen reservations stop)
//res[]???
        for (int i = T1; i < T2; i++) {
            if (!frames[i].hasRes()) {
                frames[i].addRes(r, unTranslate(i));
            } 
        }
    }

    public void displayRes() {
        
    }

    public boolean can_Res(int timeStart, int timeEnd) { //check for conflicting reservation times
        boolean can = true;
        for (int i = timeStart; i < timeEnd ; i++) {
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
            frames[i] = new Time_Frame();
        }
        //initialize the time frames here, also set the day number
    }

    private String unTranslate(int i) {
        switch (i) {
            case 0:
                return "12:00 am";
            case 1:
                return "12:30 am";
            case 2:
                return "1:00 am";
            case 3:
                return "1:30 am";
            case 4:
                return "2:00 am";
            case 5:
                return "2:30 am";
            case 6:
                return "3:00 am";
            case 7:
                return "3:30 am";
            case 8:
                return "4:00 am";
            case 9:
                return "4:30 am";
            case 10:
                return "5:00 am";
            case 11:
                return "5:30 am";
            case 12:
                return "6:00 am";
            case 13:
                return "6:30 am";
            case 14:
                return "7:00 am";
            case 15:
                return "7:30 am";
            case 16:
                return "8:00 am";
            case 17:
                return "8:30 am";
            case 18:
                return "9:00 am";
            case 19:
                return "9:30 am";
            case 20:
                return "10:00 am";
            case 21:
                return "10:30 am";
            case 22:
                return "11:00 am";
            case 23:
                return "11:30 am";
            case 24:
                return "12:00 pm";
            case 25:
                return "12:30 pm";
            case 26:
                return "1:00 pm";
            case 27:
                return "1:30 pm";
            case 28:
                return "2:00 pm";
            case 29:
                return "2:30 pm";
            case 30:
                return "3:00 pm";
            case 31:
                return "3:30 pm";
            case 32:
                return "4:00 pm";
            case 33:
                return "4:30 pm";
            case 34:
                return "5:00 pm";
            case 35:
                return "5:30 pm";
            case 36:
                return "6:00 pm";
            case 37:
                return "6:30 pm";
            case 38:
                return "7:00 pm";
            case 39:
                return "7:30 pm";
            case 40:
                return "8:00 pm";
            case 41:
                return "8:30 pm";
            case 42:
                return "9:00 pm";
            case 43:
                return "9:30 pm";
            case 44:
                return "10:00 pm";
            case 45:
                return "10:30 pm";
            case 46:
                return "11:00 pm";
            case 47:
                return "11:30 pm";
        }
        return null;
    }
}
