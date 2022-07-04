package com.appcenttodo.repository;

import com.appcenttodo.entity.Log;

import org.springframework.data.jpa.repository.JpaRepository;

public interface LogRepository  extends JpaRepository<Log,Long> {
}
