package com.navarro.Restaurant.service;

import com.navarro.Restaurant.model.Menu;
import com.navarro.Restaurant.repository.MenuRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MenuServiceImpl implements MenuService{

    private final MenuRepository menuRepository;
    @Override
    public List<Menu> listAll() {
        return menuRepository.findAll();
    }

    @Override
    public Menu geById(Long id) {
        Optional<Menu> menuOptional = menuRepository.findById(id);
        if(menuOptional.isPresent()) {
        return menuOptional.get();
        }
        throw new NullPointerException();
    }

    @Override
    public Menu create(Menu menu) {
        return menuRepository.save(menu);
    }

    @Override
    public Menu update(Long id, Menu body) {
        Optional<Menu> menuOptional = menuRepository.findById(id);
        if (menuOptional.isPresent()){
            Menu food = menuOptional.get();
            food.setName(body.getName());
            food.setImage(body.getImage());
            food.setPrice(body.getPrice());
            return food;
        }
        throw new NullPointerException();
    }

    @Override
    public void delete(Long id) {
        Menu menu = menuRepository.findById(id)
                .orElseThrow(NullPointerException::new);
        menuRepository.delete(menu);
    }
}
