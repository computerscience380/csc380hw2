/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Zach
 */
public class Car {
    String licencePlate;
    String name;
    
    public String returnPlate(){
        return licencePlate;
    }
    public String returnName(){
        return name;
    }
    public Car(String l, String t) {
        licencePlate = l;
        name = t;
    }
}
