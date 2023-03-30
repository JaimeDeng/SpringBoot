package com.example.SpringBoot.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.example.SpringBoot.entity.PersonInfo;
import com.example.SpringBoot.repository.PersonInfoDao;
import com.example.SpringBoot.vo.PersonInfoReq;
import com.example.SpringBoot.vo.PersonInfoRes;

@Service
public class PersonInfoServiceImpl implements PersonInfoService {
	
	@Autowired
	PersonInfoDao PIDao;
	
	PersonInfo personInfo = new PersonInfo();
	PersonInfoRes PIRes = new PersonInfoRes();
	PersonInfoReq PIReq = new PersonInfoReq();

	@Override
	public PersonInfoRes addPersonInfo(PersonInfoReq personInfoReq) {
		var personInfoList = personInfoReq.getPersonInfoList();
		int reqId = personInfoReq.getId();
		int reqAge = personInfoReq.getAge();
		String reqName = personInfoReq.getName();
		String reqGender = personInfoReq.getGender();
	
		//大量增加PersonInfo
		if(personInfoList.size() != 0) { 	//List有東西才執行
			for(int i = 0 ; i < personInfoList.size() ; i++) {
				int personInfoListId = personInfoList.get(i).getId();
				int personInfoListAge = personInfoList.get(i).getAge();
				String personInfoListName = personInfoList.get(i).getName();
				String personInfoListGender = personInfoList.get(i).getGender();
				if(PIDao.existsById(personInfoListId)) {
					PIRes.message = "該ID已有人員資訊";
					return PIRes;
				}
				if(personInfoListId < 1) {
					PIRes.message = "ID格式錯誤";
					return PIRes;
				}
				if(personInfoListAge < 1) {
					PIRes.message = "年齡格式錯誤";
					return PIRes;
				}
				if(!StringUtils.hasText(personInfoListGender)) {
					PIRes.message = "性別不得為空或null";
					return PIRes;
				}
				if(!StringUtils.hasText(personInfoListName)) {
					PIRes.message = "姓名不得為空或null";
					return PIRes;
				}
				personInfo.setPersonInfo(personInfoListId, personInfoListName, 
						personInfoListAge, personInfoListGender);
				PIDao.save(personInfo);
				PIRes.setPersonInfo(personInfoListId, personInfoListName, 
						personInfoListAge, personInfoListGender);
				}
			PIRes.message = "人員資訊新增成功";
			return PIRes;
		}else {
			//單次增加PersonInfo
			if(PIDao.existsById(reqId)) {
				PIRes.message = "該ID已有人員資訊";
				return PIRes;
			}else {
				if(reqId < 1) {
					PIRes.message = "ID格式錯誤";
					return PIRes;
				}
				if(reqAge < 1) {
					PIRes.message = "年齡格式錯誤";
					return PIRes;
				}
				if(!StringUtils.hasText(reqGender)) {
					PIRes.message = "性別不得為空或null";
					return PIRes;
				}
				if(!StringUtils.hasText(reqName)) {
					PIRes.message = "姓名不得為空或null";
					return PIRes;
				}
				personInfo.setPersonInfo(reqId, reqName, reqAge, reqGender);
				PIDao.save(personInfo);
				PIRes.message = "人員資訊新增成功";
				PIRes.setPersonInfo(reqId, reqName, reqAge, reqGender);
				return PIRes;
			}		
		}
	}

	@Override
	public List getAllPersonInfo() {
		var allPesonInfoList = new ArrayList<PersonInfo>(PIDao.findAll());
		return allPesonInfoList;
	}

	@Override
	public PersonInfoRes getPersonInfoById(PersonInfoReq personInfoReq) {
		if(personInfoReq.getId() < 1) {
			PIRes.message = "ID格式錯誤";
			return PIRes;
		}
		Optional<PersonInfo> personInfo = PIDao.findById(personInfoReq.getId());
		if(personInfo.isPresent()) {
			PIRes.setPersonInfo(personInfo);
			PIRes.message = "搜尋完成";
		}else {
			PIRes.message = "查無ID對象";
		}
		return PIRes;
	}

	@Override
	public List getPersonInfoByAgeGreaterThan(int age) {
		if(age < 1) {
			var list = new ArrayList<String>();
			list.add("查詢的age不得低於1");
			return list;
		}
		return PIDao.findAllByAgeGreaterThan(age);
	}

}
