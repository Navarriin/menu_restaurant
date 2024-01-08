package com.navarro.Restaurant.service;

import com.navarro.Restaurant.dtos.MenuDTO;
import com.navarro.Restaurant.model.Menu;
import com.navarro.Restaurant.repository.MenuRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class MenuService {
    @Autowired
    private MenuRepository repository;

    public List<MenuDTO> getList(){
        return repository.findAll()
                .stream().map(MenuDTO::new)
                .collect(Collectors.toList());
    }

    public Menu getOne(Long id){
        Optional<Menu> menuOptional = repository.findById(id);
        if(menuOptional.isPresent()) return menuOptional.get();
        throw new EntityNotFoundException();
    }

    public Menu createFood(MenuDTO body){
        Menu menu = new Menu(body);
        return repository.save(menu);
    }

    public void updateFood(Long id, Menu body){

    }

    public void deleteFood(Long id){

    }
}
