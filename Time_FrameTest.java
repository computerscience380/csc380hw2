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
public class Time_FrameTest {
    
    @Test
    public void testHasRes(){
        Time_Frame t = new Time_Frame();
        String one = "1";
        String two = "2";
        int three = 3;
        String time = "6:30 am";
        Reservation r = new Reservation(one, two, three);
        t.addRes(r, time);
        
        if (!t.hasRes()) {
            fail("ERROR: RESERVATION NOT ADDED");
        }
    }
    
    @Test
    public void testHasNoRes(){
        Time_Frame t = new Time_Frame();
        if (t.hasRes()) {
            fail("ERROR: THERE IS A RESERVATION WHEN THERE SHOULD BE NO RESERVATIONS");
        }
    }
}
