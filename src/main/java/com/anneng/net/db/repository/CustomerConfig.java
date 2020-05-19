package com.anneng.net.db.repository;

import com.anneng.net.model.bean.Customer;
import com.anneng.net.model.bean.Orders;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerConfig extends CrudRepository<Customer, Long> {
    @Query("select * from customer where name = :customerName and dest = :dest ")
    List<Customer> findByNameAndDest(String customerName, String dest);

    @Query("select * from customer group by name")
    List<Customer> findAllByHeader();

    @Query("select * from customer where name = :customerName")
    List<Customer> findAllByName(String customerName);
}