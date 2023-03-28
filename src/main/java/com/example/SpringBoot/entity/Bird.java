package com.example.SpringBoot.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.SpringBoot.service.Active;
import com.example.SpringBoot.service.Animal;

public class Bird extends Animal {
	
	
	String name = "鳥仔";
	int age = 87;
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Bird(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
}
