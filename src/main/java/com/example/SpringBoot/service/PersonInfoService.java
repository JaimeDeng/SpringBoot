package com.example.SpringBoot.service;

import java.util.List;

import com.example.SpringBoot.vo.PersonInfoReq;
import com.example.SpringBoot.vo.PersonInfoRes;

public interface PersonInfoService {
	
	public PersonInfoRes addPersonInfo(PersonInfoReq personInfoReq);
	public List getAllPersonInfo();
	public PersonInfoRes getPersonInfoById(PersonInfoReq personInfoReq);
	public List getPersonInfoByAgeGreaterThan(int age);
	
}
