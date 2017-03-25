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
    private final int day;
    private Time_Frame[] frames;

    public boolean create_Res(Reservation r ,int timeStart, int timeEnd){
            if (frames[time].hasRes()) {
                return false;
            } else {
                frames[time].addRes(r);
                return true;
            }
    }
    
    private void setDay(){
        
    }
    
    public int getDay(){
        return day;
    }
    
    public Day_res(){
        this.frames = new Time_Frame[48];
        //initialize the time frames here, also set the day number
    }
    //more methods to retrieve the information/check if a reservation is available
}
