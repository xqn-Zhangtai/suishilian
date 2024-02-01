package com.bxkj.suishilian.demo.demos.dao;

import com.bxkj.suishilian.demo.demos.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


//import org.springframework.transaction.annotation.Transactional;
public interface UserRepository extends JpaRepository<User, Long>{
    @Query("SELECT u FROM User u WHERE u.LoginName = :login_name and u.Password = :Password")
    User findByLoginNameAndPassword(@Param("login_name")String LoginName, @Param("Password")String Password);

    @Query("SELECT u FROM User u WHERE u.LoginName = :login_name")
    User findByLoginName(@Param("login_name")String loginName);
}
