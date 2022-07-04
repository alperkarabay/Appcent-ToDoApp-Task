package com.appcenttodo.service;

import com.appcenttodo.entity.UserDetail;
import com.appcenttodo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Base64;
@Service
public class UserServiceImpl implements UserService{
    @Autowired
    UserRepository userRepository;
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
        if(userRepository.findByUsername(user.getUsername())!=null)  System.out.println("kayıtlı kullanıcı");
        else  userRepository.save(registeredUser);
    }

    @Override
    public boolean login(UserDetail user) {
        UserDetail currentUser = userRepository.findByUsername(user.getUsername());
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
