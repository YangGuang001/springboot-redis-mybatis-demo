package com.yang.spring.jedis.springjedisdemo.service.impl;

import com.github.pagehelper.PageHelper;
import com.yang.spring.jedis.springjedisdemo.mapper.UserMapper;
import com.yang.spring.jedis.springjedisdemo.model.User;
import com.yang.spring.jedis.springjedisdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by yz on 2018/7/26.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public int addUser(User user) {
        return userMapper.insertSelective(user);
    }

    @Override
    public List<User> findAllUser(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return userMapper.selectAllUser();
    }
}
