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

    private int id;
    private int quantity;
    private int pizzaId;
    private double cost;

    @Override
    public int getProductId() {
        return pizzaId;
    }

    @Override
    public void setProductId(int productId) {
        this.pizzaId = productId;
    }

}
