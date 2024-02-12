package com.navarro.Restaurant.service;

import com.navarro.Restaurant.dto.MenuDTO;
import org.springframework.data.crossstore.ChangeSetPersister;

import java.util.List;
import java.util.Optional;

public interface MenuService {

    List<MenuDTO> listAll();
    MenuDTO getById(Long id) throws ChangeSetPersister.NotFoundException;
    MenuDTO create(MenuDTO menu);
    MenuDTO update(Long id, MenuDTO menu);
    void delete(Long id);

}
