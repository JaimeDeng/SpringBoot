package com.example.SpringBoot.entity;

import javax.persistence.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.SpringBoot.service.Active;
import com.example.SpringBoot.service.Animal;
import com.example.SpringBoot.service.OrderService;

@Entity
@Table(name = "widget_test")
public class JpaDemo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;
	
	@Id
	@Column(name = "name")
	private String name;
	
	@Id
	@Column(name = "create_time")
	private String create_time;

	public long getId() {
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

	public String getCreate_time() {
		return create_time;
	}

	public void setCreate_time(String create_time) {
		this.create_time = create_time;
	}
	
	
	
}
