package com.example.SpringBoot;

import java.util.*;
import java.util.Map.Entry;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.example.SpringBoot.entity.*;
import com.example.SpringBoot.entity.Menu;
import com.example.SpringBoot.service.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MenuTest {
	
	@Autowired
	private OrderService os;
	
    @Test          
    public void test() {
    	
    	Scanner scan = new Scanner(System.in);
    	
     	os.setMenu("牛排" , 100);
    	os.setMenu("豬排" , 90);
    	os.setMenu("雞排" , 80);
    	os.setMenu("魚排" , 130);
    	os.setMenu("魷魚" , 120);
    	os.menuInfo();
    	
    	var orderMap = new LinkedHashMap<String , Integer>();
    	while(true) {
        	System.out.println("請輸入餐點: ");
    		String order = scan.next();
    		System.out.println("請輸入份數: ");
    		int orderNum = scan.nextInt();
    		int actualOrderNum = 0;
    		if(orderMap.containsKey(order)) {
    			actualOrderNum = orderMap.get(order) + orderNum;
    		}else {
    			actualOrderNum = orderNum;
    		}
    		orderMap.put(order, actualOrderNum);
    		System.out.println("是否繼續點餐? Y/N");
	    	String orderNew = scan.next();
	    	if(orderNew.equals("Y")) {
	    		continue;
	    	}else if(orderNew.equals("N")) {
	    		break;
	    	}else {
	    		System.out.println("母湯亂輸入");
	    		return;
	    	}
    	}
    	os.order(orderMap);
    }
}
