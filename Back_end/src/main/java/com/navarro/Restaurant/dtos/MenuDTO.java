package com.navarro.Restaurant.dtos;

import com.navarro.Restaurant.model.Menu;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.util.List;

public record MenuDTO(
        Long id,
        @NotNull String name,
        String image,
        @NotNull BigDecimal value
) {
    public MenuDTO (Menu menu) {
        this(menu.getId(), menu.getName(), menu.getImage(), menu.getValue());
    }
}
