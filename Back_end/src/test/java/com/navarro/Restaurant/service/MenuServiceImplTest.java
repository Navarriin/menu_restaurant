package com.navarro.Restaurant.service;

import com.navarro.Restaurant.dto.MenuDTO;
import com.navarro.Restaurant.dto.mapper.MenuMapper;
import com.navarro.Restaurant.model.Menu;
import com.navarro.Restaurant.repository.MenuRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import org.springframework.test.context.ActiveProfiles;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;


@ActiveProfiles("test")
class MenuServiceImplTest {

    @Mock
    private MenuRepository repository;

    @Mock
    private MenuMapper menuMapper;

    @InjectMocks
    private MenuServiceImpl menuService;

    private Menu menu;
    private MenuDTO menuDTO;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        this.menuDTO = new MenuDTO(1L, "Macarrao", "imagem.png", new BigDecimal(34));
        this.menu = menuMapper.toEntity(menuDTO);
    }

    @Test
    void listAllSuccess() {
        when(menuMapper.toDTO(menu)).thenReturn(menuDTO);
        when(repository.findAll()).thenReturn(Collections.singletonList(menu));

        List<MenuDTO> result = menuService.listAll();

        assertNotNull(result);
        assertFalse(result.isEmpty());
        assertEquals(result, Collections.singletonList(menuDTO));
        assertEquals(1, result.size());
        assertEquals(menuDTO, result.get(0));
    }

    @Test
    void getByIdSuccess() {
        when(menuMapper.toDTO(menu)).thenReturn(menuDTO);
        when(repository.findById(Mockito.anyLong()))
                .thenReturn(Optional.ofNullable(menu));

        MenuDTO result = menuService.getById(1L);

        assertNotNull(result);
        assertThat(result).isEqualTo(menuDTO);
    }

    /*
       @Override
    public MenuDTO geById(Long id) {
        return menuRepository.findById(id)
                .map(mapper::toDTO)
                .orElseThrow(NoSuchElementException::new);
    }
     */

}