package com.bjsxt.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.bjsxt.pojo.Users;
/**
 * 
 *JpaSpecificationExecutor
 *
 */
public interface UsersRepositorySpecification extends JpaRepository<Users, Integer>, JpaSpecificationExecutor<Users> {

}
