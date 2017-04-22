/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.csc380homework;

import static org.junit.Assert.fail;
import org.junit.Test;

/**
 *
 * @author Sean McGrath
 */
public class Parking_LotTest {

    @Test
    public void reserveTest() {
        Parking_Lot l = new Parking_Lot(5, "test");
        int day = 15;
        int time = 1;
        int time2 = 4;
        String one = "1";
        String two = "2";
        String three = "3";
        Reservation r = new Reservation(one, two, three);
        Reservation r = l.reserve(r, day, time, time2);
        
        
        //check for existance of r
    }
}
