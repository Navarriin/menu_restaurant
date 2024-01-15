package com.navarro.Restaurant.service;

import com.navarro.Restaurant.model.Menu;
import com.navarro.Restaurant.repository.MenuRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

import static com.navarro.Restaurant.utils.MockMenus.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

class MenuServiceTest {

    @Mock
    private MenuRepository menuRepository;

    @InjectMocks
    @Autowired
    private MenuService menuService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getListSuccess() {
        when(menuRepository.findAll()).thenReturn(mockMenuList());

        List<Menu> menuList = this.menuService.getList();

        assertNotNull(menuList);
        assertEquals(menuList.get(0).getId(), ID);
        assertEquals(menuList.get(0).getName(), NAME);
        assertEquals(menuList.get(0).getImage(), IMAGE);
        assertEquals(menuList.get(0).getValue(), VALUE);
    }

    @Test
    void getOneSuccess() {
        Menu menu = mockMenuEntity();
        when(menuRepository.findById(ID)).thenReturn(Optional.of(menu));

        Menu menuOne = menuService.getOne(ID);

        assertNotNull(menuOne);
        assertEquals(menuOne.getId(), ID);
        assertEquals(menuOne.getName(), NAME);
        assertEquals(menuOne.getImage(), IMAGE);
        assertEquals(menuOne.getValue(), VALUE);
    }

    @Test
    void createFood() {
    }

    @Test
    void updateFood() {
    }

    @Test
    void deleteFoodSuccess() {
        Menu menu = mockMenuEntity();
        when(menuRepository.findById(ID)).thenReturn(Optional.of(menu));

        menuService.deleteFood(ID);

        Mockito.verify(menuRepository, times(1)).delete(menu);
    }
}