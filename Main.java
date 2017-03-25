/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.csc380homework;

import java.util.ArrayList;
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
              
        ArrayList <ParkingLot>lots = new ArrayList(); //parking lot arrayList
        ArrayList <String>alerts = new ArrayList();//police alerts
        
        do{
            Scanner kb;

            System.out.println("Welcome to the SUNY Oswego Parking Lot Reservation System!");

            System.out.println("Please specify what type of user you are from the following options, or shut down the system:");
            System.out.println("|User|Police|Admin|ShutDown|");
            kb = new Scanner(System.in);
            command = kb.nextLine();
            String OC = command;
            command = command.toLowerCase();
            command = command.replaceAll("\\s",""); 
            
            switch (command) {
                case "user":
                    {
                        boolean a;
                        String userName;
                        String password;
                        System.out.println("Enter username");//loggin authentication, any user + password will work atm
                        kb = new Scanner(System.in);
                        userName = kb.nextLine();
                        System.out.println("Enter password");
                        kb = new Scanner(System.in);
                        password = kb.nextLine();
                        a = authenticate(userName, password);
                        if(a){
                            System.out.println("Welcome student/employee/guest!");
                            System.out.println();
                            do{
                                System.out.println("Please enter a command from the following options:");
                                System.out.println("|Reserve|AvailabeSpots|AlertPolice|Logout|");
                                kb = new Scanner(System.in);
                                userCommand = kb.nextLine();
                                String originalC = userCommand;
                                userCommand = userCommand.toLowerCase();
                                userCommand = userCommand.replaceAll("\\s","");
                                
                                switch (userCommand) {
                                    case "reserve":    // reserve one ore more time slots    !unwritten!
                                        break;
                                    case "availabespots":
                                        //take time, check how many if any are available at that time
                                        System.out.println("enter the time and day you wish to check"); // something like that, maybe split up into two serpeerate asks
                                        break;
                                    case "logout": //logout
                                        System.out.println("logging out");
                                        break;
                                    case "alertpolice":   //ask what parking lot and what parking spot, used for when a spot is in misuse and creates an alert that is shown to a cop the next time they login    !unwritten!
                                        System.out.println("something goes here");
                                        break;
                                    default:
                                        System.out.println("ERROR: INVALID COMMAND " + originalC.toUpperCase()); //unexpected input
                                        break;
                                }
                            }while(!userCommand.equals("logout"));
                        } else {
                            System.out.println("ERROR: USER NOT FOUND");  //authentication fails (it never will as is)
                        }       break;
                    }
                case "police":
                {             
                    //somewhere around here will be the alerts, or maybe within the doWhile below
                    boolean a;
                    String userName;
                    String password;
                    System.out.println("Enter username");//loggin authentication, any user + password will work atm
                    kb = new Scanner(System.in);
                    userName = kb.nextLine();
                    System.out.println("Enter password");
                    kb = new Scanner(System.in);
                    password = kb.nextLine();
                    a = authenticate(userName, password);
                    if(a){
                        System.out.println("Welcome officer!");
                        System.out.println();
                        do{
                            System.out.println("Please enter a command from the following options:");
                            System.out.println("|DisplayAllReservations|CheckParkingSpot|Logout|");
                            kb = new Scanner(System.in);
                            policeCommand = kb.nextLine();
                            String originalC = policeCommand;
                            policeCommand = policeCommand.toLowerCase();  //formatting
                            policeCommand = policeCommand.replaceAll("\\s","");  //formatting
                            
                            switch (policeCommand) {
                                case "checkparkingspot":  //retreive information from specific parking spot  !unwritten!
                                    break;
                                case "displayallreservations": //det all reservations and display them in an orderly manner  includes: spot#, name, liscence plate, and authentication#    !unwritten!
                                    break;
                                case "logout":  //return to previous switch board
                                    System.out.println("logging out");
                                    break;
                                default:
                                    System.out.println("ERROR: INVALID COMMAND " + originalC.toUpperCase());
                                    break;
                        }
                    
                        }while(!policeCommand.equals("logout"));
                    } else {
                        System.out.println("ERROR: USER NOT FOUND");
                    }       break;
                }
                case "admin":
                {
                    //"authenticate"(any loggon will work)   then go to new dowhile with new options    like<create parking lots><get current reservations>
                    boolean a;
                    String userName;
                    String password;
                    System.out.println("Enter username");
                    kb = new Scanner(System.in);
                    userName = kb.nextLine();
                    System.out.println("Enter password");
                    kb = new Scanner(System.in);
                    password = kb.nextLine();
                    a = authenticate(userName, password);
                    if(a){
                        System.out.println("Welcome Administrator!");
                        System.out.println();
                        do{
                            System.out.println("Please enter a command from the following options:");
                            System.out.println("|CreateLot|RemoveLot|displaylotnames|DisplayAllReservations|CheckParkingSpot|Logout|");//spaces and capitalization do not matter
                            kb = new Scanner(System.in);
                            adminCommand = kb.nextLine();
                            String originalC = adminCommand;
                            adminCommand = adminCommand.toLowerCase();//formatting
                            adminCommand = adminCommand.replaceAll("\\s","");//remove spaces, formatting
                            
                            switch (adminCommand) {
                                case "createlot":   //create a parking lot<name it and specify the number of parking spots>
                                {
                                    System.out.println("Enter the name of the lot to be created:");
                                    kb = new Scanner(System.in);
                                    String lotName = kb.nextLine();
                                    int spots = 0;
                                    boolean b;
                                    do {
                                        System.out.println("Enter the number of parking spots in this new lot:");
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
                                    if(lots.size() > 0){
                                        System.out.println("Enter the name of the lot to be removed:");
                                        kb = new Scanner(System.in);
                                        String lotName = kb.nextLine();
                                        for (Iterator<ParkingLot> iterator = lots.iterator(); iterator.hasNext(); ) {
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
                                        System.out.println(i.getLotName());
                                    }                                    
                                    break;
                                case "displayallreservations":
                                    break;  //get all reservations and display them in an orderly manner  includes: spot#, name, liscence plate, and authentication#    !unwritten!
                                case "checkparkingspot":
                                    break;  //get the information from a specific spot         !unwritten!
                                case "removeareservation": //remove a pre-existing reservation for whatever reason     !unwritten!                                    
                                    break;
                                case "logout":
                                    System.out.println("logging out");//logout, return to previous switch board
                                    break;
                                default:
                                    System.out.println("ERROR: INVALID COMMAND " + originalC.toUpperCase());//unexpected input
                                    break;
                            }
                        }while(!adminCommand.equals("logout"));    
                    } else {
                        System.out.println("ERROR: USER NOT FOUND");
                    }       break;
                }
                case "shutdown":
                    System.out.println("System shutting down");//system shutting down
                    break;
                default:          
                    System.out.println("ERROR: INVALID COMMAND " + OC.toUpperCase());//unexpected input
                    break;
            }
        }while(!command.equals("shutdown"));
    }
    
    public static boolean authenticate(String u, String p){
        System.out.println("Authentication successful!");
        return true;
    }
    
}
