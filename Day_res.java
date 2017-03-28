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
public class Day_res {

    private int day;
    private Time_Frame[] frames;

    public void create_Res(Reservation r, String T1, String T2) {//go from first res to one less than last res like in can_Res(because T2 isnt a res its only a marker for hen reservations stop)

        for (int i = this.translateToInt(T1); i < this.translateToInt(T2); i++) {
            if (!frames[i].hasRes()) {
                frames[i].addRes(r, unTranslate(i));
            } else {
                System.out.println("How?, somehow already reserved");
            }
        }

        //print out all the times that are already reserved <- NO that goes in "can res"
        //return false;
    }

    public void create_Res(Reservation r, String time) {
        frames[this.translateToInt(time)].addRes(r, time);
    }

    public boolean can_Res(String timeStart, String timeEnd) { //check for conflicting reservation times
        boolean can = true;
        for (int i = this.translateToInt(timeStart); i < this.translateToInt(timeEnd); i++) {
            if (frames[i].hasRes()) {
                can = false;//can't
                break;
            }
        }
        return can;
    }

    public boolean can_Res(String time) {
        return !frames[this.translateToInt(time)].hasRes();
    }

    public void getWhy() {//when the 2 time get res fails, use this to print out all conflicting times

    }

//    public void printRes(String time) {
//        System.out.println(frames[this.translateToInt(time)].getRes().toString());
//    }
    private void setDay(int d) {
        day = d;
    }

    public int getDay() {
        return day;
    }

    public Day_res(int day) {
        this.frames = new Time_Frame[48];
        this.setDay(day);
        for (int i = 0; i < frames.length; i++) {
            frames[i] = new Time_Frame();
        }
        //initialize the time frames here, also set the day number
    }

    //another method to translate the time of a res into a printable time
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

    private int translateToInt(String time) {
        String pattern = "^([1-9]|1[0-2]):([0-5][0-9]) ([APap][mM]$)";
        Pattern r = Pattern.compile(pattern);
        Matcher ma = r.matcher(time);
        if (time.equals("11:59 pm")) {
            return 48;
        }

        if (ma.matches()) {
            String h = ma.group(1);
            int m = Integer.parseInt(ma.group(2));
            String period = ma.group(3);

            if (period.equals("AM") || period.equals("am") || period.equals("aM") || period.equals("Am")) { //unfinished, needs more logic updating
                switch (h) {
                    case "12":
                        if (m == 0) {
                            return 0;
                        } else {
                            return 1;
                        }
                    case "1":
                        if (m == 0) {
                            return 2;
                        } else {
                            return 3;
                        }
                    case "2":
                        if (m == 0) {
                            return 4;
                        } else {
                            return 5;
                        }
                    case "3":
                        if (m == 0) {
                            return 6;
                        } else {
                            return 7;
                        }
                    case "4":
                        if (m == 0) {
                            return 8;
                        } else {
                            return 9;
                        }
                    case "5":
                        if (m == 0) {
                            return 10;
                        } else {
                            return 11;
                        }
                    case "6":
                        if (m == 0) {
                            return 12;
                        } else {
                            return 13;
                        }
                    case "7":
                        if (m == 0) {
                            return 14;
                        } else {
                            return 15;
                        }
                    case "8":
                        if (m == 0) {
                            return 16;
                        } else {
                            return 17;
                        }
                    case "9":
                        if (m == 0) {
                            return 18;
                        } else {
                            return 19;
                        }
                    case "10":
                        if (m == 0) {
                            return 20;
                        } else {
                            return 21;
                        }
                    case "11":
                        if (m == 0) {
                            return 22;
                        } else {
                            return 23;
                        }
                    default:
                        System.out.println("UNKNOWN ERROR");
                        return -1;
                }
            } else {
                switch (h) {
                    case "12":
                        if (m == 0) {
                            return 24;
                        } else {
                            return 25;
                        }
                    case "1":
                        if (m == 0) {
                            return 26;
                        } else {
                            return 27;
                        }
                    case "2":
                        if (m == 0) {
                            return 28;
                        } else {
                            return 29;
                        }
                    case "3":
                        if (m == 0) {
                            return 30;
                        } else {
                            return 31;
                        }
                    case "4":
                        if (m == 0) {
                            return 32;
                        } else {
                            return 33;
                        }
                    case "5":
                        if (m == 0) {
                            return 34;
                        } else {
                            return 35;
                        }
                    case "6":
                        if (m == 0) {
                            return 36;
                        } else {
                            return 37;
                        }
                    case "7":
                        if (m == 0) {
                            return 38;
                        } else {
                            return 39;
                        }
                    case "8":
                        if (m == 0) {
                            return 40;
                        } else {
                            return 41;
                        }
                    case "9":
                        if (m == 0) {
                            return 42;
                        } else {
                            return 43;
                        }
                    case "10":
                        if (m == 0) {
                            return 44;
                        } else {
                            return 45;
                        }
                    case "11":
                        if (m == 0) {
                            return 46;
                        } else {
                            return 47;
                        }
                    default:
                        System.out.println("UNKNOWN ERROR");
                        return -1;
                }
            }
        } else {
            System.out.println("ERROR: bad input of " + time);
            return -1;
        }
    }
}
