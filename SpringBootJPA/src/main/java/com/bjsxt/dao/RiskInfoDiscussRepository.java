package com.bjsxt.dao;

import org.springframework.data.jpa.repository.Query;

import com.bjsxt.common.jpa.base.JpaBaseRepository;
import com.bjsxt.pojo.RiskInfoDiscuss;
import com.bjsxt.pojo.RiskInfoDiscussId;

public interface RiskInfoDiscussRepository extends JpaBaseRepository<RiskInfoDiscuss, RiskInfoDiscussId>{

	// 不能获取当前的序列号的值
	@Query(value="select nextval ('riskinfo_discuss_sequence')",nativeQuery=true)
	Integer queryDiscussSequence();
}
