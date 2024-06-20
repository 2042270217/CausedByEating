package org.example.controller;

import jakarta.validation.constraints.Pattern;
import org.example.pojo.Result;
import org.example.pojo.User;
import org.example.service.UserService;
import org.example.utils.JWTUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
@Validated
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public Result register(@Pattern(regexp = "^\\S{5,16}$") String userId, @Pattern(regexp = "^\\S{5,16}$") String password) {
        User u = userService.findByUserId(userId);
        if (u == null) {
            //注册
            userService.register(userId, password);
            return Result.success();
        } else {
            return Result.error("用户名已占用");
        }
    }

    @PostMapping("/login")
    public Result login(@Pattern(regexp = "^\\S{5,16}$") String userId, @Pattern(regexp = "^\\S{5,16}$") String password) {
        User u = userService.findByUserId(userId);
        if (u == null) {
            return Result.error("用户不存在");
        } else {
            if (password.equals(u.getPassword())) {
                Map<String, Object> claims;
                claims = new HashMap<>();
                claims.put("userId", u.getUserId());
                claims.put("userName", u.getUserName());
                String token = JWTUtils.genToken(claims);
                return Result.success(token);
            } else {
                return Result.error("密码错误");
            }
        }
    }
}
