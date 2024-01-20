package com.navarro.Restaurant.service;

import com.navarro.Restaurant.dtos.UserDTO;
import com.navarro.Restaurant.model.User;
import com.navarro.Restaurant.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> getAllUsers(){
        return repository.findAll().stream().toList();
    }

    public User getUserByID(Long id) {
        Optional<User> userById = repository.findById(id);
        if(userById.isPresent()){
            return userById.get();
        }
        throw new NullPointerException();
    }

    public User createUser(UserDTO body) {
        User user = new User();
        user.setName(body.name());
        user.setPassword(body.password());
        return repository.save(user);
    }

    public User updateUser(Long id, UserDTO body) {
        Optional<User> userOptional = repository.findById(id);
        if(userOptional.isPresent()) {
            User getUser = userOptional.get();
            getUser.setName(body.name());
            getUser.setPassword(body.password());
            return getUser;
        }
        throw new NoSuchElementException();
    }
}
