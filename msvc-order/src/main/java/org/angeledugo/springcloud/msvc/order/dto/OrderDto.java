package org.angeledugo.springcloud.msvc.order.dto;

import org.angeledugo.springcloud.msvc.order.entity.Order;
import org.angeledugo.springcloud.msvc.order.models.Product;

public class OrderDto {
        private Long orderId;
        private Long productId;
        private int quantity;
        private double totalPrice;
        private String productDescription;
        private double productPrice;

        public OrderDto(Order order, Product product) {
            this.orderId = order.getId();
            this.productId = product.getId();
            this.quantity = order.getQuantity();
            this.totalPrice = order.getTotalPrice();
            this.productDescription = product.getDescription();
            this.productPrice = product.getPrice();
        }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }


    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }
}
