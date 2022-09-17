package com.example.lawappauth.services;

import com.example.lawappauth.model.AppUser;
import com.example.lawappauth.repository.DBUserAcess;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class UserRepository {
    DBUserAcess acess;

    public UserRepository(DBUserAcess acess) {
        this.acess = acess;
    }

    @Transactional
    public void create(AppUser appUser){
        acess.save(appUser);
    }

    @Transactional
    public void upadte(AppUser appUser){
        create(appUser);
    }

    public AppUser read(String username){
        return acess.getAppUserByUsername(username);
    }

    @Transactional
    public void delete(String username){
        acess.deleteAppUserByUsername(username);
    }
}
