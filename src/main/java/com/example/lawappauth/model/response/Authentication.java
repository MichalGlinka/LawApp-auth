package com.example.lawappauth.model.response;

import lombok.Getter;
import lombok.Setter;

@Setter @Getter
public class Authentication {
    boolean authenticated;

    public Authentication(boolean authenticated) {
        this.authenticated = authenticated;
    }

    @Override
    public String toString() {
        return "Authentication{" +
                "authenticated=" + authenticated +
                '}';
    }
}
