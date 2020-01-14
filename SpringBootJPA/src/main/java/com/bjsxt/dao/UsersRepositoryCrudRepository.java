package com.bjsxt.dao;

import org.springframework.data.repository.CrudRepository;

import com.bjsxt.pojo.Users;

/**
 * CrudRepository接口
 *
 *
 */
public interface UsersRepositoryCrudRepository extends CrudRepository<Users, Integer> {

}
