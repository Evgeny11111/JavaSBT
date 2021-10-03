package ru.sbt;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static org.junit.Assert.*;

public class AngarTest {


    @org.junit.Test
    public void allCarsUniqueOwners(){
        Car carr1 = new Car(12321313, "Volvo", "Legkov", 180, 150, 123124);
        Owner ownerr1 = new Owner(123124, "Eugeny", "Vagapov", 23);
        Car carr2 = new Car(24142335, "Honda", "Legkov", 200, 200, 123124);
        Owner ownerr2 = new Owner(123124, "Eugeny", "Vagapov", 23);
        Car carr3 = new Car(12225334, "Volvo", "Legkov", 190, 170, 234563);
        Owner ownerr3 = new Owner(234563, "Vladimir", "Tolmachev", 17);
        Car carr4 = new Car(25362323, "Porshe", "Legkov", 250, 400, 234556);
        Car carr5 = new Car(64534235, "Porshe", "Legkov", 260, 350, 123124);
        Angar obj = new Angar(Angar.angar);
        obj.addCar(carr1, ownerr1);
        obj.addCar(carr2, ownerr3);
        obj.addCar(carr3, ownerr2);
        obj.addCar(carr4, ownerr2);
        obj.addCar(carr5, ownerr1);

        ArrayList<Owner> result = new ArrayList<>(Arrays.asList(ownerr2,ownerr1,ownerr3));
        assertEquals(obj.allCarsUniqueOwners(),result);
        obj.angar.clear();
    }

    @org.junit.Test
    public void createBrandToCars() {
        Car carr1 = new Car(12321313, "Volvo", "Legkov", 180, 150, 123124);
        Owner ownerr1 = new Owner(123124, "Eugeny", "Vagapov", 23);
        Car carr2 = new Car(24142335, "Honda", "Legkov", 200, 200, 123124);
        Owner ownerr2 = new Owner(123124, "Eugeny", "Vagapov", 23);
        Car carr3 = new Car(12225334, "Volvo", "Legkov", 190, 170, 234563);
        Owner ownerr3 = new Owner(234563, "Vladimir", "Tolmachev", 17);
        Car carr4 = new Car(25362323, "Porshe", "Legkov", 250, 400, 234556);
        Car carr5 = new Car(64534235, "Porshe", "Legkov", 260, 350, 123124);
        Angar obj = new Angar(Angar.angar);
        obj.addCar(carr1, ownerr1);
        obj.addCar(carr2, ownerr3);
        obj.addCar(carr3, ownerr2);
        obj.addCar(carr4, ownerr2);
        obj.addCar(carr5, ownerr1);

        HashMap <String, ArrayList<Car>> result = new HashMap<>();
        result.put("Honda", new ArrayList(Arrays.asList(carr2)));
        result.put("Volvo", new ArrayList(Arrays.asList(carr3,carr1)));
        result.put("Porshe", new ArrayList(Arrays.asList(carr4,carr5)));
        assertEquals(obj.createBrandToCars(),result);
        obj.angar.clear();
    }

    @org.junit.Test
    public void createCarsOwners() {
        Car carr1 = new Car(25345323, "Volvo", "Legkov", 180, 150, 353532);
        Owner ownerr1 = new Owner(353532, "Eugeny", "Vagapov", 23);
        Car carr2 = new Car(34243545, "BMW", "X7", 230, 200, 353532);
        Owner ownerr2 = new Owner(123124, "Anton", "Belokopytov", 22);
        Car carr3 = new Car(41345356, "Audi", "Legkov", 240, 255, 123124);
        Owner ownerr3 = new Owner(234563, "Vladimir", "Tolmachev", 17);
        Car carr4 = new Car(25362323, "Porshe", "Legkov", 255, 400, 234563);
        Car carr5 = new Car(64534235, "Porshe", "Legkov", 260, 350, 234563);
        Car carr6 = new Car(12353456, "Audi", "TT", 280, 350, 234563);
        Angar obj = new Angar(Angar.angar);
        obj.addCar(carr1, ownerr1);
        obj.addCar(carr2, ownerr1);
        obj.addCar(carr3, ownerr2);
        obj.addCar(carr4, ownerr3);
        obj.addCar(carr5, ownerr3);
        obj.addCar(carr6, ownerr3);

        HashMap<Owner, ArrayList<Car>> result = new HashMap<>();
        result.put(ownerr1, new ArrayList(Arrays.asList(carr2,carr1)));
        result.put(ownerr2, new ArrayList(Arrays.asList(carr3)));
        result.put(ownerr3, new ArrayList(Arrays.asList(carr6,carr4,carr5)));

        assertEquals(obj.createCarsOwners(),result);
        obj.angar.clear();
    }

    @org.junit.Test
    public void topThreeCarsByMaxVelocity() {
        Car carr1 = new Car(25345323, "Volvo", "Legkov", 180, 150, 353532);
        Owner ownerr1 = new Owner(353532, "Eugeny", "Vagapov", 23);
        Car carr2 = new Car(34243545, "BMW", "X7", 230, 200, 353532);
        Owner ownerr2 = new Owner(123124, "Anton", "Belokopytov", 22);
        Car carr3 = new Car(41345356, "Audi", "Legkov", 240, 255, 123124);
        Owner ownerr3 = new Owner(234563, "Vladimir", "Tolmachev", 17);
        Car carr4 = new Car(25362323, "Porshe", "Legkov", 270, 400, 234563);
        Car carr5 = new Car(64534235, "Porshe", "Legkov", 260, 350, 234563);
        Car carr6 = new Car(12353456, "Audi", "TT", 280, 350, 234563);
        Angar obj = new Angar(Angar.angar);
        obj.addCar(carr1, ownerr1);
        obj.addCar(carr2, ownerr1);
        obj.addCar(carr3, ownerr2);
        obj.addCar(carr4, ownerr3);
        obj.addCar(carr5, ownerr3);
        obj.addCar(carr6, ownerr3);

        List<Car> result = new ArrayList(Arrays.asList(carr6,carr4,carr5));

        assertEquals(obj.topThreeCarsByMaxVelocity(),result);
        obj.angar.clear();
    }
    {
        Car carr1 = new Car(25345323, "Volvo", "Legkov", 180, 150, 353532);
        Owner ownerr1 = new Owner(353532, "Eugeny", "Vagapov", 23);
        Car carr2 = new Car(34243545, "BMW", "X7", 230, 200, 353532);
        Angar obj = new Angar(Angar.angar);
        obj.addCar(carr1, ownerr1);
        obj.addCar(carr2, ownerr1);


        ArrayList<Car> result = new ArrayList(Arrays.asList(carr2,carr1));

        assertEquals(obj.topThreeCarsByMaxVelocity(),result);
        obj.angar.clear();
    }

    @org.junit.Test
    public void allCarsOfBrand() {
        Car carr1 = new Car(25345323, "Volvo", "Legkov", 180, 150, 353532);
        Owner ownerr1 = new Owner(353532, "Eugeny", "Vagapov", 23);
        Car carr2 = new Car(34243545, "Bmw", "X7", 230, 200, 353532);
        Owner ownerr2 = new Owner(123124, "Anton", "Belokopytov", 22);
        Car carr3 = new Car(41345356, "Audi", "Legkov", 240, 255, 123124);
        Owner ownerr3 = new Owner(234563, "Vladimir", "Tolmachev", 17);
        Car carr4 = new Car(25362323, "Porshe", "Legkov", 270, 400, 234563);
        Car carr5 = new Car(64534235, "Porshe", "Legkov", 260, 350, 234563);
        Car carr6 = new Car(12353456, "Audi", "TT", 280, 350, 234563);
        Angar obj = new Angar(Angar.angar);
        obj.addCar(carr1, ownerr1);
        obj.addCar(carr2, ownerr1);
        obj.addCar(carr3, ownerr2);
        obj.addCar(carr4, ownerr3);
        obj.addCar(carr5, ownerr3);
        obj.addCar(carr6, ownerr3);
        obj.brandToCars = obj.createBrandToCars();

        ArrayList<Car> result1 = new ArrayList(Arrays.asList(carr2));
        ArrayList<Car> result2 = new ArrayList(Arrays.asList(carr3,carr6));
        ArrayList<Car> result3 = new ArrayList(Arrays.asList(carr5,carr4));

        assertEquals(obj.allCarsOfBrand("Bmw"),result1);
        assertEquals(obj.allCarsOfBrand("Audi"),result2);
        assertEquals(obj.allCarsOfBrand("Porshe"),result3);
        obj.angar.clear();
    }

    @org.junit.Test
    public void carsWithPowerMoreThan() {
        Car carr1 = new Car(25345323, "Volvo", "Legkov", 180, 150, 353532);
        Owner ownerr1 = new Owner(353532, "Eugeny", "Vagapov", 23);
        Car carr2 = new Car(34243545, "Bmw", "X7", 230, 450, 353532);
        Owner ownerr2 = new Owner(123124, "Anton", "Belokopytov", 22);
        Car carr3 = new Car(41345356, "Audi", "Legkov", 240, 00, 123124);
        Owner ownerr3 = new Owner(234563, "Vladimir", "Tolmachev", 17);
        Car carr4 = new Car(25362323, "Porshe", "Legkov", 270, 400, 234563);
        Car carr5 = new Car(64534235, "Porshe", "Legkov", 260, 350, 234563);
        Car carr6 = new Car(12353456, "Audi", "TT", 280, 330, 234563);
        Angar obj = new Angar(Angar.angar);
        obj.addCar(carr1, ownerr1);
        obj.addCar(carr2, ownerr1);
        obj.addCar(carr3, ownerr2);
        obj.addCar(carr4, ownerr3);
        obj.addCar(carr5, ownerr3);
        obj.addCar(carr6, ownerr3);

        ArrayList<Car> result1 = new ArrayList(Arrays.asList(carr2,carr4));
        ArrayList<Car> result2 = new ArrayList(Arrays.asList(carr2,carr5,carr4));
        ArrayList<Car> result3 = new ArrayList(Arrays.asList(carr2,carr6,carr4,carr5));

        assertEquals(obj.carsWithPowerMoreThan(360),result1);
        assertEquals(obj.carsWithPowerMoreThan(340),result2);
        assertEquals(obj.carsWithPowerMoreThan(300),result3);
        obj.angar.clear();
    }

    @org.junit.Test
    public void allCarsOfOwner() {
        Car carr1 = new Car(25345323, "Volvo", "Legkov", 180, 150, 353532);
        Owner ownerr1 = new Owner(353532, "Eugeny", "Vagapov", 23);
        Car carr2 = new Car(34243545, "Bmw", "X7", 230, 450, 353532);
        Owner ownerr2 = new Owner(123124, "Anton", "Belokopytov", 22);
        Car carr3 = new Car(41345356, "Audi", "Legkov", 240, 180, 123124);
        Owner ownerr3 = new Owner(234563, "Vladimir", "Tolmachev", 17);
        Car carr4 = new Car(25362323, "Porshe", "Legkov", 270, 400, 234563);
        Car carr5 = new Car(64534235, "Porshe", "Legkov", 260, 350, 234563);
        Car carr6 = new Car(12353456, "Audi", "TT", 280, 330, 234563);
        Angar obj = new Angar(Angar.angar);
        obj.addCar(carr1, ownerr1);
        obj.addCar(carr2, ownerr1);
        obj.addCar(carr3, ownerr2);
        obj.addCar(carr4, ownerr3);
        obj.addCar(carr5, ownerr3);
        obj.addCar(carr6, ownerr3);
        obj.carsOwners = obj.createCarsOwners();

        ArrayList<Car> result1 = new ArrayList(Arrays.asList(carr3));
        ArrayList<Car> result2 = new ArrayList(Arrays.asList(carr1,carr2));
        ArrayList<Car> result3 = new ArrayList(Arrays.asList(carr5,carr6,carr4));

        assertEquals(obj.allCarsOfOwner(ownerr2),result1);
        assertEquals(obj.allCarsOfOwner(ownerr1),result2);
        assertEquals(obj.allCarsOfOwner(ownerr3),result3);
        obj.angar.clear();
    }

    @org.junit.Test
    public void meanOwnersAgeOfCarBrand() {
        Car carr1 = new Car(25345323, "Volvo", "Legkov", 180, 150, 353532);
        Owner ownerr1 = new Owner(353532, "Eugeny", "Vagapov", 23);
        Car carr2 = new Car(34243545, "Bmw", "X7", 230, 450, 353532);
        Owner ownerr2 = new Owner(123124, "Anton", "Belokopytov", 22);
        Car carr3 = new Car(41345356, "Audi", "Legkov", 240, 180, 123124);
        Owner ownerr3 = new Owner(234563, "Vladimir", "Tolmachev", 17);
        Car carr4 = new Car(25362323, "Porshe", "Legkov", 270, 400, 234563);
        Car carr5 = new Car(64534235, "Porshe", "Legkov", 260, 350, 234563);
        Car carr6 = new Car(12353456, "Audi", "TT", 280, 330, 234563);
        Angar obj = new Angar(Angar.angar);
        obj.addCar(carr1, ownerr1);
        obj.addCar(carr2, ownerr1);
        obj.addCar(carr3, ownerr2);
        obj.addCar(carr4, ownerr3);
        obj.addCar(carr5, ownerr3);
        obj.addCar(carr6, ownerr3);

        int result1 = 19;
        int result2 = 17;
        int result3 = 23;
        assertEquals(obj.meanOwnersAgeOfCarBrand("Audi"),result1);
        assertEquals(obj.meanOwnersAgeOfCarBrand("Porshe"),result2);
        assertEquals(obj.meanOwnersAgeOfCarBrand("Bmw"),result3);
        obj.angar.clear();
    }

    @org.junit.Test
    public void meanCarNumberForEachOwner() {
        Car carr1 = new Car(25345323, "Volvo", "Legkov", 180, 150, 353532);
        Owner ownerr1 = new Owner(353532, "Eugeny", "Vagapov", 23);
        Car carr2 = new Car(34243545, "Bmw", "X7", 230, 450, 353532);
        Owner ownerr2 = new Owner(123124, "Anton", "Belokopytov", 22);
        Car carr3 = new Car(41345356, "Audi", "Legkov", 240, 180, 123124);
        Owner ownerr3 = new Owner(234563, "Vladimir", "Tolmachev", 17);
        Car carr4 = new Car(25362323, "Porshe", "Legkov", 270, 400, 234563);
        Car carr5 = new Car(64534235, "Porshe", "Legkov", 260, 350, 234563);
        Car carr6 = new Car(12353456, "Audi", "TT", 280, 330, 234563);
        Angar obj = new Angar(Angar.angar);
        obj.addCar(carr1, ownerr1);
        obj.addCar(carr2, ownerr1);
        obj.addCar(carr3, ownerr2);
        obj.addCar(carr4, ownerr3);
        obj.addCar(carr5, ownerr3);
        obj.addCar(carr6, ownerr3);

        int result = 2;
        assertEquals(obj.meanCarNumberForEachOwner(),result);
        obj.angar.clear();
    }


    @org.junit.Test
    public void removeCar() {
        Car carr1 = new Car(25345323, "Volvo", "Legkov", 180, 150, 353532);
        Owner ownerr1 = new Owner(353532, "Eugeny", "Vagapov", 23);
        Car carr2 = new Car(34243545, "Bmw", "X7", 230, 450, 353532);
        Owner ownerr2 = new Owner(123124, "Anton", "Belokopytov", 22);
        Car carr3 = new Car(41345356, "Audi", "Legkov", 240, 180, 123124);
        Owner ownerr3 = new Owner(234563, "Vladimir", "Tolmachev", 17);
        Car carr4 = new Car(25362323, "Porshe", "Legkov", 270, 400, 234563);
        Car carr5 = new Car(64534235, "Porshe", "Legkov", 260, 350, 234563);
        Car carr6 = new Car(12353456, "Audi", "TT", 280, 330, 234563);
        Angar obj = new Angar(Angar.angar);
        obj.addCar(carr1, ownerr1);
        obj.addCar(carr2, ownerr1);
        obj.addCar(carr3, ownerr2);
        obj.addCar(carr4, ownerr3);
        obj.addCar(carr5, ownerr3);
        obj.addCar(carr6, ownerr3);

        assertEquals(obj.removeCar(25345323),carr1);
        assertEquals(obj.removeCar(34243545),carr2);
        obj.angar.clear();
    }

    @org.junit.Test
    public void addCar() {
        Car carr1 = new Car(25345323, "Volvo", "Legkov", 180, 150, 353532);
        Owner ownerr1 = new Owner(353532, "Eugeny", "Vagapov", 23);
        Car carr2 = new Car(34243545, "Bmw", "X7", 230, 450, 353532);
        Owner ownerr2 = new Owner(123124, "Anton", "Belokopytov", 22);
        Car carr3 = new Car(41345356, "Audi", "Legkov", 240, 180, 123124);
        Owner ownerr3 = new Owner(234563, "Vladimir", "Tolmachev", 17);
        Car carr4 = new Car(25362323, "Porshe", "Legkov", 270, 400, 234563);
        Car carr5 = new Car(64534235, "Porshe", "Legkov", 260, 350, 234563);
        Car carr6 = new Car(12353456, "Audi", "TT", 280, 330, 234563);
        Angar obj = new Angar(Angar.angar);
        obj.addCar(carr1, ownerr1);
        obj.addCar(carr2, ownerr1);
        obj.addCar(carr3, ownerr2);
        obj.addCar(carr4, ownerr3);
        obj.addCar(carr5, ownerr3);
        obj.addCar(carr6, ownerr3);

        //System.out.println(obj.angar);
        HashMap<Car,Owner> result = new HashMap<>();
        result.put(carr1, ownerr1);
        result.put(carr2, ownerr1);
        result.put(carr3, ownerr2);
        result.put(carr4, ownerr3);
        result.put(carr5, ownerr3);
        result.put(carr6, ownerr3);

        assertEquals(obj.angar,result);
        obj.angar.clear();
    }
}