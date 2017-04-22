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

    private Account account;
    private int spot;
    private int day;

    public Account getAccount(){
        return account;
    }
    
    public int getSpot(){
        return spot;
    }
    
    public int getDay(){
        return day;
    }

    private void setAccount(Account a) {
        account = a;
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

    public Reservation(Account a) {
        setAccount(a);
    }
}
//go thru each posibility, ask if has res, if so print it
//maybe ask for confirmation of given information before reserving in main class
