package com.appcenttodo.services;

import com.appcenttodo.models.Log;
import com.appcenttodo.repositories.LogRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.time.LocalDateTime;
import java.util.List;
@Service
public class LogServiceImpl implements LogService{
    @Autowired
    LogRepository repo;
    @Override
    public List<Log> getLogs() {
        List<Log> allLogs = repo.findAll();
        return allLogs;
    }

    @Override
    public void addLog(Log log) {
        Log logToAdd = new Log();
        logToAdd.setDescription(log.getDescription());
        logToAdd.setCreatedDate(LocalDateTime.now());
        repo.save(logToAdd);

    }
}
