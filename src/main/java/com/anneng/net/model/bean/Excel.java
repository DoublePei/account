package com.anneng.net.model.bean;

import lombok.Data;

import java.util.Date;

@Data
public class Excel {
    /**
     * 日期
     */
    private String mailDate;
    /**
     * 运单号
     */
    private String orderNum;
    /**
     * 寄件公司
     */
    private String customerName;
    /**
     * 目的网点
     */
    private String outlets;
    /**
     * 省份
     */
    private String dest;
    /**
     * 收件客户
     */
    private String recipient;
    /**
     * 数量
     */
    private Double goodsNum;
    /**
     * 重量
     */
    private Double quantity;
    /**
     * 保价费
     */
    private Double insuredFee;
    /**
     * 额外收费
     */
    private Double extra;
    /**
     * 支付方式
     */
    private Integer payType;

    /**
     * 成本
     */
    private Double cost;
    /**
     * 总金额
     */
    private Double totalPrice;
}
