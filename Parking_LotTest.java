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
        Account a = new Account("a", "a", "1", "2", "3", "student", "554736");
        Reservation r = new Reservation(a);
        int spot = l.reserve(r, day, time, time2);
        
        if (spot != 1) {
            fail();
        }
    }
    @Test
    public void spotsAvailbleTest(){
        Parking_Lot lot = new Parking_Lot(4, "name");
        if (!lot.spotsAvailble(1, 5, 8)) {
            fail();
        }
    }
    @Test
    public void hasResTest() {
        Parking_Lot pl  = new Parking_Lot(1, "lot name");
        if (pl.hasReservations()) {
            fail();
        }
        Account a = new Account("a", "a", "1", "2", "3", "student", "554736");
        Reservation r = new Reservation(a);
        pl.reserve(r, 1 ,2, 4);
        if (!pl.hasReservations()) {
            fail();
        }
    }
}
