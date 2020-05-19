package com.anneng.net.model.bo;

import com.anneng.net.model.bean.Customer;
import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;

import java.util.List;

@Data
@Accessors(chain = true)
public class CustomerBo {
    @Id
    private Long id;
    private String name;
    private String phone;
    private String dest;
    private Double hPrice;
    private Double vPrice;
    private Double basePrice;
    private Boolean hashChildren;
    private List<Customer> children;


    public static CustomerBo from(Customer customer){
        return new CustomerBo()
                .setId(customer.getId())
                .setBasePrice(customer.getBasePrice())
                .setDest(customer.getDest())
                .setHPrice(customer.getHPrice())
                .setName(customer.getName())
                .setPhone(customer.getPhone())
                .setVPrice(customer.getVPrice())
                ;
    }
}
