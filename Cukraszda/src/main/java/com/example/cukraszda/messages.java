package com.example.cukraszda;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class messages {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    @ManyToOne
    @JoinColumn(name="user_id")
    private users user;

    //private int user_id;
    private String title;
    private String content;
    private LocalDateTime date;


    public users getUser() {
        return user;
    }

    public void setUser(users user) {
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
}
