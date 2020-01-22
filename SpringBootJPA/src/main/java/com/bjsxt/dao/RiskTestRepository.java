package com.bjsxt.dao;

import org.springframework.data.jpa.repository.Query;

import com.bjsxt.common.jpa.base.JpaBaseRepository;
import com.bjsxt.pojo.TestTwo;

public interface RiskTestRepository extends JpaBaseRepository<TestTwo,Integer>{
	
	@Query("from TestTwo where id = ?1")
	TestTwo queryTestTwoById(Integer id);
	
	
}
