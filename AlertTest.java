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
public class AlertTest {
    
    @Test
    public void AlertTest() {
        String location = "lot 2a";
        int spot = 7;
        String location2 = "lot 7c";
        int spot2 = 26;
        String comment = "Black SUV that is not supposed to be there";
        Alert a = new Alert(location, spot, comment);
        if (a.getSpot() != spot && !a.getLocation().equals(location) && !a.getComment().equals(comment)) {
            fail();
        }
        Alert b = new Alert(location2, spot2);        
        if (b.getSpot() != spot2 && !b.getLocation().equals(location2)) {
            fail();
        }
    }
    
    
}
