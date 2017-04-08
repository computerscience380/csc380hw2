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
public class Printer {

    public void line() {
        System.out.println("=================================");
    }

    public void menus(String which) {
        if (which.equalsIgnoreCase("main")) {
            System.out.println(
                    "================================= \n"
                    + "|           MAIN MENU           | \n"
                    + "================================= \n"
                    + "| Options:                      | \n"
                    + "|        1. Log In              | \n"
                    + "|        2. Account             | \n"
                    + "|        3. Exit                | \n"
                    + "================================= ");
        } else if (which.equalsIgnoreCase("admin")) {
            System.out.println(
                    "|          ADMIN MENU           | \n"
                    + "================================= \n"
                    + "| Options:                      | \n"
                    + "|        1. Create Lot          | \n"
                    + "|        2. Remove Lot          | \n"
                    + "|        3. Display All         | \n"
                    + "|        4. Check Spot          | \n"
                    + "|        5. Delete Account      | \n"
                    + "|        6. Display Lots        | \n"
                    + "|        7. Remove Reservation  | \n"
                    + "|        8. Logout              | \n"
                    + "================================= ");
        } else if (which.equalsIgnoreCase("user")) {
            System.out.println(
                    "|           USER MENU           | \n"
                    + "================================= \n"
                    + "| Options:                      | \n"
                    + "|        1. Reserve             | \n"
                    + "|        2. Availability        | \n"
                    + "|        3. Alert               | \n"
                    + "|        4. Logout              | \n"
                    + "================================= ");
        } else if (which.equalsIgnoreCase("police")) {
            System.out.println(
                    "|          POLICE MENU           | \n"
                    + "================================= \n"
                    + "| Options:                      | \n"
                    + "|        1. Display All         | \n"
                    + "|        2. Check Spot          | \n"
                    + "|        3. Logout              | \n"
                    + "================================= ");
        } else if (which.equalsIgnoreCase("account")) {
            System.out.println(
                    "|          ACCOUNT MENU         | \n"
                    + "================================= \n"
                    + "| Options:                      | \n"
                    + "|        1. Change              | \n"
                    + "|        2.        | \n" //only 3 maybe
                    + "|        3. Delete              | \n"
                    + "|        4. Logout              | \n"
                    + "================================= ");
        }
    }

    public void displayLotName(String prompt, int i) {
        System.out.println(i + ". " + prompt);
    }

    public void alert(int many) {
        if (many == 1) {
            System.out.println("There is curently " + many + " alert");
            System.out.println("Check it?");
        } else if (many > 1) {
            System.out.println("There are curently " + many + " alerts");
            System.out.println("Check them?");
        }
    }

    public void selected(String what) {
        if (what.equalsIgnoreCase("login")) {
            System.out.println("Log In selected");
        } else if (what.equalsIgnoreCase("exit")) {
            System.out.println("Exiting System");
        } else if (what.equalsIgnoreCase("account")) {
            System.out.println("Account Selected");
        } else if (what.equalsIgnoreCase("logout")) {
            System.out.println("Logging Out");
        } else if (what.equalsIgnoreCase("back")) {
            System.out.println("Returning to previous menu");
        }
    }

    public void ask(String what) {
        if (what.equalsIgnoreCase("day")) {
            System.out.println("Enter the day of the month for reservation:");
        } else if (what.equalsIgnoreCase("time")) {

        } else if (what.equalsIgnoreCase("name")) {

        } else if (what.equalsIgnoreCase("licenceplate")) {

        } else if (what.equalsIgnoreCase("permit")) {

        } else if (what.equalsIgnoreCase("username")) {
            System.out.println("================================= \n"
                    + "Enter username:                     ");
        } else if (what.equalsIgnoreCase("password")) {
            System.out.println("================================= \n"
                    + "Enter password:                     ");
        }
    }

    public void error(String what) {
        System.out.print("ERROR: ");
        if (what.equalsIgnoreCase("nolots")) {
            System.out.println("no parking lots exist");
        } else if (what.equalsIgnoreCase("badinput")) {
            System.out.println("invalid input");
        } else if (what.equalsIgnoreCase("badauthorize")) {
            System.out.println("invalid username or password");
        }
    }
}
