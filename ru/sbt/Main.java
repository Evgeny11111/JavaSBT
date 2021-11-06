package ru.sbt;


public class Main {
    public static void main(String[] args) throws InterruptedException, Dispatcher3.TaxisException, Dispatcher3.OrdersException {
        Dispatcher3Test dispatcher3Test = new Dispatcher3Test();
        dispatcher3Test.runTest1();
        dispatcher3Test.runTest2();
        dispatcher3Test.runTest3();
        dispatcher3Test.runTest4();
        dispatcher3Test.runTest5();
    }
}
