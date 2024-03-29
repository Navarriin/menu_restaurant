package com.navarro.Restaurant.dto;

import com.navarro.Restaurant.model.Menu;

import java.math.BigDecimal;

public record MenuDTO(Long id, String name, String image, BigDecimal price) {

    public MenuDTO(Menu menu) {
        this(menu.getId(), menu.getName(), menu.getImage(), menu.getPrice());
    }
}
