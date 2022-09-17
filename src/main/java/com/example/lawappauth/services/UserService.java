package com.example.lawappauth.services;

import com.example.lawappauth.model.AppUser;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserManager{
    UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public AppUser switchUser(String username) {
        AppUser readUser = repository.read(username);
        readUser.setEnabled(!readUser.isEnabled());
        return readUser;
    }

    @Override
    public void deleteUser(AppUser appUser) {
        repository.delete(appUser.getUsername());
    }
}
