package com.bjsxt.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.bjsxt.service.TestService;

@RestController
@RequestMapping("/test")
@EnableWebMvc
public class TestAPi {
	
	@Autowired
	TestService testService;
	// 查询
	 @RequestMapping(value = "/hello",method = RequestMethod.GET)
     public String say(){
		 System.out.println("hello everyBody");
		 testService.findAll();
         return "hello";
     }
	 // 增加
	 @RequestMapping(value = "/insert",method = RequestMethod.GET)
     public String insert(){
		 testService.insertTest();
         return "insertTest";
     }
	// 增加两个不同的表
	 @RequestMapping(value = "/insertTwoDiff",method = RequestMethod.GET)
     public String insertTwoDiff(){
		 testService.insertTwoDiff();
         return "insertTwoDiff";
     }
	 // 删除
	 @RequestMapping(value = "/delete/{id}",method = RequestMethod.GET)
     public String delete(@PathVariable("id") String  id){
		 testService.deleteTest(id);
         return "deleteTest";
     }
	 //修改
	 @RequestMapping(value = "/update",method = RequestMethod.GET)
     public String update(){
//		 testService.updateTest();
         return "updateTest";
     }
}
