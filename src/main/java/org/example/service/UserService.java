package org.example.service;

import org.example.pojo.User;

public interface UserService {
    User findByUserId(String userId);

    void register(String userId, String password,String userName);

    void update(User user);

    void updateImg(String userImg);

    boolean updatePassword(String password);
}
