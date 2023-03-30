package com.example.SpringBoot.vo;

import java.util.Optional;

import com.example.SpringBoot.entity.PersonInfo;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(JsonInclude.Include.NON_EMPTY)		//定義Json只顯示非null&非空白
public class PersonInfoRes{

	@JsonInclude(Include.NON_DEFAULT)
	private int id;
	
	@JsonInclude(Include.NON_DEFAULT)
	private int age;
	
	public String message;

	private String gender;

	private String name;
	
	private Optional<PersonInfo> personInfo;

	public Optional<PersonInfo> getPersonInfo() {
		return personInfo;
	}

	public void setPersonInfo(Optional<PersonInfo> personInfo) {
		this.personInfo = personInfo;
	}

	public void setPersonInfo(int id , String name , int age , String gender) {
		this.id = id;
		this.age = age;
		this.name = name;
		this.gender = gender;
	}
	
}
