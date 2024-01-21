package com.navarro.Restaurant.foods;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FoodServiceImpl implements FoodService{

    private final FoodRespository foodRespository;

    @Override
    public List<Food> listAll() {
        return foodRespository.findAll();
    }

    @Override
    public Food create(Food food) {
        if(food.getId() != null){
            throw new RuntimeException("To create a record, you cannot have an ID");
        }
        return foodRespository.save(food);
    }

    @Override
    public Food update(Food food) {
        if(food.getId() == null){
            throw new RuntimeException("To update a record, you must have an ID");
        }
        return foodRespository.save(food);
    }

    @Override
    public void delete(Long id) {
        foodRespository.deleteById(id);
    }
}
