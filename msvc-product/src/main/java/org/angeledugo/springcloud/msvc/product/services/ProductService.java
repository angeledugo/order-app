package org.angeledugo.springcloud.msvc.product.services;

import org.angeledugo.springcloud.msvc.product.entity.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    List<Product> getProducts();
    Optional<Product> getProductsByid(Long id);
    Product saveProduct();
    void deleteProduct(Long id);
}
