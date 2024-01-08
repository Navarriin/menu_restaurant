package com.navarro.Restaurant.controller;

import com.navarro.Restaurant.dtos.MenuDTO;
import com.navarro.Restaurant.model.Menu;
import com.navarro.Restaurant.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("food")
public class MenuController {
    @Autowired
    private MenuService menuService;

    @GetMapping
    public ResponseEntity<List<MenuDTO>> getAll() {
        List<MenuDTO> menuList = menuService.getList();
        return ResponseEntity.ok().body(menuList);
    }

    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable Long id) {
        Menu menu = menuService.getOne(id);
        return ResponseEntity.ok().body(menu);
    }

    @PostMapping
    public ResponseEntity create(@RequestBody MenuDTO body) {
        Menu menu = menuService.createFood(body);
        return ResponseEntity.ok().body(menu);
    }
}
