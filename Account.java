/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.csc380homework;

/**
 *
 * @author Sean McGrath
 */
public class Account {

    private String username;
    private String password;
    private String type;

    private String name;
    private String licencePlate;
    private String ID;

    public Account(String user, String pass, String n, String lp, String i, String t) {
        username = user;
        password = pass;
        name = n;
        licencePlate = lp;
        ID = i;
        type = t;
    }

    public String getVariable(String which) {
        if (which.equalsIgnoreCase("username")) {
            return username;
        } else if (which.equalsIgnoreCase("password")) {
            return password;
        } else if (which.equalsIgnoreCase("name")) {
            return name;
        } else if (which.equalsIgnoreCase("licencePlate")) {
            return licencePlate;
        } else if (which.equalsIgnoreCase("ID")) {
            return ID;
        } else if (which.equalsIgnoreCase("type")) {
            return type;
        } else {
            return null;
        }
    }
}
