package EX1PIZZA;

import EX1PIZZA.Exception.OrderTooBigException;

public class Order {
    private int amount;
    private String type;
    private String name;
    public Order(int amount, String type, String name) throws OrderTooBigException {
        if(amount>10){
            throw new OrderTooBigException("too many pizzas have been ordered");
        }
        this.amount=amount;
        this.type=type;
        this.name=name;
    }

    public int getAmount() {
        return amount;
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }
}
