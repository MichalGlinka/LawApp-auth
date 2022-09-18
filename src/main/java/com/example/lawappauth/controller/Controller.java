package com.example.lawappauth.controller;

import org.springframework.web.bind.annotation.GetMapping;

@org.springframework.stereotype.Controller
public class Controller {
    @GetMapping("/doc")
    public String getDocs(){
        return "doc.html";
    }
}
