package com.example.Vault1X.dto;

import java.time.LocalDateTime;

public class ApiResponseDto<T> {
    private boolean success;
    private String message;
    private T data;
    private LocalDateTime timeStamp;

    public ApiResponseDto() {
        this.timeStamp = LocalDateTime.now();
    }

    public ApiResponseDto(boolean success, String message, T data) {
        this();
        this.success = success;
        this.message = message;
        this.data = data;
    }

    public static <T> ApiResponseDto<T> success(T data) {
        return new ApiResponseDto<>(true, "RequestSuccessful", data);
    }

    public static <T> ApiResponseDto<T> success(String message, T data) {
        return new ApiResponseDto<>(true, message, data);
    }

    public static <T> ApiResponseDto<T> error(String message) {
        return new ApiResponseDto<>(false, message, null);
    }

    public static <T> ApiResponseDto<T> error(String message, T data) {
        return new ApiResponseDto<>(false, message, data);
    }

    public boolean issuccess() {
        return success;
    }

    public void setsuccess(boolean success) {
        this.success = success;
    }

    public String getmessage() {
        return message;
    }

    public void setmessage(String message) {
        this.message = message;
    }

    public T getdata() {
        return data;
    }

    public void setdata(T data) {
        this.data = data;
    }

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(LocalDateTime timeStamp) {
        this.timeStamp = timeStamp;
    }

}