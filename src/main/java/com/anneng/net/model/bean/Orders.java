package com.anneng.net.model.bean;

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
    private Long id;
    private String orderNum;
    private String customerName;
    private String dest;
    private String recipient;
    private Double goodsNum;
    private Double quantity;
    /**
     * 保价费
     */
    private Double insuredFee;
    private Double desc;
    private Double extra;
    private Double unitPrice;
    private Integer payType;
    private Double totalPrice;
    private Double cost;
    private Double profit;
    private Double basePrice;

    /**
     * 网点
     */
    private String outlets;
    private Integer priceType;
    private String mailDate;
    private LocalDateTime createTime;
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
        if (orders.getDest() != null) this.dest = orders.getDest();
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
                ;
    }

}
