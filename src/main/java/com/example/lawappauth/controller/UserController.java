package com.example.lawappauth.controller;

import com.example.lawappauth.exceptions.NoSuchUserException;
import com.example.lawappauth.model.AppUser;
import com.example.lawappauth.model.response.Authentication;
import com.example.lawappauth.model.response.Status;
import com.example.lawappauth.services.Authorization;
import com.example.lawappauth.services.UserRepository;
import com.example.lawappauth.services.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class UserController {
    UserService userService;
    Authorization authorization;
    UserRepository repository;

    public UserController(UserService userService, Authorization authorization,UserRepository repository) {
        this.userService = userService;
        this.authorization = authorization;
        this.repository = repository;
    }

    @GetMapping("/auth")
    public Authentication authenticate(@RequestParam String username, @RequestParam String password){
        boolean auth = authorization.Authenticate(username,password);
        return new Authentication(auth);
    }

    private AppUser checkUser(String username){
        AppUser user = repository.read(username);
        if (user == null){
            throw new NoSuchUserException();
        }else {
            return user;
        }
    }

    @GetMapping("/delete")
    public Status delete(@RequestParam String username){
        try {
            AppUser user = checkUser(username);
            userService.deleteUser(user);
            return new Status(user);
        }catch (NoSuchUserException e){
            return new Status("No such user");
        }
    }

    @GetMapping("/switch")
    public Status swith(@RequestParam String username){
        try {
            checkUser(username);
            AppUser user = userService.switchUser(username);
            return new Status(user);
        }catch (NoSuchUserException e){
            return new Status("No such user");
        }
    }

    @GetMapping("/add")
    public Status add(@RequestParam String username,@RequestParam String password,@RequestParam String enabled){
        try {
            checkUser(username);
            return new Status("User already exists");
        }catch (NoSuchUserException e){
            boolean enab = enabled.equals("true");
            AppUser user = new AppUser(username,password,enab);
            repository.create(user);
            return new Status(user);
        }
    }

    @GetMapping("/reset")
    public Status resetPassword(@RequestParam String username,@RequestParam String password){
        try {
            int id = checkUser(username).getId();
            AppUser user = new AppUser(id,username,password,true);
            repository.upadte(user);
            return new Status(user);
        }catch (NoSuchUserException e){
            return new Status("No such user");
        }
    }

    @GetMapping("/read")
    public Status readUser(@RequestParam String username){
        try {
            AppUser user = checkUser(username);
            return new Status(user);
        }catch (NoSuchUserException e){
            return new Status("No such user");
        }
    }

    @GetMapping("/readAll")
    public ArrayList<AppUser> readAll(){
        return repository.readAll();
    }
}