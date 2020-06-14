package com.bjsxt.test;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.bjsxt.JpaApplication;
import com.bjsxt.dao.RiskTestRepository;
import com.bjsxt.dao.UsersRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=JpaApplication.class)
public class RiskOneToManyTest {
	
	@Autowired
	private UsersRepository usersRepository;
	
	@Autowired
	private RiskTestRepository riskTestRepository;
	
	/**
	 * 一对多关联关系的添加: https://blog.csdn.net/yingziisme/article/details/81436355
	 */
//	@Test
//	public void testSave(){
//		//创建一个用户
//		RiskReportSaleMain riskReportSaleMain = new RiskReportSaleMain();
//		riskReportSaleMain.setArchivesNo("11111");
//		riskReportSaleMain.setExploreComcode("0000");
//		riskReportSaleMain.setExplorer("2222");
//		riskReportSaleMain.setCheckUpFlag("1");
//		riskReportSaleMain.setMobileFlag("2");
//		
//		RiskReportSaleImaType riskReportSaleImaType = new RiskReportSaleImaType();
//		RiskReportSaleImaTypeId id=new RiskReportSaleImaTypeId();
//		id.setArchivesNo("11111");
//		id.setImageType("2-1");
//		riskReportSaleImaType.setId(id);
//		riskReportSaleImaType.setImageSum(2);
//		riskReportSaleImaType.setImageRepulseSum(3);
//		riskReportSaleMain.getRiskReportSaleImaTypeList().add(riskReportSaleImaType);
//		
//		try {
//			this.riskRepository.save(riskReportSaleMain);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		
//	}
	
			
}
