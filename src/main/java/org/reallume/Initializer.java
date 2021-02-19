package org.reallume;

import org.reallume.model.extra.*;
import org.reallume.model.pizza.BasePizza;
import org.reallume.model.pizza.Pizza;

public class Initializer {

    public static final int PIZZA_BASE_ID = 0;
    public static final int PIZZA_BACON_ID = 1;
    public static final int PIZZA_CHICKEN_ID = 2;
    public static final int PIZZA_CHICKEN_TOMATO_ID = 3;
    public static final int PIZZA_CHICKEN_TOMATO_MUSHROOM_SAUSAGE_ID = 4;

    static private Pizza pizzaInstance;

    public static void initializePizza(Integer objectId) throws Exception {
        switch (objectId) {
            case PIZZA_BASE_ID -> pizzaInstance = new BasePizza();
            case PIZZA_BACON_ID -> pizzaInstance = new Bacon(new BasePizza());
            case PIZZA_CHICKEN_ID -> pizzaInstance = new Chicken(new BasePizza());
            case PIZZA_CHICKEN_TOMATO_ID -> pizzaInstance = new Chicken(new Tomato(new BasePizza()));
            case PIZZA_CHICKEN_TOMATO_MUSHROOM_SAUSAGE_ID -> pizzaInstance = new Chicken(new Tomato(new Mushroom(new Sausage(new BasePizza()))));
            default -> throw new Exception("Error! Unknown operating system.");
        }
    }

    public static Pizza getPizzaInstance(){
        return pizzaInstance;
    }
}
