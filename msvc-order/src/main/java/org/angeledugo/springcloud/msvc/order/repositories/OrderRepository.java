package org.angeledugo.springcloud.msvc.order.repositories;

import org.angeledugo.springcloud.msvc.order.entity.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order, Long> {
}
