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

    private final String accountID;
    private final String username;
    private final String password;
    private final String type;

    private final String name;
    private final String licencePlate;
    private final String ID;

    public Account(String user, String pass, String n, String lp, String i, String t, String accid) {
        username = user;
        password = pass;
        name = n;
        licencePlate = lp;
        ID = i;
        type = t;
        accountID = accid;
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
            case "accountid":
                return accountID;
            default:
                return null;
        }
    }
}
