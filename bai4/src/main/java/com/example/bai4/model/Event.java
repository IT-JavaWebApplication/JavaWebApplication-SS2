package com.example.bai4.model;

public class Event {
    private int id;
    private String name;
    private String date;
    private double price;
    private int remainingTickets;

    // Constructor 5 tham số
    public Event(int id, String name, String date, double price, int remainingTickets) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.price = price;
        this.remainingTickets = remainingTickets;
    }

    // Các Getters (Bắt buộc phải có để JSP EL như ${event.name} có thể đọc được dữ liệu)
    public int getId() { return id; }
    public String getName() { return name; }
    public String getDate() { return date; }
    public double getPrice() { return price; }
    public int getRemainingTickets() { return remainingTickets; }
}