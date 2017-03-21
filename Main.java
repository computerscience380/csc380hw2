/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.Scanner;

/**
 *
 * @author Zach
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String reservationTime;
        int spot;
        String name;
        String licensePlate;

        System.out.println("Welcome to the Oswego Commuter Lot Reservation System!");
        Scanner kb = new Scanner(System.in);
        System.out.println("Enter a reservation date and time:");
        reservationTime = kb.next();
        //search through a calendar or some sort of mechanism to see if there are spots avaiable for the time and date
        //call isFull on the specified date and time which we need some way to keep track of
        //if there is continue with the next question
        reservationTime.isTimeAvailable();
        System.out.println("Enter the prefered reservation spot:");
        spot = kb.nextInt();
        //search through arraylist to see if spot is already taken
        //return true spot is available or false and throw exception saying spot is not available
        spot.isTaken();
        System.out.println("Enter name of car owner:");
        name = kb.next();
        System.out.println("Enter the license plate:");
        licensePlate = kb.next();
        //reserve date time and spot into arraylists along with name and plate
        System.out.println("Your spot has been reserved! Have a good day.");
        
    }
}

