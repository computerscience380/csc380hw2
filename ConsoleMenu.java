/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.csc380homework;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Sean McGrath
 */
public class ConsoleMenu {

    ArrayList<Parking_Lot> lots = new ArrayList(); //parking lot arrayList
    ArrayList<Alert> alerts = new ArrayList();//police alerts
    ArrayList<Account> accs = new ArrayList();//accounts
    Printer pr = new Printer();
    KeyIn inp = new KeyIn();

    public void mainMenu() {
        pr.line();
        boolean cont = true;
        while (cont) {
            int command;
            pr.menus("main");
            command = inp.intIn();
            switch (command) {
                case 1:
                    pr.selected("loggin");
                    this.loggin();
                    break;
                case 2:
                    pr.selected("account");
                    this.accountMenu();
                    break;
                case 3:
                    pr.selected("exit");
                    cont = false;
                    break;
                default:
                    pr.error("badinput");
                    break;
            }
        }
    }

    private void userMenu(Account a) {

        while (cont) {
            int command;
            Scanner kb = new Scanner(System.in);
           
            pr.menus("user");
            
                command = inp.intIn();
                switch (command) {
                    case 1: // reserve
                    {
                        pr.selected("reserve");

                        
                        
                        break;
                    }
                    case 2:

                        break;

                    case 3:   //ask what parking lot and what parking spot, used for when a spot is in misuse and creates an alert that is shown to a cop the next time they login  ALSO ask for an extra comment to be sent to cops  !unwritten!
                        if (lots.isEmpty()) {
                            System.out.println("No parking lots exist for there to be problems in");
                        } else {
                            System.out.println("What parking lot is this occuring in?");//////needs more
                            System.out.print(">");
                        }
                        break;
                    case 4: //logout
                        System.out.println("logging out");
                        System.out.println();
                        break;
                    default:
                        System.out.println("Invalid Selection"); //unexpected input
                        break;
                }
        }
    }

    private void adminMenu() {

    }

    private void policeMenu() {

    }
    
    private boolean maxRes() {//maybe not? should there be a cap to reservations
        return false;
    }

    private boolean loggin() {
        String user;
        String pass;
        pr.ask("username");
        user = inp.strIn();
        pr.ask("password");
        pass = inp.strIn();

        if (authorize(user, pass)) {
            //do some stuff
            return true;
        } else {
            pr.error("badauthorize");
            return false;
        }
    }

    private void accountMenu() {

    }

    private boolean authorize(String username, String password) {
        boolean authorized = false;
        for (Account a : accs) {
            if (accs) {
                authorized = true;
            }
        }
        return authorized;
    }
}
