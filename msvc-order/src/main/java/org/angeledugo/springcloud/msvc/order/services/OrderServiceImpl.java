package org.angeledugo.springcloud.msvc.order.services;

import org.angeledugo.springcloud.msvc.order.clients.ProductClientRest;
import org.angeledugo.springcloud.msvc.order.dto.OrderDto;
import org.angeledugo.springcloud.msvc.order.entity.Order;
import org.angeledugo.springcloud.msvc.order.models.Product;
import org.angeledugo.springcloud.msvc.order.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class OrderServiceImpl implements OrderService  {
    @Autowired
    private OrderRepository repository;

    @Autowired
    private ProductClientRest productClient;

    @Override
    public List<Order> getAllOrders() {
        return (List<Order>) repository.findAll();
    }

    @Override
    public Optional<Order> getOrderByid(Long id) {
        return repository.findById(id);
    }

    @Override
    public OrderDto getOrderDetail(Long id) {
        Order order = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found"));
        Product product = productClient.getProductById(order.getProductId());
        return new OrderDto(order, product);

    }

    @Override
    public Order saveOrder(Order order) {
        return repository.save(order);
    }

    @Override
    public void deleteOrder(Long id) {
        repository.deleteById(id);
    }
}
