package org.angeledugo.springcloud.msvc.product.services;

import org.angeledugo.springcloud.msvc.product.entity.Product;
import org.angeledugo.springcloud.msvc.product.respositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository repository;

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
