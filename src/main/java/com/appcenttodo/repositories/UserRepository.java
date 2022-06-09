package com.appcenttodo.repositories;

import com.appcenttodo.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository  extends JpaRepository<User,Long> {
    @Query(value= "select password from tbl_users where email = ?1", nativeQuery = true)
    User findByEmail(String email);
}
