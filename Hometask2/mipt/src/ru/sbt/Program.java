package ru.sbt;

import java.util.ArrayList;
import java.util.HashMap;


public class Program {
    private static Angar garage = new Angar(Angar.angar);
    public static void main(String[] args) {
        //1
        Car carr1 = new Car(12321313, "Volvo", "Legkov", 180, 150, 123124);
        Owner ownerr1 = new Owner(123124, "Eugeny", "Vagapov", 23);
        //2
        Car carr2 = new Car(24142335, "Honda", "Legkov", 200, 200, 123124);
        Owner ownerr2 = new Owner(123153, "Eugeny", "Vagapov", 23);
        //3
        Car carr3 = new Car(12225334, "Volvo", "Legkov", 190, 170, 234563);
        Owner ownerr3 = new Owner(234563, "Vladimir", "Tolmachev", 17);
        //4
        Car carr4 = new Car(25362323, "Porshe", "Legkov", 250, 400, 234556);
        Owner ownerr4 = new Owner(234556, "Anton", "Belokopytov", 17);
        //5
        Car carr5 = new Car(64534235, "Porshe", "Legkov", 260, 350, 123124);
        Owner ownerr5 = new Owner(123124, "Eugeny", "Vagapov", 23);
        garage.addCar(carr1, ownerr1);
        garage.addCar(carr2, ownerr3);
        garage.addCar(carr3, ownerr2);
        garage.addCar(carr4, ownerr2);
        garage.addCar(carr5, ownerr1);
        //print();
        System.out.println("=========================================");
        //removeCar(64534235);
        //removeCar(25362323);
       // print();
        //garage.createAllCarsSortByVelocity();
        ArrayList<Owner> ow = garage.allCarsUniqueOwners();
        for (Owner owner : ow) {
            System.out.println(owner.getOwnerId());
        }

        //System.out.println(garage.meanOwnersAgeOfCarBrand("Volvo"));
        //garage.carsOwners = garage.createCarsOwners();

        //System.out.println();
       // System.out.println("==========================================");
        //System.out.println(garage.allCarsOfOwner(ownerr2));
       /* System.out.println("==========================================");
        System.out.println(garage.carsWithPowerMoreThan(100));
        System.out.println("==========================================");
        garage.brandToCars = garage.createBrandToCars();
        ArrayList<Car> carrrr =garage.allCarsOfBrand("Volvo");
        for (Car key : carrrr) {
            System.out.println(key.getCarId());
        }
        System.out.println("==========================================");
        ArrayList<Car> maxVelo = garage.topThreeCarsByMaxVelocity();
        for (Car key : maxVelo) {
            System.out.println(key.getCarId());
        }
        System.out.println("==========================================");
        System.out.println(garage.meanCarNumberForEachOwner());*/
    }

    //Collection<Owner> allCarsUniqueOwners();




    public static void print() {//+
        for (Car key : garage.angar.keySet()) {
            System.out.println("point:");
            System.out.print(key.getCarId());
            System.out.print(' ');
            System.out.print(key.getBrand());
            System.out.print(' ');
            System.out.print(key.getMaxVelocity());
            System.out.print(' ');
            System.out.print(key.getPower());
            System.out.print(' ');
            System.out.println(key.getOwnerId());
            System.out.print(garage.angar.get(key).getOwnerId());
            System.out.print(' ');
            System.out.println(garage.angar.get(key).getAge());
        }
    }
}
