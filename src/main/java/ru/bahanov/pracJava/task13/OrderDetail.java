package ru.bahanov.pracJava.task13;

import java.util.Date;

public class OrderDetail {
    private int orderId;
    private Date dateOrder;
    private int productId;
    private String name;
    private String description;
    private double price;
    private int quantity;
    private double totalPrice;

    public OrderDetail(int orderId, Date dateOrder, int productId, String name, String description, double price, int quantity, double totalPrice) {
        this.orderId = orderId;
        this.dateOrder = dateOrder;
        this.productId = productId;
        this.name = name;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return "OrderDetail{" +
                "orderId=" + orderId +
                ", dateOrder=" + dateOrder +
                ", productId=" + productId +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                ", totalPrice=" + totalPrice +
                '}';
    }
}