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
public class Day_resTest {
    
    @Test
    public void TestAddDay(){
        int day = 12;
        Day_res d = new Day_res(day);
        
        if (d.getDay() != day) {
            fail();
        }
    }
    
    @Test
    public void displayResTest(){
        String time = "6:30 am";
        Day_res d = new Day_res(12);
         String one = "1";
        String two = "2";
        int three = 3;
        Reservation r = new Reservation(one, two, three);
        
        d.create_Res(r, time);
        
        d.displayRes();
    }
    
    @Test
    public void canResTest(){
        String time = "6:30 am";
        int day = 12;
        Day_res d = new Day_res(day);
        
        if (!d.can_Res(time)) {
            fail();
        }
    }
    
    @Test
    public void canManyResTest(){
        String time = "6:30 am";
        String time2 = "8:00 am";
        int day = 12;
        Day_res d = new Day_res(day);
        if (!d.can_Res(time, time2)) {
            fail();
        }
    }
    
    @Test
    public void createSingleResTest(){
        String time = "6:30 am";
        Day_res d = new Day_res(12);
        String one = "1";
        String two = "2";
        int three = 3;
        Reservation r = new Reservation(one, two, three);
        
        d.create_Res(r, time);
        
        if (d.can_Res(time)) {
            fail();
        }
    }
}
