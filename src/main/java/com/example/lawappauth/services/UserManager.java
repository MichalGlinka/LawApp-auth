package com.example.lawappauth.services;

import com.example.lawappauth.model.AppUser;

public interface UserManager {
    public AppUser switchUser(String username,boolean isEnabled);

    public void deleteUser(AppUser appUser);
}
