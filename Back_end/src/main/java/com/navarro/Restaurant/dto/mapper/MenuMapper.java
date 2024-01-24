package com.navarro.Restaurant.dto.mapper;
import com.navarro.Restaurant.dto.MenuDTO;
import com.navarro.Restaurant.model.Menu;
import org.springframework.stereotype.Component;

@Component
public class MenuMapper {

    public MenuDTO toDTO(Menu menu) {
        if(menu == null) return null;

        return new MenuDTO(menu);
    }

    public Menu toEntity(MenuDTO menuDTO) {
        if(menuDTO == null) return null;

        Menu menu = new Menu();
        if(menuDTO.id() != null) menu.setId(menuDTO.id());

        menu.setName(menuDTO.name());
        menu.setImage(menuDTO.image());
        menu.setPrice(menuDTO.price());

        return menu;
    }
}
