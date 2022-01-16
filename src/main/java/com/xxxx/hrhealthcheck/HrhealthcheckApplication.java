package com.xxxx.hrhealthcheck;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.xxxx.hrhealthcheck.dao")
@SpringBootApplication
public class HrhealthcheckApplication {

    public static void main(String[] args) {
        SpringApplication.run(HrhealthcheckApplication.class, args);
    }

}
