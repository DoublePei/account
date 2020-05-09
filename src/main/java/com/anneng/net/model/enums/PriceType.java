package com.anneng.net.model.enums;

public enum PriceType {

    HEIGHT(1, "重量"), VRI(2, "体积");

    private int code;
    private String desc;

    PriceType(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public static PriceType of(int code) {
        for (PriceType payType : PriceType.values()) {
            if (payType.code == code) {
                return payType;
            }
        }
        throw new IllegalArgumentException("unsupported dag node type " + code);
    }
    public static PriceType of(String desc) {
        for (PriceType payType : PriceType.values()) {
            if (payType.desc.equals(desc)) {
                return payType;
            }
        }
        throw new IllegalArgumentException("unsupported pay desc type " + desc);
    }

    public int getCode() {
        return this.code;
    }
    public String getDesc() {
        return this.desc;
    }


}
