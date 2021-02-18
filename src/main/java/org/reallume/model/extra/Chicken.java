package org.reallume.model.extra;

import org.reallume.model.pizza.BasePizza;
import org.reallume.model.pizza.PizzaDecorator;


public class Chicken extends PizzaDecorator {

    private String name = "курицей";
    private final BasePizza basePizza;

    public Chicken(BasePizza basePizza) {
        super(basePizza);
        this.basePizza = basePizza;
    }

    @Override
    public String getName() {
        if(super.getName().equals(basePizza.getName()))
            return super.getName() + " c " + this.name;
        else
            return super.getName() + ", " + this.name;
    }

    @Override
    public Double getPrice() {
        return super.getPrice() + 60;
    }

}
