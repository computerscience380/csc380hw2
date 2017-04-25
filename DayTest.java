/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.csc380homework;

import java.util.Arrays;
import org.junit.Test;
import static org.junit.Assert.*;

/**
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
        int day = 1;
        Day d = new Day(day);
        Account a = new Account("a", "a", "1", "2", "3", "student", "124124");
        Reservation r = new Reservation(a);

        Time_Frame[] tf = d.reserve(r, time, time2);
        if (!tf[7].getRes().equals(r)) {
            fail();
        }

        if (d.can_Res(time, time2)) {
            fail();
        }
    }

    @Test
    public void getResTest() {
        int time = 7;
        int time2 = 8;
        int t1 = 1;
        int t2 = 3;
        int tt1 = 24;
        int tt2 = 31;
        String one = "1";
        String two = "2";
        String three = "3";
        int day = 12;
        Day d = new Day(day);

        Account a = new Account("a", "a", one, two, three, "student", "43");
        Account a2 = new Account("a", "a", three, two, one, "student", "4333");
        Account a3 = new Account("a", "a", one, one, one, "student", "3434");

        Reservation r1 = new Reservation(a);
        Reservation r2 = new Reservation(a2);
        Reservation r3 = new Reservation(a3);

        d.reserve(r1, t1, t2);
        d.reserve(r2, time, time2);
        Time_Frame[] frames = d.reserve(r3, tt1, tt2);

        boolean fail = true;
        for (Time_Frame frame : frames) {
            if (frame.getRes() != null) {
                if (frame.getRes().equals(r1) || frame.getRes().equals(r2) || frame.getRes().equals(r3)) {
                    fail = false;
                }
            }
        }
        if (fail) {
            fail();
        }

    }

    @Test
    public void hasResTest() {
        int day = 12;
        Day d = new Day(day);

        if (d.hasReservations()) {
            fail();
        }
        Account a = new Account("a", "a", "1", "2", "3", "student", "554736");
        Reservation r = new Reservation(a);
        d.reserve(r, 2, 4);
        if (!d.hasReservations()) {
            fail();
        }
    }
}
