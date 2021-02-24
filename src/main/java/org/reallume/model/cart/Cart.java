package org.reallume.model.cart;

import org.reallume.model.order.Order;

import java.util.List;

public interface Cart {

    void addOrder(Order order);

    void removeOrderById(Long id);

    void removeAll();

    List<Order> getOrders();

    Double getOverallCost();

}
