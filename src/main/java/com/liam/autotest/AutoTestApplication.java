package com.liam.autotest;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan(value = {"com.liam.autotest.sys.dao"})
@SpringBootApplication
public class AutoTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(AutoTestApplication.class, args);
    }

}
