package com.example.SpringBoot.entity;

import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.SpringBoot.service.Active;
import com.example.SpringBoot.service.Animal;
import com.example.SpringBoot.service.OrderService;

public class Menu {
	
	private TreeMap<String , Integer> menuMap = new TreeMap<String , Integer>();
	
	public TreeMap<String, Integer> getMenuMap() {
		return menuMap;
	}

	public void setMenuMap(String name , int price) {
		menuMap.put(name, price);
	}
	
}
