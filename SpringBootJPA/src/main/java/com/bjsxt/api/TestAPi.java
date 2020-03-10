package com.bjsxt.api;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bjsxt.service.TestService;
import com.bjsxt.vo.AjaxResult;
import com.bjsxt.vo.RiskRequestVo;

import io.swagger.annotations.ApiResponse;

@RestController
@RequestMapping("/test")
//@EnableWebMvc
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
	 //测试
	 @RequestMapping(value = "/test",method = RequestMethod.POST)
     public AjaxResult test(@RequestBody RiskRequestVo riskRequestVo,HttpServletRequest request){
		 AjaxResult ajaxResult =new AjaxResult();
		 String name = riskRequestVo.getName();
		 String time= riskRequestVo.getInsertTime().toString();
		 String contextPath = request.getContextPath();
//		 testService.updateTest();
		 ajaxResult.setData("/home/middle/file/abc_ccc.doc");
         return ajaxResult;
     }
}
