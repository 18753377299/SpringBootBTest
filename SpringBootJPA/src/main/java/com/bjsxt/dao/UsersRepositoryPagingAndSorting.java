package com.bjsxt.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.bjsxt.pojo.Users;
/**
 * 
 *PagingAndSortingRepository接口
 *
 */
public interface UsersRepositoryPagingAndSorting extends PagingAndSortingRepository<Users,Integer> {

}
