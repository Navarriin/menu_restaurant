package com.navarro.Restaurant.service;

import com.navarro.Restaurant.dto.MenuDTO;

import java.util.List;
import java.util.Optional;

public interface MenuService {

    List<MenuDTO> listAll();
    MenuDTO geById(Long id);
    MenuDTO create(MenuDTO menu);
    MenuDTO update(Long id, MenuDTO menu);
    void delete(Long id);

}
