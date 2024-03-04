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
import org.mockito.exceptions.misusing.PotentialStubbingProblem;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.ActiveProfiles;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.Objects;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

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
        when(repository.findById(menu.getId())).thenReturn(Optional.empty());

        var result = assertThrows(MenuNotFoundException.class, () -> menuService.getById(menu.getId()));
        assertEquals("Menu not found for id: 1", result.getMessage());
    }

    @Test
    void createFoodSuccess() {
        when(menuMapper.toDTO(menu)).thenReturn(menuDTO);
        when(repository.save(menuMapper.toEntity(menuDTO))).thenReturn(menu);

        var result = assertDoesNotThrow(() -> menuService.create(menuDTO));

        assertNotNull(result);
        assertEquals(result, menuDTO);
    }

    @Test
    void createFoodError() {
        when(menuMapper.toDTO(menu)).thenReturn(menuDTO);
        when(repository.save(menuMapper.toEntity(menuDTO))).thenReturn(null);

        assertThrows(PotentialStubbingProblem.class ,() -> menuService.create(null));
    }

    @Test
    void updateFoodSuccess() {
        when(repository.save(any())).thenReturn(menu);
        when(menuMapper.toDTO(menu)).thenReturn(menuDTO);
        when(repository.findById(menuDTO.id())).thenReturn(Optional.ofNullable(menu));

        assertDoesNotThrow(() -> menuService.update(menuDTO.id(), menuDTO));
        verify(repository, times(1)).findById(menuDTO.id());
        verify(repository, times(1))
                .save(argThat(savedMenu ->
                        savedMenu.getName().equals(menuDTO.name()) &&
                        savedMenu.getImage().equals(menuDTO.image()) &&
                        Objects.equals(savedMenu.getPrice(), menuDTO.price())
                ));

    }

    @Test
    void updateFoodError() {
        when(repository.findById(menuDTO.id())).thenReturn(Optional.empty());

        var result = assertThrows(MenuNotFoundException.class, () -> menuService.update(menuDTO.id(), menuDTO));
        assertEquals("Menu not found for id: 1", result.getMessage());
        verify(repository, times(1)).findById(menuDTO.id());
        verify(repository, never()).save(any());

    }

    @Test
    void deleteFoodSuccess() {
        when(repository.findById(menuDTO.id())).thenReturn(Optional.ofNullable(menu));

        assertDoesNotThrow(() -> menuService.delete(menuDTO.id()));
        verify(repository, times(1)).delete(menu);
    }

    @Test
    void deleteFoodError() {
        when(repository.findById(anyLong())).thenReturn(Optional.empty());

        var result = assertThrows(MenuNotFoundException.class, () -> menuService.delete(1L));
        assertEquals("Menu not found for id: 1", result.getMessage());
        verify(repository, Mockito.never()).delete(Mockito.any());
    }

}