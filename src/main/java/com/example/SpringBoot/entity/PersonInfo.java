package com.example.SpringBoot.entity;

import java.util.*;

import javax.persistence.*;

import org.springframework.beans.factory.annotation.*;


@Entity
@Table(name = "personinfo")
public class PersonInfo {
	
	@Id
	@Column(name = "id")
	private int id;
	
	@Column(name = "age")
	private int age;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "gender")
	private String gender;
	
	public PersonInfo() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

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
	
	public void setPersonInfo(int id , String name , int age , String gender) {
		this.id = id;
		this.age = age;
		this.name = name;
		this.gender = gender;
	}
}
