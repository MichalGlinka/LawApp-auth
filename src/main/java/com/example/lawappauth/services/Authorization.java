package com.example.lawappauth.services;

import com.example.lawappauth.model.AppUser;
import org.springframework.stereotype.Service;

@Service
public class Authorization implements Authorize{
    UserRepository repository;

    public Authorization(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public boolean Authenticate(String username, String password) {
        AppUser userReaded = repository.read(username);
        if (userReaded != null && userReaded.isEnabled()){
            return userReaded.getPassword().equals(password);
        }else {
            return false;
        }
    }
}
