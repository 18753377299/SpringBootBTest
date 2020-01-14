package com.bjsxt.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bjsxt.pojo.Test;

public interface TestRepository extends JpaRepository<Test,String>{
	
}
