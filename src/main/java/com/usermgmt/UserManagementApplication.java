package com.usermgmt;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.usermgmt")
public class UserManagementApplication {

    public static void main(String[] args) {

        new SpringApplicationBuilder(UserManagementApplication.class).run(args);
    }
}
