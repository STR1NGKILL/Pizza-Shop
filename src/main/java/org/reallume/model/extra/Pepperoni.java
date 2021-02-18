package org.reallume.model.extra;

import org.reallume.model.pizza.BasePizza;
import org.reallume.model.pizza.PizzaDecorator;


public class Pepperoni extends PizzaDecorator {

    private String name = "пепперони";
    private final BasePizza basePizza;

    public Pepperoni(BasePizza basePizza) {
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
        return super.getPrice() + 55;
    }

}
