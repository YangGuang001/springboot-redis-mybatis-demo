package com.yang.spring.jedis.springjedisdemo.mapper;

import com.yang.spring.jedis.springjedisdemo.model.User;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;

public interface UserMapper {
    final String PREF = "demo";

    int deleteByPrimaryKey(Integer userId);

    int insert(User record);

    @CachePut(value = PREF, key = "#record.userId")
    int insertSelective(User record);

    User selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    @Cacheable(value = PREF, key = "#root.methodName")
    List<User> selectAllUser();
}