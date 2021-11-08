package ru.sbt;

import java.util.*;

public class Angar implements Garage {

    private final List<Car> allCars;
    private final Map<Car, Owner> angar;
    private final Map<Integer, Integer> carsForOne;
    private final Map<String, List<Car>> brandToCars;
    private final Map<Owner, List<Car>> carsOwners;
    private final Map<Owner, Integer> OwnersToAge;


    public Angar(Map<Car, Owner> angar) {
        this.angar = angar;
        this.allCars = createAllCarsSortByVelocity(angar);
        this.carsOwners = createCarsOwners(angar);
        this.brandToCars = createBrandToCars(angar);
        this.OwnersToAge = createOwnersToAge(angar);
        this.carsForOne = createCarsForOne(angar);
    }
    private Map<Owner, List<Car>> createCarsOwners(Map<Car, Owner> angar) {
        Map<Owner, List<Car>> res = new HashMap<>();
        for (Car key : angar.keySet()) {
            if (res.get(angar.get(key)) == null) {
                List<Car> cars = new ArrayList<>();
                cars.add(key);
                res.put(angar.get(key), cars);
            } else {
                List<Car> newCars = res.get(angar.get(key));
                newCars.add(key);
                res.replace(angar.get(key), res.get(angar.get(key)), newCars);
            }
        }
        return res;
    }

    private List<Car> createAllCarsSortByVelocity(Map<Car, Owner> angar) {
        List<Car> res = new ArrayList<>(angar.keySet());
        res.sort((lhs, rhs) -> Integer.compare(rhs.getMaxVelocity(), lhs.getMaxVelocity()));
        return res;
    }
    private Map<String, List<Car>> createBrandToCars(Map<Car, Owner> angar) {//+
        Map<String, List<Car>> res = new HashMap<>();
        for (Car car1 : angar.keySet()) {
            if(res.get(car1.getBrand()) == null)
            {
                List<Car> cars = new ArrayList<>();
                cars.add(car1);
                res.put(car1.getBrand(), cars);
            }else{
                List<Car> cars = res.get(car1.getBrand());
                cars.add(car1);
                res.put(car1.getBrand(), cars);
            }
        }
        return res;
    }
    private Map<Owner, Integer> createOwnersToAge(Map<Car, Owner> angar){
        Map<Owner, Integer> res = new HashMap<>();
        for (Owner owner1 : angar.values()) {
            res.computeIfAbsent(owner1, k -> owner1.getAge());
        }
        return res;
    }

    private Map<Integer, Integer> createCarsForOne(Map<Car, Owner> angar) {
        Map<Integer, Integer> res = new HashMap<>();
        for (Car key : angar.keySet()) {
            res.putIfAbsent(key.getOwnerId(), 0);
        }
        for (Car key : angar.keySet()) {
            res.replace(angar.get(key).getOwnerId(), res.get(angar.get(key).getOwnerId()) + 1);
        }
        return res;
    }
    public List<Owner> allCarsUniqueOwners(){
        return new ArrayList<>(carsOwners.keySet());
    }



    public List<Car> topThreeCarsByMaxVelocity() {//+
        List<Car> carsByMaxVelocity = new ArrayList<>();
        int it = 0;
        while (it < 3 && it < allCars.size()) {
            carsByMaxVelocity.add(allCars.get(it));
            it++;
        }
        return carsByMaxVelocity;
    }


    public List<Car> allCarsOfBrand(String brand) {//+
        return brandToCars.get(brand);
    }


    public List<Car> carsWithPowerMoreThan(int power) {//+
        List<Car> cars = new ArrayList<>();
        for (Car car1 : angar.keySet()) {
            if (car1.getPower() > power) {
                cars.add(car1);
            }
        }
        return cars;
    }

    public List<Car> allCarsOfOwner(Owner owner) {//+
        return carsOwners.get(owner);
    }


    public int meanOwnersAgeOfCarBrand(String brand) {//+
        List<Owner> Owners = new ArrayList<>();
        int l = 0;
        int sum = 0;
        for (Car key : angar.keySet()) {
            if (key.getBrand().equals(brand)) {
                if (!Owners.contains(angar.get(key))) {
                    Owners.add(angar.get(key));
                    sum += OwnersToAge.get(angar.get(key));
                    l++;
                }
            }
        }
        return sum / l;
    }


    public int meanCarNumberForEachOwner() {//+
        int l = 0;
        Integer sum = 0;
        for (Integer value : carsForOne.values()) {
            l++;
            sum += value;
        }
        return sum / l;
    }


    public Car removeCar(int carId) {//+
        Car car2 = new Car(carId, null, null, 0, 0, 0);
        for (Car key : angar.keySet()) {
            if (key.getCarId() == carId) {
                angar.remove(key);
                return key;
            }
        }
        return car2;
    }
    public void addCar(Car car, Owner owner) {//+
        angar.put(car, owner);
    }

    public Map<Car, Owner> getAngar() {
        return angar;
    }

    public Map<Integer, Integer> getCarsForOne() {
        return carsForOne;
    }

    public Map<String, List<Car>> getBrandToCars() {
        return brandToCars;
    }

    public Map<Owner, List<Car>> getCarsOwners() {
        return carsOwners;
    }

    public Map<Owner, Integer> getOwnersToAge() {
        return OwnersToAge;
    }
}
