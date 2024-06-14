package com.kmSystem;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.kmSystem.mapper")//注解指定当前项目中的mapper接口路径位置，在项目加载时自动加载所有接口
public class LqkCommodityManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(LqkCommodityManagementApplication.class, args);
    }

}
