package com.example.lawappauth.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Setter @Getter
public class AppUser {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String username;
    String password;
    boolean enabled;
    boolean admin;

    public AppUser(String username, String password, boolean enabled, boolean admin) {
        this.username = username;
        this.password = password;
        this.enabled = enabled;
        this.admin = admin;
    }

    public AppUser(int id, String username, String password, boolean enabled, boolean admin) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.enabled = enabled;
        this.admin = admin;
    }

    public AppUser() {
    }

    @Override
    public String toString() {
        return "AppUser{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", enabled=" + enabled +
                ", admin=" + admin +
                '}';
    }
}
