package com.appcenttodo.controller;



import com.appcenttodo.models.User;
import com.appcenttodo.services.UserServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "${user.base-url}")
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {
    @Autowired
    private UserServiceImpl userService;



    @PostMapping("${user.validation-url}")
    public ResponseEntity<Boolean> validateUser(@RequestBody User user){
        boolean isValidate = userService.login(user);
        return ResponseEntity.ok().body(isValidate);
    }

    @PostMapping("${user.post-url}")
    public ResponseEntity<String> addTask(@RequestBody User user){
        userService.register(user);
        return ResponseEntity.ok("User registered successfully"); }
}
