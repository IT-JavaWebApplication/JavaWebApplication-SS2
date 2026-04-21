package com.example.bai3.model;

import java.util.Date;

public class Order {
    private String id;
    private String name;
    private double price;
    private Date date;

    // Constructor nhanh để tạo dữ liệu mẫu
    public Order(String id, String name, double price, Date date) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.date = date;
    }

    // Getter
    public String getId() { return id; }
    public String getName() { return name; }
    public double getPrice() { return price; }
    public Date getDate() { return date; }
}