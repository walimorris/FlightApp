package com.morris.flightapp;

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
    }
}
