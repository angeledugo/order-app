package org.angeledugo.springcloud.msvc.product.respositories;

import org.angeledugo.springcloud.msvc.product.entity.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepostory extends CrudRepository<Product, Long> {
}
