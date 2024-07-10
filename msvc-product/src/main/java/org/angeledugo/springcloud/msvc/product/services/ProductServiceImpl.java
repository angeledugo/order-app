package org.angeledugo.springcloud.msvc.product.services;

import org.angeledugo.springcloud.msvc.product.entity.Product;
import org.angeledugo.springcloud.msvc.product.respositories.ProductRepostory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepostory repository;

    @Override
    public List<Product> getProducts() {
        return (List<Product>) repository.findAll();
    }

    @Override
    public Optional<Product> getProductsByid(Long id) {
        return repository.findById(id);
    }

    @Override
    public Product saveProduct(Product product) {
        return repository.save(product);
    }

    @Override
    public void deleteProduct(Long id) {
        repository.deleteById(id);
    }
}
