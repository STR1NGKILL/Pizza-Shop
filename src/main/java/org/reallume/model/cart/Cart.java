package org.reallume.model.cart;

import org.reallume.model.order.Order;

import java.util.List;

public interface Cart {

    void setId(Long id);

    Long getId();

    void addOrder(Order order);

    void removeOrderById(Long id);

    void removeAll();

    List<Order> getOrders();

    Double getOverallCost();

}
