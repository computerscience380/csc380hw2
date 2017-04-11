/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.csc380homework;

import java.util.Scanner;

/**
 *
 * @author Sean McGrath
 */
public class KeyIn {

    public String strIn() {
        Scanner kb = new Scanner(System.in);
        return kb.nextLine();
    }

    public int intIn() {
        Scanner kb = new Scanner(System.in);
        if (kb.hasNextInt()) {
            return kb.nextInt();
        } else {
            return -1;
        }
    }
}
