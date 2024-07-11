package org.angeledugo.springcloud.msvc.order.services;

import org.angeledugo.springcloud.msvc.order.entity.Order;

import java.util.List;
import java.util.Optional;

public interface OrderService {

    List<Order> getAllOrders();
    Optional<Order> getOrderByid(Long id);
    Order saveOrder(Order order);
    void deleteOrder(Long id);
}
