package com.appcenttodo.services;

import com.appcenttodo.models.UserDetail;
import com.appcenttodo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.sound.midi.SysexMessage;
import javax.swing.*;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
@Service
public class UserServiceImpl implements UserService{
    @Autowired
    UserRepository repo;
    private boolean isSignedIn;
    private Long currentUserId;
    @Override
    public boolean isUserSignedIn(){
        return this.isSignedIn;
    }
    @Override
    public Long getCurrentUserId(){
        return this.currentUserId;
    }
    @Override
    public void register(UserDetail user) {
        UserDetail registeredUser = new UserDetail();
        registeredUser.setUsername(user.getUsername());
        registeredUser.setPassword(Base64.getEncoder().encodeToString(user.getPassword().getBytes()));
        if(repo.findByUsername(user.getUsername())!=null)  System.out.println("kayıtlı kullanıcı");
        else  repo.save(registeredUser);
    }

    @Override
    public boolean login(UserDetail user) {
        UserDetail currentUser = repo.findByUsername(user.getUsername());
        this.currentUserId = currentUser.getId();

        String pass = Base64.getEncoder().encodeToString(user.getPassword().getBytes());
        if(currentUser.getPassword().equals(pass)){
            this.isSignedIn =true;
            return true;
        }
        else return false;

    }
    @Override
    public boolean signOut(){
        this.isSignedIn = false;
        return true;
    }
}
