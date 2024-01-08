package com.navarro.Restaurant.dtos;

import com.navarro.Restaurant.model.Menu;

import java.math.BigDecimal;

public record MenuDTO(
         Long id,
         String name,
         String image,
         String description,
         BigDecimal value
) {
    public MenuDTO (Menu menu) {
        this(menu.getId(), menu.getName(), menu.getImage(), menu.getDescription(), menu.getValue());
    }
}
