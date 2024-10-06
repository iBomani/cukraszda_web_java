package com.example.cukraszda;

import java.time.LocalDateTime;

public class MessageDTO {
    private String name;
    private String title;
    private String content;
    private LocalDateTime date;

    public MessageDTO(String name, String title, String content, LocalDateTime date) {
        this.name = name;
        this.title = title;
        this.content = content;
        this.date = date;
    }

    public MessageDTO(String title, String content, LocalDateTime date) {
        this("Vendég", title, content, date);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
