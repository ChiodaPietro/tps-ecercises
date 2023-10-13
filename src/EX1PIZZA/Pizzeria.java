package EX1PIZZA;

import java.io.IOException;
import java.util.Vector;

public class Pizzeria extends Thread {
    private String name;
    private Vector<Order> orders;

    public Pizzeria(String name) {
        this.name = name;
        orders = new Vector<>();
    }

    public String getPizzeriaName() {
        return name;
    }

    public synchronized void addOrder(Order order) {
        orders.add(order);
        notify();
    }

    @Override
    public void run() {
        while (true) {
                waitfororders();
                try {
                    System.out.println("preparing the pizza for mr " + orders.get(0).getName());
                    for (int i = 0; i < orders.get(0).getAmount(); i++) {
                        Thread.sleep(5000);
                    }
                } catch (InterruptedException e) {
                    System.out.println("excetpion while preparing the pizza");
                }
                System.out.println("prepared "+orders.get(0).getAmount() +" pizza " + orders.get(0).getType() + " for " + orders.get(0).getName());
                orders.remove(0);
            }

    }
public synchronized void waitfororders(){
        while(orders.isEmpty()){
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
}
}
