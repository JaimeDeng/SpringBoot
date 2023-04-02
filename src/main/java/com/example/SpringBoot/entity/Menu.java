package com.example.SpringBoot.entity;

import java.util.TreeMap;

import javax.persistence.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.SpringBoot.service.Active;
import com.example.SpringBoot.service.Animal;
import com.example.SpringBoot.service.OrderService;

@Entity
@Table(name = "menu")
public class Menu {
	
	@Id
	@Column(name = "name")
	private String name;
	
	@Column(name = "price")
	private Integer price;
	
	private Integer amount;

	public Menu() {
	}
	
	public void setNameAndPrice(String name , Integer price) {
		this.name = name;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}
	
	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	
}
