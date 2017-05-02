/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.csc380homework;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.UUID;

/**
 *
 * @author Sean McGrath
 */
public class ConsoleMenu {

    private ArrayList<Parking_Lot> lots = new ArrayList();
    private ArrayList<Alert> alerts = new ArrayList();
    private ArrayList<Account> accs = new ArrayList();
    private final Printer pr = new Printer();
    private final KeyIn inp = new KeyIn();

    public void mainMenu() {
        pr.line();
        int command;
        pr.menus("main");
        command = inp.intIn();
        switch (command) {
            case 1:
                pr.outln("Login Selected");
                loggin();
                mainMenu();
                break;
            case 2:
                pr.outln("Create Account Selected");
                accCreation();
                mainMenu();
                break;
            case 3:
                pr.outln("Exit Selected");
                break;
            default:
                pr.outln("ERROR: invalid input");
                mainMenu();
                break;
        }
    }

    private void studentMenu(Account a) {
        int command;
        pr.menus("student");
        command = inp.intIn();
        switch (command) {
            case 1:
                pr.outln("Reserve Selected");
                reserve(a);
                studentMenu(a);
                break;
            case 2:
                pr.outln("Availability Selected");
                available();
                studentMenu(a);
                break;

            case 3:
                pr.outln("Alert Selected");
                String location = askWhatString("location");
                int parkingSpot = askWhatInt("alertspot");
                if (askWhatInt("wantcomment") == 1) {
                    String comment = askWhatString("comment");
                    Alert al = new Alert(location, parkingSpot, comment);
                    alerts.add(al);
                } else {
                    Alert al = new Alert(location, parkingSpot);
                    alerts.add(al);
                }
                studentMenu(a);
                break;
            case 4:
                pr.outln("Account Selected");
                Account b = accountMenu(a);
                if (!b.getVariable("accountid").equals("0000000000")) {
                    pr.line();
                    studentMenu(b);
                }
                break;
            case 5:
                pr.outln("Logout Selected");
                break;
            default:
                System.out.println("Invalid Selection");
                studentMenu(a);
                break;
        }
    }

    private void adminMenu(Account a) {
        int command;
        pr.menus("admin");
        command = inp.intIn();
        switch (command) {
            case 1:
                pr.outln("Create Lot Selected");
                String lotname = askWhatString("lotname");
                int spots = askWhatInt("spots");
                Parking_Lot lot = new Parking_Lot(spots, lotname);
                lots.add(lot);
                pr.outln("Lot " + lotname + " added.");
                pr.line();
                adminMenu(a);
                break;
            case 2:
                pr.outln("Remove Lot Selected");
                if (!lots.isEmpty()) {
                    int lname = askWhatInt("lot");
                    pr.outln("Lot " + lots.get(lname).getLotName() + " removed");
                    lots.remove(lname);
                    pr.line();
                } else {
                    pr.outln("ERROR: no parking lots");
                }
                adminMenu(a);
                break;
            case 3:
                pr.outln("Display All Selected");
                displayRes();
                adminMenu(a);
                break;
            case 4:
                pr.outln("Check Spot Selected");
                if(!lots.isEmpty()){
                int lotn = askWhatInt("lot");
                checkSpot(lotn);
                } else {
                    pr.outln("ERROR: no parking lots");
                }
                adminMenu(a);
                break;
            case 5:
                pr.outln("Display Lots Selected");
                displayLotNames();
                adminMenu(a);
                break;
            case 6:
                pr.outln("Account Selected");
                Account b = accountMenu(a);
                if (!b.getVariable("accountid").equals("0000000000")) {
                    pr.line();
                    adminMenu(b);
                }
                break;
            case 7:
                pr.outln("Logout Selected");
                break;
            default:
                pr.outln("ERROR: invalid input");
                adminMenu(a);
                break;
        }
    }

    private void policeMenu(Account a) {
        int command;
        checkAlerts();
        pr.menus("police");
        command = inp.intIn();
        switch (command) {
            case 1:
                pr.outln("Display All Selected");
                displayRes();
                policeMenu(a);
                break;
            case 2:
                pr.outln("Check Spot Selected");
                int lot = askWhatInt("lot");
                checkSpot(lot);
                policeMenu(a);
                break;
            case 3:
                pr.outln("Account Selected");
                Account b = accountMenu(a);
                if (!b.getVariable("accountid").equals("0000000000")) {
                    pr.line();
                    policeMenu(b);
                }
                break;
            case 4:
                pr.outln("Logout Selected");
                break;
            default:
                pr.outln("ERROR: invalid input");
                policeMenu(a);
                break;
        }
    }

    private Account accountMenu(Account a) {
        pr.menus("account");
        int command = inp.intIn();
        switch (command) {
            case 1:
                pr.outln("Change Selected");
                accountMenu(accEdit(a));//do, return an account b with the changed variables
                break;
            case 2:
                pr.outln("Information Selected");
                accInfo(a);
                accountMenu(a);
                break;
            case 3:
                pr.outln("Delete Selected");
                if (accDel(a)) {
                    pr.acc("y");
                    Account b = new Account("dead","dead","dead","dead","dead","dead","0000000000");
                    return b;
                } else {
                    pr.acc("n");
                    accountMenu(a);
                    break;
                }
            case 4:
                pr.outln("Back Selected");
                break;
            default:
                pr.outln("ERROR: invalid input");
                accountMenu(a);
                break;
        }
        return a;
    }

    private void loggin() {
        String user;
        String pass;
        pr.line();
        pr.outln("Enter username:  ");
        user = inp.strIn();
        pr.line();
        pr.outln("Enter password:  ");
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
            pr.outln("ERROR: invalid username or password");
        }
    }

    private void displayLotNames() {
        if (!lots.isEmpty()) {
            int counter = 0;
            for (Parking_Lot lot : lots) {
                pr.displayLotName(lot.getLotName(), counter);
                counter++;
            }
        } else {
            pr.outln("ERROR: no parking lots");
        }
    }

    private void available() {
        int lot = this.askWhatInt("lot");
        int day = this.askWhatInt("day");
        int startTime = this.askTime(1);
        int endTime = this.askTime(2);
        if (endTime <= startTime) {
            pr.outln("ERROR: second time is before or the same as the first time");
            available();
        } else {//attempt reserve
            if (lots.get(lot).spotsAvailble(day, startTime, endTime)) {//check if any spots are available(if not error if so reserve)
                pr.canres(day, startTime, endTime);
            } else {
                pr.cantres(day, startTime, endTime);
            }
        }
    }

    private void displayRes() {
        if (lots.isEmpty()) {
            pr.outln("ERROR: no parking lots");
        } else {
            boolean cont = true;
            int count = 0;
            for (Parking_Lot lot : lots) {
                if (lot.hasReservations()) {
                    count++;
                }
            }
            if (count == 0) {
                cont = false;
            }

            if (cont) {
                for (Parking_Lot lot : lots) {
                    if (lot.hasReservations()) {
                        pr.outln("");
                        pr.outln("----Parking lot '" + lot.getLotName() + "': ");
                        Parking_Spot[] spots = lot.getSpots();
                        for (Parking_Spot spot : spots) {
                            if (spot.hasReservations()) {
                                pr.outln("---Spot #" + spot.getID());
                                Day[] days = spot.getDays();
                                for (Day day : days) {
                                    if (day.hasReservations()) {
                                        pr.outln("--On the " + day.getDay() + pr.postfix(day.getDay()));
                                        Time_Frame[] frames = day.getFrames();
                                        pr.printReservations(frames);
                                    }
                                }
                            }
                        }
                    } else {
                        pr.outln("Lot " + lot.getLotName() + " has no reservations");
                    }
                }
            } else {
                pr.outln("There are no reservations in any parking lots");
            }
        }
    }

    private void checkSpot(int lot) {
        Parking_Spot[] spots = lots.get(lot).getSpots();
        pr.outln("There are currently " + spots.length + " parking spots in the lot " + lots.get(lot).getLotName());
        pr.outln("Which parking spot do you wish to check");
        int response = inp.intIn();
        if (response > 0 && response <= spots.length) {
            if (spots[response - 1].hasReservations()) {
                Day[] days = spots[response - 1].getDays();
                for (Day day : days) {
                    if (day.hasReservations()) {
                        pr.outln("--On the " + day.getDay() + pr.postfix(day.getDay()));
                        Time_Frame[] frames = day.getFrames();
                        pr.printReservations(frames);
                    }
                }
            } else {
                pr.outln("There are no reservations in this parking spot");
            }
        } else {
            pr.outln("ERROR: invalid input");
            checkSpot(lot);
        }
    }

    private void reserve(Account a) {
        if (!lots.isEmpty()) {
            boolean redo;
            int startTime;
            int endTime;
            int lot = this.askWhatInt("lot");
            int day = this.askWhatInt("day");
            do {
                redo = false;
                startTime = this.askTime(1);
                endTime = this.askTime(2);
                if (endTime <= startTime) {
                    pr.outln("ERROR: second time is before or the same as the first time");
                    redo = true;
                } else {
                    if (lots.get(lot).spotsAvailble(day, startTime, endTime)) {
                        Reservation r = new Reservation(a);
                        int spot = lots.get(lot).reserve(r, day, startTime, endTime);
                        pr.havRes(day, startTime, endTime, spot);
                    } else {
                        pr.outln("ERROR: no spots available for requested time frame");
                    }
                }
            } while (redo);
        } else {
            pr.outln("ERROR: no parking lots");
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
                    pr.outln("ERROR: invalid input");
                    return askTime(1);
                }
            } else if (period == 2) {//pm
                pr.ask("time1");
                int t1 = inp.intIn();
                if (t1 > 0 && t1 <= 24) {
                    return t1 + 23;
                } else {
                    pr.outln("ERROR: invalid input");
                    return askTime(1);
                }
            } else {
                pr.outln("ERROR: invalid input");
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
                    pr.outln("ERROR: invalid input");
                    return askTime(2);
                }
            } else if (period == 2) {//pm
                pr.ask("time2");
                int t1 = inp.intIn();
                if (t1 > 0 && t1 <= 24) {
                    return t1 + 24;
                } else {
                    pr.outln("ERROR: invalid input");
                    return askTime(2);
                }
            } else {
                pr.outln("ERROR: invalid input");
                return askTime(2);
            }
        }
    }

    private void checkAlerts() {
        pr.line();
        int response;
        if (!alerts.isEmpty()) {
            pr.alert(alerts.size());
            response = inp.intIn();
            if (response == 1) {
                int c = 1;
                for (Alert i : alerts) {
                    pr.printAlert(i, c);
                    c++;
                }
                alerts.clear();
            } else if (response == 2) {
                pr.outln("continuing to menu");
            } else {
                pr.outln("ERROR: invalid input");
                checkAlerts();
            }
        }
    }

    private Account accEdit(Account a) {
        int response = askWhatInt("changewhich");
        if (response == 1) {//name
            pr.line();
            pr.outln("Name Selected");
            pr.outln("Enter the new name:");
            String name = inp.strIn();
            Account b = new Account(a.getVariable("username"), a.getVariable("password"), name, a.getVariable("licenceplate"), a.getVariable("id"), a.getVariable("type"), a.getVariable("accountid"));
            accs.remove(a);
            accs.add(b);
            return b;
        } else if (response == 2) {//LP
            pr.line();
            pr.outln("Licence Plate Selected");
            pr.outln("Enter the new licence plate:");
            String lp = inp.strIn();
            Account b = new Account(a.getVariable("username"), a.getVariable("password"), a.getVariable("name"), lp, a.getVariable("id"), a.getVariable("type"), a.getVariable("accountid"));
            accs.remove(a);
            accs.add(b);
            return b;
        } else if (response == 3) {//permit
            pr.line();
            pr.outln("Permit ID Selected");
            pr.outln("Enter the new permit ID:");
            String permit = inp.strIn();
            Account b = new Account(a.getVariable("username"), a.getVariable("password"), a.getVariable("name"), a.getVariable("licenceplate"), permit, a.getVariable("type"), a.getVariable("accountid"));
            accs.remove(a);
            accs.add(b);
            return b;
        } else {
            return null;
        }
    }

    private void accInfo(Account a) {
        pr.out("Name: ");
        pr.outln(a.getVariable("name"));
        pr.out("Licence plate: ");
        pr.outln(a.getVariable("licenceplate"));
        pr.out("Permit: ");
        pr.outln(a.getVariable("id"));
        pr.out("Account Authority: ");
        pr.outln(a.getVariable("type"));
    }

    private boolean accDel(Account a) {
        pr.ask("accdel");//
        int choice = inp.intIn();
        if (choice == 1) {
            accs.remove(a);
            return true;
        } else if (choice == 2) {
            return false;
        } else {
            pr.outln("ERROR: invalid input");
            return accDel(a);
        }
    }

    private void accCreation() {
        String name = askWhatString("name");
        String licencePlate = askWhatString("licenceplate");
        String permit = askWhatString("permit");
        String user = askWhatString("username");
        String pass = askWhatString("password");
        String t;
        int type = askWhatInt("type");
        if (type == 1) {
            t = "student";
        } else if (type == 2) {
            t = "admin";
        } else {
            t = "police";
        }

        Account ac = new Account(user, pass, name, licencePlate, permit, t, UUID.randomUUID().toString());
        accs.add(ac);
    }

    private String askWhatString(String what) {
        switch (what) {
            case "comment":
                pr.outln("Enter comment:");
                return inp.strIn();
            case "location":
                pr.outln("Where is this occuring");
                return inp.strIn();
            case "name":
                pr.ask("name");
                return inp.strIn();
            case "licenceplate":
                pr.ask("licenceplate");
                return inp.strIn();
            case "permit":
                pr.ask("permit");
                return inp.strIn();
            case "username":
                pr.line();
                pr.outln("Enter username:  ");
                String temp = inp.strIn();
                for (Account acc : accs) {
                    if (acc.getVariable("username").equalsIgnoreCase(temp)) {
                        pr.outln("ERROR: given username is already in use");
                        return askWhatString("username");
                    }
                }
                if (temp == null) {
                    System.out.println("NULL!@!@!");
                }
                return temp;
            case "password":
                pr.line();
                pr.outln("Enter password: ");
                return inp.strIn();
            case "lotname":
                pr.ask("lotname");
                return inp.strIn();
        }
        return null;
    }

    private int askWhatInt(String what) {
        switch (what) {
            case "wantcomment":
                pr.outln("Do you want to add a comment?");
                pr.ask("yn");
                int answer = inp.intIn();
                if (answer <= 0 || answer > 2) {
                    pr.outln("ERROR: invalid input");
                    return askWhatInt("wantcomment");
                } else {
                    return answer;
                }
            case "alertspot":
                pr.outln("What parking spot is this occuring in");
                int spot = inp.intIn();
                if (spot <= 0) {
                    pr.outln("ERROR: invalid input");
                    return askWhatInt("alertspot");
                } else {
                    return spot;
                }
            case "type":
                pr.ask("type");
                int type = inp.intIn();
                if (type < 0 || type > 3) {
                    pr.outln("ERROR: invalid input");
                    return askWhatInt("type");
                } else {
                    return type;
                }
            case "day":
                int day;
                pr.line();
                pr.outln("Enter the day of the month for reservation:");
                day = inp.intIn();
                if (validateDay(day)) {
                    return day;
                } else {
                    pr.outln("ERROR: day entered does not exist");
                    return askWhatInt("day");
                }
            case "lot":
                pr.outln("Choose lot: ");
                displayLotNames();
                int lot = inp.intIn();
                if (lot > lots.size() || lot < 0) {
                    pr.outln("ERROR: invalid input");
                    return askWhatInt("lot");
                } else {
                    return lot - 1;
                }
            case "spots":
                pr.line();
                pr.outln("Enter how many parking spots this lot will have:");
                int spots = inp.intIn();
                if (spots <= 0) {
                    pr.outln("ERROR: invalid input");
                    return askWhatInt("spots");
                } else {
                    return spots;
                }
            case "changewhich":
                pr.outln("Select what to change");
                pr.outln("1.  Name");
                pr.outln("2.  Licence Plate");
                pr.outln("3.  Perit ID");
                int response = inp.intIn();
                if (response > 0 && response < 4) {
                    return response;
                } else {
                    return askWhatInt("changewhich");
                }
        }
        return -1;
    }

    private int authorize(String username, String password) {
        for (Account a : accs) {
            if (a.getVariable("username").equals(username) && a.getVariable("password").equals(password)) {
                return accs.indexOf(a);
            }
        }
        return -1;
    }

    private static boolean validateDay(int d) { //make sure day given is valid
        return d > 0 && d <= Calendar.getInstance().getActualMaximum(Calendar.DAY_OF_MONTH); /////////////////
    }

}
