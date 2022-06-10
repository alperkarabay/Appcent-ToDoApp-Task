package com.appcenttodo.services;

import com.appcenttodo.models.Log;

import java.util.List;

public interface LogService {
    List<Log> getLogs();
    void addLog(Log log);
}
