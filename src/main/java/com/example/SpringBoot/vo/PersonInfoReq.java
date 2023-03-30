package com.example.SpringBoot.vo;

import java.util.*;

import com.example.SpringBoot.entity.PersonInfo;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class PersonInfoReq{
	
	private String name;
	
	private String gender;
	
	private int age;
	
	private int id;
	
	@JsonProperty("PI_List")
	private ArrayList<PersonInfo> personInfoList = new ArrayList<PersonInfo>();
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public ArrayList<PersonInfo> getPersonInfoList() {
		return personInfoList;
	}

	public void setPersonInfoList(ArrayList<PersonInfo> pluralOfPersonInfo) {
		this.personInfoList = pluralOfPersonInfo;
	}

}
