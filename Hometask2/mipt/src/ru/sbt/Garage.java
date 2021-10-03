package ru.sbt;

import java.util.Collection;

public interface Garage {
    static Collection<Owner> allCarsUniqueOwners(){
        return null;
    }

    /**
     * Complexity should be less than O(n)
     */
    static Collection<Car> topThreeCarsByMaxVelocity() {
        return null;
    }

    /**
     * Complexity should be O(1)
     */
    static Collection<Car> allCarsOfBrand(String brand) {
        return null;
    }

    /**
     * Complexity should be less than O(n)
     */
    static Collection<Car> carsWithPowerMoreThan(int power){
        return  null;
    }

    /**
     * Complexity should be O(1)
     */
    static Collection<Car> allCarsOfOwner(Owner owner){
        return null;
    }

    /**
     * @return mean value of owner age that has cars with given brand
     */
    static int meanOwnersAgeOfCarBrand(String brand){
        return 0;
    }

    /**
     * @return mean value of cars for all owners
     */
    static int meanCarNumberForEachOwner(){
        return 0;
    }

    /**
     * Complexity should be less than O(n)
     *
     * @return removed car
     */
    static Car removeCar(int carId){
        return null;
    }

    /**
     * Complexity should be less than O(n)
     */
    static void addCar(Car car, Owner owner){
    }
}
