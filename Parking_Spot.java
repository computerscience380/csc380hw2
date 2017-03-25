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
public class Parking_Spot {
    
    private final int spotID;
    private static int one = 28;
    private static int two = 30;
    private static int three = 31;
    private static int leap = 29;
    private String month;
    
    public Day_res days[];
    
    public void update(){      
        if (!this.getMonth().equals(Calendar.getInstance().getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.getDefault()))) { //check whether is on right month
            System.out.println("Updating spot");
            month = Calendar.getInstance().getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.getDefault());
            int year = Calendar.getInstance().get(Calendar.YEAR);
            int m;
            if (isLeapYear(year) && month.equals("Febuary")) {
                m = 0;
            } else {
                m = Calendar.getInstance().get(Calendar.MONTH)+1;
            }
            
            if(m == 1 || m == 3 || m == 5 || m == 7 || m == 8 || m == 10 || m == 12){
                this.setDays(three);
            } else if(m == 2){
                this.setDays(one);
            }  else if(m == 4 || m == 6 || m == 9 || m == 11) {
                this.setDays(two);
            }  else {
                this.setDays(leap);
            }         
        } else {
            System.out.println("Parking spot up to date");
        }
    }
    
    private static boolean isLeapYear(int year) {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, year);
        return cal.getActualMaximum(Calendar.DAY_OF_YEAR) > 365;
    }
    
    public String getMonth(){
        return month;
    }
    
    private void setDays(int d){
        days = new Day_res[d];
    }
    
    public int getDays(){
        return days.length;
    }
    
    public Parking_Spot(int iD, int m, String fullM){//m is a number representaion of the month(I.E. 3 is march) and fullM is a string representation(I.E. "March")     months are needed so it knows how many days to add(28,29,30,or 31)
        spotID = iD;
        month = fullM;       
        if(m == 1 || m == 3 || m == 5 || m == 7 || m == 8 || m == 10 || m == 12){
            this.setDays(three);//31 days
        } else if(m == 4 || m == 6 || m == 9 || m == 11) {
            this.setDays(two); //30 days
        } else if(m == 2){
            this.setDays(one); //28 days
        } else {
            this.setDays(leap);//leap year AND febuary so 29 days
        }
    }
    
    public boolean reservation(){ //maybe void?, add param's later
        //!unwritten!
        return true;//just here so its not anoyingly red :(
    }
    
    public int getID(){
        return spotID;
    }
    
}
