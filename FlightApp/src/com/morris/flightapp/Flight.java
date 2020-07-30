package com.morris.flightapp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class Flight implements Comparable<Flight>, Iterable<Passenger> {

    private class FlightIterable implements Iterable<Passenger> {
        public Iterator<Passenger> iterator() {
            Passenger[] passengers = new Passenger[Flight.this.passengerArrayList.size()];
            Flight.this.passengerArrayList.toArray(passengers);
            Arrays.sort(passengers);
            return Arrays.asList(passengers).iterator();
        }
    }
    private int passengers;
    private static int allPassengers;
    private static int maxPassengerPerFlight;
    private int seatCapacity;
    private int seatsAvailable;
    private int totalCheckedBags;
    private int flightNumber;
    private char flightClass;
    private boolean[] isSeatAvailable = new boolean[seatsAvailable];
    private ArrayList<Passenger> passengerArrayList;

    public Flight() {
        this.passengers = 0;
        this.seatCapacity = 150;
        this.seatsAvailable = this.seatCapacity;
        this.totalCheckedBags = 0;
        this.flightNumber = 0;
        this.flightClass = 'a';
        passengerArrayList = new ArrayList<>();
    }

    public Flight(int seatCapacity) {
        this();
        this.seatCapacity = seatCapacity;
    }

    /**
     * Constructs flight with default fields and adds a flight number and flight class
     * @param flightNumber : Flight number
     * @param flightClass : Flight class
     */
    public Flight(int flightNumber, char flightClass) {
        this();
        this.flightNumber = flightNumber;
        this.flightClass = flightClass;
    }

    /**
     * If a flight's capacity is not filled, adds one passenger to flight, increments number of total passengers
     * and decrements number of available seats on flight.
     */
    public void add1Passenger() {
        if ( hasSeating() /* && this.passengers < maxPassengerPerFlight */ ) {
            this.passengers++;
            allPassengers++;
            this.seatsAvailable--;
        } else {
            /* produces message alert "capacity full" */
            handleTooManyPassengers();
        }
    }

    /**
     * If there is seating available on flight, adds a passenger to the flight and the passenger's number of bags added
     * onto the total bag count on flight.
     * @param bags : number of bags passenger carries onto flight
     */
    public void add1Passenger(int bags) {
        if ( hasSeating() ) {
            add1Passenger();
            totalCheckedBags += bags;
        } else {
            handleTooManyPassengers();
        }
    }

    public void add1Passenger(Passenger passenger) {
        if ( hasSeating() ) {
            add1Passenger();
            passengerArrayList.add(passenger);
        } else {
            handleTooManyPassengers();
        }
    }

    /**
     * Allows client to add multiple passengers at one time. If adding the number of passengers to the total flight
     * count is less than the flight capacity, add the passengers to flight count and iterate each passenger to
     * check how many bags they are adding to the flight.
     * @param list : list of passengers with parameters of bag count
     */
    public void addPassengers(Passenger... list) {
        if ( hasSeating(list.length) ) {
            this.passengers += list.length;
            for (Passenger passenger : list) {
                totalCheckedBags += passenger.getCheckedBags();
            }
        }
    }

    /* boolean that checks if passengers on flight is less than seats available on flight. This methods works
     * in conjunction with add1Passenger() methods.
     */
    private boolean hasSeating() {
        return this.passengers < this.seatsAvailable;
    }

    /* used in conjunction with adding a list of passengers to one flight. Adds the number of passengers currently
     * on flight and the number being added. returns true if we can add passengers to flight and false otherwise.
     */
    private boolean hasSeating(int count) {
        return this.passengers + count <= this.seatsAvailable;
    }

    /**
     * removes one passenger from flight and makes one seat on flight available.
     */
    public void remove1Passenger() {
        System.out.println("[ATTENTION!] Removed one passenger ");
        this.passengers--;
        allPassengers--;
        this.seatsAvailable++;
    }

    /**
     * allPassengers is a private static field so this method's purpose is for the entire Flight class and impacts
     * all instances of Flight in a client.
     * @return : returns number of all Passengers across all instances of Flight
     */
    public static int getAllPassengers() {
        return allPassengers;
    }

    /**
     * resets all instances of Flight passengers to 0
     */
    public static void resetAllpassengers() {
        allPassengers = 0;
    }

    /* static {
        AdminService admin = new AdminService();
        admin.connect();
        maxPassengerPerFlight = admin.isRestricted() ? admin.getMaxFlightPassengers() : Integer.MAX_VALUE;
        admin.close();
    } */

    /**
     * Prints an error message to the console if passenger capacity has been reached on the flight.
     */
    private void handleTooManyPassengers() {
        System.out.println("Error! Passenger capacity full!");
    }

    /**
     * @return : true if there are seats available on flight, false otherwise
     */
    public boolean hasSeatsAvailable() {
        return this.seatsAvailable > 0;
    }

    /**
     * @return : number of passengers on a flight.
     */
    public int getPassengers() {
        return this.passengers;
    }

    /**
     * @return : number of seats available on a flight.
     */
    public int getSeatsAvailable() {
        return this.seatsAvailable;
    }

    /**
     * @return : seat capacity of flight.
     */
    public int getSeatCapacity() {
        return this.seatCapacity;
    }

    public int getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(int flightNumber) {
        this.flightNumber = flightNumber;
    }

    public char getFlightClass() {
        return flightClass;
    }

    public void setFlightClass(char flightClass) {
        this.flightClass = flightClass;
    }

    public boolean[] getIsSeatAvailable() {
        return isSeatAvailable;
    }

    public void setIsSeatAvailable(boolean[] isSeatAvailable) {
        this.isSeatAvailable = isSeatAvailable;
    }

    public int getTotalCheckedBags() {
        return totalCheckedBags;
    }

    public void setTotalCheckedBags(int totalCheckedBags) {
        this.totalCheckedBags = totalCheckedBags;
    }

    public int compareTo(Flight flight) {
        int returnValue = flight.flightNumber - this.flightNumber;
        return returnValue;
    }

    public Iterator<Passenger> iterator() {
        return passengerArrayList.iterator();
    }

    public Iterable<Passenger> getOrderedPassengers() {
        FlightIterable orderedPassengers = new FlightIterable();
        return orderedPassengers;
    }
}