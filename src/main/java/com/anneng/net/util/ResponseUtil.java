package com.anneng.net.util;

public class ResponseUtil {

    public static <T> ApiResponse success(T data) {
        return new ApiResponse<>(ApiResponse.OK, 200, ApiResponse.SUCCESS, data);
    }

    public static <T> ApiResponse success(T data, String message) {
        return new ApiResponse<>(ApiResponse.OK, 200, message, data);
    }

    public static ApiResponse error(String message) {
        return new ApiResponse<>(ApiResponse.ERROR, 200, message, null);
    }

    public static ApiResponse error(int code, String message) {
        return new ApiResponse<>(ApiResponse.ERROR, code, message, null);
    }
}
