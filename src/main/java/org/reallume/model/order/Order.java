package org.reallume.model.order;

public interface Order {

    Long getId();

    void setId(Long id);

    Integer getQuantity();

    void setQuantity(Integer quantity);

    Integer getProductId();

    void setProductId(Integer productId);

    Double getCost();

    void setCost(Double cost);

}
