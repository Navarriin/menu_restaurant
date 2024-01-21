package com.navarro.Restaurant.foods;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodRespository extends JpaRepository<Food, Long> {
}
