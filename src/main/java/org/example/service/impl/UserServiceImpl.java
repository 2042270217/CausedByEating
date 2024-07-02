package org.example.service.impl;

import org.example.mapper.UserMapper;
import org.example.pojo.Result;
import org.example.pojo.User;
import org.example.service.UserService;
import org.example.utils.ThreadLocalUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    @Override
    public User findByUserId(String userId) {
        return userMapper.findByUserId(userId);
    }

    @Override
    public void register(String userId, String password, String userName) {
        userMapper.add(userId, password, userName);
    }

    @Override
    public void update(User user) {
        Map<String, Object> map = ThreadLocalUtils.get();
        String userId = (String) map.get("userId");
        userMapper.update(user.getUserName(), user.getUserSex(), userId);
    }

    @Override
    public void updateImg(String userImg) {
        Map<String, Object> map = ThreadLocalUtils.get();
        String userId = (String) map.get("userId");
        userMapper.updateImg(userImg, userId);

    }

    @Override
    public boolean updatePassword(String password) {
        Map<String, Object> map = ThreadLocalUtils.get();
        String userId = (String) map.get("userId");
        String oldPassword = userMapper.findPasswordByUserId(userId);
        if(password.equals(oldPassword)) {
            //原密码不能与新密码相同
            return false;
        }

        userMapper.updatePassword(password, userId);
        return true;
    }
}
