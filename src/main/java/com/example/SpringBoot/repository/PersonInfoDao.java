package com.example.SpringBoot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.SpringBoot.entity.Bank;
import com.example.SpringBoot.entity.Menu;
import com.example.SpringBoot.entity.PersonInfo;
//
//@Repository
//public interface PersonInfoDao extends JpaRepository<PersonInfo, Integer> {
//	
//	//Repository自訂methods
//	//使用@Query標記JPQL語法 , 指定撈取自訂範圍內的DB資料
//	@Query("SELECT pi FROM PersonInfo pi WHERE pi.age > :inputAge")	// :parameter => 可變參數
//	List<PersonInfo> findAllByAgeGreaterThan(@Param("inputAge") int age);		//@Param指定可變參數 , 後面加入帶入之屬性
//
//}
