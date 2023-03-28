package com.example.SpringBoot.service;

import java.util.ArrayList;
import java.util.IllegalFormatException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

import org.springframework.stereotype.Service;
import com.example.SpringBoot.entity.Menu;

@Service
public class OrderServiceImpl implements OrderService {

	Menu menu = new Menu();
	Scanner scan = new Scanner(System.in);
	
	@Override
	public void setMenu(String name , int price) {
		menu.getMenuMap().put(name, price);
	}
	
	@Override
	public void menuInfo() {
		System.out.println();
		System.out.println("=※=※=※=※ MENU ※=※=※=※=");
		for (Map.Entry<String, Integer> entry : menu.getMenuMap().entrySet()) {
			System.out.println("         " + entry.getKey() + " " + entry.getValue() + "元");
		}
		System.out.println("=※=※=※=※=※=※=※=※=※=※=");
	}
	
//	@Override
//	public void orderScan() {
//		
//		int totalPrice = 0;	//總價容器
//		boolean end = false;		//點餐結束判斷
//		//利用Map來記錄點餐內容與份數
//		var orderMap = new LinkedHashMap<String , Integer>();
//		
//		//點餐
//		Outer: while(!end){
//			System.out.println("請輸入餐點: ");
//			String order = scan.next();
//			if(menu.getMenuMap().containsKey(order)) {
//				System.out.println("請輸入份數: ");
//				int orderNum = scan.nextInt();
//				if(orderNum <= 0) {
//					System.out.println("不可輸入0以下的數字");
//					continue Outer;
//				}
//				int price = menu.getMenuMap().get(order) * orderNum;
//				System.out.println("您點了" + order + orderNum +" 份 , 總共" + price + "元");
//				totalPrice += price;
//				int orderActualNum = 0;
//				if(orderMap.get(order) != null) {
//					orderActualNum = orderMap.get(order) + orderNum;
//				}else {
//					orderActualNum = orderNum;
//				}
//				orderMap.put(order, orderActualNum);
//			}else {
//				System.out.println("菜單無此餐點");
//			}
//			//續點功能
//			while(true) {
//				System.out.println("還需要再點餐嗎? Y/N");
//				String endOrNot = scan.next();
//				if(endOrNot.equals("Y")) {
//					continue Outer;
//				}else if(endOrNot.equals("N")){
//					end = true;
//					break Outer;
//				}else {
//					System.out.println("輸入錯誤 , 請重新輸入");
//				}
//			}
//			//續點功能
//		}
//		//點餐
//		
//		//合計
//		System.out.println("您的餐點為: ");
//		for(Map.Entry<String, Integer> entry : orderMap.entrySet()) {
//			System.out.print(entry.getKey() + entry.getValue() + "份 ");
//		}
//		if(totalPrice > 500) {
//			System.out.println("總價格: " + totalPrice);
//			totalPrice *= 0.9;
//			System.out.println("消費滿500打九折後為: " + totalPrice);
//		}else {
//			System.out.println("總價格: " + totalPrice);
//		}
//		//合計
//	}
	
	@Override
	public void order(LinkedHashMap orderMap) {
		//防呆區
		Set<Map.Entry<String, Integer>> entrySet = orderMap.entrySet();
		for(Map.Entry<String , Integer> entry : entrySet ) {
			if(!menu.getMenuMap().containsKey(entry.getKey())) {
				System.out.println("您輸入的餐點 " + entry.getKey() + " 不存在");
				return;
			}
			if(entry.getValue() <= 0) {
				System.out.println("您於 " + entry.getKey() +" 輸入的份數錯誤");
				return;
			}
		}
		//防呆區
		//合計
		int totalPrice = 0;
		System.out.println("您的餐點為: ");
		for(Map.Entry<String, Integer> entrySettlement : entrySet) {
			System.out.print(entrySettlement.getKey() + entrySettlement.getValue() + "份 ");
			int price = entrySettlement.getValue() * menu.getMenuMap().get(entrySettlement.getKey());
			System.out.println(price + "元");
			totalPrice += price;
		}
		if(totalPrice > 500) {
			System.out.println("總價格: " + totalPrice);
			totalPrice *= 0.9;
			System.out.println("消費滿500打九折後為: " + totalPrice);
		}else {
			System.out.println("總價格: " + totalPrice);
		}
		//合計
	}
}

