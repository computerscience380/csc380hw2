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
public class Alert {
    private String location;
    private int parkingSpot;
    private String comment = null;
    
    private void setComment(String c) {
        comment = c;
    }
    private void setSpot(int s) {
        parkingSpot = s;
    }
    private void setLocation(String l){
        location = l;
    }
    
    public String getLocation(){
        return location;
    }
    public int getSpot(){
        return parkingSpot;
    }
    public String getComment(){
        return comment;
    }
    
    public Alert(String lot, int spot, String comment){
        setComment(comment);
        setSpot(spot);
        setLocation(lot);
    }
    public Alert(String lot, int spot){
        setSpot(spot);
        setLocation(lot);
    }
}
