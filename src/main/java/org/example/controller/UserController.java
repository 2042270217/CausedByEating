package org.example.controller;

import jakarta.validation.constraints.Pattern;
import org.example.pojo.Result;
import org.example.pojo.User;
import org.example.service.UserService;
import org.example.utils.IdGeneratorUtils;
import org.example.utils.JWTUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    public Result register(@Pattern(regexp = "^\\S{6,16}$") @RequestParam(name = "userName") String userName, @Pattern(regexp = "^\\S{6,16}$") @RequestParam(name = "password") String password) {
        String userId = IdGeneratorUtils.genId();
        User u = userService.findByUserId(userId);
        while (u != null) {
//            /反复测试
            userId = IdGeneratorUtils.genId();
            u = userService.findByUserId(userId);
        }
        //可以注册
        userService.register(userId, password,userName);
        return Result.success(userId);

    }

    @PostMapping("/login")
    public Result login(@RequestParam(name = "userId") String userId, @RequestParam(name = "password") String password) {
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
