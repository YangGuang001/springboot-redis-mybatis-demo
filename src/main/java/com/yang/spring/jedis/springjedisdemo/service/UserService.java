package com.yang.spring.jedis.springjedisdemo.service;

import com.yang.spring.jedis.springjedisdemo.model.User;

import java.util.List;

/**
 * Created by yz on 2018/7/26.
 */
public interface UserService {
    int addUser(User user);

    List<User> findAllUser(int pageNum, int pageSize);
}
