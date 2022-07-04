package com.appcenttodo.controller;

import com.appcenttodo.models.Task;
import com.appcenttodo.repositories.TaskRepository;
import com.appcenttodo.services.TaskServiceImpl;
import  com.appcenttodo.models.UserDetail;
import com.appcenttodo.services.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "${todo.base-url}")
@CrossOrigin(origins = "http://localhost:3000")
public class TaskController {
    @Autowired
    private TaskServiceImpl taskService;
    @Autowired
    private TaskRepository taskRepo;
    @Autowired
    private UserServiceImpl userService;

   // private boolean isSignedIn = userService.isUserSignedIn();
    @GetMapping("${todo.get-url}")
    public ResponseEntity getTasks() throws Exception {
        if(!userService.isUserSignedIn())
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("You have to sign in first");

        List<Task> allTasks = taskService.getTasks();
        return ResponseEntity.ok().body(allTasks);
    }

    @PostMapping("${todo.post-url}")
    public ResponseEntity<String> addTask(@RequestBody Task taskToAdd){
        if(!userService.isUserSignedIn())
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("You have to sign in first");

        taskService.addTask(taskToAdd);
        return ResponseEntity.ok("Task added successfully"); }

    @PutMapping("${todo.put-url}")
    public ResponseEntity<String> updateTask(@PathVariable Long id, @RequestBody Task taskToUpdate) throws Exception {
        if(!userService.isUserSignedIn())
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("You have to sign in first");
        if( taskRepo.findById(id).get().getUserId() != userService.getCurrentUserId())
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("You can't update this task");
        if( taskRepo.findById(id)== null)
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Invalid task id");
        taskService.updateTask(id,taskToUpdate);

        return ResponseEntity.ok("Task updated successfully");
    }

    @DeleteMapping("${todo.delete-url}")
    public ResponseEntity<String> deleteTask(@PathVariable Long id) throws Exception {
        if(!userService.isUserSignedIn())
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("You have to sign in first");
        if(taskRepo.findById(id).get().getUserId()  != userService.getCurrentUserId())
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("You can't delete this task");
        if( taskRepo.findById(id)== null)
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Invalid task id");
        taskService.deleteTask(id);
        return ResponseEntity.ok("Task deleted successfully");
    }
}
