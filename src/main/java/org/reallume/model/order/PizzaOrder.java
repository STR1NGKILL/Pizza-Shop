package org.reallume.model.order;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
public class PizzaOrder implements Order{

    private Long id;
    private Integer quantity;
    private Integer pizzaId;
    private Double cost;

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
    public Integer getProductId() {
        return pizzaId;
    }

    @Override
    public void setProductId(Integer productId) {
        this.pizzaId = productId;
    }

    @Override
    public Double getCost() {
        return cost;
    }

    @Override
    public void setCost(Double cost) {
        this.cost = cost;
    }

}
