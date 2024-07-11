package org.angeledugo.springcloud.msvc.order.controllers;

import org.angeledugo.springcloud.msvc.order.dto.OrderDto;
import org.angeledugo.springcloud.msvc.order.entity.Order;
import org.angeledugo.springcloud.msvc.order.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService service;

    @GetMapping
    public List<Order> getOrder() {
        return service.getAllOrders();
    }

    @GetMapping("/{id}")
    public OrderDto getOrderById(@PathVariable Long id) {
        return service.getOrderDetail(id);
    }

    @PostMapping
    public Order createOrder(@RequestBody Order order) {
        return service.saveOrder(order);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Order> updateOrder(@RequestBody Order orderDetails, @PathVariable Long id) {
        return service.getOrderByid(id)
                .stream()
                .findFirst()
                .map(order -> {
                    order.setProductId(orderDetails.getProductId());
                    order.setQuantity(orderDetails.getQuantity());
                    order.setTotalPrice(orderDetails.getTotalPrice());
                    Order updateOrder = service.saveOrder(order);

                    return ResponseEntity.ok(updateOrder);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteOrder(@PathVariable Long id) {
        service.deleteOrder(id);
        return ResponseEntity.noContent().build();
    }

}
