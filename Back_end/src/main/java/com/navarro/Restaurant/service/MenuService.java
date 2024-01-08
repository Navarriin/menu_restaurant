package com.navarro.Restaurant.service;

import com.navarro.Restaurant.dtos.MenuDTO;
import com.navarro.Restaurant.model.Menu;
import com.navarro.Restaurant.repository.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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

    public void getOne(Long id){

    }

    public Menu createFood(Menu body){
        return repository.save(body);
    }

    public void updateFood(Long id, Menu body){

    }

    public void deleteFood(Long id){

    }
}
