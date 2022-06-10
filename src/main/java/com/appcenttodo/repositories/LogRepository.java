package com.appcenttodo.repositories;

import com.appcenttodo.models.Log;

import org.springframework.data.jpa.repository.JpaRepository;

public interface LogRepository  extends JpaRepository<Log,Long> {
}
