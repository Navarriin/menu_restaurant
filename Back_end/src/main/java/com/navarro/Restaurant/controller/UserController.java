package com.navarro.Restaurant.controller;

import com.navarro.Restaurant.dtos.UserDTO;
import com.navarro.Restaurant.model.User;
import com.navarro.Restaurant.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping
    public ResponseEntity<List<User>> getAll() {
        List<User> allUsers = userService.getAllUsers();
        return ResponseEntity.ok().body(allUsers);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getById(Long id) {
        User userById = userService.getUserByID(id);
        return ResponseEntity.ok().body(new UserDTO(userById));
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping
    public ResponseEntity<UserDTO> getById(@RequestBody UserDTO body) {
        User userById = userService.createUser(body);
        return ResponseEntity.ok().body(new UserDTO(userById));
    }
}
