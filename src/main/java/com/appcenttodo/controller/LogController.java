package com.appcenttodo.controller;

import com.appcenttodo.entity.Log;
import com.appcenttodo.service.LogServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping(value = "${log.base-url}")
public class LogController {
    @Autowired
    private LogServiceImpl logService;

    @GetMapping("${log.get-url}")
    public ResponseEntity<List<Log>> getLogs(){
        List<Log> allLogs = logService.getLogs();
        return ResponseEntity.ok().body(allLogs);
    }
}
