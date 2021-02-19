package org.reallume.model.order;

public interface Order {

    int getId();

    int getQuantity();

    int getProductId();

    double getCost();

    void setId(int id);

    void setQuantity(int quantity);

    void setProductId(int productId);

    void setCost(double cost);

}
