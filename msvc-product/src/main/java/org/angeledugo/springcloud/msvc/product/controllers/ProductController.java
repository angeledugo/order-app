package org.angeledugo.springcloud.msvc.product.controllers;

import org.angeledugo.springcloud.msvc.product.entity.Product;
import org.angeledugo.springcloud.msvc.product.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService service;

    @GetMapping
    public List<Product> getAllProducts() {
        return service.getProducts();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getProductById(@PathVariable Long id) {
        Optional<Product> product =  service.getProductsByid(id);
        if (product.isPresent()) {
            return ResponseEntity.ok(product.get());
        }
        return ResponseEntity.notFound().build();

    }

    @PostMapping
    public ResponseEntity<?> createProduct(@RequestBody Product product) {
        Product productDb = service.saveProduct(product);

        return ResponseEntity.status(HttpStatus.CREATED).body(productDb);

    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateProduct(@RequestBody Product product, @PathVariable Long id) {
        Optional<Product> o = service.getProductsByid(id);
        if(o.isPresent()) {
            Product productdb = o.get();
            productdb.setDescription(product.getDescription());
            productdb.setPrice(product.getPrice());

            return ResponseEntity.status(HttpStatus.CREATED).body(service.saveProduct(productdb));
        }

        return  ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable Long id) {
        Optional<Product> o = service.getProductsByid(id);

        if(o.isPresent()) {
            service.deleteProduct(id);
        }

        return ResponseEntity.noContent().build();
    }


}
