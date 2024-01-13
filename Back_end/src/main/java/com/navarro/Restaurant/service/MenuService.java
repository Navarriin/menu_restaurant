package com.navarro.Restaurant.service;

import com.navarro.Restaurant.dtos.MenuDTO;
import com.navarro.Restaurant.model.Menu;
import com.navarro.Restaurant.repository.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class MenuService {

    @Autowired
    private MenuRepository repository;

    public List<MenuDTO> getList(){
        List<MenuDTO> menuDTOList = repository.findAll()
                .stream().map(MenuDTO::new)
                .sorted(Comparator.comparingLong(MenuDTO::id)).toList();
        if(menuDTOList.isEmpty()) throw new NullPointerException();
        return menuDTOList;
    }

    public Menu getOne(Long id){
        Optional<Menu> menuOptional = repository.findById(id);
        if(menuOptional.isPresent()) return menuOptional.get();
        throw new NoSuchElementException();
    }

    public Menu createFood(MenuDTO body) {
        Menu menu = new Menu();
        try {
            menu.setName(body.name());
            menu.setImage(body.image());
            menu.setValue(body.value());
            return repository.save(menu);
        } catch (IllegalArgumentException err){
            throw new IllegalArgumentException();
        }
    }

    public Menu updateFood(Long id, MenuDTO body){
        Optional<Menu> optional = repository.findById(id);
        if(optional.isPresent()){
            Menu menu = optional.get();
            menu.setName(body.name());
            menu.setImage(body.image());
            menu.setValue(body.value());
            return menu;
        }
        throw new NoSuchElementException();
    }

    public void deleteFood(Long id) {
        Optional<Menu> optionalMenuDTO = repository.findById(id);
        if(optionalMenuDTO.isPresent()) {
            Menu menu = optionalMenuDTO.get();
            repository.delete(menu);
        }
        throw new NoSuchElementException();
    }
}
