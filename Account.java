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
        switch (which) {
            case "username":
                return username;
            case "password":
                return password;
            case "name":
                return name;
            case "licenceplate":
                return licencePlate;
            case "id":
                return ID;
            case "type":
                return type;
            default:
                return null;
        }
    }
}
