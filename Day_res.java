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
public class Day_res {
    private final Time_Frame[] frames = new Time_Frame[48];//48 reservable time slots, one for each half an hour in a 24 hour day

    public boolean create_Res(Reservation r ,int time){
            if (frames[time].hasRes()) {
                return false;
            } else {
                frames[time].addRes(r);
                return true;
            }
    }
    
    //more methods to retrieve the information/check if a reservation is available
}
