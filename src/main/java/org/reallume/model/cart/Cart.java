package org.reallume.model.cart;

import org.reallume.model.order.Order;

public interface Cart {

    void addOrder(Order order);

    void removeOrderById(Long id);

    void removeAll();

    Double getOverallCost();

}
