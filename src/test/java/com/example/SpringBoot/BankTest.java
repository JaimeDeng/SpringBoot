package com.example.SpringBoot;

import java.util.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.example.SpringBoot.entity.*;
import com.example.SpringBoot.entity.Bird;
import com.example.SpringBoot.service.*;
import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class BankTest {
	
	
	@Autowired
	private BankService bs;
	
    @Test          
    public void test() {
    	
//    	Scanner scan = new Scanner(System.in);
//    	
//    	System.out.println("請輸入帳號");
//    	String account = scan.next();
//    	Bank bank = new Bank();
//    	
//    	Outer: while(true) {
//	    	System.out.println("請選擇功能 1查看餘額 / 2存款 / 3提款 / 4結束");
//	    	int select = scan.nextInt();
//	    	switch(select) {
//		    	case 1:
//		        	bs.getAmount(bank);
//		        	break;
//		    	case 2:
//		        	System.out.println("請輸入存款金額: ");
//		        	int dpAmount = scan.nextInt();
//		        	bs.deposit(bank, dpAmount);
//		        	break;
//		    	case 3:
//		        	System.out.println("請輸入提款金額: ");
//		        	int wdAmount = scan.nextInt();
//		        	bs.withDraw(bank, wdAmount);
//		        	break;
//		    	case 4:
//		    		System.out.println("88");
//		    		break Outer;
//		        default:
//		        	System.out.println("母湯亂輸入");
//	    	}
//	    	System.out.println("還要再進行業務嗎? Y/N");
//	    	String continueOrNot = scan.next();
//	    	if(continueOrNot.equals("Y")) {
//	    		continue;
//	    	}else if(continueOrNot.equals("N")) {
//	    		System.out.println("結束");
//	    		break Outer;
//	    	}else {
//	    		System.out.println("母湯亂輸入");
//	    		break Outer;
//	    	}
//    	}
    }

}
