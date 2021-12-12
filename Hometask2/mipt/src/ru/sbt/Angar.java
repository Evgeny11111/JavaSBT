package ru.sbt;

import java.util.*;

public class Angar implements Garage {


    private final Map<Car, Owner> angar;
    private final Map<Integer, Integer> carsForOne;
    private final Map<String, List<Car>> brandToCars;
    private final Map<Owner, List<Car>> carsOwners;
    private final Map<Owner, Integer> OwnersToAge;
    private final Map<Integer, Car> powerToCar;
    private final Map<Integer, Car> velocityToCar;
    private final Map<Long, Car> carIdToCar;
    private final Map<Integer, Owner> ownerIdToOwner;

    public Angar(Map<Car, Owner> angar) {
        this.angar = angar;
        this.carsOwners = createCarsOwners(angar);
        this.brandToCars = createBrandToCars(angar);
        this.OwnersToAge = createOwnersToAge(angar);
        this.carsForOne = createCarsForOne(angar);
        this.powerToCar = createPowerToCar(angar);
        this.velocityToCar = createVelocityToCar(angar);
        this.carIdToCar = createCarIdToCar(angar);
        this.ownerIdToOwner = createOwnerIdToOwner(angar);
    }

    private Map<Integer, Owner> createOwnerIdToOwner(Map<Car, Owner> angar) {
        Map<Integer, Owner> result = new HashMap<>();
        for (Car car : angar.keySet()) {
            result.put(car.getOwnerId(), angar.get(car));
        }
        return result;
    }

    private Map<Long, Car> createCarIdToCar(Map<Car, Owner> angar) {
        Map<Long, Car> result = new HashMap<>();
        for (Car car : angar.keySet()) {
            result.put(car.getCarId(), car);
        }
        return result;
    }

    private Map<Integer, Car> createVelocityToCar(Map<Car, Owner> angar) {
        Map<Integer, Car> result = new TreeMap<>(new CompatorForPower());
        for (Car car : angar.keySet()) {
            result.put(car.getMaxVelocity(), car);
        }
        return result;
    }

    private Map<Integer, Car> createPowerToCar(Map<Car, Owner> angar) {
        Map<Integer, Car> result = new TreeMap<>(new CompatorForPower());
        for (Car car : angar.keySet()) {
            result.put(car.getPower(), car);
        }
        return result;
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

    private Map<String, List<Car>> createBrandToCars(Map<Car, Owner> angar) {//+
        Map<String, List<Car>> res = new HashMap<>();
        for (Car car1 : angar.keySet()) {
            if (res.get(car1.getBrand()) == null) {
                List<Car> cars = new ArrayList<>();
                cars.add(car1);
                res.put(car1.getBrand(), cars);
            } else {
                List<Car> cars = res.get(car1.getBrand());
                cars.add(car1);
                res.put(car1.getBrand(), cars);
            }
        }
        return res;
    }

    private Map<Owner, Integer> createOwnersToAge(Map<Car, Owner> angar) {
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

    public List<Owner> allCarsUniqueOwners() {
        return new ArrayList<>(carsOwners.keySet());
    }


    public List<Car> topThreeCarsByMaxVelocity() {//+
        List<Car> carsByMaxVelocity = new ArrayList<>();
        for (Integer integer : velocityToCar.keySet()) {
            if (carsByMaxVelocity.size() == 3) {
                break;
            }
            carsByMaxVelocity.add(velocityToCar.get(integer));
        }
        return carsByMaxVelocity;
    }


    public List<Car> allCarsOfBrand(String brand) {//+
        return brandToCars.get(brand);
    }


    public List<Car> carsWithPowerMoreThan(int power) {//+
        List<Car> cars = new ArrayList<>();
        for (Integer integer : powerToCar.keySet()) {
            if (integer < power) {
                break;
            }
            cars.add(powerToCar.get(integer));
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

    public Car removeCar(long carId) {//+
        if (carIdToCar.containsKey(carId)) {
            Car car = carIdToCar.get(carId);
            angar.remove(carIdToCar.get(carId));
            Owner owner = ownerIdToOwner.get(carIdToCar.get(carId).getOwnerId());
            List<Car> list = carsOwners.get(owner);
            list.remove(owner);
            carsOwners.replace(owner, carsOwners.get(owner), list);
            carsForOne.remove(owner.getOwnerId());
            brandToCars.remove(carIdToCar.get(carId).getBrand());
            powerToCar.remove(carIdToCar.get(carId).getPower(), carIdToCar.get(carId));
            velocityToCar.remove(carIdToCar.get(carId).getMaxVelocity(), carIdToCar.get(carId));
            carIdToCar.remove(carId);
            if (carsOwners.get(owner).size() == 0) {
                ownerIdToOwner.remove(owner.getOwnerId());
                OwnersToAge.remove(owner);
            }
            return car;
        }
        return null;
    }

    public void addCar(Car car, Owner owner) {//+
        angar.put(car, owner);
        if (carsOwners.containsKey(owner)) {
            List<Car> cars = carsOwners.get(owner);
            cars.add(car);
            carsOwners.replace(owner, carsOwners.get(owner), cars);
        } else {
            List<Car> cars = new ArrayList<>();
            cars.add(car);
            carsOwners.put(owner, cars);
        }
        if (brandToCars.containsKey(car.getBrand())) {
            List<Car> cars = brandToCars.get(car.getBrand());
            cars.add(car);
            brandToCars.replace(car.getBrand(), brandToCars.get(car.getBrand()), cars);
        } else {
            List<Car> cars = new ArrayList<>();
            cars.add(car);
            brandToCars.put(car.getBrand(), cars);
        }
        OwnersToAge.put(owner, owner.getAge());
        if (carsForOne.containsKey(owner.getOwnerId())) {
            carsForOne.replace(owner.getOwnerId(), carsForOne.get(owner.getOwnerId()), carsForOne.get(owner.getOwnerId()) + 1);
        } else {
            carsForOne.put(owner.getOwnerId(), 1);
        }
        powerToCar.put(car.getPower(), car);
        velocityToCar.put(car.getMaxVelocity(), car);
        carIdToCar.put(car.getCarId(), car);
        ownerIdToOwner.put(owner.getOwnerId(), owner);
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

    public Map<Integer, Car> getPowerToCar() {
        return powerToCar;
    }
}
