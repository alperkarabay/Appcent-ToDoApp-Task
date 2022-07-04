package com.appcenttodo.service;

import com.appcenttodo.entity.Log;

import java.util.List;

public interface LogService {
    List<Log> getLogs();
    void addLog(Log log);
}
