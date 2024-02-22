package com.navarro.Restaurant.service;

import com.navarro.Restaurant.dto.MenuDTO;
import com.navarro.Restaurant.dto.mapper.MenuMapper;
import com.navarro.Restaurant.exceptions.MenuNotFoundException;
import com.navarro.Restaurant.repository.MenuRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class MenuServiceImpl implements MenuService{

    private final MenuMapper mapper;
    private final MenuRepository menuRepository;

    public MenuServiceImpl(MenuMapper mapper, MenuRepository menuRepository) {
        this.mapper = mapper;
        this.menuRepository = menuRepository;
    }

    @Override
    public List<MenuDTO> listAll() {
        return menuRepository.findAll()
                .stream().map(mapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public MenuDTO getById(Long id) {
        return menuRepository.findById(id)
                .map(mapper::toDTO)
                .orElseThrow(() -> new MenuNotFoundException("Menu not found for id: " + id));
    }

    @Override
    public MenuDTO create(MenuDTO body) {
       return mapper.toDTO(menuRepository.save(mapper.toEntity(body)));
    }

    @Override
    public MenuDTO update(Long id, MenuDTO body) {
        return menuRepository.findById(id).map(data -> {
                    data.setName(body.name());
                    data.setImage(body.image());
                    data.setPrice(body.price());
                    return mapper.toDTO(menuRepository.save(data));
                }).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public void delete(Long id) {
        menuRepository.delete(menuRepository.findById(id)
                .orElseThrow(NoSuchElementException::new));
    }
}
