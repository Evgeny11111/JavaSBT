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

        Car carr7 = new Car(25345399, "Volvo", "Legko", 222, 156, 35353);
        Owner ownerr4 = new Owner(35353, "Eugeny", "Vagapov", 23);
        Car carr8 = new Car(34243599, "Bmw", "X", 231, 206, 35353);
        Owner ownerr5 = new Owner(12312, "Anton", "Belokopytov", 22);
        Car carr9 = new Car(41345399, "Audi", "Legko", 241, 256, 123124);
        Owner ownerr6 = new Owner(23456, "Vladimir", "Tolmachev", 17);




        Garage garage = new Angar(angar);
        garage.addCar(carr1,ownerr1);
        System.out.println(garage.getCarsForOne());

        System.out.println();
        System.out.println(garage.removeCar(carr1.getCarId()));
        System.out.println(garage.removeCar(carr8.getCarId()));
        System.out.println(garage.removeCar(231131));
        System.out.println(garage.getCarsForOne());


    }

}
