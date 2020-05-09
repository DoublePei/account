package com.anneng.net.Thread;

import com.anneng.net.model.bean.Customer;
import com.anneng.net.model.bean.Excel;
import com.anneng.net.model.bean.Orders;
import com.anneng.net.model.enums.PriceType;
import com.anneng.net.service.AccountService;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

import static com.alibaba.excel.util.StringUtils.isEmpty;

public class ExcelExecutor {

    private AccountService accountService;

    private List<Orders> excels = new ArrayList<>();

    private ConcurrentHashMap concurrentHashMap;

    public ExcelExecutor(AccountService accountService) {
        this.accountService = accountService;
        concurrentHashMap = new ConcurrentHashMap();
        Iterable<Customer> user = accountService.findUser();
        user.forEach(e -> concurrentHashMap.put(mkKey(e), mkValue(e.getHPrice(), e.getBasePrice())));
    }

    public List<Orders> get() {
        return excels;
    }

    public void load(List<Excel> sourceExcel) {
        List<Orders> excelBos = sourceExcel.stream().map(e -> buildExcelBo(e)).collect(Collectors.toList());
        excels.addAll(excelBos);
    }


    private Orders buildExcelBo(Excel excel) {
        Orders orders = Orders.of(excel);
        String values = concurrentHashMap.getOrDefault(mkKey(orders.getCustomerName(), orders.getDest()), "").toString();
        if (isEmpty(values)) {
            return orders;
        }
        String[] split = values.split("_");
        Double price = Double.valueOf(split[0]);
        Double basePrice = Double.valueOf(split[1]);
        orders.setBasePrice(basePrice)
                .setPriceType(PriceType.HEIGHT.getDesc())
                .setUnitPrice(price);

        orders.setTotalPrice(getTotalPrive(orders));
        orders.setProfit(getProfile(orders));

        return orders;
    }

    private Double getProfile(Orders orders) {
        if (orders.getTotalPrice() != null && orders.getCost() != null)
            return orders.getTotalPrice() - orders.getCost();
        return 0.0d;
    }

    private Double getTotalPrive(Orders orders) {
        Double basePrice = orders.getBasePrice();
        Double height = orders.getQuantity();
        Double hPrice = orders.getUnitPrice();
        Double extra = orders.getExtra();
        Double insuredFee = orders.getInsuredFee();
        if (orders.getTotalPrice() != null && orders.getTotalPrice() != 0) {
            return orders.getTotalPrice();
        }
        double v = hPrice * height + extra + insuredFee;
        return v > basePrice ? v : basePrice;
    }


    private String mkValue(Double hPrice, Double basePrice) {
        return hPrice + "_" + basePrice;
    }

    private String mkKey(Customer e) {
        return e.getName() + "_" + e.getDest();
    }

    private String mkKey(String name, String dest) {
        return name + "_" + dest;
    }
}
