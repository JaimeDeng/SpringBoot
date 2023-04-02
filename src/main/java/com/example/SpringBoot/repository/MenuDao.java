package com.example.SpringBoot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.SpringBoot.entity.Bank;
import com.example.SpringBoot.entity.Menu;

@Repository
public interface MenuDao extends JpaRepository<Menu, String> {
	
	@Query("SELECT m FROM Menu m WHERE m.price < :input")
	public List<Menu> getMenuByPriceLowerThan(@Param("input") int price) ;

}
