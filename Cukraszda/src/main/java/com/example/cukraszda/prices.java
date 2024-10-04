package com.example.cukraszda;
import jakarta.persistence.*;

@Entity
public class prices {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;



    @ManyToOne
    @JoinColumn(name = "cookie_id", nullable = false)
    private cookies cookie;

    //private int cookie_id;
    private int price;
    private String unit;


    public cookies getCookie() {
        return cookie;
    }

    public void setCookie(cookies cookie) {
        this.cookie = cookie;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
