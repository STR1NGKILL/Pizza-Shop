package org.reallume.model.order;

import org.reallume.model.pizza.Pizza;

public interface Order {

    Long getId();

    void setId(Long id);

    Integer getQuantity();

    void setQuantity(Integer quantity);

    Pizza getProduct();

    void setProduct(Pizza pizza);

}
