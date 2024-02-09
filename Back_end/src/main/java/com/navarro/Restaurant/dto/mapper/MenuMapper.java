package com.navarro.Restaurant.dto.mapper;
import com.navarro.Restaurant.dto.MenuDTO;
import com.navarro.Restaurant.model.Menu;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class MenuMapper {

    public MenuDTO toDTO(Menu menu) {
        if(Objects.isNull(menu)) return null;

        return new MenuDTO(menu);
    }

    public Menu toEntity(MenuDTO menuDTO) {
        if(Objects.isNull(menuDTO)) return null;

        Menu menu = new Menu();
        if(Objects.nonNull(menuDTO.id())) menu.setId(menuDTO.id());

        menu.setName(menuDTO.name());
        menu.setImage(menuDTO.image());
        menu.setPrice(menuDTO.price());

        return menu;
    }
}
