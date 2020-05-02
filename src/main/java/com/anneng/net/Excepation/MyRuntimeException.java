package com.anneng.net.Excepation;

import lombok.Getter;
import lombok.Setter;

public class MyRuntimeException extends RuntimeException{
    private static final long serialVersionUID = 1L;

    @Getter
    @Setter
    private int errorCode;
    public MyRuntimeException(int errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }
    public MyRuntimeException(String message) {
        super(message);
    }

}
