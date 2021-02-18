package org.reallume.model.extra;

import org.reallume.model.pizza.Pizza;
import org.reallume.model.pizza.PizzaDecorator;


public class Chicken extends PizzaDecorator {

    private String name = "курицей";
    private String basePizzaName = "Обычная пицца";
    private final Pizza pizza;

    public Chicken(Pizza pizza) {
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
    public Double getPrice() {
        return super.getPrice() + 60;
    }

}
