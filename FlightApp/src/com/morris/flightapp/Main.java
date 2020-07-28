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

        Flight f = new Flight();
        Passenger p1 = new Passenger(2, 0, 8.00, "Jacob", "Smith");
        Passenger p2 = new Passenger(1, 0, 8.00, "Maria", "Gonzalez");
        System.out.println("Adding Passengers: " + p1.getPassengerName() + ", " + p2.getPassengerName());
        f.addPassengers(p1, p2);
        System.out.println("TotalBags for flight: " + f.getTotalCheckedBags());

        CargoFlight c130 = new CargoFlight(1000.0f);
        c130.add1Package(20, 1, 5);
        System.out.println(c130.getUsedCargoSpace()); // 100.0
        c130.add1Package(15, 2, 11);
        System.out.println(c130.getUsedCargoSpace());
        c130.add1Package(60, 6, 30);
        System.out.println(c130.getUsedCargoSpace()); // prints error and cargo info
    }
    public static void swapFlightNumbers(Flight i, Flight j) {
        int k = i.getFlightNumber();
        i.setFlightNumber(j.getFlightNumber());
        j.setFlightNumber(k);
    }
}
