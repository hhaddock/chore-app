package com.atlas.menter.service;

import com.atlas.menter.dto.LoginDto;
import com.atlas.menter.dto.UserCreateDto;
import com.atlas.menter.entity.Recipe;
import com.atlas.menter.entity.User;

public interface UserService {

    public abstract User createUser(UserCreateDto user);
    public abstract void updateUser(Long id, User user);
    public abstract void deleteUser(Long id);
//    public abstract Iterable<Recipe> getUsers();

    public abstract User getUserById(Long id);

    public abstract String authenticateUser(LoginDto login);
}
