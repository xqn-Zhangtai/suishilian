package com.bxkj.suishilian.demo.demos.controller;

import com.bxkj.suishilian.demo.demos.dao.UserRepository;
import com.bxkj.suishilian.demo.demos.entity.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import java.util.List;

import static com.bxkj.suishilian.demo.demos.utils.toSHA256.toSHA256;

@RestController
@RequestMapping("/api")
@Api(tags = "User")
//解决跨域的问题
//@CrossOrigin(origins = {"http://localhost:8080","http://192.168.1.5:8080/"})
@CrossOrigin(origins = "*")
public class UserAPIController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/api/register")
    public String registerUser(@RequestBody User user) {
        // 加密用户密码
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        // 保存用户
        userRepository.save(user);
        return "User registered successfully";
    }

    @GetMapping("/api/login")
    public ResponseEntity<User> getCurrentUserInfo(@AuthenticationPrincipal UserDetails userDetails) {
        // Assuming there's a method to find a user by username
        User user = userRepository.findByUsername(userDetails.getUsername());
        if (user != null) {
            return ResponseEntity.ok(user);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }



}
