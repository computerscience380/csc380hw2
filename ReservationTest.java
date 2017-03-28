/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.csc380homework;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Sean McGrath
 */
public class ReservationTest {
    
    @Test
    public void setVariablesTest(){
        String one = "1";
        String two = "2";
        int three = 3;
        Reservation r = new Reservation(one,two,three);
        if (!r.getName().equals(one)) {
            fail("ERROR: Name not added");
        }
        if (!r.getPlate().equals(two)) {
            fail("ERROR: Plate not added");
        }
        if (r.getPermit() != three) {
            fail("ERROR: permit not added");
        }
        
    }
    

   
}
