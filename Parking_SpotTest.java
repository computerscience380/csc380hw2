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
public class Parking_SpotTest {
    
    @Test
    public void spotsAvailbleTest(){
        Parking_Spot p = new Parking_Spot(4);
        if (!p.spotsAvailble(1, 5, 8)) {
            fail();
        }
    } 
}
