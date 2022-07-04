package com.appcenttodo.services;


import com.appcenttodo.models.UserDetail;
import org.springframework.stereotype.Service;


public interface UserService {
    void register(UserDetail user);
    boolean login(UserDetail user);
    boolean isUserSignedIn();
    Long getCurrentUserId();
    boolean signOut();
}
