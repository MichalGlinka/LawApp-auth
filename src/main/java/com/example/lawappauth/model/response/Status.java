package com.example.lawappauth.model.response;

import com.example.lawappauth.model.AppUser;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Status {
    String message;
    AppUser user;

    public Status(String message) {
        this.message = message;
    }

    public Status(AppUser user) {
        this.user = user;
    }

    @Override
    public String toString() {
        if (user == null) {
            return "Status{" +
                    "message='" + message;
        }else {
            return user.toString();
        }
    }
}
