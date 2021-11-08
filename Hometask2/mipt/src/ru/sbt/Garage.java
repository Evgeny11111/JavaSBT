package ru.sbt;


import java.util.Collection;
import java.util.List;
import java.util.Map;

public interface Garage {
    List<Owner> allCarsUniqueOwners();

    /**
     * Complexity should be less than O(n)
     */
    Collection<Car> topThreeCarsByMaxVelocity();

    /**
     * Complexity should be O(1)
     */
    List<Car> allCarsOfBrand(String brand);

    /**
     * Complexity should be less than O(n)
     */
    List<Car> carsWithPowerMoreThan(int power);

    /**
     * Complexity should be O(1)
     */
    List<Car> allCarsOfOwner(Owner owner);

    /**
     * @return mean value of owner age that has cars with given brand
     */
    int meanOwnersAgeOfCarBrand(String brand);

    /**
     * @return mean value of cars for all owners
     */
    int meanCarNumberForEachOwner();

    /**
     * Complexity should be less than O(n)
     *
     * @return removed car
     */
    Car removeCar(int carId);

    /**
     * Complexity should be less than O(n)
     */
    void addCar(Car car, Owner owner);

    Map<Car, Owner> getAngar();

    Map<Integer, Integer> getCarsForOne();

    Map<String, List<Car>> getBrandToCars();

    Map<Owner, List<Car>> getCarsOwners();

    Map<Owner, Integer> getOwnersToAge() ;
}
