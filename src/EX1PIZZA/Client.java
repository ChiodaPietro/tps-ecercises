package EX1PIZZA;

import EX1PIZZA.Exception.OrderTooBigException;

public class Client {
    private String name;

    public Client(String name) {
        this.name = name;
    }

    public  Order order(int amount, String type) throws OrderTooBigException {

        return new Order(amount, type, this.name);
    }

    public String getName() {
        return name;
    }
}
