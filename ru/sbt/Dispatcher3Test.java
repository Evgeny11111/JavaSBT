package ru.sbt;

import org.junit.Test;

import java.util.ArrayList;


class Dispatcher3Test {

    @Test
    public void runTest1() throws InterruptedException, Dispatcher3.TaxisException, Dispatcher3.OrdersException {
        ArrayList<Taxi3> taxis = new ArrayList<>();
        int numTaxes = 3;
        int numOrders = 6;
        for (int i = 0; i < numTaxes; i++) {
            taxis.add(new Taxi3("taxi_" + (i+1)));
        }

        ArrayList<Order> orders = new ArrayList<>();

        for (int i = 0; i < numOrders; i++) {
            orders.add(new Order("order_" + (i+1)));
        }

        Dispatcher3 dispatcher = new Dispatcher3(taxis,orders);

        dispatcher.run();
    }
    @Test
    public void runTest2() throws InterruptedException, Dispatcher3.TaxisException, Dispatcher3.OrdersException {
        ArrayList<Taxi3> taxis = new ArrayList<>();
        int numTaxes = 15;
        int numOrders = 15;
        for (int i = 0; i < numTaxes; i++) {
            taxis.add(new Taxi3("taxi_" + (i+1)));
        }

        ArrayList<Order> orders = new ArrayList<>();

        for (int i = 0; i < numOrders; i++) {
            orders.add(new Order("order_" + (i+1)));
        }

        Dispatcher3 dispatcher = new Dispatcher3(taxis,orders);

        dispatcher.run();
    }
    @Test
    public void runTest3() throws InterruptedException, Dispatcher3.TaxisException, Dispatcher3.OrdersException {
        ArrayList<Taxi3> taxis = new ArrayList<>();
        int numTaxes = 6;
        int numOrders = 4;
        for (int i = 0; i < numTaxes; i++) {
            taxis.add(new Taxi3("taxi_" + (i+1)));
        }

        ArrayList<Order> orders = new ArrayList<>();

        for (int i = 0; i < numOrders; i++) {
            orders.add(new Order("order_" + (i+1)));
        }

        Dispatcher3 dispatcher = new Dispatcher3(taxis,orders);

        dispatcher.run();
    }

    @Test
    public void runTest4() throws InterruptedException, Dispatcher3.TaxisException, Dispatcher3.OrdersException {
        ArrayList<Taxi3> taxis = new ArrayList<>();
        int numTaxes = 0;
        int numOrders = 2;
        for (int i = 0; i < numTaxes; i++) {
            taxis.add(new Taxi3("taxi_" + (i+1)));
        }

        ArrayList<Order> orders = new ArrayList<>();

        for (int i = 0; i < numOrders; i++) {
            orders.add(new Order("order_" + (i+1)));
        }

        Dispatcher3 dispatcher = new Dispatcher3(taxis,orders);

        dispatcher.run();

    }
    @Test
    public void runTest5() throws InterruptedException, Dispatcher3.TaxisException, Dispatcher3.OrdersException {
        ArrayList<Taxi3> taxis = new ArrayList<>();
        int numTaxes = 5;
        int numOrders = 0;
        for (int i = 0; i < numTaxes; i++) {
            taxis.add(new Taxi3("taxi_" + (i+1)));
        }

        ArrayList<Order> orders = new ArrayList<>();

        for (int i = 0; i < numOrders; i++) {
            orders.add(new Order("order_" + (i+1)));
        }

        Dispatcher3 dispatcher = new Dispatcher3(taxis,orders);

        dispatcher.run();

    }
}