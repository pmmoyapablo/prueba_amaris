package com.amaris.springboot.domain.entity;

import java.io.Serializable;

public class ListEmployees implements Serializable {
    public ListEmployees(){

    }
    private String message;
    private String status;
    private Data[] data;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Data[] getData() {
        return data;
    }

    public void setData(Data[] data) {
        this.data = data;
    }
}
