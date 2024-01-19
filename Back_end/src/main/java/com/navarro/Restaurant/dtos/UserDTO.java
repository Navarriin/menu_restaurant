package com.navarro.Restaurant.dtos;

import com.navarro.Restaurant.model.Menu;
import com.navarro.Restaurant.model.User;

import java.util.List;

public record UserDTO(
        Long id,
        String name,
        String password
        //List<Menu> foods
) {
    public UserDTO(User user){
        this(user.getId(), user.getName(), user.getPassword()); //user.getFoods());
    }
}
