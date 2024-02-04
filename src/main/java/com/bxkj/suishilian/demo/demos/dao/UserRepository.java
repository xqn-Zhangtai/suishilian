package com.bxkj.suishilian.demo.demos.dao;

import com.bxkj.suishilian.demo.demos.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


//import org.springframework.transaction.annotation.Transactional;
public interface UserRepository extends JpaRepository<User, Long>{
    User findByUsername(String username);
}
