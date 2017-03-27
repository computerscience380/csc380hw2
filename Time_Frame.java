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
    Reservation res;
    boolean hasRes = false;
    String time;
    
    public void addRes(Reservation r, String t) {
        time = t;
        res = r;
        hasRes = true;
    }
    
    public boolean hasRes(){
        return hasRes;
    }
    
    public Reservation getRes(){
        return res;
    }
    
    public void removeRes(){
        
    }
}
