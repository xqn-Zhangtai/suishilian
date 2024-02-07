package com.bxkj.suishilian.demo.demos.controller;

import com.bxkj.suishilian.demo.demos.dao.UserRepository;
import com.bxkj.suishilian.demo.demos.entity.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.core.annotation.AuthenticationPrincipal;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.crypto.password.PasswordEncoder;
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
//    @Autowired
//    private PasswordEncoder passwordEncoder;


    @PutMapping("/user/ModifiedUser")
    @ApiOperation(value = "更新用户信息", notes = "根据提供的用户信息更新用户")
    public ResponseEntity<User> ModifiedUser(@RequestBody User userDetails) {
        Long id = userDetails.getId(); // 从 userDetails 中获取 ID

        return userRepository.findById(id)
                .map(user -> {
                    user.setUsername(userDetails.getUsername());
                    user.setPassword(userDetails.getPassword());
                    // 其他属性的更新
                    User updatedUser = userRepository.save(user);
                    return ResponseEntity.ok(updatedUser);
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
    @PostMapping("/user/CreateUser")
    @ApiOperation(value = "添加新的最新用户信息", notes = "添加新的最新资讯信息")
    public ResponseEntity<User> CreateUser(@RequestBody User user) {
        User createdUser = userRepository.save(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
    }


    @DeleteMapping("/user/DeleteUser/{id}")
    @ApiOperation(value = "根据id删除最新用户信息", notes = "Deletes a Honor by ID")
    public ResponseEntity<Void> DeleteUser(@PathVariable Long id) {
        userRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
    @PostMapping("/user/GetUserAll")
    @ApiOperation(value = "返回最新用户信息的集合", notes = "返回所有最新资讯信息的集合")
    public ResponseEntity<List<User>> GetUserAll() {
        List<User> user = userRepository.findAll();
        return ResponseEntity.ok(user);
    }
    @PostMapping("/user/Login")
    @ApiOperation(value = "用户登录", notes = "返回所有最新资讯信息的集合")
    public ResponseEntity<User> Login(@RequestParam String strUser, @RequestParam String strPwd) {
        User user = userRepository.findByLoginNameAndPassword(strUser, strPwd);

        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build(); // 返回未授权状态码
        }
    }



}
