package EX1PIZZA.Exception;

import EX1PIZZA.Order;

public class OrderTooBigException extends Exception{
    public OrderTooBigException(String s){
        super(s);
    }
}
