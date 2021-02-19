package org.reallume.model.extra;

import org.reallume.model.pizza.Pizza;
import org.reallume.model.pizza.PizzaDecorator;


public class Bacon extends PizzaDecorator {

    private String name = "беконом";
    private String basePizzaName = "Обычная пицца";
    private final Pizza pizza;

    public Bacon(Pizza pizza) {
        super(pizza);
        this.pizza = pizza;
    }

    @Override
    public String getName() {
        if(super.getName().equals(basePizzaName))
            return super.getName() + " c " + this.name;
        else
            return super.getName() + ", " + this.name;
    }

    @Override
    public double getPrice() {
        return super.getPrice() + 100D;
    }

}
