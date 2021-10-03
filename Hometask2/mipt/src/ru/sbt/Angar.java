package ru.sbt;

import java.util.*;

public class Angar implements Garage{
    public static ArrayList<Car> allCars = new ArrayList<>();
    public static HashMap<Car, Owner> angar = new HashMap<>();
    public static HashMap<Integer, Integer> carsToOne = new HashMap<>();
    public static HashMap<String, ArrayList<Car>> brandToCars = new HashMap<>();
    public static HashMap<Owner, ArrayList<Car>> carsOwners = new HashMap<>();
    public static HashMap<Integer, Integer> idOwnersToAge = new HashMap<>();

    public Angar(HashMap<Car, Owner> angar) {
        this.angar = angar;
    }

    public static ArrayList<Owner> allCarsUniqueOwners(){
        ArrayList<Owner> res = new ArrayList<>();
        carsOwners = createCarsOwners();
        res.addAll(carsOwners.keySet());
        return res;
    }

    public static HashMap<String, ArrayList<Car>> createBrandToCars() {//+
        HashMap<String, ArrayList<Car>> res = new HashMap<>();
        for (Car car1 : angar.keySet()) {
                if(res.get(car1.getBrand()) == null)
                {
                    ArrayList<Car> cars = new ArrayList<>();
                    cars.add(car1);
                    res.put(car1.getBrand(), cars);
                }else{
                    ArrayList<Car> cars = res.get(car1.getBrand());
                    cars.add(car1);
                    res.put(car1.getBrand(), cars);
                }
        }
        return res;
    }

    public static HashMap<Owner, ArrayList<Car>> createCarsOwners() {//+
        HashMap<Owner, ArrayList<Car>> res = new HashMap<>();
        for (Car key : angar.keySet()) {
            if (res.get(angar.get(key)) == null) {
                ArrayList<Car> cars = new ArrayList<>();
                cars.add(key);
                res.put(angar.get(key), cars);
            } else {
                ArrayList<Car> newCars = res.get(angar.get(key));
                newCars.add(key);
                res.replace(angar.get(key), res.get(angar.get(key)), newCars);
            }
        }
        return res;
    }

    public static HashMap<Integer, Integer> createIdOwnersToAge(){
        HashMap<Integer, Integer> res =new HashMap<Integer,Integer>();
        for (Owner owner1 : angar.values()) {
            if (res.get(owner1.getOwnerId()) == null) {
                res.put(owner1.getOwnerId(), owner1.getAge());
            }
        }
        return res;
    }
    static void createAllCarsSortByVelocity(){
        allCars.addAll(angar.keySet());
        Collections.sort(allCars, new Comparator<Car>(){
            @Override
            public int compare(Car lhs, Car rhs){
                return lhs.getMaxVelocity() > rhs.getMaxVelocity() ? -1 : lhs.getMaxVelocity() < rhs.getMaxVelocity() ? 1 : 0;
            }
        });
    }


    public static List<Car> topThreeCarsByMaxVelocity() {//+
        ArrayList<Car> carsByMaxVelocity = new ArrayList<>();
        createAllCarsSortByVelocity();
        int it = 0;
        while (it < 3 && it < allCars.size()) {
            carsByMaxVelocity.add(allCars.get(it));
            it++;
        }
        return carsByMaxVelocity;
    }


    public static ArrayList<Car> allCarsOfBrand(String brand) {//+
        return brandToCars.get(brand);
    }


    public static ArrayList<Car> carsWithPowerMoreThan(int power) {//+
        ArrayList<Car> cars = new ArrayList<>();
        for (Car car1 : angar.keySet()) {
            if (car1.getPower() > power) {
                cars.add(car1);
            }
        }
        return cars;
    }

    //create
    public static ArrayList<Car> allCarsOfOwner(Owner owner) {//+
        return carsOwners.get(owner);
    }


    public static int meanOwnersAgeOfCarBrand(String brand) {//+
        ArrayList<Integer> idOwners = new ArrayList<>();
        idOwnersToAge = createIdOwnersToAge();
        int l = 0;
        int sum = 0;
        for (Car key : angar.keySet()) {
            if (key.getBrand().equals(brand)) {
                if (idOwners.indexOf(angar.get(key).getOwnerId()) == -1) {
                    int p = angar.get(key).getOwnerId();
                    idOwners.add(p);
                    int t = key.getOwnerId();
                    sum += idOwnersToAge.get(t);
                    l++;
                }
            }
        }
        int res = sum / l;
        return res;
    }


    public static int meanCarNumberForEachOwner() {//+
        int l = 0;
        for (Car key : angar.keySet()) {
            if (carsToOne.get(key.getOwnerId()) == null) {
                carsToOne.put(key.getOwnerId(), 0);
                l++;
            }
        }
        for (Car key : angar.keySet()) {
            carsToOne.replace(angar.get(key).getOwnerId(), carsToOne.get(angar.get(key).getOwnerId()) + 1);
        }
        Integer sum = 0;
        for (Integer value : carsToOne.values()) {
            sum += value;
        }
        int res = sum / l;
        return res;
    }


    public static Car removeCar(int carId) {//+
        Car car2 = new Car(carId, null, null, 0, 0, 0);
        for (Car key : angar.keySet()) {
            if (key.getCarId() == carId) {
                angar.remove(key);
                return key;
            }
        }
        return car2;
    }
    public static void addCar(Car car, Owner owner) {//+
        angar.put(car, owner);
    }
}
