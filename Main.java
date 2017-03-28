/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.csc380homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Sean McGrath
 */
public class Main {

    /**
     * @param args the command line arguments
     * @throws java.text.ParseException
     */
    public static void main(String[] args) throws ParseException {

        String userCommand;
        String adminCommand;
        String policeCommand;
        String command;
        //print saying congrats or something maybe, along with which parking spot they've reserved  "you've sucessfully reserved parking spot '---' from 'time' to 'time+29'!"
        //print saying congrats or something maybe, along with which parking spot they've reserved  "you've sucessfully reserved parking spot '---' from 'time' to 'time'!"

        ArrayList<Parking_Lot> lots = new ArrayList(); //parking lot arrayList
        ArrayList<Alert> alerts = new ArrayList();//police alerts

        do {
            Scanner kb;
            System.out.println("Welcome to the SUNY Oswego Parking Lot Reservation System!");
            System.out.println("Please specify what type of user you are from the following options, or shut down the system:");
            System.out.println("|User|Police|Admin|CreateAccount|ShutDown|");//should I keep 'CreateAccount' ???
            System.out.print(">");
            kb = new Scanner(System.in);
            command = kb.nextLine();
            String OC = command;
            command = command.toLowerCase();
            command = command.replaceAll("\\s", "");

            switch (command) {
                case "user": {
                    boolean a;
                    String userName;
                    String password;
                    System.out.println("Enter username");//loggin authentication, any user + password will work atm
                    System.out.print(">");
                    kb = new Scanner(System.in);
                    userName = kb.nextLine();
                    System.out.println("Enter password");
                    System.out.print(">");
                    kb = new Scanner(System.in);
                    password = kb.nextLine();
                    a = authenticate(userName, password);
                    System.out.println();

                    if (a) {
                        System.out.println("Welcome student/employee/guest!");
                        do {
                            System.out.println("Please enter a command from the following options:");
                            System.out.println("|Reserve|AvailabeSpots|AlertPolice|Logout|");
                            System.out.print(">");
                            kb = new Scanner(System.in);
                            userCommand = kb.nextLine();
                            String originalC = userCommand;
                            userCommand = userCommand.toLowerCase();
                            userCommand = userCommand.replaceAll("\\s", "");

                            switch (userCommand) {
                                case "reserve": // reserve one ore more time slots   maybe a max amount of reservations?     how much is too much
                                {
                                    if (lots.isEmpty()) {
                                        System.out.println("ERROR: no existing parking lots to make reservations at");
                                    } else {
                                        String name;
                                        int day = -1;
                                        int ID = -1;
                                        boolean failure = false;
                                        String lotName = null;
                                        String plate = null;
                                        String startTime = null;
                                        String endTime = null;

                                        do {
                                            System.out.println("Please enter the name of the parking lot this reservation will be made at out of the following options, be aware capitalization matters:");
                                            for (Parking_Lot i : lots) {
                                                System.out.println(i.getLotName());
                                            }
                                            System.out.print(">");
                                            kb = new Scanner(System.in);
                                            lotName = kb.nextLine();

                                            for (Iterator<Parking_Lot> iterator = lots.iterator(); iterator.hasNext();) {
                                                Parking_Lot i = iterator.next();
                                                if (i.getLotName().equals(lotName)) {
                                                    failure = false;
                                                    break;
                                                } else {
                                                    failure = true;
                                                }
                                            }
                                            if (failure) {
                                                System.out.println("ERROR: the given parking lot of '" + lotName + "' does not exist");
                                            }
                                        } while (failure);

                                        System.out.println("Please enter your full name as FIRSTNAME LASTNAME");
                                        System.out.print(">");
                                        kb = new Scanner(System.in);
                                        name = kb.nextLine();

                                        System.out.println("Welcome " + name + "!");

                                        do {
                                            System.out.println("Please enter the day of the date you wish to reserve on:");
                                            System.out.print(">");
                                            kb = new Scanner(System.in);
                                            if (!kb.hasNextInt()) {
                                                System.out.println("ERROR: Please enter the NUMBER of the day you wish to reserve on");
                                                failure = true;
                                            } else {
                                                day = kb.nextInt();
                                                if (validateDay(day)) {
                                                    failure = false;
                                                } else {
                                                    System.out.println("ERROR: the day you have entered does not exist, try again");
                                                    failure = true;
                                                }
                                            }
                                        } while (failure);

                                        boolean redo = false;
                                        do {

                                            do {
                                                kb = new Scanner(System.in);
                                                String ip;
                                                String pattern = "^([1-9]|1[0-2]):([0-5][0-9]) ([APap][mM]$)";
                                                System.out.println("Enter the time of the start of your reservation like the following example: 1:14 am   ;be aware that this will be rounded down to the nearest half hour:");
                                                System.out.print(">");
                                                ip = kb.nextLine();
                                                Pattern r = Pattern.compile(pattern);
                                                Matcher m = r.matcher(ip);
                                                if (m.matches()) {//good input, so now round
                                                    startTime = roundDown(ip);
                                                    failure = false;
                                                } else {
                                                    System.out.println("ERROR: the given input is not in the specified format");
                                                    failure = true;
                                                }
                                            } while (failure);

                                            do {
                                                kb = new Scanner(System.in);
                                                String ip;
                                                String pattern = "^([1-9]|1[0-2]):([0-5][0-9]) ([APap][mM]$)";
                                                String leavePattern = "([0]$)";
                                                System.out.println("Enter the time of the end of your reservation or enter 0 if you are only reserving one time period   ;be aware that this will be rounded up to the nearest half hour:");
                                                System.out.print(">");
                                                ip = kb.nextLine();
                                                Pattern r1 = Pattern.compile(leavePattern);
                                                Matcher l = r1.matcher(ip);
                                                if (!l.matches()) {
                                                    Pattern r = Pattern.compile(pattern);
                                                    Matcher m = r.matcher(ip);
                                                    if (m.matches()) {
                                                        endTime = roundUp(ip);//good input, so now round
                                                        if (endTime.equals("false")) {
                                                            System.out.println("ERROR: an unknown error has occured");
                                                            failure = true;
                                                        } else {//make sure that the times are in the right order
                                                            if (!validateTimeOrder(startTime, endTime)) {   //
                                                                System.out.println("ERROR: the second given time is either in another day or is before the first time");
                                                                failure = false;
                                                                redo = true;
                                                            } else {//complete success
                                                                redo = false;
                                                                failure = false;
                                                            }
                                                        }
                                                    } else {
                                                        System.out.println("ERROR: the given input is not in the specified format");
                                                        failure = true;
                                                    }
                                                } else {
                                                    System.out.println("Understood, only one time slot will be atempted to be reserved");
                                                    failure = false;
                                                    redo = false;
                                                    endTime = "none";
                                                }
                                            } while (failure);
                                        } while (redo);

                                        do {
                                            System.out.println("Please enter a valid permit ID number:");   //permit ID 
                                            System.out.print(">");
                                            kb = new Scanner(System.in);
                                            if (kb.hasNextInt()) {
                                                ID = kb.nextInt();
                                                failure = false;
                                            } else {
                                                System.out.println("ERROR: invalid permit ID");
                                                failure = true;
                                            }
                                        } while (failure);

                                        do {
                                            System.out.println("Please enter a valid licence plate:");   //permit ID 
                                            System.out.print(">");
                                            kb = new Scanner(System.in);
                                            if (kb.hasNext()) {
                                                plate = kb.nextLine();
                                                failure = false;
                                            } else {
                                                System.out.println("ERROR: invalid licence plate");
                                                failure = true;
                                            }
                                        } while (failure);

                                        boolean cont = true;

                                        //check whether it is one or more times being reserved then check if they are availble(if not all are availbe return which are and tell to retry)
                                        Reservation r = new Reservation(name, plate, ID);
                                        for (Iterator<Parking_Lot> iterator = lots.iterator(); iterator.hasNext();) {
                                            Parking_Lot i = iterator.next();
                                            if (i.getLotName().equals(lotName)) {
                                                if (endTime.equals("none")) {//add single reservation
                                                    if (lots.get(lots.indexOf(i)).spotsAvailbleAtTimeAndDay(day, startTime)) {
                                                        lots.get(lots.indexOf(i)).addReservation(r, day, startTime);
                                                        cont = true;
                                                    } else {
                                                        System.out.println("ERROR: from time " + startTime + " to time " + roundOff(startTime) + " on day " + day + " of this month a reservation is already in place for every parking spot in " + lotName + " parking lot");
                                                        cont = false;
                                                        break;
                                                    }
                                                } else {
                                                    if (lots.get(lots.indexOf(i)).spotsAvailbleAtTimeAndDay(day, startTime, endTime)) {
                                                        //add more than one time (from time A to time B)
                                                        lots.get(lots.indexOf(i)).addReservation(r, day, startTime, endTime);
                                                        cont = true;
                                                    } else {
                                                        //the "why" method
                                                        cont = false;//100% needs more
                                                    }
                                                }
                                                break;
                                            }
                                        }

                                        if (cont) {//maybe check with res and output different success 
                                            System.out.println("Congratulations " + name + " your reservation has been sucessfully made!");
                                        } else if (cont &&) {

                                        } else {
                                            System.out.println("Unfortunatly your reservation was unable to be completed at this time");
                                        }
                                        //then create the reservation and send it into the system based on what parking lot is asked for.

                                        // sucess -> some sort of congratulations including their name
                                        //failure -> apologize and 'returning to action selection'
                                    }
                                    System.out.println("");
                                    break;
                                }
                                case "availabespots":
                                    if (lots.isEmpty()) {
                                        System.out.println("No parking lots exist for there to be parking spots in");
                                    } else {
                                        //take time, check how many if any are available at that time
                                        System.out.println("enter the time and day you wish to check"); // something like that, maybe split up into two serperate asks
                                        System.out.print(">");
                                    }

                                    break;
                                case "logout": //logout
                                    System.out.println("logging out");
                                    System.out.println();
                                    break;
                                case "alertpolice":   //ask what parking lot and what parking spot, used for when a spot is in misuse and creates an alert that is shown to a cop the next time they login  ALSO ask for an extra comment to be sent to cops  !unwritten!
                                    if (lots.isEmpty()) {
                                        System.out.println("No parking lots exist for there to be problems in");
                                    } else {
                                        System.out.println("What parking lot is this occuring in?");//////needs more
                                        System.out.print(">");
                                    }
                                    break;
                                default:
                                    System.out.println("ERROR: INVALID COMMAND " + originalC.toUpperCase()); //unexpected input
                                    break;
                            }
                        } while (!userCommand.equals("logout"));
                    } else {
                        System.out.println("ERROR: USER NOT FOUND RETURNING TO MAIN SCREEN");  //authentication fails (it never will as is)
                    }
                    break;
                }
                case "police": {
                    boolean a;
                    String userName;
                    String password;
                    System.out.println("Enter username");//loggin authentication, any user + password will work atm
                    System.out.print(">");
                    kb = new Scanner(System.in);
                    userName = kb.nextLine();
                    System.out.println("Enter password");
                    System.out.print(">");
                    kb = new Scanner(System.in);
                    password = kb.nextLine();
                    a = authenticate(userName, password);
                    System.out.println();

                    String response = null;
                    if (a) {
                        if (!alerts.isEmpty()) {
                            System.out.println("There are currently " + alerts.size() + " active alerts");
                            System.out.println("Would you like to view them?(y/n)");
                            System.out.print(">");
                            kb = new Scanner(System.in);
                            response = kb.next();
                            if (response.equals("y")) {
                                int c = 1;
                                for (Alert i : alerts) {
                                    i.toPrint(c);
                                    alerts.remove(i);
                                    c++;
                                }
                            }
                        }
                    }

                    if (a) {
                        System.out.println("Welcome officer!");
                        do {
                            if (!response.equals("n")) {
                                if (!alerts.isEmpty()) {
                                    System.out.println("There are currently " + alerts.size() + " active alerts");
                                    System.out.println("Would you like to view them?(y/n)");
                                    System.out.print(">");
                                    kb = new Scanner(System.in);
                                    response = kb.next();
                                    if (response.equals("y")) {
                                        int c = 1;
                                        for (Alert i : alerts) {
                                            i.toPrint(c);
                                            c++;
                                        }
                                    }
                                }
                            }
                            response = null;

                            System.out.println("Please enter a command from the following options:");
                            System.out.println("|DisplayAllReservations|CheckParkingSpot|Logout|");
                            System.out.print(">");
                            kb = new Scanner(System.in);
                            policeCommand = kb.nextLine();
                            String originalC = policeCommand;
                            policeCommand = policeCommand.toLowerCase();  //formatting
                            policeCommand = policeCommand.replaceAll("\\s", "");  //formatting

                            switch (policeCommand) {
                                case "checkparkingspot":  //retreive information from specific parking spot  !unwritten!
                                    break;
                                case "displayallreservations": //get all reservations and display them in an orderly manner  includes: spot#, name, liscence plate, and authentication#    !unwritten!
                                    break;
                                case "logout":  //return to previous switch board
                                    System.out.println("logging out");
                                    System.out.println();
                                    break;
                                default:
                                    System.out.println("ERROR: INVALID COMMAND " + originalC.toUpperCase());
                                    break;
                            }

                        } while (!policeCommand.equals("logout"));
                    } else {
                        System.out.println("ERROR: USER NOT FOUND RETURNING TO MAIN SCREEN");
                    }
                    break;
                }
                case "admin": {
                    //"authenticate"(any loggon will work)   
                    boolean a;
                    String userName;
                    String password;
                    System.out.println("Enter username");
                    System.out.print(">");
                    kb = new Scanner(System.in);
                    userName = kb.nextLine();
                    System.out.println("Enter password");
                    System.out.print(">");
                    kb = new Scanner(System.in);
                    password = kb.nextLine();
                    a = authenticate(userName, password);
                    System.out.println();
                    if (a) {
                        System.out.println("Welcome Administrator!");
                        do {
                            System.out.println("Please enter a command from the following options:");
                            System.out.println("|CreateLot|RemoveLot|displaylotnames|DisplayAllReservations|CheckParkingSpot|RemoveReservation|Logout|");//spaces and capitalization do not matter
                            System.out.print(">");
                            kb = new Scanner(System.in);
                            adminCommand = kb.nextLine();
                            String originalC = adminCommand;
                            adminCommand = adminCommand.toLowerCase();//formatting
                            adminCommand = adminCommand.replaceAll("\\s", "");//remove spaces, formatting

                            switch (adminCommand) {
                                case "createlot": //create a parking lot<name it and specify the number of parking spots>
                                {
                                    int spots = 0;
                                    String lotName;
                                    boolean again = false;

                                    do {
                                        System.out.println("Enter the name of the lot to be created:");
                                        System.out.print(">");
                                        kb = new Scanner(System.in);
                                        lotName = kb.nextLine();
                                        if (!lots.isEmpty()) {
                                            for (Parking_Lot i : lots) {
                                                if (i.getLotName().equals(lotName)) {
                                                    System.out.println("ERROR: A parking lot of this name already exists");
                                                    System.out.println("Parking lot not added");
                                                    again = true;
                                                    break;
                                                }
                                                again = false;
                                            }
                                        }
                                    } while (again);

                                    do {
                                        System.out.println("Enter the number of parking spots in this new lot:");
                                        System.out.print(">");
                                        kb = new Scanner(System.in);
                                        if (!kb.hasNextInt()) {
                                            System.out.println("Incompatable input type");
                                        } else {
                                            spots = kb.nextInt();
                                        }
                                    } while (spots <= 0);
                                    Parking_Lot l = new Parking_Lot(spots, lotName);
                                    lots.add(l);

                                    break;
                                }
                                case "removelot": //remove a parking lot<based on lot name>
                                {
                                    if (lots.size() > 0) {
                                        System.out.println("Enter the name of the lot to be removed:");
                                        System.out.print(">");
                                        kb = new Scanner(System.in);
                                        String lotName = kb.nextLine();
                                        for (Iterator<Parking_Lot> iterator = lots.iterator(); iterator.hasNext();) {
                                            Parking_Lot i = iterator.next();
                                            if (i.getLotName().equals(lotName)) {
                                                lots.remove(i);
                                            }
                                        }
                                    } else {
                                        System.out.println("ERROR: NO PARKING LOTS EXIST TO BE REMOVED");
                                    }
                                    break;
                                }
                                case "displaylotnames":  //show all the names of all the parking lots                                
                                    for (Parking_Lot i : lots) {
                                        System.out.println("Parking lot: " + i.getLotName());
                                    }
                                    break;
                                case "availableSpots":
                                    //check if at least one spot available at given time    make boolean spots avaiable?
                                    //same as the one in user
                                    break;
                                case "displayallreservations":

                                    break;  //get all reservations and display them in an orderly manner  includes: spot#, name, liscence plate, and authentication#    !unwritten!
                                case "checkparkingspot":
                                    break;  //get the information from a specific spot         !unwritten!
                                //use !canres on each possible res in the spot if cant res then return the information
                                case "removereservation": //remove a pre-existing reservation for whatever reason, based on name of reserver     !unwritten!                                    
                                    break;//take full name and look to remove any reservations under them
                                case "logout":
                                    System.out.println("logging out");//logout, return to previous switch board
                                    System.out.println();
                                    break;
                                default:
                                    System.out.println("ERROR: INVALID COMMAND " + originalC.toUpperCase());//unexpected input
                                    break;
                            }
                        } while (!adminCommand.equals("logout"));
                    } else {
                        System.out.println("ERROR: USER NOT FOUND RETURNING TO MAIN SCREEN");
                    }
                    break;
                }
                case "shutdown":
                    System.out.println("System shutting down");//system shutting down
                    break;
                default:
                    System.out.println("ERROR: INVALID COMMAND " + OC.toUpperCase());//unexpected input
                    break;
            }
        } while (!command.equals("shutdown"));
    }

    public static boolean authenticate(String u, String p) {
        System.out.println("Authentication successful!");
        return true;
    }

    public static boolean validateDay(int d) { //make sure day given is valid
        return d > 0 && d <= Calendar.getInstance().getActualMaximum(Calendar.DAY_OF_MONTH); /////////////////
    }

    public static boolean validateTimeOrder(String T1, String T2) { // make sure the second time given is after the first time given
        String pattern = "^(0?[1-9]|1[0-2]):([0-5][0-9]) ([APap][mM]$)";
        Pattern r = Pattern.compile(pattern);
        Matcher ma = r.matcher(T1);
        Matcher mb = r.matcher(T2);

        if (ma.matches() && mb.matches()) {
            String p1 = ma.group(3);
            String p2 = mb.group(3);
            if (p1.equals(p2)) {
                int h1 = Integer.parseInt(ma.group(1));
                int h2 = Integer.parseInt(mb.group(1));
                if (h2 < h1) {
                    return false;
                } else if (h1 == h2) {
                    int m1 = Integer.parseInt(ma.group(2));
                    int m2 = Integer.parseInt(mb.group(2));
                    if (m1 == m2) {
                        System.out.println("ERROR: the two entered times are equivelent");
                        return false;
                    } else if (m1 == 00 && m2 == 30) {
                        System.out.println("Be aware that the entered times are equivelent to only entering the first time");
                        return true;
                    } else {
                        return false;
                    }
                } else {
                    return true;
                }
            } else if (p1.equals("am") && p2.equals("pm")) {
                return true;
            } else {
                return false;
            }

        } else {
            System.out.println("ERROR: bad input of either " + T1 + " or " + T2);
            return false;
        }
        //return T2 > T1 BAISICALLY;
    }

    public static String roundOff(String time) {
        String pattern = "^([1-9]|1[0-2]):([0-5][0-9]) ([APap][mM]$)";
        Pattern r = Pattern.compile(pattern);
        Matcher ma = r.matcher(time);
        if (ma.matches()) {
            int m = Integer.parseInt(ma.group(2));
            m = m + 29;
            String fin = ma.group(1) + ":" + m + " " + ma.group(3);
            return fin;
        } else {
            System.out.println("ERROR: BAD INPUT");
            return time;
        }
    }

    public static String roundUp(String time) {
        String pattern = "^([1-9]|1[0-2]):([0-5][0-9]) ([APap][mM]$)";
        Pattern r = Pattern.compile(pattern);
        Matcher ma = r.matcher(time);

        if (ma.matches()) {
            String h = ma.group(1);
            int m = Integer.parseInt(ma.group(2));
            String period = ma.group(3);
            String t = "";

            if (period.equals("AM") || period.equals("am") || period.equals("aM") || period.equals("Am")) {
                switch (h) {
                    case "12":
                        if (m <= 29) {
                            t = "12:30 am";   //from 12:00
                        } else {
                            t = "1:00 am"; //from 12:30
                        }
                        break;
                    case "1":
                        if (m <= 29) {
                            t = "1:30 am";
                        } else {
                            t = "2:00 am";
                        }
                        break;
                    case "2":
                        if (m <= 29) {
                            t = "2:30 am";
                        } else {
                            t = "3:00 am";
                        }
                        break;
                    case "3":
                        if (m <= 29) {
                            t = "3:30 am";
                        } else {
                            t = "4:00 am";
                        }
                        break;
                    case "4":
                        if (m <= 29) {
                            t = "4:30 am";
                        } else {
                            t = "5:00 am";
                        }
                        break;
                    case "5":
                        if (m <= 29) {
                            t = "5:30 am";
                        } else {
                            t = "6:00 am";
                        }
                        break;
                    case "6":
                        if (m <= 29) {
                            t = "6:30 am";
                        } else {
                            t = "7:00 am";
                        }
                        break;
                    case "7":
                        if (m <= 29) {
                            t = "7:30 am";
                        } else {
                            t = "8:00 am";
                        }
                        break;
                    case "8":
                        if (m <= 29) {
                            t = "8:30 am";
                        } else {
                            t = "9:00 am";
                        }
                        break;
                    case "9":
                        if (m <= 29) {
                            t = "9:30 am";
                        } else {
                            t = "10:00 am";
                        }
                        break;
                    case "10":
                        if (m <= 29) {
                            t = "10:30 am";
                        } else {
                            t = "11:00 am";
                        }
                        break;
                    case "11":
                        if (m <= 29) {
                            t = "11:30 am";
                        } else {
                            t = "12:00 pm";
                        }
                        break;
                    default:
                        System.out.println("UNKNOWN ERROR");
                        return "false";
                }
            } else {
                switch (h) {
                    case "12":
                        if (m <= 29) {
                            t = "12:30 pm";  //noon
                        } else {
                            t = "1:00 pm";  //past noon
                        }
                        break;
                    case "1":
                        if (m <= 29) {
                            t = "1:30 pm";
                        } else {
                            t = "2:00 pm";
                        }
                        break;
                    case "2":
                        if (m <= 29) {
                            t = "2:30 pm";
                        } else {
                            t = "3:00 pm";
                        }
                        break;
                    case "3":
                        if (m <= 29) {
                            t = "3:30 pm";
                        } else {
                            t = "4:00 pm";
                        }
                        break;
                    case "4":
                        if (m <= 29) {
                            t = "4:30 pm";
                        } else {
                            t = "5:00 pm";
                        }
                        break;
                    case "5":
                        if (m <= 29) {
                            t = "5:30 pm";
                        } else {
                            t = "6:00 pm";
                        }
                        break;
                    case "6":
                        if (m <= 29) {
                            t = "6:30 pm";
                        } else {
                            t = "7:00 pm";
                        }
                        break;
                    case "7":
                        if (m <= 29) {
                            t = "7:30 pm";
                        } else {
                            t = "8:00 pm";
                        }
                        break;
                    case "8":
                        if (m <= 29) {
                            t = "8:30 pm";
                        } else {
                            t = "9:00 pm";
                        }
                        break;
                    case "9":
                        if (m <= 29) {
                            t = "9:30 pm";
                        } else {
                            t = "10:00 pm";
                        }
                        break;
                    case "10":
                        if (m <= 29) {
                            t = "10:30 pm";
                        } else {
                            t = "11:00 pm";
                        }
                        break;
                    case "11":
                        if (m <= 29) {
                            t = "11:30 pm";
                        } else {
                            t = "11:59 pm"; //midnight, since it is the second time it isnt reserved its only a marker for when reserving stops
                        }
                        break;
                    default:
                        System.out.println("UNKNOWN ERROR");
                        return "false";
                }
            }
            return t;
        } else {
            System.out.println("ERROR: bad input of " + time);
            return "false";
        }
    }

    public static String roundDown(String time) {
        String pattern = "^([1-9]|1[0-2]):([0-5][0-9]) ([APap][mM]$)";
        Pattern r = Pattern.compile(pattern);
        Matcher ma = r.matcher(time);

        if (ma.matches()) {
            String h = ma.group(1);
            int m = Integer.parseInt(ma.group(2));
            String period = ma.group(3);
            String t;

            if (period.equals("AM") || period.equals("am") || period.equals("aM") || period.equals("Am")) {
                switch (h) {
                    case "12":
                        if (m <= 29) {
                            t = "12:00 am";   //midnight
                        } else {
                            t = "12:30 am"; //30min past midnight
                        }
                        break;
                    case "1":
                        if (m <= 29) {
                            t = "1:00 am";
                        } else {
                            t = "1:30 am";
                        }
                        break;
                    case "2":
                        if (m <= 29) {
                            t = "2:00 am";
                        } else {
                            t = "2:30 am";
                        }
                        break;
                    case "3":
                        if (m <= 29) {
                            t = "3:00 am";
                        } else {
                            t = "3:30 am";
                        }
                        break;
                    case "4":
                        if (m <= 29) {
                            t = "4:00 am";
                        } else {
                            t = "4:30 am";
                        }
                        break;
                    case "5":
                        if (m <= 29) {
                            t = "5:00 am";
                        } else {
                            t = "5:30 am";
                        }
                        break;
                    case "6":
                        if (m <= 29) {
                            t = "6:00 am";
                        } else {
                            t = "6:30 am";
                        }
                        break;
                    case "7":
                        if (m <= 29) {
                            t = "7:00 am";
                        } else {
                            t = "7:30 am";
                        }
                        break;
                    case "8":
                        if (m <= 29) {
                            t = "8:00 am";
                        } else {
                            t = "8:30 am";
                        }
                        break;
                    case "9":
                        if (m <= 29) {
                            t = "9:00 am";
                        } else {
                            t = "9:30 am";
                        }
                        break;
                    case "10":
                        if (m <= 29) {
                            t = "10:00 am";
                        } else {
                            t = "10:30 am";
                        }
                        break;
                    case "11":
                        if (m <= 29) {
                            t = "11:00 am";
                        } else {
                            t = "11:30 am";
                        }
                        break;
                    default:
                        System.out.println("UNKNOWN ERROR");
                        return "false";
                }
            } else {
                switch (h) {
                    case "12":
                        if (m <= 29) {
                            t = "12:00 pm";  //noon
                        } else {
                            t = "12:30 pm";  //past noon
                        }
                        break;
                    case "1":
                        if (m <= 29) {
                            t = "1:00 pm";
                        } else {
                            t = "1:30 pm";
                        }
                        break;
                    case "2":
                        if (m <= 29) {
                            t = "2:00 pm";
                        } else {
                            t = "2:30 pm";
                        }
                        break;
                    case "3":
                        if (m <= 29) {
                            t = "3:00 pm";
                        } else {
                            t = "3:30 pm";
                        }
                        break;
                    case "4":
                        if (m <= 29) {
                            t = "4:00 pm";
                        } else {
                            t = "4:30 pm";
                        }
                        break;
                    case "5":
                        if (m <= 29) {
                            t = "5:00 pm";
                        } else {
                            t = "5:30 pm";
                        }
                        break;
                    case "6":
                        if (m <= 29) {
                            t = "6:00 pm";
                        } else {
                            t = "6:30 pm";
                        }
                        break;
                    case "7":
                        if (m <= 29) {
                            t = "7:00 pm";
                        } else {
                            t = "7:30 pm";
                        }
                        break;
                    case "8":
                        if (m <= 29) {
                            t = "8:00 pm";
                        } else {
                            t = "8:30 pm";
                        }
                        break;
                    case "9":
                        if (m <= 29) {
                            t = "9:00 pm";
                        } else {
                            t = "9:30 pm";
                        }
                        break;
                    case "10":
                        if (m <= 29) {
                            t = "10:00 pm";
                        } else {
                            t = "10:30 pm";
                        }
                        break;
                    case "11":
                        if (m <= 29) {
                            t = "11:00 pm";
                        } else {
                            t = "11:30 pm";
                        }
                        break;
                    default:
                        System.out.println("UNKNOWN ERROR");
                        return "false";
                }
            }
            return t;
        } else {
            System.out.println("ERROR: bad input of " + time);
            return "false";
        }
    }
}
