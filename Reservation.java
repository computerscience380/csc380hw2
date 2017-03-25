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
    
    private String licencePlate;
    private String name;
    private int permit;
    
    public String getPlate(){
        return licencePlate;
    }
    public String getName(){
        return name;
    }
    
    public int getPermit(){
        return permit;
    }
    
    private void setPlate(String pl){
        licencePlate = pl;
    }
    
    private void setName(String n){
        name = n;
    }
    
    private void setPermit(int p){
        permit = p;
    }
    
    public Reservation(String n, String plate, int permitNum){
       this.setPlate(plate);
       this.setName(n);
       this.setPermit(permitNum); 
    }
    
    
}
