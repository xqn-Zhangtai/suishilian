package com.bxkj.suishilian.demo.demos.controller;

import com.bxkj.suishilian.demo.demos.dao.UserRepository;
import com.bxkj.suishilian.demo.demos.entity.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @PutMapping("/user/ModifiedUser")
    @ApiOperation(value = "更新用户信息", notes = "根据提供的用户信息更新用户")
    public ResponseEntity<User> ModifiedUser(@RequestBody User userDetails) {
        Long id = userDetails.getId(); // 从 userDetails 中获取 ID

        return userRepository.findById(id)
                .map(user -> {
                    user.setLoginName(userDetails.getLoginName());
                    user.setPassword(userDetails.getPassword());
                    user.setIsAction(userDetails.getIsAction());
                    user.setCreateTime(userDetails.getCreateTime());
                    // 其他属性的更新
                    User updatedUser = userRepository.save(user);
                    return ResponseEntity.ok(updatedUser);
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/user/Login")
    @ApiOperation(value = "用户登录", notes = "返回所有最新资讯信息的集合")
    public ResponseEntity<User> Login(@RequestParam String strUser, @RequestParam String strPwd) {
        // 对输入的密码进行 SHA-256 加密处理，然后与数据库中的密码进行比较
        String hashedPassword = toSHA256(strPwd);
        User user = userRepository.findByLoginNameAndPassword(strUser, hashedPassword);

        if (user != null) {

            if (user.getPassword().equals(hashedPassword)) {
                // 密码匹配，返回用户信息
                return ResponseEntity.ok(user);
            }
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build(); // 返回未授权状态码
        }
        // 用户不存在或密码不匹配时返回未授权状态码
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }
    @PostMapping("/user/Register")
    @ApiOperation(value = "用户注册", notes = "注册新用户")
    public ResponseEntity<User> registerUser(@RequestParam String strUser, @RequestParam String strPwd) {
        // 检查用户是否已经存在于系统中，如果不存在则注册新用户
        User existingUser = userRepository.findByLoginName(strUser);
        if (existingUser != null) {
            // 如果用户已经存在，则返回状态码表示冲突或其他适当的状态码
            return ResponseEntity.status(HttpStatus.CONFLICT).build(); // 返回状态码表示冲突
        } else {
            // 如果用户不存在，则创建新用户并保存到数据库
            User newUser = new User();
            newUser.setLoginName(strUser);
            newUser.setPassword(toSHA256(strPwd));
            newUser.setIsAction("true");
            // 获取当前的日期时间
            LocalDateTime now = LocalDateTime.now();
            // 定义日期时间格式
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
            // 格式化日期时间
            String formattedDateTime = now.format(formatter);
            newUser.setCreateTime(formattedDateTime);
            // 可以设置其他用户属性并保存到数据库
             userRepository.save(newUser);

            // 返回新注册的用户信息
            return ResponseEntity.ok(newUser);
        }
    }
    @PostMapping("/user/GetUserAll")
    @ApiOperation(value = "返回最新用户信息的集合", notes = "返回所有最新资讯信息的集合")
    public ResponseEntity<List<User>> GetUserAll() {
        List<User> user = userRepository.findAll();
        return ResponseEntity.ok(user);
    }
//    @PostMapping("/user/CreateUser")
//    @ApiOperation(value = "添加新的最新用户信息", notes = "添加新的最新资讯信息")
//    public ResponseEntity<User> CreateUser(@RequestBody User user) {
//        User createdUser = userRepository.save(user);
//        return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
//    }


    @DeleteMapping("/user/DeleteUser/{id}")
    @ApiOperation(value = "根据id删除最新用户信息", notes = "Deletes a Honor by ID")
    public ResponseEntity<Void> DeleteUser(@PathVariable Long id) {
        userRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
