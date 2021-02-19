package org.reallume;

import org.reallume.model.extra.*;
import org.reallume.model.order.Order;
import org.reallume.model.order.PizzaOrder;
import org.reallume.model.pizza.BasePizza;
import org.reallume.model.pizza.Pizza;

public class Initializer {

    public static final int PIZZA_BASE_ID = 0;
    public static final int PIZZA_BACON_ID = 1;
    public static final int PIZZA_CHICKEN_ID = 2;
    public static final int PIZZA_CHICKEN_TOMATO_ID = 3;
    public static final int PIZZA_CHICKEN_TOMATO_MUSHROOM_SAUSAGE_ID = 4;

    public static final int ORDER_PIZZA_TYPE_ID = 0;

    static private Pizza pizzaInstance;
    static private Order orderInstance;

    public static void initializePizza(Integer objectId) throws Exception {
        switch (objectId) {
            case PIZZA_BASE_ID -> pizzaInstance = new BasePizza(PIZZA_BASE_ID);
            case PIZZA_BACON_ID -> pizzaInstance = new Bacon(new BasePizza(PIZZA_BACON_ID));
            case PIZZA_CHICKEN_ID -> pizzaInstance = new Chicken(new BasePizza(PIZZA_CHICKEN_ID));
            case PIZZA_CHICKEN_TOMATO_ID -> pizzaInstance = new Chicken(new Tomato(new BasePizza(PIZZA_CHICKEN_TOMATO_ID)));
            case PIZZA_CHICKEN_TOMATO_MUSHROOM_SAUSAGE_ID -> pizzaInstance = new Chicken(new Tomato(new Mushroom(new Sausage(new BasePizza(PIZZA_CHICKEN_TOMATO_MUSHROOM_SAUSAGE_ID)))));
            default -> throw new Exception("Error! Unknown operating system.");
        }
    }

    public static void initializeOrder(Integer objectId, int id, int quantity, int productId, double cost) throws Exception {
        switch (objectId) {
            case ORDER_PIZZA_TYPE_ID -> orderInstance = new PizzaOrder(id, quantity, productId, cost);
            default -> throw new Exception("Error! Unknown operating system.");
        }
    }

    public static Pizza getPizzaInstance(){ return pizzaInstance; }
    public static Order getOrderInstance(){ return orderInstance; }
}
