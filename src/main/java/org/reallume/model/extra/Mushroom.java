package org.reallume.model.extra;

import org.reallume.model.pizza.Pizza;
import org.reallume.model.pizza.PizzaDecorator;


public class Mushroom extends PizzaDecorator {

    private String name = "грибами";
    private String basePizzaName = "Обычная пицца";
    private final Pizza pizza;

    public Mushroom(Pizza pizza) {
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
        return super.getPrice() + 40D;
    }

}
