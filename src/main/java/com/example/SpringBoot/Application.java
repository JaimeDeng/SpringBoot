package com.example.SpringBoot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

import com.example.SpringBoot.entity.*;
import com.example.SpringBoot.service.*;
import com.example.SpringBoot.Dao.*;

//@ComponentScan(basePackages = {"com.example.SpringBoot.Dao"})		//掃不到bean時可以指定packages位址
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		
	}
}
