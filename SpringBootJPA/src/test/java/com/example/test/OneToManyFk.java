package com.example.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.JpaApplication;
import com.example.dao.TestTwoRepository;
import com.example.pojo.TestTwo;
import com.example.pojo.TestTwoKey;
import com.example.pojo.TestTwoKeyId;

/**
 * 一对多关联关系测试
 *
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=JpaApplication.class)
public class OneToManyFk {
	
	@Autowired
	private TestTwoRepository testTwoRepository;
	/**
	 * 一对多关联关系的添加,使用@Data不能成功，自己添加get、set方法就可以成功
	 */
	@Test
	public void testTwoSave(){
		try {
			TestTwo testTwo = new TestTwo();
			testTwo.setId("1");
			testTwo.setName("lqk");
			
			List<TestTwoKey> testTwoKeyList = new ArrayList<TestTwoKey>();
			TestTwoKey testTwoKey = new TestTwoKey();
			TestTwoKeyId id =new TestTwoKeyId();
			id.setTestId("1");
			id.setTestType("aa");
			testTwoKey.setId(id);
			
			testTwoKeyList.add(testTwoKey);
//			testTwo.setTestTwoKeyList(testTwoKeyList);
			//保存
			this.testTwoRepository.save(testTwo);
			System.out.println(testTwo);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
