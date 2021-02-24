package org.reallume.model.order;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.reallume.model.pizza.Pizza;


@NoArgsConstructor
@AllArgsConstructor
public class PizzaOrder implements Order{

    private Long id;
    private Integer quantity;
    private Pizza pizza;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public Integer getQuantity() {
        return quantity;
    }

    @Override
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public Pizza getProduct() {
        return pizza;
    }

    @Override
    public void setProduct(Pizza pizza) {
        this.pizza = pizza;
    }

}
