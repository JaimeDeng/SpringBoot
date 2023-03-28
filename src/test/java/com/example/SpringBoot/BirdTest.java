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
class BirdTest {
	
	Bird b = new Bird("大鵰" , 10);
	@Autowired
	Active act;
	
    @Test          
    @DisplayName("fly test")
    public void test1() {
    	System.out.println(act.flyText(b.getName() , b.getAge()));b.flyText(b.getName() , b.getAge());
    }
    @Test       
    @DisplayName("run test")
    public void test2() {
    	b.run(b.getName() , b.getAge());
    }
    @Test
    @DisplayName("sleep test")
    public void test3() {
    	b.sleep(b.getName() , b.getAge());
    }
}
