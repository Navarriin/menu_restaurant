package com.navarro.Restaurant.controller;

import com.navarro.Restaurant.dtos.UserDTO;
import com.navarro.Restaurant.model.User;
import com.navarro.Restaurant.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> getAll() {
        List<User> allPersons = userService.getAllPersons();
        return ResponseEntity.ok().body(allPersons);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getAll(Long id) {
        UserDTO personById = userService.getPersonByID(id);
        return ResponseEntity.ok().body(personById);
    }
}
