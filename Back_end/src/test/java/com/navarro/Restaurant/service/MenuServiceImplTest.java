package com.navarro.Restaurant.service;

import com.navarro.Restaurant.dto.MenuDTO;
import com.navarro.Restaurant.dto.mapper.MenuMapper;
import com.navarro.Restaurant.exceptions.MenuNotFoundException;
import com.navarro.Restaurant.model.Menu;
import com.navarro.Restaurant.repository.MenuRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.MockBeans;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.test.context.ActiveProfiles;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@ActiveProfiles("test")
@ExtendWith(MockitoExtension.class)
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
        menu = new Menu(1L, "Macarrao", "imagem.png", new BigDecimal(34));
        menuDTO = new MenuDTO(1L, "Macarrao", "imagem.png", new BigDecimal(34));
    }

    @Test
    void listAllSuccess() {
        when(menuMapper.toDTO(menu)).thenReturn(menuDTO);
        when(repository.findAll()).thenReturn(Collections.singletonList(menu));

        var result = assertDoesNotThrow(() -> menuService.listAll());

        assertNotNull(result);
        assertFalse(result.isEmpty());
        assertEquals(result, Collections.singletonList(menuDTO));
        assertEquals(1, result.size());
        assertEquals(menuDTO, result.get(0));
    }

    @Test
    void getByIdSuccess() {
        when(menuMapper.toDTO(menu)).thenReturn(menuDTO);
        when(repository.findById(menuDTO.id())).thenReturn(Optional.ofNullable(menu));

        var result = assertDoesNotThrow(() -> menuService.getById(menuDTO.id()));

        assertNotNull(result);
        assertEquals(result, menuDTO);
    }
    @Test
    void getByIdError() {
        when(repository.findById(anyLong())).thenReturn(Optional.empty());

        var result = assertThrows(MenuNotFoundException.class, () -> menuService.getById(1L));
        assertEquals("Menu not found for id: 1", result.getMessage());
    }

    /*
      @Override
    public MenuDTO getById(Long id) {
        return menuRepository.findById(id)
                .map(mapper::toDTO)
                .orElseThrow(NoSuchElementException::new);
    }
     */

}