package org.reallume.model.pizza;


public class PizzaDecorator implements Pizza {

    private final Pizza pizza;

    public PizzaDecorator(Pizza pizza) {
        this.pizza = pizza;
    }

    @Override
    public int getId() { return pizza.getId(); }

    @Override
    public String getName() {
        return pizza.getName();
    }

    @Override
    public Double getPrice() {
        return pizza.getPrice();
    }

}
