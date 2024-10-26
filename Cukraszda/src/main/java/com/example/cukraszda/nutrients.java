package com.example.cukraszda;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
public class nutrients {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;



    @OneToOne
    @JoinColumn(name="cookie_id", nullable = false)
    @JsonBackReference
    private cookies cookie;
    //private String cookie_id;
    private String type_free;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public cookies getCookie() {
        return cookie;
    }

    public void setCookie(cookies cookie) {
        this.cookie = cookie;
    }

    public String getType_free() {
        return type_free;
    }

    public void setType_free(String type_free) {
        this.type_free = type_free;
    }
}
