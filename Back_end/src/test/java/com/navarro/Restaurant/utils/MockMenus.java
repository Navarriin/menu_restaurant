package com.navarro.Restaurant.utils;


import com.navarro.Restaurant.dtos.MenuDTO;
import com.navarro.Restaurant.model.Menu;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class MockMenus {

    public static Long ID = 5L;
    public static String NAME = "Macarrão";
    public static String IMAGE = "https://renata.com.br/images/receitas/87/renata-imagem-receitas-macarrao-ao-molho-rustico-de-tomate-e-bacon-share.jpg";
    public static BigDecimal VALUE = new BigDecimal(75);

    public static MenuDTO mockMenuDTO() {
        return new MenuDTO(ID, NAME, IMAGE, VALUE);
    }
    public static Menu mockMenuEntity(){
        return new Menu(mockMenuDTO());
    }
    public static List<Menu> mockMenuList () {
        Menu menu = mockMenuEntity();
        Menu menuTwo = mockMenuEntity();
        List<Menu> menuList = new ArrayList<>();
        menuList.add(menu);
        menuList.add(menuTwo);
        return menuList;
    }

}
