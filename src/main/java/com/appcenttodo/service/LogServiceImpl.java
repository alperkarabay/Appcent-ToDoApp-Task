package com.appcenttodo.service;

import com.appcenttodo.entity.Log;
import com.appcenttodo.repository.LogRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.time.LocalDateTime;
import java.util.List;
@Service
public class LogServiceImpl implements LogService{
    @Autowired
    LogRepository logRepository;
    @Override
    public List<Log> getLogs() {
        List<Log> allLogs = logRepository.findAll();
        return allLogs;
    }

    @Override
    public void addLog(Log log) {
        Log logToAdd = new Log();
        logToAdd.setDescription(log.getDescription());
        logToAdd.setCreatedDate(LocalDateTime.now());
        logRepository.save(logToAdd);

    }
}
