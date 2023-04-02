package com.example.SpringBoot.controller;

import java.util.*;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import com.example.SpringBoot.entity.PersonInfo;
import com.example.SpringBoot.service.PersonInfoService;
import com.example.SpringBoot.vo.PersonInfoReq;
import com.example.SpringBoot.vo.PersonInfoRes;

//@RestController
public class PersonInfoController {

	@Autowired
	private PersonInfoService PIservice;
	
	PersonInfoRes PIRes = new PersonInfoRes();
	
	@PostMapping("/addPersonInfo")	//等同於method = POST
	public PersonInfoRes addPersonInfo(@RequestBody PersonInfoReq PIReq) {
		PIRes = PIservice.addPersonInfo(PIReq);
		return PIRes;
	}
	
	@PostMapping("/getAllPersonInfo")	//等同於method = POST
	public List getAllPesonInfo() {
		List list = new ArrayList<>();
		list = PIservice.getAllPersonInfo();
		return list;
	}
	
	@PostMapping("/getPersonInfoById")	//等同於method = POST
	public PersonInfoRes getPersonInfoById(@RequestBody PersonInfoReq PIReq) {
		PIRes = PIservice.getPersonInfoById(PIReq);
		return PIRes;
	}
	
	@PostMapping("/getPersonInfoByAgeGreaterThan")	//等同於method = POST
	public List getPersonInfoByAgeGreaterThan(@RequestBody PersonInfoReq PIReq) {
		int age = PIReq.getAge();
		List list = new ArrayList<>();
		list = PIservice.getPersonInfoByAgeGreaterThan(age);
		return list;
	}
}
