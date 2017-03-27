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

    public void create_Res(Reservation r, String T1, String T2) {
        if (this.can_Res(timeStart, timeEnd)) {
            for (int i = timeStart; i < timeEnd; i++) {
                frames[i].addRes(r);
                //return true;
            }
        } else {
            //print out all the times that are already reserved
            //return false;
        }
    }
    public void create_Res(Reservation r, String time) {
        frames[this.translateToInt(time)].addRes(r, time);
    }

    public boolean can_Res(String timeStart, String timeEnd) { //check for conflicting reservation times
        boolean can = true;
        for (int i = this.translateToInt(timeStart); i <= this.translateToInt(timeEnd) ; i++) {
            if (frames[i].hasRes) {
                can = false;//can't
            }
        }
        return can;
    }

    public boolean can_Res(String time) {
        System.out.println(time);
        System.out.println(frames.length);
        return !frames[this.translateToInt(time)].hasRes();
    }
    
    public void getWhy(){//when the 2 time get res fails, use this to print out all conflicting times
        
    }

    public void printRes(String time) {
        System.out.println(frames[this.translateToInt(time)].getRes().toString());
    }

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
    //more methods to retrieve the information/check if a reservation is available

    //another method to translate the time of a res into a printable time
    
    public int translateToInt(String time) {
        String pattern = "^([1-9]|1[0-2]):([0-5][0-9]) ([APap][mM]$)";
        Pattern r = Pattern.compile(pattern);
        Matcher ma = r.matcher(time);

        if (ma.matches()) {
            String h = ma.group(1);
            int m = Integer.parseInt(ma.group(2));
            String period = ma.group(3);
            String t = "";

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
