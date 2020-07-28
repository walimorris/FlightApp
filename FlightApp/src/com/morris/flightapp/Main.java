package com.morris.flightapp;

import static com.morris.flightapp.Flight.getAllPassengers;
import static com.morris.flightapp.Flight.resetAllpassengers;

public class Main {

    public static void main(String[] args) {
        Flight nycToLv = new Flight();
        Flight slcToSf = new Flight();
        Flight flight1 = new Flight();
        Flight flight2 = new Flight();
        flight2.add1Passenger();
        System.out.println(flight2.getPassengers());
        if (nycToLv.hasSeatsAvailable()) {
            System.out.println("Passengers on NYC to LV flight: " + nycToLv.getPassengers());
        }
        for (int i = 0; i < 5; i++) {
            if (nycToLv.hasSeatsAvailable()) {
                nycToLv.add1Passenger();
            }
        }
        System.out.println("Passengers on NYC to LV flight: " + nycToLv.getPassengers());
        System.out.println("NYC to LV flight seats available: " + nycToLv.getSeatsAvailable());
        nycToLv.remove1Passenger();
        System.out.println("NYC to LV flight seats available: " + nycToLv.getSeatsAvailable());

        Passenger bob = new Passenger("Bob", "Dylan");
        System.out.println("New passenger: " + bob.getPassengerName());
        System.out.println("\n[Attention!]Resetting all passengers");
        resetAllpassengers();

        Flight flight3 = new Flight(120, 'C');
        System.out.println("Flight #: " + flight3.getFlightNumber() + " " + "Flight Class: " + flight3.getFlightClass());

        nycToLv.add1Passenger();
        System.out.println(getAllPassengers());

        System.out.println("Creating new flight seatacToOh");
        System.out.println("Creating new flight laxToCin");
        Flight seatacToOh = new Flight(3, 'P');
        Flight laxToCin = new Flight(4, 'E');
        System.out.println("\nseatacToOh Flight: #" + seatacToOh.getFlightNumber());
        System.out.println("laxToCin Flight: #" + laxToCin.getFlightNumber());
        System.out.println("[ATTENTION!]Swapping Flight# : seatacToOh - laxToCin");
        swapFlightNumbers(seatacToOh, laxToCin);
        System.out.println("\nseatacToOh Flight: #" + seatacToOh.getFlightNumber());
        System.out.println("laxToCin Flight: #" + laxToCin.getFlightNumber());
    }

    public static void swapFlightNumbers(Flight i, Flight j) {
        int k = i.getFlightNumber();
        i.setFlightNumber(j.getFlightNumber());
        j.setFlightNumber(k);
    }
}
