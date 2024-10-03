package com.example.cukraszda;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity
public class nutrients {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    private String cookie_id;
    private String type_free;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCookie_id() {
        return cookie_id;
    }

    public void setCookie_id(String cookie_id) {
        this.cookie_id = cookie_id;
    }

    public String getType_free() {
        return type_free;
    }

    public void setType_free(String type_free) {
        this.type_free = type_free;
    }
}
