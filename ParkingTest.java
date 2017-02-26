/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Joe
 */
public class ParkingTest {
@Test
    public void TestIsEmpty(){
        Parking lot= new Parking();
        if(lot.isEmpty()){
            
        } else {
            fail("Error: not empty");
        }
    }
    @Test
    public void testAddCar(){
        Parking lot = new Parking();
        Car c = new Car();
        
        lot.addCar(c);
        
        if(lot.isEmpty()){
            fail("Error: car not added");
        }
    }
    @Test
    public void testRemoveCar(){
        Parking lot = new Parking();
        
        Car c = new Car();
        
        lot.addCar(c);
        lot.removeCar(c);
        
        if(!lot.isEmpty()){
            fail("Error: car not removed");        }
    }
    
    @Test
    public void testIsFull(){
        Parking lot = new Parking();
        
        Car c = new Car();
        
        if(!lot.isFull()){
            fail("Error: lot is full");
            
        }
    }
    
}
