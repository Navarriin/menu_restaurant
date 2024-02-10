package com.navarro.Restaurant.controller;

import com.navarro.Restaurant.dto.MenuDTO;
import com.navarro.Restaurant.service.MenuService;
import jakarta.transaction.Transactional;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("food")
public class MenuController {

    private final MenuService menuService;

    public MenuController(MenuService menuService) {
        this.menuService = menuService;
    }

    @GetMapping
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public ResponseEntity<List<MenuDTO>> listALl() {
        List<MenuDTO> menuList = menuService.listAll();
        return ResponseEntity.ok().body(menuList);
    }

    @GetMapping("/{id}")
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public ResponseEntity<MenuDTO> getFoodById(@PathVariable Long id) {
        MenuDTO menuById = menuService.getById(id);
        return ResponseEntity.ok().body(menuById);
    }

    @PostMapping
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public ResponseEntity<MenuDTO> create(@RequestBody MenuDTO body) {
        MenuDTO menuList = menuService.create(body);
        return ResponseEntity.ok().body(menuList);
    }

    @Transactional
    @PutMapping("/{id}")
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public ResponseEntity<MenuDTO> update(@PathVariable Long id, @RequestBody MenuDTO body) {
        MenuDTO menu = menuService.update(id, body);
        return ResponseEntity.ok().body(menu);
    }

    @DeleteMapping("/{id}")
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        menuService.delete(id);
        return ResponseEntity.ok().build();
    }
}
