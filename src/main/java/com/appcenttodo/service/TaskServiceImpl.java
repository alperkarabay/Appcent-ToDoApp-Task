package com.appcenttodo.service;

import com.appcenttodo.entity.Log;
import com.appcenttodo.entity.Task;
import com.appcenttodo.enums.LogStatus;
import com.appcenttodo.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TaskServiceImpl implements TaskService{
    @Autowired
    TaskRepository taskRepository;
    @Autowired
    LogServiceImpl logService;

    @Autowired
    UserServiceImpl userService;
    @Override
    public List<Task> getTasks(){
        List<Task> allTasks = taskRepository.findAllByUserId(Math.toIntExact(userService.getCurrentUserId()));
        return allTasks;
    }
    @Override
    public void addTask(Task task){
        Task taskToAdd = new Task();
        taskToAdd.setTaskTitle(task.getTaskTitle());
        taskToAdd.setStatus(task.getStatus());
        taskToAdd.setUserId(Math.toIntExact(userService.getCurrentUserId()));
        taskRepository.save(taskToAdd);
        createLog(taskToAdd,LogStatus.POST);
    }
    @Override
    public void updateTask(long id, Task task) throws Exception {

        Task taskToUpdate = taskRepository.findById(id).orElseThrow(() -> new Exception("Task not found with id : "+ id));
        if(task.getTaskTitle()!=null)
             taskToUpdate.setTaskTitle(task.getTaskTitle());
        if(task.getStatus()!=null)
            taskToUpdate.setStatus(task.getStatus());
        taskRepository.save(taskToUpdate);
        createLog(taskToUpdate,LogStatus.UPDATE);
        }


    @Override
    public void deleteTask(long id) throws Exception {
        Task taskToDelete = taskRepository.findById(id).orElseThrow(() -> new Exception("Task not found with id : "+ id));
        taskRepository.delete(taskToDelete);
        createLog(taskToDelete,LogStatus.DELETE);
    }

    public void createLog(Task task, LogStatus request){
        Log log = new Log();
        log.setCreatedDate(LocalDateTime.now());
        if(request == LogStatus.UPDATE){
            log.setDescription("Task with the id " + task.getId() + " updated by user " + userService.getCurrentUserId());
        } else if (request == LogStatus.DELETE) {
            log.setDescription("Task with the id " + task.getId() + " deleted by user " + userService.getCurrentUserId());
        } else if(request == LogStatus.POST){
            log.setDescription("New task created with task id " + task.getId() + " by user" + userService.getCurrentUserId());
        }

        logService.addLog(log);
    }
}

