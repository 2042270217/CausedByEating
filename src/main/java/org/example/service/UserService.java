package org.example.service;

import org.example.pojo.User;

public interface UserService {
    User findByUserId(String userId);

    void register(String userId, String password,String userName);
}
