package com.appcenttodo.repositories;

import com.appcenttodo.models.UserDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository  extends JpaRepository<UserDetail,Long> {
    UserDetail findByUsername(String username);
}
