package com.navarro.Restaurant.foods;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/food")
@RequiredArgsConstructor
public class FoodController {

    private final FoodService foodService;

    @PreAuthorize("hasRole('PRODUCT_SELECT')")
    @GetMapping
    public List<Food> listAll() {
        return foodService.listAll();
    }

    @PreAuthorize("hasRole('PRODUCT_CREATE')")
    @PostMapping
    public Food create(@RequestBody Food food){
        return foodService.create(food);
    }

    @PreAuthorize("hasRole('PRODUCT_UPDATE')")
    @PutMapping
    public Food update(@RequestBody Food food){
        return foodService.update(food);
    }

    @PreAuthorize("hasRole('PRODUCT_DELETE')")
    @DeleteMapping
    public void delete(@RequestParam("id") Long id){
        foodService.delete(id);
    }
}
