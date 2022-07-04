package com.appcenttodo.service;

import com.appcenttodo.entity.Task;

import java.util.List;

public interface TaskService {
    List<Task> getTasks();
    void addTask(Task task);
    void updateTask(long id,Task task) throws Exception;
    void deleteTask(long id) throws Exception;



}
