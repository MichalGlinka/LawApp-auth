package com.example.lawappauth.controller;

import com.example.lawappauth.model.AppUser;
import com.example.lawappauth.model.response.Authentication;
import com.example.lawappauth.model.response.Status;
import com.example.lawappauth.services.Authorization;
import com.example.lawappauth.services.UserRepository;
import com.example.lawappauth.services.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping("/delete")
    public Status delete(@RequestParam String username){
        AppUser user = repository.read(username);
        if (user == null){
            return new Status("No such user",new AppUser("null","null",false));
        }
        userService.deleteUser(user);
        return new Status("User removed",user);
    }

    @GetMapping("/switch")
    public Status swith(@RequestParam String username){
        AppUser user = userService.switchUser(username);
        return new Status("User status switched",user);
    }

    @GetMapping("/add")
    public Status add(@RequestParam String username,@RequestParam String password,@RequestParam String enabled){
        boolean enab = enabled.equals("true");
        AppUser user = new AppUser(username,password,enab);
        repository.create(user);
        return new Status("User created",user);
    }
}