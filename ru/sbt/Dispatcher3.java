package ru.sbt;

import java.util.ArrayList;
import java.util.HashMap;

public class Dispatcher3 {
    ArrayList<Taxi3> taxis;
    ArrayList<Order> orders;
    Order ord;
    int counter;

    public static HashMap<Taxi3, Integer> taxiToActive = new HashMap<>();
    //true - active
    //false-not active

    public Dispatcher3(ArrayList<Taxi3> taxis, ArrayList<Order> orders) {
        this.taxis = taxis;
        this.orders = orders;
    }

    public static void notifyAvailable(Taxi3 taxi) {
        if (taxi.isActive() == 0) {
            taxiToActive.replace(taxi, 0);
        } else {
            taxiToActive.replace(taxi, 1);
        }
    }

    void run() throws InterruptedException, TaxisException, OrdersException {
        if (taxis.size() == 0) {
            throw new TaxisException("The number of taxis equals 0");
        }
        if (orders.size() == 0) {
            throw new OrdersException("The number of orders equals 0");
        }
            for (Taxi3 taxi3 : taxis) {
                taxiToActive.put(taxi3, 0);
            }
            while (orders.size() > 0) {
                counter = 0;
                for (Taxi3 taxi3 : taxiToActive.keySet()) {
                    if (orders.size() == 0) {
                        break;
                    }
                    ord = orders.get(0);
                    synchronized (ord) {
                        counter++;
                        notifyAvailable(taxi3);
                        Integer carAvailable = taxiToActive.get(taxi3);
                        if (carAvailable == 0) {
                            taxi3.placeOrder(ord);
                            Thread t = new Thread(taxi3, taxi3.getNameTaxi());
                            t.start();
                            Thread.sleep(10);
                            orders.remove(ord);
                            Thread.sleep(10);
                        }
                    }
                }

        }
    }
    static class TaxisException extends Exception{

        public TaxisException(String message){
            super(message);
        }
    }
    static class OrdersException extends Exception{
        public OrdersException(String message){
            super(message);
        }
    }
}


