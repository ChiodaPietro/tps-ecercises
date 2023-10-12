package EX1PIZZA;

import EX1PIZZA.Exception.OrderTooBigException;

public class Main {
    public static void main(String[] args) throws InterruptedException {
      Pizzeria mammamia=new Pizzeria("mammamia");
      mammamia.start();

      Client giorgio= new Client("giorgio");
      Client mario=new Client("Mario");
        try {
            mammamia.addOrder(giorgio.order(3, "margherita"));
            mammamia.addOrder(mario.order(2, "spaghetti"));
        } catch (OrderTooBigException e) {
            System.out.println("too many pizzas");
        }
        mammamia.join();
    }
}
