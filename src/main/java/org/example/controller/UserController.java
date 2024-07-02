package org.example.controller;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import org.example.pojo.Result;
import org.example.pojo.User;
import org.example.service.UserService;
import org.example.utils.IdGeneratorUtils;
import org.example.utils.JWTUtils;
import org.example.utils.ThreadLocalUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

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
        userService.register(userId, password, userName);
        return Result.success(userId);

    }

    @PostMapping("/login")
    public Result login(@Pattern(regexp = "^\\S{6,16}$") @RequestParam(name = "userId") String userId, @Pattern(regexp = "^\\S{6,16}$") @RequestParam(name = "password") String password) {
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

    @PutMapping("/update")
    public Result update(@RequestBody @Validated User user) {
        userService.update(user);
        return Result.success();
    }

    @PutMapping("/updateImg")
    public Result updateImg(@NotEmpty String userImg) {
        userService.updateImg(userImg);
        return Result.success();
    }

    @PutMapping("/updatePassword")
    public Result updatePassword(@Pattern(regexp = "^\\S{6,16}$") @RequestParam(name = "password") String password) {
        boolean check = userService.updatePassword(password);
        if (!check) {
            return Result.error("新密码不能与原密码相同");
        }
        return Result.success();
    }

    @GetMapping("/get")
    public Result<User> get() {
        Map<String, Object> map = ThreadLocalUtils.get();
        String userId = (String) map.get("userId");
        var u = userService.findByUserId(userId);
        return Result.success(u);
    }
}
