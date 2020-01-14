package com.bjsxt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.bjsxt.dao.TestRepository;
import com.bjsxt.dao.TestTwoRepository;
import com.bjsxt.pojo.Test;
import com.bjsxt.pojo.TestTwo;

@Service
@Transactional
public class TestService {
	
	@Autowired
	TestRepository testRepository;
	@Autowired
	TestTwoRepository testTwoRepository;
	
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
	
	
}
