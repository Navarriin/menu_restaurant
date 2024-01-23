package com.navarro.Restaurant.controller;

import com.navarro.Restaurant.dto.MenuDTO;
import com.navarro.Restaurant.model.Menu;
import com.navarro.Restaurant.service.MenuService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("food")
@RequiredArgsConstructor
public class MenuController {

    private final MenuService menuService;

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping
    public ResponseEntity<List<MenuDTO>> listALl() {
        List<MenuDTO> menuList = menuService.listAll();
        return ResponseEntity.ok().body(menuList);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/{id}")
    public ResponseEntity<MenuDTO> getFoodById(@PathVariable Long id) {
        MenuDTO menuById = menuService.geById(id);
        return ResponseEntity.ok().body(menuById);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping
    public ResponseEntity<MenuDTO> create(@RequestBody MenuDTO body) {
        MenuDTO menuList = menuService.create(body);
        return ResponseEntity.ok().body(menuList);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PutMapping("/{id}")
    public ResponseEntity<MenuDTO> update(@PathVariable Long id, @RequestBody MenuDTO body) {
        MenuDTO menu = menuService.update(id, body);
        return ResponseEntity.ok().body(menu);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        menuService.delete(id);
        return ResponseEntity.ok().build();
    }
}
