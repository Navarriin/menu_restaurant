package com.navarro.Restaurant.repository;

import com.navarro.Restaurant.model.Menu;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.math.BigDecimal;
import java.util.List;

@DataJpaTest
class MenuRepositoryTest {

    @Autowired
    private MenuRepository menuRepository;

    private Menu firstFood;

    @BeforeEach
    private void setUp() {
        this.firstFood = new Menu(
                "Macarrão",
                "https://bakeandcakegourmet.com.br/uploads/site/receitas/macarrao-com-sardinha-3-qdu2sdl2.jpg",
                new BigDecimal(76));
    }

    @Test
    public void saveFood() {
        Menu saveFood = menuRepository.save(this.firstFood);

        Assertions.assertNotNull(saveFood);
        Assertions.assertNotNull(saveFood.getId());
        Assertions.assertEquals(this.firstFood, saveFood);
    }

}