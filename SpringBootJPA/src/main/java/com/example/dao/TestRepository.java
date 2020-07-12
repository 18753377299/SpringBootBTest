package com.example.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.pojo.Test;

public interface TestRepository extends JpaRepository<Test,String>{
	
}
