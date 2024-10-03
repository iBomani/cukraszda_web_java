package com.example.cukraszda;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity
public class prices {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    private int cookie_id;
    private int price;
    private String unit;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCookie_id() {
        return cookie_id;
    }

    public void setCookie_id(int cookie_id) {
        this.cookie_id = cookie_id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }
}
