package ru.sbt;

import java.util.*;


public class Program {

    public static void main(String[] args) {
        Map<Car, Owner> angar = new HashMap<>();

        Car carr1 = new Car(25345323, "Volvo", "Legkov", 180, 150, 353532);
        Owner ownerr1 = new Owner(353532, "Eugeny", "Vagapov", 23);
        Car carr2 = new Car(34243545, "Bmw", "X7", 230, 450, 353532);
        Owner ownerr2 = new Owner(123124, "Anton", "Belokopytov", 22);
        Car carr3 = new Car(41345356, "Audi", "Legkov", 240, 180, 123124);
        Owner ownerr3 = new Owner(234563, "Vladimir", "Tolmachev", 17);
        Car carr4 = new Car(25362323, "Porshe", "Legkov", 270, 400, 234563);
        Car carr5 = new Car(64534235, "Porshe", "Legkov", 260, 350, 234563);
        Car carr6 = new Car(12353456, "Audi", "TT", 280, 330, 234563);

        angar.put(carr1, ownerr1);
        angar.put(carr2, ownerr1);
        angar.put(carr3, ownerr2);
        angar.put(carr4, ownerr3);
        angar.put(carr5, ownerr3);
        angar.put(carr6, ownerr3);



        Garage garage = new Angar(angar);
        System.out.println("=========================================");
        for (Owner owner : garage.allCarsUniqueOwners()) {
            System.out.println(owner.getOwnerId());
        }
        System.out.println("=========================================");

        garage.removeCar(12353456);
        garage.addCar(carr6, ownerr3);
        for (Car car : garage.getAngar().keySet()) {
            System.out.println(car.getBrand() + ": " + garage.getAngar().get(car).getName());
        }


        System.out.println(garage.meanCarNumberForEachOwner());
        System.out.println(garage.meanOwnersAgeOfCarBrand("Audi"));
    }

}
