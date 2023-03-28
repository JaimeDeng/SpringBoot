package com.example.SpringBoot.Dao;

import java.util.List;

import javax.persistence.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import com.example.SpringBoot.entity.JpaDemo;
import com.example.SpringBoot.service.Active;
import com.example.SpringBoot.service.Animal;
import com.example.SpringBoot.service.OrderService;

public interface JpaDemoDao extends JpaRepository<JpaDemo , Long> {
	
	List <JpaDemo> findAll();
	List <JpaDemo> findByName(String name);
	
}