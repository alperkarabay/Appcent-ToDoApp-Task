package com.appcenttodo.services;

import com.appcenttodo.models.User;
import com.appcenttodo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
@Service
public class UserServiceImpl implements UserService{
    @Autowired
    UserRepository repo;
    @Override
    public void register(User user) {
        User registeredUser = new User();
        registeredUser.setEmail(user.getEmail());
        registeredUser.setPassword(Base64.getEncoder().encodeToString(user.getPassword().getBytes()));
        repo.save(registeredUser);
    }

    @Override
    public boolean login(User user) {
        User currentUser = repo.findByEmail(user.getEmail());

        String pass = Base64.getEncoder().encodeToString(user.getPassword().getBytes());
        if(currentUser.getPassword().equals(pass)) return true;
        else return false;

    }
}
