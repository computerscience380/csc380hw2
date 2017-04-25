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
public class Time_Frame {

    private Reservation res;
    private int time;

    public Reservation reserve(Reservation r) {
        res = r;
        return res;
    }
    
    public Time_Frame(int i){
        res = null;
        setTime(i);
    }

    public boolean hasRes() {
        return res != null;
    }

    public Reservation getRes() {
        return res;
    }

    public int getTime() {
        return time;
    }

    private void setTime(int t) {
        time = t;
    }
}
