package com.appcenttodo.services;

import com.appcenttodo.models.UserDetail;
import com.appcenttodo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sound.midi.SysexMessage;
import javax.swing.*;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
@Service
public class UserServiceImpl implements UserService{
    @Autowired
    UserRepository repo;
    @Override
    public void register(UserDetail user) {
        UserDetail registeredUser = new UserDetail();
        registeredUser.setUsername(user.getUsername());
        registeredUser.setPassword(Base64.getEncoder().encodeToString(user.getPassword().getBytes()));
        if(repo.findByUserName(registeredUser.getUsername())==null)  System.out.println("kayıtlı kullanıcı");
        else  repo.save(registeredUser);
    }

    @Override
    public boolean login(UserDetail user) {
        UserDetail currentUser = repo.findByUserName(user.getUsername());

        String pass = Base64.getEncoder().encodeToString(user.getPassword().getBytes());
        if(currentUser.getPassword().equals(pass)) return true;
        else return false;

    }
}
