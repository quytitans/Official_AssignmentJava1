package entity;

import util.MilisecToDateTime;

import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class Order {
    private String ID;
    private String customer;
    private String product;
    private int totalPrice;
    private int status;
    private long createdAt;

    public Order(String ID, String customer, String product, int totalPrice, int status, long createdAt) {
        this.ID = ID;
        this.customer = customer;
        this.product = product;
        this.totalPrice = totalPrice;
        this.status = status;
        this.createdAt = createdAt;
    }

    public Order(String ID, String customer, String product, int totalPrice, int status) {
        this.ID = ID;
        this.customer = customer;
        this.product = product;
        this.totalPrice = totalPrice;
        this.status = status;
        this.createdAt = Calendar.getInstance().getTimeInMillis();
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getStatus() {
        String Str = null;
        if (this.status == 1) {
            Str = "Paid";
        } else if (this.status == 2) {
            Str = "unpaid";
        } else if (this.status == 0) {
            Str = "Deleted";
        } else {
            Str = "unknow";
        }
        return Str;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(long createdAt) {
        this.createdAt = createdAt;
    }

    public Order() {
    }


    @Override
    public String toString() {
        String strCreatedAt = MilisecToDateTime.convertToDateTime(getCreatedAt());
        return String.format("|%5s%10s%5s|%5s%20s%5s|%5s%15s%5s|%5s%10s%5s|%5s%10s%5s|%5s%15s%5s|",
                "", getID(), "",
                "", getCustomer(), "",
                "", getProduct(), "",
                "", getTotalPrice(), "", "", getStatus(), "", "", strCreatedAt, ""
        );
    }
}
