package com.anneng.net.service;


import com.anneng.net.Excepation.MyRuntimeException;
import com.anneng.net.db.repository.CustomerConfig;
import com.anneng.net.db.repository.OrdersConfig;
import com.anneng.net.db.repository.OrdersDao;
import com.anneng.net.model.Page;
import com.anneng.net.model.bean.Customer;
import com.anneng.net.model.bean.Orders;
import com.anneng.net.model.bo.CustomerBo;
import com.anneng.net.model.vo.AggParams;
import com.anneng.net.model.vo.OrdersParams;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class AccountService {


    @Autowired
    private CustomerConfig customerConfig;

    @Autowired
    private OrdersConfig ordersConfig;

    @Autowired
    private OrdersDao ordersDao;

    public Customer saveUser(Customer customer) {
        String name = customer.getName();
        String dest = customer.getDest();
        List<Customer> customers = customerConfig.findByNameAndDest(name, dest);
        if (customers != null && !customers.isEmpty() & customer.getId() == null) {
            throw new MyRuntimeException(String.format("%s 发往 %s 的用户已经存在，请勿重复添加", name, dest));
        }
        log.info("update user to db :{}", customers.toString());
        return customerConfig.save(customer);
    }

    public Customer findUser(Long userId) {
        Optional<Customer> customer = customerConfig.findById(userId);
        if (customer.isPresent()) {
            return customer.get();
        }
        return null;
    }

    public Iterable<Customer> findUser() {
        return customerConfig.findAll();
    }

    public void deleteUser(Long userId) {
        log.info("delete user from db :{}", userId);

        customerConfig.deleteById(userId);
    }

    public Customer findOrderByNameAndDest(Orders orders) {
        return findOrderByNameAndDest(orders.getCustomerName(), orders.getDest());
    }

    public Customer findOrderByNameAndDest(String name, String dest) {
        List<Customer> andDest = customerConfig.findByNameAndDest(name, dest);
        if (andDest != null && !andDest.isEmpty()) {
            return andDest.get(0);
        }
        return null;
    }

    public void saveOrdersToDB(List<Orders> list) {
        ordersConfig.saveAll(list);
    }

    public Page findOrdersList(OrdersParams params) {
        Integer page = getPage(params.getPage());
        Integer size = getSize(params.getSize());
        params.setPage(page);
        params.setSize(size);
        Page ordersPage = new Page(page, size);
        ordersPage.setData(ordersDao.getOrdersList(params));
        ordersPage.setTotal(ordersDao.getOrdersCount(params));
        return ordersPage;
    }

    public List<Orders> getOrderList(OrdersParams params) {
        return ordersDao.getOrdersListWithOutLimit(params);
    }

    private Integer getSize(Integer size) {
        if (size < 0 || size == null)
            size = 0;
        return size;
    }

    private Integer getPage(Integer page) {
        if (page < 0 || page == null)
            page = 0;
        return page;
    }

    public Orders findOrderById(Long orderId) {
        return ordersConfig.findById(orderId)
                .get();
    }

    public void deleteOrder(Long orderId) {
        ordersConfig.deleteById(orderId);
    }

    public void deleteOrder(List<Long> orders) {
        orders.stream()
                .forEach(this::deleteOrder);
    }

    public Orders saveOrders(Orders orders) {
        if (orders.getId() == null) {
            orders.setCreateTime(LocalDateTime.now());
            orders.setUpdateTime(LocalDateTime.now());
        }
        Orders orders1 = new Orders();
        Orders ifNotNull = orders1.copyOrdersIfNotNull(orders);
        return ordersConfig.save(ifNotNull);
    }

    public Page findAggPage(AggParams params) {
        Integer page = getPage(params.getPage());
        Integer size = getSize(params.getSize());
        params.setPage(page);
        params.setSize(size);
        Page ordersPage = new Page(page, size);
        ordersPage.setData(ordersDao.getAggList(params));
        ordersPage.setTotal(ordersDao.getAggCount(params));
        return ordersPage;
    }

    public Customer findUserByName(String name, String dest) {
        List<Customer> nameAndDest = customerConfig.findByNameAndDest(name, dest);
        if (nameAndDest != null && nameAndDest.size() != 0) {
            return nameAndDest.get(0);
        }
        return null;
    }

    public List<CustomerBo> findUserByHeader() {
        List<Customer> header = customerConfig.findAllByHeader();
        List<CustomerBo> customerBos = header.stream()
                .map(customer -> {
                    String name = customer.getName();
                    List<Customer> all = customerConfig.findAllByName(name);
                    if (all.isEmpty() || all.size() < 2) {
                        return CustomerBo.from(customer)
                                .setHasChildren(false);
                    }
                    return CustomerBo.from(customer)
                            .setHasChildren(true);
                })
                .collect(Collectors.toList());

        return customerBos;
    }

    public List<Customer> findUserByName(String name) {
        return customerConfig.findAllByName(name);
    }
}
