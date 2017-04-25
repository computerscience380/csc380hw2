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
public class ReservationTest {

    @Test
    public void setAccountTest() {
        Account a = new Account("a", "a", "1", "2", "3", "student", "554736");
        Reservation r = new Reservation(a);
        if (!r.getAccount().equals(a)) {
            fail("ERROR: account not added");
        }
    }

}
