package com.bjsxt.test;


import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.bjsxt.App;
import com.bjsxt.common.jpa.condition.Restrictions;
import com.bjsxt.common.jpa.vo.Criteria;
import com.bjsxt.dao.RiskTestRepository;
import com.bjsxt.pojo.TestTwo;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=App.class)
public class RiskTest {
	@Autowired 
    private RiskTestRepository riskTestRepository;
	
    @Test
    public void test(){
       Criteria<TestTwo> criteria = new Criteria<>();
       String name = "wan";
       Integer id = null;
       if(StringUtils.isNotBlank(name)) {
    	   criteria.add(Restrictions.like("name","%wan%"));
       }
       if(id!=null) {
    	   criteria.add(Restrictions.eq("id",1));
       }
//       criteria.add(Restrictions.eq("id",1)).add(Restrictions.like("name","wan"));
//       List<TestTwo> users = riskTestRepository.findAll(criteria);
       /*springboot1.0用法*/
       Pageable pageable = null;
       Sort sort = new Sort(Sort.Direction.ASC, "id");
       pageable = new PageRequest(0, 2, sort);
       Page<TestTwo> pageTestTwo =  riskTestRepository.findAll(criteria, pageable);
       List<TestTwo> users = pageTestTwo.getContent();
       /*springboot2.0用法*/
//       Page<TestTwo> users =  riskTestRepository.findAll(criteria, 
//    		   PageRequest.of(0, 1,Sort.by(Sort.Direction.DESC, "age")));
       for(TestTwo testTwo:  users) {
    	   System.out.println(testTwo);
       }
       
    }    
}
