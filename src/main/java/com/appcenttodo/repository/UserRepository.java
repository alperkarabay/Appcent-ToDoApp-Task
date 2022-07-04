package com.appcenttodo.repository;

import com.appcenttodo.entity.UserDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository  extends JpaRepository<UserDetail,Long> {
    UserDetail findByUsername(String username);
}
