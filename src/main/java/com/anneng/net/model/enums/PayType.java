package com.anneng.net.model.enums;

public enum PayType {

    MONTH_PAY(1, "月结"), CASCH(2, "现金"), ARRIVE_PAY(2, "到付"), PAYED(4, "已结");

    private int code;
    private String desc;

    PayType(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public static PayType of(int code) {
        for (PayType payType : PayType.values()) {
            if (payType.code == code) {
                return payType;
            }
        }
        throw new IllegalArgumentException("unsupported dag node type " + code);
    }

    public int getCode() {
        return this.code;
    }

}