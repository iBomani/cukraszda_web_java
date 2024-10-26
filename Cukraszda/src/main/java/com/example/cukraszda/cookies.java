package com.example.cukraszda;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

@Entity
public class cookies {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    private String name;
    private String type;
    private Boolean awarded;



    @OneToOne(mappedBy = "cookie", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private prices price;


    @OneToOne(mappedBy = "cookie", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private nutrients nutrient;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public prices getPrice() {
        return price;
    }

    public void setPrice(prices price) {
        this.price = price;
    }

    public nutrients getNutrient() {
        return nutrient;
    }

    public void setNutrient(nutrients nutrient) {
        this.nutrient = nutrient;
    }
}
