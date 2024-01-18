package com.navarro.Restaurant.service;

import com.navarro.Restaurant.dtos.UserDTO;
import com.navarro.Restaurant.model.User;
import com.navarro.Restaurant.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> getAllPersons() {
        return repository.findAll();
    }

    public UserDTO getPersonByID(Long id) {
        Optional<User> personById = repository.findById(id);
        if(personById.isPresent()){
            User user = personById.get();
            return new UserDTO(user);
        }
        throw new NullPointerException();
    }
}
