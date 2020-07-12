package com.example.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.example.dao.TestRepository;
import com.example.dao.TestTwoRepository;
import com.example.dao.UsersRepository;
import com.example.pojo.Roles;
import com.example.pojo.Test;
import com.example.pojo.TestTwo;
import com.example.pojo.Users;

@Service
@Transactional
public class TestService {
	
	@Autowired
	TestRepository testRepository;
	@Autowired
	TestTwoRepository testTwoRepository;
	@Autowired
	private UsersRepository usersRepository;
	
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public String findAll() {
		try {
			List<Test> testList =  testRepository.findAll();
			for (Test test: testList) {
				System.out.println("id:"+test.getId()+",name:"+test.getName());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "findAll";
	}
//	@Transactional(propagation = Propagation.REQUIRED)
	public void insertTest() {
		Test testA = new Test();
//		testA.setId("33");
		testA.setName("wanger");
		testRepository.save(testA);

//        System.out.print(1/0);
        Test testB = new Test();
//        testA.setId("34");
        testB.setName("mazi");
		testRepository.save(testB);
	}
	public void insertTwoDiff() {
		Test testA = new Test();
//		testA.setId("43");
		testA.setName("ergouzi");
		testRepository.save(testA);

//        System.out.print(1/0);
        TestTwo test2B = new TestTwo();
//        test2B.setId("44");
        test2B.setName("wangfugui");
        testTwoRepository.save(test2B);
	}
	public void deleteTest(String  id) {
//		testRepository.deleteById(id);
	}
	
	public Users queryUser(){
		Users findOne = this.usersRepository.findOne(4);
		Users userNew= new Users();
		BeanUtils.copyProperties(findOne, userNew);
		if(findOne!=null&&findOne.getRoles()!=null) {
			Roles roleNew =new Roles();
			Roles roles =findOne.getRoles();
			BeanUtils.copyProperties(roles, roleNew);
			roleNew.setUsers(null);
			userNew.setRoles(roleNew);
		}
		System.out.println(findOne);
		return userNew;
	}
	
}
