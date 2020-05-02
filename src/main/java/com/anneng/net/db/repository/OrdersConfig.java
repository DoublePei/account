package com.anneng.net.db.repository;

import com.anneng.net.model.bean.Orders;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdersConfig extends CrudRepository<Orders, Long> {
}