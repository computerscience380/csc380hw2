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
        switch (which) {
            case "main":
                System.out.println(
                        "================================= \n"
                        + "|           MAIN MENU           | \n"
                        + "================================= \n"
                        + "| Options:                      | \n"
                        + "|        1. Log In              | \n"
                        + "|        2. Create Account      | \n"
                        + "|        3. Exit                | \n"
                        + "================================= ");
                break;
            case "admin":
                this.line();
                System.out.println(
                        "|          ADMIN MENU           | \n"
                        + "================================= \n"
                        + "| Options:                      | \n"
                        + "|        1. Create Lot          | \n"
                        + "|        2. Remove Lot          | \n"
                        + "|        3. Display All         | \n"
                        + "|        4. Check Spot          | \n"
                        + "|        5. Display Lots        | \n"
                        + "|        6. Account             | \n"
                        + "|        7. Logout              | \n"
                        + "================================= ");
                break;
            case "student":
                this.line();
                System.out.println(
                        "|         STUDENT MENU          | \n"
                        + "================================= \n"
                        + "| Options:                      | \n"
                        + "|        1. Reserve             | \n"
                        + "|        2. Availability        | \n"
                        + "|        3. Alert               | \n"
                        + "|        4. Account             | \n"
                        + "|        5. Logout              | \n"
                        + "================================= ");
                break;
            case "police":
                this.line();
                System.out.println(
                        "|          POLICE MENU           | \n"
                        + "================================= \n"
                        + "| Options:                      | \n"
                        + "|        1. Display All         | \n"
                        + "|        2. Check Spot          | \n"
                        + "|        3. Account             | \n"
                        + "|        4. Logout              | \n"
                        + "================================= ");
                break;
            case "account":
                this.line();
                System.out.println(
                        "|          ACCOUNT MENU         | \n"
                        + "================================= \n"
                        + "| Options:                      | \n"
                        + "|        1. Change              | \n"
                        + "|        2. Information         | \n"
                        + "|        3. Delete              | \n"
                        + "|        4. Back                | \n"
                        + "================================= ");
                break;
        }
    }

    public void displayLotName(String prompt, int i) {
        System.out.println(i + 1 + ". " + prompt);
    }

    public void alert(int many) {
        if (many == 1) {
            System.out.println("There is curently " + many + " alert");
            System.out.println("Check it? \n"
                    + "1. yes  \n"
                    + "2. no   \n");
        } else if (many > 1) {
            System.out.println("There are curently " + many + " alerts");
            System.out.println("Check them? \n"
                    + "1. yes  \n"
                    + "2. no   \n");
        }
    }

    public void printAlert(Alert a, int i) {
        this.line();
        System.out.println("Alert " + i + " occured at '" + a.getLocation() + "' in parking spot #" + a.getSpot());
        if (a.getComment() == null) {
            System.out.println("There were no further comments from the user");
        } else {
            System.out.println("The user further added: " + a.getComment());
        }
    }

    public void acc(String yn) {
        if (yn.equals("y")) {
            System.out.println("Account deleted");
        } else {
            System.out.println("Account not deleted");
        }
    }

    public void ask(String what) {
        switch (what) {
            case "day":
                this.line();
                System.out.println("Enter the day of the month for reservation:");
                break;
            case "accdel":
                System.out.println("Are you sure you want to delete your account?: \n"
                        + "1. yes \n"
                        + "2. no \n");
                break;
            case "name":
                this.line();
                System.out.println("Enter full name:              ");
                break;
            case "licenceplate":
                this.line();
                System.out.println("Enter licence plate:              ");
                break;
            case "permit":
                this.line();
                System.out.println("Enter parking permit:              ");
                break;
            case "username":
                System.out.println("================================= \n"
                        + "Enter username:                     ");
                break;
            case "password":
                System.out.println("================================= \n"
                        + "Enter password:                     ");
                break;
            case "period":
                System.out.println("Select period: \n"
                        + "1. am \n"
                        + "2. pm \n");
                break;
            case "time1":
                System.out.println("Starting time: \n"
                        + "1.  12:00 \n"
                        + "2.  12:30 \n"
                        + "3.  1:00 \n"
                        + "4.  1:30 \n"
                        + "5.  2:00 \n"
                        + "6.  2:30 \n"
                        + "7.  3:00 \n"
                        + "8.  3:30 \n"
                        + "9.  4:00 \n"
                        + "10. 4:30 \n"
                        + "11. 5:00 \n"
                        + "12. 5:30 \n"
                        + "13. 6:00 \n"
                        + "14. 6:30 \n"
                        + "15. 7:00 \n"
                        + "16. 7:30 \n"
                        + "17. 8:00 \n"
                        + "18. 8:30 \n"
                        + "19. 9:00 \n"
                        + "20. 9:30 \n"
                        + "21. 10:00 \n"
                        + "22. 10:30 \n"
                        + "23. 11:00 \n"
                        + "24. 11:30 \n");
                break;
            case "time2":
                System.out.println("Ending time: \n"
                        + "1.  12:30 \n"
                        + "2.  1:00 \n"
                        + "3.  1:30 \n"
                        + "4.  2:00 \n"
                        + "5.  2:30 \n"
                        + "6.  3:00 \n"
                        + "7.  3:30 \n"
                        + "8.  4:00 \n"
                        + "9.  4:30 \n"
                        + "10. 5:00 \n"
                        + "11. 5:30 \n"
                        + "12. 6:00 \n"
                        + "13. 6:30 \n"
                        + "14. 7:00 \n"
                        + "15. 7:30 \n"
                        + "16. 8:00 \n"
                        + "17. 8:30 \n"
                        + "18. 9:00 \n"
                        + "19. 9:30 \n"
                        + "20. 10:00 \n"
                        + "21. 10:30 \n"
                        + "22. 11:00 \n"
                        + "23. 11:30 \n"
                        + "24. 12:00 \n");
                break;
            case "type":
                this.line();
                System.out.println("Select user type: \n"
                        + "1. Student \n"
                        + "2. Admin \n"
                        + "3. Police \n");
                break;
            case "lotname":
                this.line();
                System.out.println("Enter name for parking lot:");
                break;
            case "spots":
                this.line();
                System.out.println("Enter how many parking spots this lot will have:");
                break;
            case "yn":
                this.line();
                System.out.println("1. yes");
                System.out.println("2. no");
                break;
            default:
                System.out.println("ERROR: missing ask");
                break;
        }
    }

    public void outln(String prompt) {
        System.out.println(prompt);
    }

    public void out(String prompt) {
        System.out.print(prompt);
    }

    public void canres(int day, int startTime, int endTime) {
        System.out.println("On the " + day + postfix(day) + " from " + toTime(startTime) + " to " + toTime(endTime) + " there are available parking spots.");
    }

    public void cantres(int day, int startTime, int endTime) {
        System.out.println("There are conflicting times on the " + day + postfix(day) + " from " + toTime(startTime) + " to " + toTime(endTime) + ".");
    }

    public void havRes(int day, int startTime, int endTime, int spot) {
        System.out.println("A reservation has been made on the " + day + postfix(day) + " from " + toTime(startTime) + " to " + toTime(endTime) + " in parking spot #" + spot);
    }

    public void printReservations(Time_Frame[] frames) {
        Time_Frame first = null;
        Time_Frame last = null;
        for (Time_Frame frame : frames) {
            if (frame.hasRes()) {
                if (first == null) {
                    first = frame;
                } else if (first != null && last == null && frame.getRes().getAccount().getVariable("accountid").equals(first.getRes().getAccount().getVariable("accountid")) || first != null && last != null && frame.getRes().getAccount().getVariable("accountid").equals(last.getRes().getAccount().getVariable("accountid"))) {
                    last = frame;
                } else {
                    if (last == null) {
                        System.out.println("-Reserved by '" + first.getRes().getAccount().getVariable("name") + "' from " + toTime(first.getTime()) + " to " + toTime(first.getTime() + 1) + "   Licence plate: " + first.getRes().getAccount().getVariable("licenceplate") + "   Permit ID#: " + first.getRes().getAccount().getVariable("id"));
                        first = frame;
                    } else {
                        System.out.println("-Reserved by '" + first.getRes().getAccount().getVariable("name") + "' from " + toTime(first.getTime()) + " to " + toTime(last.getTime() + 1) + "   Licence plate: " + first.getRes().getAccount().getVariable("licenceplate") + "   Permit ID#: " + first.getRes().getAccount().getVariable("id"));
                        first = frame;
                        last = null;
                    }
                }
            } else if (!frame.hasRes() && first != null && last == null) {
                System.out.println("-Reserved by '" + first.getRes().getAccount().getVariable("name") + "' from " + toTime(first.getTime()) + " to " + toTime(first.getTime() + 1) + "   Licence plate: " + first.getRes().getAccount().getVariable("licenceplate") + "   Permit ID#: " + first.getRes().getAccount().getVariable("id"));
                first = null;
            } else if (!frame.hasRes() && first != null && last != null) {
                System.out.println("-Reserved by '" + first.getRes().getAccount().getVariable("name") + "' from " + toTime(first.getTime()) + " to " + toTime(last.getTime() + 1) + "   Licence plate: " + first.getRes().getAccount().getVariable("licenceplate") + "   Permit ID#: " + first.getRes().getAccount().getVariable("id"));
                first = null;
                last = null;
            }
        }
        if (first != null && last == null) {
            System.out.println("-Reserved by '" + first.getRes().getAccount().getVariable("name") + "' from " + toTime(first.getTime()) + " to " + toTime(first.getTime() + 1) + "   Licence plate: " + first.getRes().getAccount().getVariable("licenceplate") + "   Permit ID#: " + first.getRes().getAccount().getVariable("id"));
        } else if (first != null && last != null) {
            System.out.println("-Reserved by '" + first.getRes().getAccount().getVariable("name") + "' from " + toTime(first.getTime()) + " to " + toTime(last.getTime() + 1) + "   Licence plate: " + first.getRes().getAccount().getVariable("licenceplate") + "   Permit ID#: " + first.getRes().getAccount().getVariable("id"));
        }

    }

    public String postfix(int i) {//1st 2nd 3rd ect
        if (i == 1 || i == 21 || i == 31) {
            return "st";
        } else if (i == 2 || i == 22) {
            return "nd";
        } else if (i == 3 || i == 23) {
            return "rd";
        } else {
            return "th";
        }
    }

    private String toTime(int i) {
        switch (i) {
            case 0:
                return "Midnight";
            case 1:
                return "12:30 am";
            case 2:
                return "1:00 am";
            case 3:
                return "1:30 am";
            case 4:
                return "2:00 am";
            case 5:
                return "2:30 am";
            case 6:
                return "3:00 am";
            case 7:
                return "3:30 am";
            case 8:
                return "4:00 am";
            case 9:
                return "4:30 am";
            case 10:
                return "5:00 am";
            case 11:
                return "5:30 am";
            case 12:
                return "6:00 am";
            case 13:
                return "6:30 am";
            case 14:
                return "7:00 am";
            case 15:
                return "7:30 am";
            case 16:
                return "8:00 am";
            case 17:
                return "8:30 am";
            case 18:
                return "9:00 am";
            case 19:
                return "9:30 am";
            case 20:
                return "10:00 am";
            case 21:
                return "10:30 am";
            case 22:
                return "11:00 am";
            case 23:
                return "11:30 am";
            case 24:
                return "Noon";
            case 25:
                return "12:30 pm";
            case 26:
                return "1:00 pm";
            case 27:
                return "1:30 pm";
            case 28:
                return "2:00 pm";
            case 29:
                return "2:30 pm";
            case 30:
                return "3:00 pm";
            case 31:
                return "3:30 pm";
            case 32:
                return "4:00 pm";
            case 33:
                return "4:30 pm";
            case 34:
                return "5:00 pm";
            case 35:
                return "5:30 pm";
            case 36:
                return "6:00 pm";
            case 37:
                return "6:30 pm";
            case 38:
                return "7:00 pm";
            case 39:
                return "7:30 pm";
            case 40:
                return "8:00 pm";
            case 41:
                return "8:30 pm";
            case 42:
                return "9:00 pm";
            case 43:
                return "9:30 pm";
            case 44:
                return "10:00 pm";
            case 45:
                return "10:30 pm";
            case 46:
                return "11:00 pm";
            case 47:
                return "11:30 pm";
            case 48:
                return "Midnight";
        }
        return null;
    }

}
