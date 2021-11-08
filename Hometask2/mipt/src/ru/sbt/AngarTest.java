package ru.sbt;

import java.util.*;

import static org.junit.Assert.*;

public class AngarTest {


    @org.junit.Test
    public void allCarsUniqueOwnersTest(){
        Map<Car, Owner> angar = new HashMap<>();

        Car carr1 = new Car(12321313, "Volvo", "Legkov", 180, 150, 123124);
        Owner ownerr1 = new Owner(123124, "Eugeny", "Vagapov", 23);
        Car carr2 = new Car(24142335, "Honda", "Legkov", 200, 200, 123124);
        Owner ownerr2 = new Owner(123124, "Eugeny", "Vagapov", 23);
        Car carr3 = new Car(12225334, "Volvo", "Legkov", 190, 170, 234563);
        Owner ownerr3 = new Owner(234563, "Vladimir", "Tolmachev", 17);
        Car carr4 = new Car(25362323, "Porshe", "Legkov", 250, 400, 234556);
        Car carr5 = new Car(64534235, "Porshe", "Legkov", 260, 350, 123124);
        angar.put(carr1, ownerr1);
        angar.put(carr2, ownerr3);
        angar.put(carr3, ownerr2);
        angar.put(carr4, ownerr2);
        angar.put(carr5, ownerr1);
        Garage obj = new Angar(angar);

        List<Owner> result = new ArrayList<>(Arrays.asList(ownerr1,ownerr3,ownerr2));

        List<Owner> resultObj = obj.allCarsUniqueOwners();

        result.sort((lhs, rhs) -> CharSequence.compare(rhs.getName(), lhs.getName()));

        resultObj.sort((lhs, rhs) -> CharSequence.compare(rhs.getName(), lhs.getName()));
        assertEquals(resultObj,result);

    }




    @org.junit.Test
    public void topThreeCarsByMaxVelocityTest() {
        Map<Car, Owner> angar = new HashMap<>();

        Car carr1 = new Car(25345323, "Volvo", "Legkov", 180, 150, 353532);
        Owner ownerr1 = new Owner(353532, "Eugeny", "Vagapov", 23);
        Car carr2 = new Car(34243545, "BMW", "X7", 230, 200, 353532);
        Owner ownerr2 = new Owner(123124, "Anton", "Belokopytov", 22);
        Car carr3 = new Car(41345356, "Audi", "Legkov", 240, 255, 123124);
        Owner ownerr3 = new Owner(234563, "Vladimir", "Tolmachev", 17);
        Car carr4 = new Car(25362323, "Porshe", "Legkov", 270, 400, 234563);
        Car carr5 = new Car(64534235, "Porshe", "Legkov", 260, 350, 234563);
        Car carr6 = new Car(12353456, "Audi", "TT", 280, 350, 234563);
        angar.put(carr1, ownerr1);
        angar.put(carr2, ownerr1);
        angar.put(carr3, ownerr2);
        angar.put(carr4, ownerr3);
        angar.put(carr5, ownerr3);
        angar.put(carr6, ownerr3);
        Garage obj = new Angar(angar);

        //List result = new ArrayList(Arrays.asList(carr6,carr4,carr5));

        assertEquals(obj.topThreeCarsByMaxVelocity(),Arrays.asList(carr6,carr4,carr5));
    }


    @org.junit.Test
    public void allCarsOfBrandTest() {
        Map<Car, Owner> angar = new HashMap<>();

        Car carr1 = new Car(25345323, "Volvo", "Legkov", 180, 150, 353532);
        Owner ownerr1 = new Owner(353532, "Eugeny", "Vagapov", 23);
        Car carr2 = new Car(34243545, "Bmw", "X7", 230, 200, 353532);
        Owner ownerr2 = new Owner(123124, "Anton", "Belokopytov", 22);
        Car carr3 = new Car(41345356, "Audi", "Legkov", 240, 255, 123124);
        Owner ownerr3 = new Owner(234563, "Vladimir", "Tolmachev", 17);
        Car carr4 = new Car(25362323, "Porshe", "Legkov", 270, 400, 234563);
        Car carr5 = new Car(64534235, "Porshe", "Legkov", 260, 350, 234563);
        Car carr6 = new Car(12353456, "Audi", "TT", 280, 350, 234563);
        angar.put(carr1, ownerr1);
        angar.put(carr2, ownerr1);
        angar.put(carr3, ownerr2);
        angar.put(carr4, ownerr3);
        angar.put(carr5, ownerr3);
        angar.put(carr6, ownerr3);
        Garage obj = new Angar(angar);



        List<Car> result = new ArrayList(Arrays.asList(carr4,carr5));

        List<Car> resultObj = obj.allCarsOfBrand("Porshe");

        result.sort((lhs, rhs) -> CharSequence.compare(lhs.getBrand(), rhs.getBrand()));

        resultObj.sort((lhs, rhs) -> CharSequence.compare(lhs.getBrand(), rhs.getBrand()));


        assertEquals(resultObj,result);

    }

    @org.junit.Test
    public void carsWithPowerMoreThanTest() {
        Map<Car, Owner> angar = new HashMap<>();

        Car carr1 = new Car(25345323, "Volvo", "Legkov", 180, 150, 353532);
        Owner ownerr1 = new Owner(353532, "Eugeny", "Vagapov", 23);
        Car carr2 = new Car(34243545, "Bmw", "X7", 230, 450, 353532);
        Owner ownerr2 = new Owner(123124, "Anton", "Belokopytov", 22);
        Car carr3 = new Car(41345356, "Audi", "Legkov", 240, 100, 123124);
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
        Garage obj = new Angar(angar);


        List<Car> result = new ArrayList(Arrays.asList(carr2,carr4,carr5,carr6));
        List<Car> resultObj = obj.carsWithPowerMoreThan(300);

        result.sort((lhs, rhs) -> CharSequence.compare(rhs.getBrand(), lhs.getBrand()));

        resultObj.sort((lhs, rhs) -> CharSequence.compare(rhs.getBrand(), lhs.getBrand()));

        assertEquals(resultObj,result);

    }

    @org.junit.Test
    public void allCarsOfOwnerTest() {
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
        Garage obj = new Angar(angar);


        List<Car> result = new ArrayList(Arrays.asList(carr4,carr5,carr6));

        List<Car> resultObj = obj.allCarsOfOwner(ownerr3);

        result.sort( (lhs, rhs) -> CharSequence.compare(rhs.getBrand(), lhs.getBrand()));

        resultObj.sort((lhs, rhs) -> CharSequence.compare(rhs.getBrand(), lhs.getBrand()));

        assertEquals(resultObj,result);

    }

    @org.junit.Test
    public void meanOwnersAgeOfCarBrandTest() {
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
        Garage obj = new Angar(angar);

        int result1 = 19;
        int result2 = 17;
        int result3 = 23;
        assertEquals(obj.meanOwnersAgeOfCarBrand("Audi"),result1);
        assertEquals(obj.meanOwnersAgeOfCarBrand("Porshe"),result2);
        assertEquals(obj.meanOwnersAgeOfCarBrand("Bmw"),result3);
    }

    @org.junit.Test
    public void meanCarNumberForEachOwnerTest() {
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
        Garage obj = new Angar(angar);

        int result = 2;
        assertEquals(obj.meanCarNumberForEachOwner(),result);
    }


    @org.junit.Test
    public void removeCarTest() {
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
        Garage obj = new Angar(angar);

        assertEquals(obj.removeCar(25345323),carr1);
        assertEquals(obj.removeCar(34243545),carr2);
    }

    @org.junit.Test
    public void addCarTest() {
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

        Garage obj = new Angar(angar);
        obj.addCar(carr1, ownerr1);
        obj.addCar(carr2, ownerr1);
        obj.addCar(carr3, ownerr2);
        obj.addCar(carr4, ownerr3);
        obj.addCar(carr5, ownerr3);
        obj.addCar(carr6, ownerr3);


        HashMap<Car,Owner> result = new HashMap<>();
        result.put(carr1, ownerr1);
        result.put(carr2, ownerr1);
        result.put(carr3, ownerr2);
        result.put(carr4, ownerr3);
        result.put(carr5, ownerr3);
        result.put(carr6, ownerr3);

        assertEquals(obj.getAngar(),result);
    }
}