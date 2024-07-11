package org.angeledugo.springcloud.msvc.order.clients;

import org.angeledugo.springcloud.msvc.order.models.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="msvc-product", url = "msvc-product:8001")
public interface ProductClientRest {

    @GetMapping("/product/{id}")
    Product getProductById(@PathVariable("id") Long id);
}
