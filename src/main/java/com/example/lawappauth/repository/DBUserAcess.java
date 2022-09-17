package com.example.lawappauth.repository;

import com.example.lawappauth.model.AppUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DBUserAcess extends CrudRepository<AppUser, Integer> {
    public AppUser getAppUserByUsername(String username);

    public void deleteAppUserByUsername(String username);
}
