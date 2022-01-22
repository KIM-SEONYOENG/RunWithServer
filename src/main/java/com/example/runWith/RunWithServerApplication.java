package com.example.runWith;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
@MapperScan
@SpringBootApplication
public class RunWithServerApplication {
	public static void main(String[] args) {
		SpringApplication.run(RunWithServerApplication.class, args);
	}

}
