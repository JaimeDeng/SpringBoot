package com.example.SpringBoot.controller;

import java.util.ArrayList;
import java.util.List;

import javax.activation.DataSource;
import javax.annotation.Resource;
import javax.persistence.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.SpringBoot.entity.*;
import com.example.SpringBoot.Dao.JpaDemoDao;
import com.example.SpringBoot.service.Active;
import com.example.SpringBoot.service.Animal;
import com.example.SpringBoot.service.OrderService;


public class JpaDemoController {
	
	@Autowired
	JpaDemoDao jpaDemoDao;
	
	@Autowired
	DataSource dataSource;
	
	@GetMapping("/demo")
    public String demo(){
	
		List<JpaDemo> JpaDemo= new ArrayList<JpaDemo>();
		JpaDemo = jpaDemoDao.findByName("Jaime");
	
		for(int i=0;i<JpaDemo.size();i++){
			System.out.println(JpaDemo.get(i).getId());
		}
	    return "addMemberPage";

	}
}
