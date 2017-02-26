/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample;
import java.util.ArrayList;

/**
 *
 * @author Joe
 */
public class Parking {
    ArrayList<Car> lot = new ArrayList<>(200);
   
    public boolean isEmpty(){
        return lot.isEmpty();
    }
    
    public void addCar(Car c){
        lot.add(c);
    }
    public void removeCar(Car c){
        lot.remove(c);
    }
    public boolean isFull(){
        if(lot.get(lot.size()-1) != null){
            return true;
    } else{
            return false;
        }
}
}

