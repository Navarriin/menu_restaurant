package com.navarro.Restaurant.controller;

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
    public ResponseEntity<List<Menu>> listALl() {
        List<Menu> menuList = menuService.listAll();
        return ResponseEntity.ok().body(menuList);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping
    public ResponseEntity<Menu> create(@RequestBody Menu body) {
        Menu menuList = menuService.create(body);
        return ResponseEntity.ok().body(menuList);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<Menu> update(@PathVariable Long id, @RequestBody Menu body) {
        Menu menu = menuService.update(id, body);
        return ResponseEntity.ok().body(menu);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        menuService.delete(id);
        return ResponseEntity.ok().build();
    }
}
