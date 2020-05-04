package com.anneng.net.api;

import com.alibaba.excel.EasyExcel;
import com.anneng.net.Thread.ExcelExecutor;
import com.anneng.net.listener.UploadDataListener;
import com.anneng.net.model.bean.Customer;
import com.anneng.net.model.bean.Excel;
import com.anneng.net.model.bean.Orders;
import com.anneng.net.model.vo.AggParams;
import com.anneng.net.model.vo.NeedDeleteOrders;
import com.anneng.net.model.vo.OrdersParams;
import com.anneng.net.service.AccountService;
import com.anneng.net.util.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

import static com.anneng.net.util.ResponseUtil.success;
import static java.util.Objects.requireNonNull;

@RestController
@RequestMapping("/api")
public class ApiController {

    @Autowired
    private AccountService accountService;

    @PostMapping(value = "/save/users")
    public ApiResponse upload(@RequestBody Customer customer) throws IOException {
        requireNonNull(customer, "用户不能为空");
        requireNonNull(customer.getName(), "用户名称不能为空");
        requireNonNull(customer.getDest(), "目的地不能为空");
        return success(accountService.saveUser(customer));
    }

    @GetMapping(value = "/get/{userId}/user")
    public ApiResponse getUser(@PathVariable Long userId) throws IOException {
        requireNonNull(userId, "用户id不能为空");
        return success(accountService.findUser(userId));
    }

    @GetMapping(value = "/list/users")
    public ApiResponse listUsers() throws IOException {
        return success(accountService.findUser());
    }

    @DeleteMapping(value = "/del/{userId}/user")
    public ApiResponse deleteUser(@PathVariable Long userId) throws IOException {
        requireNonNull(userId, "用户id不能为空");
        accountService.deleteUser(userId);
        return success(true);
    }

    @PostMapping(value = "/upload")
    public ApiResponse upload(@RequestBody MultipartFile file) throws IOException {
        ExcelExecutor excelExecutor = new ExcelExecutor(accountService);
        EasyExcel.read(file.getInputStream(), Excel.class, new UploadDataListener(excelExecutor)).sheet().doRead();
        List<Orders> orders = excelExecutor.get();
        accountService.saveOrdersToDB(orders);
        return success(true);
    }

    @PostMapping(value = "/list/orders")
    public ApiResponse listOrdes(@RequestBody OrdersParams params) throws IOException {
        return success(accountService.findOrdersList(params));
    }

    @GetMapping(value = "/get/{orderId}/order")
    public ApiResponse getOrder(@PathVariable Long orderId) throws IOException {
        requireNonNull(orderId, "订单id不能为空");
        return success(accountService.findOrderById(orderId));
    }

    @DeleteMapping(value = "/del/{orderId}/order")
    public ApiResponse deleteOrder(@PathVariable Long orderId) throws IOException {
        requireNonNull(orderId, "订单id不能为空");
        accountService.deleteOrder(orderId);
        return success(true);
    }

    @PostMapping(value = "/del/orders")
    public ApiResponse deleteOrder(@RequestBody NeedDeleteOrders needDeleteOrders) throws IOException {
        requireNonNull(needDeleteOrders.getOrders(), "需要删除的订单不能为空");
        accountService.deleteOrder(needDeleteOrders.getOrders());
        return success(true);
    }

    @PostMapping(value = "/save/orders")
    public ApiResponse saveOrders(@RequestBody Orders orders) throws IOException {
        return success(accountService.saveOrders(orders));
    }

    @PostMapping(value = "/get/aggs/page")
    public ApiResponse getAggPage(@RequestBody AggParams params) throws IOException {
        return success(accountService.findAggPage(params));
    }

}
