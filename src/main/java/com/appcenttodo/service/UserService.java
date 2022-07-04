package com.appcenttodo.service;


import com.appcenttodo.entity.UserDetail;


public interface UserService {
    void register(UserDetail user);
    boolean login(UserDetail user);
    boolean isUserSignedIn();
    Long getCurrentUserId();
    boolean signOut();
}
