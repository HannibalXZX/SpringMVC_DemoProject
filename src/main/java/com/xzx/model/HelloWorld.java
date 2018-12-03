package com.xzx.model;

public class HelloWorld {

    private String data;

    public HelloWorld() {
        super();
    }

    public HelloWorld(String data) {
        super();
        this.data = data;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "HelloWorld [data=" + data + "]";
    }

}
