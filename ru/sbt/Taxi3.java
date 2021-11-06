package ru.sbt;

import java.util.ArrayList;
import java.util.List;

public class Taxi3 implements Runnable {
    private final String nameTaxi;
    private Integer isActive;


    void disable() {
        isActive = 1;
    }

    Taxi3(String nameTaxi) {
        this.nameTaxi = nameTaxi;
        isActive = 0;
    }

    private final List<Order> executedOrders = new ArrayList<>();

    public void run() {
        while (isActive == 0) {
            long timeOrder = (long) (Math.random() * 1000) + 500;
            disable();
            System.out.println(Thread.currentThread().getName() + ": "+executedOrders.get(executedOrders.size()-1).getNameOrder() +  " started...");
            try {
                Thread.sleep(timeOrder);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + ": "+executedOrders.get(executedOrders.size()-1).getNameOrder() +" finished");
        }
        isActive = 0;
    }


    void placeOrder(Order order){
        executedOrders.add(order);
    }

    public List<Order> getExecutedOrders() {
        return executedOrders;
    }

    public String getNameTaxi() {
        return nameTaxi;
    }

    public Integer isActive() {
        return isActive;
    }
}
