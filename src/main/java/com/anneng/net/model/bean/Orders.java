package com.anneng.net.model.bean;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import com.anneng.net.model.enums.PayType;
import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@Data
@Table("orders")
@Accessors(chain = true)
public class Orders {

    @Id
    @ExcelIgnore
    private Long id;
    @ExcelProperty("寄件日期")
    private String mailDate;
    @ExcelProperty("订单号")
    private String orderNum;
    @ExcelProperty("寄件公司")
    private String customerName;
    @ExcelProperty("省份")
    private String dest;
    @ExcelProperty("收件人")
    private String recipient;
    /**
     * 网点
     */
    @ExcelProperty("目的网点")
    private String outlets;
    @ExcelProperty("发货数量")
    private Double goodsNum;
    @ExcelProperty("发货重量")
    private Double quantity;
    /**
     * 保价费
     */
    @ExcelProperty("保价费")
    private Double insuredFee;
    @ExcelProperty("额外费用")
    private Double extra;
    @ExcelProperty("单价")
    private Double unitPrice;
    @ExcelProperty("支付方式")
    private String payType;
    @ExcelProperty("总金额")
    private Double totalPrice;
    @ExcelProperty("成本")
    private Double cost;
    @ExcelProperty("利润")
    private Double profit;
    @ExcelProperty("起步价")
    private Double basePrice;

    @ExcelProperty("支付方式")
    private String priceType;

    @ExcelProperty("描述信息")
    private String description;
    @ExcelIgnore
    private LocalDateTime createTime;
    @ExcelIgnore
    private LocalDateTime updateTime;


    public Orders copyOrdersIfNotNull(Orders orders) {
        if (orders.getId() != null) this.id = orders.getId();
        if (orders.getOrderNum() != null) this.orderNum = orders.getOrderNum();
        if (orders.getCustomerName() != null) this.customerName = orders.getCustomerName();
        if (orders.getDest() != null) this.dest = orders.getDest();
        if (orders.getRecipient() != null) this.recipient = orders.getRecipient();
        if (orders.getGoodsNum() != null) this.goodsNum = orders.getGoodsNum();
        if (orders.getQuantity() != null) this.quantity = orders.getQuantity();
        if (orders.getInsuredFee() != null) this.insuredFee = orders.getInsuredFee();
        if (orders.getDescription() != null) this.description = orders.getDescription();
        if (orders.getExtra() != null) this.extra = orders.getExtra();
        if (orders.getUnitPrice() != null) this.unitPrice = orders.getUnitPrice();
        if (orders.getPayType() != null) this.payType = orders.getPayType();
        if (orders.getTotalPrice() != null) this.totalPrice = orders.getTotalPrice();
        if (orders.getCost() != null) this.cost = orders.getCost();
        if (orders.getProfit() != null) this.profit = orders.getProfit();
        if (orders.getBasePrice() != null) this.basePrice = orders.getBasePrice();
        if (orders.getOutlets() != null) this.outlets = orders.getOutlets();
        if (orders.getPriceType() != null) this.priceType = orders.getPriceType();
        if (orders.getMailDate() != null) this.mailDate = orders.getMailDate();
        if (orders.getCreateTime() != null) this.createTime = orders.getCreateTime();
        this.updateTime = LocalDateTime.now();
        return this;
    }


    public static Orders of(Excel excel) {
        return new Orders()
                .setMailDate(excel.getMailDate())
                .setOrderNum(excel.getOrderNum())
                .setCustomerName(excel.getCustomerName())
                .setOutlets(excel.getOutlets())
                .setDest(excel.getDest())
                .setRecipient(excel.getRecipient())
                .setGoodsNum(excel.getGoodsNum())
                .setQuantity(excel.getQuantity())
                .setInsuredFee(excel.getInsuredFee())
                .setExtra(excel.getExtra())
                .setPayType(excel.getPayType())
                .setTotalPrice(excel.getTotalPrice())
                .setCost(excel.getCost())
                .setCreateTime(LocalDateTime.now())
                .setUpdateTime(LocalDateTime.now())
                ;
    }

}
