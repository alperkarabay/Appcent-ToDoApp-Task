package com.appcenttodo.controller;

import com.appcenttodo.models.Task;
import com.appcenttodo.services.TaskServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "${todo.base-url}")
@CrossOrigin(origins = "http://localhost:3000")
public class TaskController {
    @Autowired
    private TaskServiceImpl taskService;


    @GetMapping("${todo.get-url}")
    public ResponseEntity<List<Task>> getTasks(){
        List<Task> allTasks = taskService.getTasks();
        return ResponseEntity.ok().body(allTasks);
    }

    @PostMapping("${todo.post-url}")
    public ResponseEntity<String> addTask(@RequestBody Task taskToAdd){
        taskService.addTask(taskToAdd);
        return ResponseEntity.ok("Task added successfully"); }

    @PutMapping("${todo.put-url}")
    public ResponseEntity<String> updateTask(@PathVariable Long id, @RequestBody Task taskToUpdate) throws Exception {
        taskService.updateTask(id,taskToUpdate);
        return ResponseEntity.ok("Task updated successfully");
    }

    @DeleteMapping("${todo.delete-url}")
    public ResponseEntity<String> deleteTask(@PathVariable Long id) throws Exception {
        taskService.deleteTask(id);
        return ResponseEntity.ok("Task deleted successfully");
    }
}
