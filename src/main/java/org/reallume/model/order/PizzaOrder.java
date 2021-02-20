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

    private Long id;
    private Integer quantity;
    private Integer pizzaId;
    private Double cost;

    @Override
    public Integer getProductId() {
        return pizzaId;
    }

    @Override
    public void setProductId(Integer productId) {
        this.pizzaId = productId;
    }

}
