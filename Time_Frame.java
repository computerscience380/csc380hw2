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
    
    public void addRes(Reservation r) {
        res = r;
    }
    
    public boolean hasRes(){
        if (res == null) {
            return false;
        } else {
            return true;
        }
    }
}
