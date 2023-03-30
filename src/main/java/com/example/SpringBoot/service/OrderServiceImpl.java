package com.example.SpringBoot.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.IllegalFormatException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import com.example.SpringBoot.entity.Menu;
import com.example.SpringBoot.repository.MenuDao;
import com.example.SpringBoot.vo.OrderRequest;
import com.example.SpringBoot.vo.OrderResponse;

//@Service
//public class OrderServiceImpl implements OrderService {
//
//	Menu menu = new Menu();
//	
//	@Autowired
//	MenuDao menuDao;
//
//	@PersistenceContext
//	EntityManager entityManager;
//	
//	@Override
//	public OrderResponse setMenu(OrderRequest orderReq) {
//		OrderResponse orderRes = new OrderResponse();
//		String reqName = orderReq.getName();
//		Integer reqPrice = orderReq.getPrice();
//		var menuSet = orderReq.getMenuSet();
//		
//		StringBuilder sb = new StringBuilder();	//使用StringBuilder將餐點設置的項目逐個添加進去
//		if(menuSet.size() != 0) {
//			for( int i = 0 ; i < menuSet.size() ; i++) {
//				String menuSetName = menuSet.get(i).getName();
//				Integer menuSetPrice = menuSet.get(i).getPrice();
//				if(StringUtils.hasText(menuSetName) && menuSetPrice > 0) {
//					menu.setNameAndPrice(menuSetName , menuSetPrice);
//					menuDao.save(menu);
//					sb.append(menuSet.get(i).getName()).append(menuSet.get(i).getPrice()).append(", ");
//				}else {
//					orderRes.message = "內容不得為空或null";
//					return orderRes;
//				}
//			}
//			sb.deleteCharAt(sb.length() - 2);
//			orderRes.message = "餐點登錄完成: " + sb.toString();
//			return orderRes;
//		}else {
//			if(StringUtils.hasText(reqName) && reqPrice > 0) {
//				menu.setNameAndPrice(reqName , reqPrice);
//				menuDao.save(menu);
//				orderRes.setName(reqName);
//				orderRes.setPrice(reqPrice);
//				orderRes.message = "餐點登錄完成";
//				return orderRes;
//			}else {
//				orderRes.message = "內容不得為空或null";
//				return orderRes;
//			}
//		}
//	}
//	
//	@Override
//	public List menuInfo() {
//		var list = new ArrayList<>(menuDao.findAll());
//		return list;
//	}
//	
//	@Override
//	public List menuInfoByPriceLowerThan() {
//				TypedQuery<Menu> query = entityManager.createQuery(
//			    "SELECT M FROM menu M WHERE price < :200", Menu.class);
//			query.setParameter("price", 200);
//			List<Menu> results = query.getResultList();
//
//		return results;
//	}
//	
//	@Override
//	public OrderResponse order(OrderRequest orderReq) {
//		OrderResponse orderRes = new OrderResponse();
//		var order = orderReq.getOrder();
//		//防呆區
//		Set<Map.Entry<String, Integer>> entrySet = order.entrySet();
//		for(Map.Entry<String , Integer> entry : entrySet ) {
//			if(!menuDao.existsById(entry.getKey())) {
//				orderRes.message = "您輸入的餐點 " + entry.getKey() + " 不存在";
//				return orderRes;
//			}
//			if(entry.getValue() <= 0) {
//				orderRes.message = "您於 " + entry.getKey() +" 輸入的份數不得低於1";
//				return orderRes;
//			}
//		}
//		//防呆區
//		//合計
//		int totalPrice = 0;
//		StringBuilder sb = new StringBuilder();	//使用StringBuilder將點餐一覽的項目逐個添加進去
//		System.out.println("您的餐點為: ");
//		for(Map.Entry<String, Integer> entrySettlement : entrySet) {
//			System.out.print(entrySettlement.getKey() + entrySettlement.getValue() + "份");
//			String orderContent = entrySettlement.getKey() + entrySettlement.getValue() + "份"
//			+ menuDao.getById(entrySettlement.getKey()).getPrice() + "元";
//			sb.append(orderContent).append(", ");		//StringBuilder增加 餐點內容及逗號
//			int price = entrySettlement.getValue() * menuDao.getById(entrySettlement.getKey()).getPrice();
//			System.out.println(price + "元");
//			totalPrice += price;
//		}
//		sb.setLength(sb.length() - 2);		//設定StringBuilder的長度 , 達成不顯示多餘的逗號跟空白
//		String orderContent = sb.toString();
//		orderRes.orderMessage = "您的餐點為: " + orderContent;
//		int originPrice = totalPrice;
//		if(totalPrice > 500) {
//			totalPrice *= 0.9;
//			orderRes.setPrice(totalPrice);
//			orderRes.message = "原價總價" + originPrice + "元 , 您消費超過500元 , 給予九折優惠";
//			return orderRes;
//		}else {
//			orderRes.setPrice(totalPrice);
//			orderRes.message = "點餐完成";
//		}
//		//合計
//		return orderRes;
//	}
//}

