package com.anneng.net.model.bean;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table("customer")
public class Customer {
    @Id
    private Long id;
    private String name;
    private String phone;
    private String dest;
    private Double hPrice;
    private Double vPrice;
    private Double basePrice;
}
