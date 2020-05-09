package com.anneng.net.model.bean;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
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
    @ExcelProperty(value = "寄件日期", index = 0)
    private String mailDate;
    @ExcelProperty(value = "运单号", index = 1)
    private String orderNum;
    @ExcelProperty(value = "寄件公司", index = 2)
    private String customerName;
    @ExcelProperty(value = "省份", index = 3)
    private String dest;
    @ExcelProperty(value = "收件客户", index = 5)
    private String recipient;
    /**
     * 网点
     */
    @ExcelProperty(value = "目的网点", index = 4)
    private String outlets;
    @ExcelProperty(value = "件数", index = 8)
    private Double goodsNum;
    @ExcelProperty(value = "重量/体积", index = 7)
    private Double quantity;
    /**
     * 保价费
     */
    @ExcelProperty(value = "保价费", index = 9)
    private Double insuredFee;
    @ExcelProperty(value = "附加费", index = 12)
    private Double extra;
    @ExcelProperty(value = "单价", index = 10)
    private Double unitPrice;
    @ExcelProperty(value = "计费方式", index = 6)
    private String payType;
    @ExcelProperty(value = "总金额", index = 14)
    private Double totalPrice;
    @ExcelProperty(value = "成本", index = 15)
    private Double cost;
    @ExcelProperty(value = "利润", index = 16)
    private Double profit;
    @ExcelProperty(value = "起步价", index = 11)
    private Double basePrice;

    @ExcelProperty(value = "支付方式", index = 13)
    private String priceType;

    @ExcelProperty(value = "备注", index = 17)
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
