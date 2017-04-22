/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.csc380homework;

import java.util.Calendar;
import java.util.Locale;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Sean McGrath
 */
public class Parking_SpotTest {
    
    @Test
    public void Parking_SpotTest() {
        Parking_Spot p = new Parking_Spot(4);
        if (p.getID() != 4) {
            fail();
        }
        System.out.println(Calendar.getInstance().getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.getDefault()));
        
        if (!p.getMonth().equals(Calendar.getInstance().getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.getDefault()))) {
            fail();
        }
        
        System.out.println(Calendar.getInstance().getActualMaximum(Calendar.DAY_OF_MONTH));
        
        if (p.getDays() != Calendar.getInstance().getActualMaximum(Calendar.DAY_OF_MONTH)) {
            fail();
        }System.out.println("END OF TEST");
        System.out.println("");
        
        
    }
    
    
    @Test
    public void displayResTest(){
        Parking_Spot p = new Parking_Spot(4);
         String one = "1";
        String two = "2";
        int three = 3;
        Reservation r = new Reservation(one, two, three);
        
        p.reserve(r, 2, "5:00 am", "2:30 pm");
        p.displayRes();
        System.out.println("END OF TEST");
        System.out.println("");
    }
    
    @Test
    public void spotsAvailbleTest(){
        Parking_Spot p = new Parking_Spot(4);
        if (!p.spotsAvailbleAtTimeAndDay(1, "6:30 am")) {
            fail();
        }
    }
    
    
}
