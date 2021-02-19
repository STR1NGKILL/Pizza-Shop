package org.reallume.model.order;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PizzaOrder implements Order{

    private long id;
    private int quantity;
    private int pizzaId;
    private int cost;


    @Override
    public long getId() {
        return id;
    }

    @Override
    public int getQuantity() {
        return quantity;
    }

    @Override
    public int getProductId() {
        return pizzaId;
    }

    @Override
    public int getCost() {
        return cost;
    }
}
