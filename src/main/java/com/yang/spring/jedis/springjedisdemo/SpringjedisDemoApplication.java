package com.yang.spring.jedis.springjedisdemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@MapperScan("com.yang.spring.jedis.springjedisdemo.mapper")
@EnableCaching
public class SpringjedisDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringjedisDemoApplication.class, args);
    }

}

