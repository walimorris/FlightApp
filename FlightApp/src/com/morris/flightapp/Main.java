package com.morris.flightapp;

import java.util.Arrays;
import java.util.Iterator;

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

        CargoFlight c131 = new CargoFlight(1000, 10, 'C');
        System.out.println(c131.getFlightNumber());
        System.out.println(c131.getMaxCargoSpace());

        Flight c130f = new CargoFlight(15);
        c130f.add1Passenger();
        System.out.println(c130f.getPassengers());
        System.out.println(c130f.getSeatCapacity());

        Passenger[] passengers = {
                new Passenger("Luisa", "Vargas", 3, 365),
                new Passenger("Demetrius", "Morris", 3, 367),
                new Passenger("Jacob", "McDonald", 1, 455),
                new Passenger("Simon", "Reynolds", 2, 30),
        };
        Arrays.sort(passengers);
        for ( Passenger p: passengers ) {
            System.out.println(p.getPassengerName());
        }

        Flight f175 = new Flight(175, 'P');
        Flight f160 = new Flight(160, 'P');
        f175.add1Passenger(new Passenger("Jim", "Jones", 3, 122));
        f175.add1Passenger(new Passenger("Rosa", "Vargas", 3, 455));
        f175.add1Passenger(new Passenger("Jerome", "Morris", 2, 223));
        f175.add1Passenger(new Passenger("Santiago", "Ramirez", 1, 105));
        Iterator<Passenger> iter = f175.iterator();

        // results of implementing iterable in Flight.java
        while ( iter.hasNext() ) {
            Passenger p = iter.next();
            System.out.println(p.getPassengerName());
        }
        // check how many seats are left on flight
        System.out.println("Seats left on f175: " + f175.getSeatsAvailable()); // returns 146

        // Implementing the nested RewarProgram in the Passenger Class
        Passenger brooke = new Passenger("Brooke", "Ulysis", 3, 365);
        System.out.println(brooke.getRewardProgram().getMemberLevel());

        // implementing the sorted Iterator
        for ( Passenger p : f175.getOrderedPassengers() ) {
            System.out.println(p.getPassengerName());
        }

    }
    public static void swapFlightNumbers(Flight i, Flight j) {
        int k = i.getFlightNumber();
        i.setFlightNumber(j.getFlightNumber());
        j.setFlightNumber(k);
    }
}