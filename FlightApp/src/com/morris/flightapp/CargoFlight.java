package com.morris.flightapp;

public class CargoFlight extends Flight {
    private final float maxCargoSpace;
    private float usedCargoSpace;

    public CargoFlight() {
        super();
        this.maxCargoSpace = 1000.0f;
        this.usedCargoSpace = 0.0f;
    }

    public CargoFlight(float maxCargoSpace) {
        this.maxCargoSpace = maxCargoSpace;
    }

    public CargoFlight(int seatCapacity) {
        super(seatCapacity);
        this.maxCargoSpace = 1000.0f;
        this.usedCargoSpace = 0.0f;
    }

    /**
     * Requires the max space available for the cargo plane and begins with empty cargo.
     *
     * @param maxCargoSpace : space available for cargo plane
     */
    public CargoFlight(float maxCargoSpace, int flightNumber, char flightClass) {
        super(flightNumber, flightClass);
        this.maxCargoSpace = maxCargoSpace;
        this.usedCargoSpace = 0.0f;
    }

    /**
     * Adds a package to the cargo flight and checks if cargo flight has space available. If there is
     * no space available, prints a summary of cargo properties.
     *
     * @param height   : package height
     * @param width    : package width
     * @param diameter : package diameter
     */
    public void add1Package(float height, float width, float diameter) {
        float size = height * width * diameter;
        if (hasCargoSpace(size)) {
            usedCargoSpace += size;
        } else {
            /* given the size of cargo, reports if the size make cargo flight over capacity. */
            reportCargoSpaceCapacityReached(size);
        }

    }

    /**
     * Returns true if cargo has space left on light, returns false if there is no space on cargo flight.
     *
     * @param size : size of new package to add to cargo flight
     * @return true or false
     */
    public boolean hasCargoSpace(float size) {
        return this.usedCargoSpace + size <= this.maxCargoSpace;
    }

    /**
     * Reports the properties of the cargo flight when a new package exceeds the capacity.
     *
     * @param size : size of new package being added to cargo flight
     */
    public void reportCargoSpaceCapacityReached(float size) {
        float capacityRemaining = this.maxCargoSpace - this.usedCargoSpace;
        String capacity = String.format("Max Capacity: %f", this.maxCargoSpace);
        String capacityUsed = String.format("Capacity Used: %f", this.usedCargoSpace);
        String capacityRemainingStr = String.format("Capacity Remaining: %f", capacityRemaining);
        String capacityRequired = String.format("Capacity Required: %f", size);
        System.out.println(capacity + "\n" + capacityUsed + "\n" + capacityRemainingStr +
                "\n" + capacityRequired);
    }

    public float getMaxCargoSpace() {
        return maxCargoSpace;
    }

    public float getUsedCargoSpace() {
        return usedCargoSpace;
    }

    public void setUsedCargoSpace(float usedCargoSpace) {
        this.usedCargoSpace = usedCargoSpace;
    }
}