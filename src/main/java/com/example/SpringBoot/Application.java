package com.example.SpringBoot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import com.example.SpringBoot.entity.*;
import com.example.SpringBoot.service.PersonInfoService;

//@ComponentScan(basePackages = {"com.example.SpringBoot.Repository"})		//掃不到bean時可以指定packages位址
@SpringBootApplication  //(exclude = {DataSourceAutoConfiguration.class })
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		
	}
}
