package com.navarro.Restaurant.service;

import com.navarro.Restaurant.model.Menu;
import com.navarro.Restaurant.repository.MenuRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class MenuServiceTest {

    @InjectMocks
    private MenuService menuService;

    @Mock
    private MenuRepository menuRepository;

    private Menu firstFood;
    private Menu secondFood;
    private Menu lastFood;



    @BeforeEach
    private void setUp() {
        this.firstFood = new Menu("Macarrão", "https://example.com/macarrao.jpg", new BigDecimal(76));
        this.secondFood = new Menu("Arroz", "https://example.com/arroz.jpg", new BigDecimal(50));
        this.lastFood = new Menu("Feijão", "https://example.com/feijao.jpg", new BigDecimal(60));
    }

    @Test
    public void getAllFoods() {
        List<Menu> menuList = new ArrayList<>();

        menuList.add(firstFood);
        menuList.add(secondFood);
        menuList.add(lastFood);

        when(this.menuRepository.findAll()).thenReturn(menuList);

        List<Menu> menuListReal = menuService.getList();

    }

    @Test
    public void saveTheFood() {

    }
}