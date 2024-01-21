package com.navarro.Restaurant.foods;

import org.springframework.stereotype.Service;

import java.util.List;

public interface FoodService {
    List<Food> listAll();
    Food create(Food food);
    Food update(Food food);
    void delete(Long id);
}
