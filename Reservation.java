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
    
    String licencePlate;
    String name;
    int permit;
    
    public String returnPlate(){
        return licencePlate;
    }
    public String returnName(){
        return name;
    }
    
    public Reservation(String n, String plate, int permitNum){
       licencePlate = plate;
       name = n;
       permit = permitNum; 
    }
    
    
}
