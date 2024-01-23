package com.navarro.Restaurant.service;

import com.navarro.Restaurant.dto.MenuDTO;
import com.navarro.Restaurant.dto.mapper.MenuMapper;
import com.navarro.Restaurant.model.Menu;
import com.navarro.Restaurant.repository.MenuRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MenuServiceImpl implements MenuService{

    private final MenuRepository menuRepository;
    private final MenuMapper mapper;
    @Override
    public List<MenuDTO> listAll() {
        return menuRepository.findAll()
                .stream().map(mapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public MenuDTO geById(Long id) {
        return menuRepository.findById(id)
                .map(mapper::toDTO)
                .orElseThrow(NullPointerException::new);
    }

    @Override
    public MenuDTO create(MenuDTO body) {
       return mapper.toDTO(menuRepository.save(mapper.toEntity(body)));
    }

    @Override
    public MenuDTO update(Long id, MenuDTO body) {
        return menuRepository.findById(id)
                .map(data -> {
                    data.setName(body.name());
                    data.setImage(body.image());
                    data.setPrice(body.price());
                    return mapper.toDTO(menuRepository.save(data));
                }).orElseThrow(NullPointerException::new);
    }

    @Override
    public void delete(Long id) {
        menuRepository.delete(menuRepository.findById(id)
                .orElseThrow(NullPointerException::new));
    }
}
