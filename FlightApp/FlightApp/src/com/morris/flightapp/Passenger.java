package com.morris.flightapp;

public class Passenger {
    private int checkedBags;
    private int freeBags;
    private final double perBagFee;
    private String firstName;
    private String lastName;

    /**
     * Constructs a passenger with number of checked bags, amount of freebags, per-bag free which is final,
     * first name and last name
     * @param checkedBags : number of checked bags
     * @param freeBags : number of free bags
     * @param perBagFee : final price, price per bag
     * @param firstName : passenger's first name
     * @param lastName : passenger's last name
     */
    public Passenger(int checkedBags, int freeBags, double perBagFee, String firstName,
                     String lastName) {
        this.checkedBags = checkedBags;
        this.freeBags = freeBags;
        this.perBagFee = perBagFee;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    /**
     * Constructs a passenger with first name and last name
     * @param firstName : passenge's first name
     * @param lastName : passenger's last name
     */
    public Passenger(String firstName, String lastName) {
        this(0,0, 8.00);
        this.firstName = firstName;
        this.lastName = lastName;
    }

    /**
     * Constructs a passenger with number of free bags they have on board flight
     * @param checkedBags : number of bags checked in by passeneger
     * @param freeBags : number of free bags passenger carried on flight
     * @param perBagFee : final price per bag on board
     */
    public Passenger(int checkedBags, int freeBags, double perBagFee) {
        this.checkedBags = checkedBags;
        this.freeBags = freeBags;
        this.perBagFee = perBagFee;
        this.firstName = null;
        this.lastName = null;
    }

    public int getCheckedBags() {
        return this.checkedBags;
    }

    public void setCheckedBags(int checkedBags) {
        this.checkedBags = checkedBags;
    }

    public int getFreeBags() {
        return this.freeBags;
    }

    public void setFreeBags(int freeBags) {
        this.freeBags = freeBags;
    }

    public double getPerBagFee() {
        return this.perBagFee;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassengerName() {
        String fullName = String.format("%s %s", this.firstName, this.lastName);
        return fullName;
    }
}