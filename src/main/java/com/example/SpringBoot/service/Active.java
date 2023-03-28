package com.example.SpringBoot.service;

import org.springframework.stereotype.Repository;


public interface Active {
	
	public void run(String name , int age);
	public void sleep(String name , int age);
	public String flyText(String name , int age);

}
