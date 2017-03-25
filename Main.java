/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.csc380homework;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.Scanner;

/**
 *
 * @author Sean McGrath
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        String userCommand;
        String adminCommand;
        String policeCommand;
        String command;

        ArrayList<ParkingLot> lots = new ArrayList(); //parking lot arrayList
        ArrayList<Alert> alerts = new ArrayList();//police alerts

        do {
            Scanner kb;
            System.out.println("Welcome to the SUNY Oswego Parking Lot Reservation System!");
            System.out.println("Please specify what type of user you are from the following options, or shut down the system:");
            System.out.println("|User|Police|Admin|ShutDown|");
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
                    if (a) {
                        System.out.println("Welcome student/employee/guest!");
                        System.out.println();
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
                                case "reserve": // reserve one ore more time slots   maybe a max amount of reservations?     how much is too much    !mostly unwritten!
                                {
                                    if (lots.isEmpty()) {
                                        System.out.println("ERROR: no existing parking lots to make reservations at");
                                    } else {
                                        String name;
                                        int startH = -1;
                                        int startM = -1;
                                        String startP = null;
                                        int endH = -1;
                                        int endM = -1;
                                        String endP = null;
                                        int day = -1;
                                        int ID = -1;
                                        boolean failure = false;
                                        String lotName = null;
                                        String plate = null;

                                        do {
                                            System.out.println("Please enter the name of the parking lot this reservation will be made at out of the following options, be aware capitalization matters:");
                                            for (ParkingLot i : lots) {
                                                System.out.println(i.getLotName());
                                            }
                                            System.out.print(">");
                                            kb = new Scanner(System.in);
                                            lotName = kb.nextLine();

                                            for (Iterator<ParkingLot> iterator = lots.iterator(); iterator.hasNext();) {
                                                ParkingLot i = iterator.next();
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

                                        do {
                                            boolean cont;
                                            System.out.println("Please enter the hour, minutes, and am or pm in format <hour min period> for the start of your reservation, be aware that this will be rounded down to the nearest half hour:");
                                            System.out.print(">");
                                            kb = new Scanner(System.in);
                                            if (kb.hasNextInt()) {//hour
                                                startH = kb.nextInt();
                                                if (validateHour(startH)) {
                                                    cont = true;
                                                    failure = false;
                                                } else {
                                                    System.out.println("ERROR: the hour value given: " + startH + " is not a real hour");
                                                    cont = false;
                                                    failure = true;
                                                }
                                            } else {
                                                System.out.println("ERROR: invalid hour please enter a NUMBER");
                                                cont = false;
                                                failure = true;
                                            }

                                            if (cont) {//min
                                                if (kb.hasNextInt()) {
                                                    startM = kb.nextInt();
                                                    if (validateMin(startM)) {
                                                        cont = true;
                                                        failure = false;
                                                    } else {
                                                        System.out.println("ERROR: the minute value given: " + startM + " is not a real minute");
                                                        cont = false;
                                                        failure = true;
                                                    }
                                                } else {
                                                    System.out.println("ERROR: invalid minute please enter a NUMBER");
                                                    cont = false;
                                                    failure = true;
                                                }
                                            }

                                            if (cont) {//period
                                                if (kb.hasNext()) {
                                                    startP = kb.nextLine();
                                                    startP = startP.toUpperCase();
                                                    startP = startP.replaceAll("\\s", "");
                                                    if (startP.equals("AM") || startP.equals("PM")) {
                                                        failure = false;
                                                    } else {
                                                        System.out.println("ERROR: invalid period input of " + startP);
                                                        System.out.println("Please input AM or PM");
                                                        failure = true;
                                                    }
                                                } else {
                                                    System.out.println("ERROR: no period input given");
                                                    System.out.println("Please input AM or PM");
                                                    failure = true;
                                                }
                                            }

                                        } while (failure);
                                        System.out.println(startH);
                                        System.out.println(startM);
                                        System.out.println(startP);

                                        do {
                                            boolean cont = true;
                                            System.out.println("Please enter the hour, minutes, and am or pm in format <hour min period> for the end of your reservation, if you only want to reserve a single time then enter 'none' for this, be aware that this will be rounded up to the nearest half hour:");
                                            System.out.print(">");
                                            kb = new Scanner(System.in);
                                            if (!kb.hasNextInt()) {  //hour or 'none'
                                                String leave = kb.next();
                                                leave = leave.toLowerCase();
                                                leave = leave.replaceAll("\\s", "");
                                                if (leave.equals("none")) {
                                                    endH = -2;
                                                    endM = -2;
                                                    endP = "na";
                                                    System.out.println("Understood, only one time slot will be atempted to be reserved");
                                                    cont = false;
                                                    failure = false;
                                                } else {
                                                    System.out.println("ERROR: invalid hour please enter a NUMBER");
                                                    cont = false;
                                                    failure = true;
                                                }
                                            } else {
                                                endH = kb.nextInt();
                                                if (validateHour(endH)) {
                                                    cont = true;
                                                    failure = false;
                                                } else {
                                                    System.out.println("ERROR: the hour value given: " + endH + " is not a real hour");
                                                    cont = false;
                                                    failure = true;
                                                }
                                            }

                                            if (cont) {//min
                                                if (kb.hasNextInt()) {
                                                    endM = kb.nextInt();
                                                    if (validateMin(endM)) {
                                                        cont = true;
                                                        failure = false;
                                                    } else {
                                                        System.out.println("ERROR: the minute value given: " + endM + " is not a real minute");
                                                        cont = false;
                                                        failure = true;
                                                    }
                                                } else {
                                                    System.out.println("ERROR: invalid minute please enter a NUMBER");
                                                    cont = false;
                                                    failure = true;
                                                }
                                            }
                                            
                                            if (cont) {//period
                                                if (kb.hasNext()) {
                                                    endP = kb.nextLine();
                                                    endP = endP.toUpperCase();
                                                    endP = endP.replaceAll("\\s", "");
                                                    if (endP.equals("AM") || endP.equals("PM")) {
                                                        failure = false;
                                                    } else {
                                                        System.out.println("ERROR: invalid period input of " + endP);
                                                        System.out.println("Please input AM or PM");
                                                        failure = true;
                                                    }
                                                } else {
                                                    System.out.println("ERROR: no period input given");
                                                    System.out.println("Please input AM or PM");
                                                    failure = true;
                                                }
                                            }
                                        } while (failure);
                                        
                                        do{
                                        System.out.println("Please enter a valid permit ID number:");   //permit ID 
                                        System.out.print(">");
                                        kb = new Scanner(System.in);
                                            if (kb.hasNextInt()) {
                                                ID = kb.nextInt();
                                                failure = false;
                                            } else {
                                                System.out.println("ERROR: invalid permit ID");
                                                System.out.println("Please enter a valid NUMBER permit ID");
                                                failure = true;
                                            }               
                                        }while(failure);
                                        //check whether it is one or more times being reserved then check if they are availble(if not all are availbe return which are and tell to retry)
                                        Reservation r = new Reservation(name, plate, ID);
                                        //then create the reservation and send it into the system based on what parking lot is asked for.
                                        
                                        // sucess -> some sort of congratulations including their name
                                        //failure -> apologize and 'returning to action selection'
                                    }
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
                    //somewhere around here will be the alerts, or maybe within the doWhile below(must be after login)(for each alert give the alert information along with the information of what SHOULD be in the spot allerted to(the reservation info))
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
                    if (a) {
                        System.out.println("Welcome officer!");
                        System.out.println();
                        do {
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
                    //"authenticate"(any loggon will work)   then go to new dowhile with new options    like<create parking lots><get current reservations>
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
                    if (a) {
                        System.out.println("Welcome Administrator!");
                        System.out.println();
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
                                    System.out.println("Enter the name of the lot to be created:");
                                    System.out.print(">");
                                    kb = new Scanner(System.in);
                                    String lotName = kb.nextLine();
                                    int spots = 0;
                                    boolean b;
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
                                    ParkingLot l = new ParkingLot(spots, lotName);
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
                                        for (Iterator<ParkingLot> iterator = lots.iterator(); iterator.hasNext();) {
                                            ParkingLot i = iterator.next();
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
                                    for (ParkingLot i : lots) {
                                        System.out.println("Parking lot: " + i.getLotName());
                                    }
                                    break;
                                case "displayallreservations":
                                    break;  //get all reservations and display them in an orderly manner  includes: spot#, name, liscence plate, and authentication#    !unwritten!
                                case "checkparkingspot":
                                    break;  //get the information from a specific spot         !unwritten!
                                case "removereservation": //remove a pre-existing reservation for whatever reason, based on name of reserver     !unwritten!                                    
                                    break;
                                case "logout":
                                    System.out.println("logging out");//logout, return to previous switch board
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

    public static boolean validateHour(int h) {//make jsut hour is valid 
        if (h >= 0 && h <= 12) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean validateMin(int m) {//make sure valid min given
        if (m >= 0 && m <= 60) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean validateDay(int d) {//make sure day given is valid
        if (d > 0 && d <= Calendar.getInstance().getActualMaximum(Calendar.DAY_OF_MONTH)) {
            return true;
        } else {/////////////////
            return false;
        }
    }

    public static boolean validateTimeOrder() {// make sure the second time given is after the first time given
        if (true) {
            return true;
        } else {
            return true;
        }
    }
}
