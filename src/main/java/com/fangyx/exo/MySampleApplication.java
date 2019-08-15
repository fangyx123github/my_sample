package com.fangyx.exo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

@MapperScan("com.fangyx.exo.mapper")
@SpringBootApplication
@Configuration
public class MySampleApplication /*extends WebMvcConfigurationSupport */{


    public static void main(String[] args) {
        SpringApplication.run(MySampleApplication.class, args);
    }

}
