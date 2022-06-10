package com.appcenttodo.services;

import com.appcenttodo.models.Log;
import com.appcenttodo.models.Task;
import com.appcenttodo.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TaskServiceImpl implements TaskService{
    @Autowired
    TaskRepository repo;
    @Autowired
    LogServiceImpl logService;
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
        repo.save(taskToAdd);
        createLog(taskToAdd,0);
    }
    @Override
    public void updateTask(long id, Task task) throws Exception {

        Task taskToUpdate = repo.findById(id).orElseThrow(() -> new Exception("Task not found with id : "+ id));
        taskToUpdate.setTaskTitle(task.getTaskTitle());
        taskToUpdate.setStatus(task.getStatus());
        repo.save(taskToUpdate);
        createLog(taskToUpdate,id);
        }


    @Override
    public void deleteTask(long id) throws Exception {
        Task taskToDelete = repo.findById(id).orElseThrow(() -> new Exception("Task not found with id : "+ id));
        repo.delete(taskToDelete);
    }

    public void createLog(Task task,long id){
        Log log = new Log();
        log.setCreatedDate(LocalDateTime.now());
        if(repo.findById(id).isPresent()){
            log.setDescription("Task with the id " + id + " updated");
        }
        else{
            log.setDescription("New task created with task id " + task.getId() );
        }

        logService.addLog(log);
    }
}

