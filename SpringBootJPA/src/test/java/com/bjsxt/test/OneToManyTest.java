package com.bjsxt.test;

import java.math.BigDecimal;
import java.util.UUID;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.bjsxt.App;
import com.bjsxt.dao.RiskInfoDiscussRepository;
import com.bjsxt.dao.UsersRepository;
import com.bjsxt.pojo.RiskInfoDiscuss;
import com.bjsxt.pojo.Users;

/**
 * 一对多关联关系测试
 *
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=App.class)
public class OneToManyTest {
	
	@Autowired
	private UsersRepository usersRepository;
	@Autowired
	private RiskInfoDiscussRepository riskInfoDiscussRepository;
	
	/**
	 * 一对多关联关系的添加,使用@Data不能成功，自己添加get、set方法就可以成功
	 */
	@Test
	public void testSave(){
		BigDecimal aa = new BigDecimal(2).setScale(1, BigDecimal.ROUND_HALF_UP);
		System.out.println(aa);
		//创建一个用户
		Users users = new Users();
		users.setAddress("天津");
		users.setAge(32);
		users.setName("小刚");
		
		//创建一个角色
//		Roles roles = new Roles();
//		roles.setRolename("管理员");
//		
//		//关联
//		roles.getUsers().add(users);
//		users.setRoles(roles);
		
		//保存
		this.usersRepository.save(users);
		System.out.println(users);
	}
	@Test
	public void testRiskInfoDiscussSave(){
		//创建一个用户
		RiskInfoDiscuss riskInfoDiscuss = new RiskInfoDiscuss();
		riskInfoDiscuss.setExpertNo(11);
		riskInfoDiscuss.setScore(new BigDecimal(3.1));
		riskInfoDiscussRepository.save(riskInfoDiscuss);
//		riskInfoDiscussRepository.saveAndFlush(riskInfoDiscuss);
		Integer discussSequence = riskInfoDiscussRepository.queryDiscussSequence();
		riskInfoDiscuss.setSerialNo(discussSequence-1);
		System.out.println(riskInfoDiscuss);
	}
	
	/**
	 * 一对多关联关系的查询
	 */
	@Test
	public void testFind(){
		try {
			//		Users findOne = this.usersRepository.findOne(4);
					Users findOne = this.usersRepository.findOne(4);
					System.out.println(findOne);
//					usersRepository.delete(1);
					System.out.println(UUID.randomUUID());
					System.out.println(System.currentTimeMillis());
			//		Roles roles = findOne.getRoles();
			//		System.out.println(roles.getRolename());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
