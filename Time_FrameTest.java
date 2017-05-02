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
        Time_Frame t = new Time_Frame(1);
        if (t.hasRes()) {
            fail("");
        }
        Account a = new Account("a","a","1","2","3","student","554736");
        Reservation r = new Reservation(a);
        t.reserve(r);
        if (!t.hasRes()) {
            fail("");
        }
    }
    @Test
    public void reserveTest(){
        Time_Frame t = new Time_Frame(1);
        Account a = new Account("a","a","1","2","3","student","554736");
        Reservation r = new Reservation(a);
        t.reserve(r);
        if (!t.getRes().equals(r)) {
            fail();
        }
    }
}
