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
public class DayTest {

    @Test
    public void TestAddDay() {
        int day = 12;
        Day d = new Day(day);

        if (d.getDay() != day) {
            fail();
        }
    }

    @Test
    public void addRescanResTest() {
        int time = 7;
        int time2 = 8;
        int day = 12;
        Day d = new Day(day);

        if (!d.can_Res(time, time2)) {
            fail();
        }
    }
}
