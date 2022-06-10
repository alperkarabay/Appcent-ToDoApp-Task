package com.appcenttodo.services;


import com.appcenttodo.models.UserDetail;


public interface UserService {
    void register(UserDetail user);
    boolean login(UserDetail user);

}
