package com.appcenttodo.services;

import com.appcenttodo.models.Task;
import com.appcenttodo.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class TaskServiceImpl implements TaskService{
    @Autowired
    TaskRepository repo;
    @Override
    public List<Task> getTasks(){
        List<Task> allTasks = repo.findAll();
       return allTasks;
    }
    @Override
    public void addTask(Task task){
        Task taskToAdd = new Task();
        taskToAdd.setTaskTitle(task.getTaskTitle());
        taskToAdd.setStatus(task.getStatus());
        taskToAdd.setCreatedDate(new Date());
        repo.save(taskToAdd);
    }
    @Override
    public void updateTask(long id, Task task) throws Exception {
        Task taskToUpdate = repo.findById(id).orElseThrow(() -> new Exception("Task not found with id : "+ id));
        taskToUpdate.setTaskTitle(task.getTaskTitle());
        taskToUpdate.setStatus(task.getStatus());
        repo.save(taskToUpdate);
        }


    @Override
    public void deleteTask(long id) throws Exception {
        Task taskToDelete = repo.findById(id).orElseThrow(() -> new Exception("Task not found with id : "+ id));
        repo.delete(taskToDelete);
    }
}

