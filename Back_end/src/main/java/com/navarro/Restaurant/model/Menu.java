package com.navarro.Restaurant.model;

import com.navarro.Restaurant.dtos.MenuDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.math.BigDecimal;

@Entity
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String image;
    private BigDecimal value;

    public Menu(){}
    public Menu(Long id, String name, String image, BigDecimal value) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.value = value;
    }

    public Menu(MenuDTO body) {
        this.id = body.id();
        this.name = body.name();
        this.image = body.image();
        this.value = body.value();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }
}
