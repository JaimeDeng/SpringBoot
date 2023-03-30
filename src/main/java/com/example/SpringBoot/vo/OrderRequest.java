package com.example.SpringBoot.vo;

import java.util.ArrayList;
import java.util.LinkedHashMap;

import javax.persistence.Column;

import com.example.SpringBoot.entity.Menu;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;

public class OrderRequest {
	
	private String name;
	
	private Integer price;
	
	private LinkedHashMap<String , Integer> order = new LinkedHashMap<String , Integer>();
	
	private ArrayList<Menu> menuSet = new ArrayList<Menu>();
	
	
	public ArrayList<Menu> getMenuSet() {
		return menuSet;
	}

	public OrderRequest() {
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

	public LinkedHashMap<String, Integer> getOrder() {
		return order;
	}

	public void setOrder(LinkedHashMap<String, Integer> order) {
		this.order = order;
	}
	
	
	
}
