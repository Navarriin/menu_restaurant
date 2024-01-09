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
                .sorted(((obj1, obj2) -> Long.compare(obj1.id(), obj2.id())))
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

    public Menu updateFood(Long id, MenuDTO body){
        Optional<Menu> optional = repository.findById(id);
        if(optional.isPresent()){
            Menu menu = optional.get();
            menu.setName(body.name());
            menu.setImage(body.image());
            menu.setValue(body.value());
            repository.save(menu);
            return menu;
        }
        throw new EntityNotFoundException();
    }

    public void deleteFood(Long id){
        repository.deleteById(id);
    }
}
