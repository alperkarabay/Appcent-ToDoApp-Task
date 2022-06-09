package com.appcenttodo.services;

import com.appcenttodo.models.User;
import com.appcenttodo.repositories.UserRepository;

public class UserServiceImpl implements UserService{
    UserRepository repo;
    @Override
    public void register(User user) {
        User registeredUser = new User();
        registeredUser.setEmail(user.getEmail());
        registeredUser.setPassword(user.getPassword());
    }

    @Override
    public boolean login(String email,String password) {
        User currentUser = repo.findByEmail(email);
        String pass = currentUser.getPassword();
        if(password.equals(pass)) return true;
        else return false;

    }
}
