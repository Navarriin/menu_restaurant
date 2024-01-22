package com.navarro.Restaurant.service;

import com.navarro.Restaurant.model.Menu;

import java.util.List;

public interface MenuService {
    List<Menu> listAll();
    Menu geById(Long id);
    Menu create(Menu menu);
    Menu update(Long id, Menu menu);
    void delete(Long id);

}
