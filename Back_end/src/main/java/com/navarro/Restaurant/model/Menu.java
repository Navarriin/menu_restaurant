package com.navarro.Restaurant.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.navarro.Restaurant.dtos.MenuDTO;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

@Entity
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    private String name;

    private String image;

    @NotNull
    private BigDecimal value;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private User user;

    public Menu(){}

    public Menu(String name, String image, BigDecimal value){
        this.name = name;
        this.image = image;
        this.value = value;
    }

    public Menu(Long id, String name, String image, BigDecimal value) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.value = value;
    }

    public Menu(MenuDTO menuDTO) {
        this.id = menuDTO.id();
        this.name = menuDTO.name();
        this.image = menuDTO.image();
        this.value = menuDTO.value();
    }

    public Long getId() {
        return id;
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
