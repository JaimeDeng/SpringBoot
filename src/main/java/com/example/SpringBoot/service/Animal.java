package com.example.SpringBoot.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class Animal implements Active {

	@Override
	public String flyText(String name , int age) {
		 return String.format("%s%d歲 , 正在飛", name , age);
	}
	@Override
	public void run(String name , int age) {
		System.out.println(name + age + "歲 , 正在跑");
	}
	@Override
	public void sleep(String name , int age) {
		System.out.println(name + age + "歲 , 正在睡搞搞");
	}

}
