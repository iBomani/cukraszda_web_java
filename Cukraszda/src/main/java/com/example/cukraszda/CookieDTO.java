package com.example.cukraszda;

public class CookieDTO {
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private String name;
    private String type;
    private Boolean awarded;
    private int price;
    private String unit;
    private String type_free;


    public CookieDTO(int id, String name, String type, Boolean awarded, int price, String unit, String type_free) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.awarded = awarded;
        this.price = price;
        this.unit = unit;
        this.type_free = type_free;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Boolean getAwarded() {
        return awarded;
    }

    public void setAwarded(Boolean awarded) {
        this.awarded = awarded;
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

    public String getType_free() {
        return type_free;
    }

    public void setType_free(String type_free) {
        this.type_free = type_free;
    }

}
