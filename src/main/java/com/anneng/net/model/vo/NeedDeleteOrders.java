package com.anneng.net.model.vo;

import com.anneng.net.model.bean.Orders;
import lombok.Data;

import java.util.List;

@Data
public class NeedDeleteOrders {
    private List<Long> orders;
}
