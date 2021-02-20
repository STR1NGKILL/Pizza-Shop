package org.reallume.model.order;

public interface Order {

    Long getId();

    Integer getQuantity();

    Integer getProductId();

    double getCost();

    void setId(Long id);

    void setQuantity(Integer quantity);

    void setProductId(Integer productId);

    void setCost(Double cost);

}
