/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.csc380homework;

import java.util.ArrayList;
import java.util.Calendar;

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

        Parking_Lot e = new Parking_Lot(2, "lotA");
        Account a = new Account("a", "a", "a", "a", "a", "student");//for testing: username is a, password is a
        //Account b = new Account("a", "a", "a", "c", "a", "admin");
        //Account c = new Account("a", "a", "a", "d", "a", "police ");//need to make sure loggin stuff are not the same when creating accounts
        lots.add(e);
        accs.add(a);
        //accs.add(b);
       // accs.add(c);

        int command;
        pr.menus("main");
        command = inp.intIn();
        switch (command) {
            case 1:
                pr.selected("Login");
                loggin();
                mainMenu();
                break;
            case 2:
                pr.selected("Create Account");
                accCreation();
                mainMenu();
                break;
            case 3:
                pr.selected("Exit");
                break;
            default:
                pr.error("invalid input");
                mainMenu();
                break;
        }
    }

    private void studentMenu(Account a) {
        int command;
        pr.menus("student");
        command = inp.intIn();
        switch (command) {
            case 1: // reserve
                reserve(a);
                studentMenu(a);
                break;
            case 2:
                pr.selected("Availability");//check f any spots available
                available();
                studentMenu(a);
                break;

            case 3:   //ask what parking lot and what parking spot, used for when a spot is in misuse and creates an alert that is shown to a cop the next time they login  ALSO ask for an extra comment to be sent to cops  !unwritten!
                pr.selected("Alert");
                this.makeAlert(a);
                studentMenu(a);
                break;
            case 4: //account
                int deleted = accountMenu(a);
                if (deleted != -1) {
                    studentMenu(a);
                }
                break;
            case 5: //logout
                pr.selected("Logout");
                break;
            default:
                System.out.println("Invalid Selection"); //unexpected input
                studentMenu(a);
                break;
        }
    }

    private void adminMenu(Account a) {
        boolean cont = true;
        int command;
        while (cont) {
            pr.menus("admin");
            command = inp.intIn();
            switch (command) {
                case 1:
                    pr.selected("Create Lot");
                case 2:
                    pr.selected("Remove Lot");
                case 3:
                    pr.selected("Display All");
                case 4:
                    pr.selected("Check Spot");
                case 5:
                    pr.selected("Delete Account");
                case 6:
                    pr.selected("Display Lots");
                case 7:
                    pr.selected("Remove Reservation");
                case 8:
                    pr.selected("Logout");
                    cont = false;
                    break;
                default:
            }

        }
    }

    private void policeMenu(Account a) {
        int command;
        //add alerts as a checkAlerts method here
        this.checkAlerts();//make

        pr.menus("police");
        command = inp.intIn();
        switch (command) {
            case 1:
                pr.selected("Display All");

                policeMenu(a);
                break;
            case 2:
                pr.selected("Check Spot");

                policeMenu(a);
                break;
            case 3:
                pr.selected("Logout");
                break;
            default:
                pr.error("invalid input");
                policeMenu(a);
                break;
        }
    }

    private int accountMenu(Account a) {
        pr.menus("account");
        int command = inp.intIn();
        switch (command) {
            case 1:
                pr.selected("Change");
                accountMenu(this.accChange);//do
                break;
            case 2:
                pr.selected("Information");
                this.accsInfo(a);
                break;
            case 3:
                pr.selected("Delete");
                if (accsDel(a)) {
                    pr.acc("y");
                    return -1;
                } else {
                    pr.acc("n");
                    accountMenu(a);
                    break;
                }
            case 4:
                pr.selected("Back");
                break;
            default:
                pr.error("invalid input");
                accountMenu(a);
                break;
        }
        return 0;
    }

    private void loggin() {
        String user;
        String pass;
        pr.ask("username");
        user = inp.strIn();
        pr.ask("password");
        pass = inp.strIn();

        int auth = authorize(user, pass);
        if (auth > -1) {
            pr.outln("Login sucessful");
            switch (accs.get(auth).getVariable("type")) {
                case "student":
                    studentMenu(accs.get(auth));
                    break;
                case "admin":
                    adminMenu(accs.get(auth));
                    break;
                case "police":
                    policeMenu(accs.get(auth));
                    break;
            }
        } else {
            pr.error("invalid username or password");
        }
    }

    private void displayLotNames() {
        int counter = 0;
        for (Parking_Lot lot : lots) {
            pr.displayLotName(lot.getLotName(), counter);
        }
    }

    private void available() {
        int lot = this.askLot();
        int day = this.askDay();
        int startTime = this.askTime(1);
        int endTime = this.askTime(2);
        System.out.println(endTime);
        System.out.println(startTime);
        if (endTime <= startTime) {
            pr.error("second time is before or the same as the first time");
            available();
        } else {//attempt reserve
            if (lots.get(lot).spotsAvailble(day, startTime, endTime)) {//check if any spots are available(if not error if so reserve)
                pr.canres(day, startTime, endTime);
            } else {
                pr.cantres(day, startTime, endTime);
            }
        }
    }

    private Reservation[] getRes() {

    }

    private void reserve(Account a) {
        if (!lots.isEmpty()) {
            pr.selected("Reserve");
            boolean redo;
            int startTime;
            int endTime;
            int lot = this.askLot();
            int day = this.askDay();
            do {
                redo = false;
                startTime = this.askTime(1);
                endTime = this.askTime(2);
                if (endTime <= startTime) {
                    pr.error("second time is before or the same as the first time");
                    redo = true;
                } else {//attempt reserve
                    if (lots.get(lot).spotsAvailble(day, startTime, endTime)) {//check if any spots are available(if not error if so reserve)
                        Reservation r = new Reservation(a.getVariable("name"), a.getVariable("licenceplate"), a.getVariable("id"));
                        int spot = lots.get(lot).addReservation(r, day, startTime, endTime);
                        pr.havRes(day, startTime, endTime, spot);
                    } else {
                        pr.error("no spots available during requested time frame");
                    }
                }
            } while (redo);
        } else {
            pr.error("no parking lots");
        }
    }

    private int askLot() {
        pr.ask("lot");
        this.displayLotNames();//do this
        int lot = inp.intIn() - 1;
        if (lot > lots.size() || lot < 0) {
            pr.error("invalid input");
            return askLot();
        } else {
            return lot;
        }
    }

    private int askDay() {
        int day;
        pr.ask("day");
        day = inp.intIn();
        if (validateDay(day)) {
            return day;
        } else {
            pr.error("day entered does not exist");
            return askDay();
        }
    }

    private int askTime(int i) {
        if (i == 1) {//start
            pr.ask("period");
            int period = inp.intIn();
            if (period == 1) {//am
                pr.ask("time1");
                int t1 = inp.intIn();
                if (t1 > 0 && t1 <= 24) {
                    return t1 - 1;
                } else {
                    pr.error("invalid input");
                    return askTime(1);
                }
            } else if (period == 2) {//pm
                pr.ask("time1");
                int t1 = inp.intIn();
                if (t1 > 0 && t1 <= 24) {
                    return t1 + 23;
                } else {
                    pr.error("invalid input");
                    return askTime(1);
                }
            } else {
                pr.error("invalid input");
                return askTime(1);
            }
        } else {//end
            pr.ask("period");
            int period = inp.intIn();
            if (period == 1) {//am
                pr.ask("time2");
                int t1 = inp.intIn();
                if (t1 > 0 && t1 <= 24) {
                    return t1;
                } else {
                    pr.error("invalid input");
                    return askTime(2);
                }
            } else if (period == 2) {//pm
                pr.ask("time2");
                int t1 = inp.intIn();
                if (t1 > 0 && t1 <= 24) {
                    return t1 + 24;
                } else {
                    pr.error("invalid input");
                    return askTime(2);
                }
            } else {
                pr.error("invalid input");
                return askTime(2);
            }
        }
    }

    public static boolean validateDay(int d) { //make sure day given is valid
        return d > 0 && d <= Calendar.getInstance().getActualMaximum(Calendar.DAY_OF_MONTH); /////////////////
    }

    private void checkAlerts() {
        int response;
        if (!alerts.isEmpty()) {
            pr.alert(alerts.size());
            response = inp.intIn();
            if (response == 1) {
                int c = 1;
                for (Alert i : alerts) {
                    i.toPrint(c);//change to printer class
                    alerts.remove(i);
                    c++;
                }

            }
        }
    }

    private boolean maxRes() {//maybe not? should there be a cap to reservations
        return false;
    }

    private void accsInfo(Account a) {
        pr.out("Name: ");
        pr.outln(a.getVariable("name"));
        pr.out("Licence plate: ");
        pr.outln(a.getVariable("licenceplate"));
        pr.out("Permit: ");
        pr.outln(a.getVariable("id"));
        pr.out("Account Authority: ");
        pr.outln(a.getVariable("type"));
    }

    private boolean accsDel(Account a) {
        pr.ask("accdel");//
        int choice = inp.intIn();
        if (choice == 1) {
            accs.remove(a);
            return true;
        } else if (choice == 2) {
            return false;
        } else {
            pr.error("invalid input");
            return accsDel(a);
        }
    }

    private void accCreation() {
        String name = askName();
        String licencePlate = askLP();
        String permit = askID();
        String user = askUser();
        String pass = askPass();
        String t;
        int type = askType();
        if (type == 1) {
            t = "student";
        } else if (type == 2) {
            t = "admin";
        } else {
            t = "police";
        }

        Account ac = new Account(user, pass, name, licencePlate, permit, t);
        accs.add(ac);
    }

    private String askName() {
        pr.ask("name");
        return inp.strIn();
    }

    private String askLP() {
        pr.ask("licenceplate");
        return inp.strIn();
    }

    private String askID() {
        pr.ask("permit");
        return inp.strIn();
    }

    private String askUser() {
        pr.ask("username");
        return inp.strIn();
    }

    private String askPass() {
        pr.ask("password");
        return inp.strIn();
    }

    private int askType() {
        pr.ask("type");
        int type = inp.intIn();
        if (type < 0 || type > 3) {
            pr.error("invalid input");
            return askType();
        } else {
            return type;
        }
    }

    private int authorize(String username, String password) {
        for (Account a : accs) {
            if (a.getVariable("username").equals(username) && a.getVariable("password").equals(password)) {
                return accs.indexOf(a);
            }
        }
        return -1;
    }
}
