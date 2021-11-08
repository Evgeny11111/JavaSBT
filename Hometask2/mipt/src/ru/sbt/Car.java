package ru.sbt;


public class Car {
    private final long carId;
    private final String brand;
    private final String modelName;
    private final int maxVelocity;
    private final int power;
    private final int ownerId;
    public Car(long carId, String brand, String modelName, int maxVelocity, int power, int ownerId) {
        this.carId = carId;
        this.brand = brand;
        this.modelName = modelName;
        this.maxVelocity = maxVelocity;
        this.power = power;
        this.ownerId = ownerId;
    }

    public long getCarId() {
        return carId;
    }

    public String getBrand() {
        return brand;
    }

    public int getOwnerId() {
        return ownerId;
    }

    public int getPower() {
        return power;
    }

    public int getMaxVelocity() {
        return maxVelocity;
    }
}
