package com.navarro.Restaurant.service;

import com.navarro.Restaurant.dto.MenuDTO;

import java.util.List;

public interface MenuService {

    List<MenuDTO> listAll();
    MenuDTO getById(Long id);
    MenuDTO create(MenuDTO menu);
    MenuDTO update(Long id, MenuDTO menu);
    void delete(Long id);

}
