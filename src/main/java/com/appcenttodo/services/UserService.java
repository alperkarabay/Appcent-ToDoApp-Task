package com.appcenttodo.services;

import com.appcenttodo.models.User;

public interface UserService {
    void register(User user);
    boolean login(User user);
}
