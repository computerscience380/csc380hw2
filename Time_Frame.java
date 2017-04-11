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
    boolean has = false;
    private String time;
    
    public void addRes(Reservation r, String t) {
        this.setTime(t);
        res = r;
        has = true;
    }
    
    public boolean hasRes(){
        return has;
    }
    
    public Reservation getRes(){
        return res;
    }
    
    public String getTime(){
        return time;
    }
    
    private void setTime(String t){
        time = t;
    }
    
    public void removeRes(){
      has = false;
      res = null;
      this.setTime(null);
    }
    
    public String toString(){
        return "    At time: " + this.getTime() + "\n" + this.getRes().toString();
    }
}
