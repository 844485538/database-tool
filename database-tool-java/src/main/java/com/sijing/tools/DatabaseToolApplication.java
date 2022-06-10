package com.sijing.tools;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author 李健新
 *
 *    框架模板示例工程
 */
@MapperScan(basePackages = "com.sijing.tools.mapper")
@SpringBootApplication
public class DatabaseToolApplication {

    public static void main(String[] args) {
        SpringApplication.run(DatabaseToolApplication.class, args);
    }

}
