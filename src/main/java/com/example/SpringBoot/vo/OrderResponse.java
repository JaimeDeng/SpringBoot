package com.example.SpringBoot.vo;

import java.util.ArrayList;

import com.example.SpringBoot.entity.Menu;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)		//定義Json只顯示非null
public class OrderResponse{
	
	public String message;
	
	public String orderMessage;
	
	public String name;

	private Integer price;
	
	private ArrayList<Menu> menuSet = new ArrayList<Menu>();
	
	

	public ArrayList<Menu> getMenuSet() {
		return menuSet;
	}

	public void setMenuSet(ArrayList<Menu> menuSet) {
		this.menuSet = menuSet;
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
	
	
}
