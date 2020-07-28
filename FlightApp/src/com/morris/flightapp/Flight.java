package com.morris.flightapp;

public class Flight {
    private int passengers;
    private final int seatCapacity;
    private int seatsAvailable;

    public Flight() {
        this.passengers = 0;
        this.seatCapacity = 150;
        this.seatsAvailable = 150;
    }

    /**
     * If a flight's capacity is not filled, adds one passenger to flight, increments number of total passengers
     * and decrements number of available seats on flight.
     */
    public void add1Passenger() {
        if (this.passengers < this.seatCapacity) {
            this.passengers++;
            this.seatsAvailable--;
        } else {
            /* produces message alert "capacity full" */
            handleTooManyPassengers();
        }
    }

    /**
     * removes one passenger from flight and makes one seat on flight available.
     */
    public void remove1Passenger() {
        System.out.println("[ATTENTION!] Removed one passenger ");
        this.passengers--;
        this.seatsAvailable++;
    }

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
}
