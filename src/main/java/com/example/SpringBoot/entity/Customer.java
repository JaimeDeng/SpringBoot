package com.example.SpringBoot.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Entity
@Table(name="widget_test")
public class Customer {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "creat_time")
	private String creat_time;
	
	
	public Customer() {
	}
	
	public Customer(Long id, String name, String creat_time) {
		this.id = id;
		this.name = name;
		this.creat_time = creat_time;
	}

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	
	public String getCreat_time() {
		return creat_time;
	}
	
	public void setCreat_time(String creat_time) {
		this.creat_time = creat_time;
	}

//	@Override
//	public String toString() {
//		return "Customer [id=" + id + ", name=" + name +  ", creat_time=" + creat_time + "]";
//	}
	
}
