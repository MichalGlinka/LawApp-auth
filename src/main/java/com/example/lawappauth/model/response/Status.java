package com.example.lawappauth.model.response;

import com.example.lawappauth.model.AppUser;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Status {
    String message;
    AppUser user;

    public Status(String message, AppUser user) {
        this.message = message;
        this.user = user;
    }

    @Override
    public String toString() {
        return "Status{" +
                "message='" + message + '\'' +
                "," + user.toString();
    }
}
