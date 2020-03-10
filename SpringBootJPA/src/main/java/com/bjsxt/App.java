package com.bjsxt;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.scheduling.annotation.EnableAsync;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import com.bjsxt.config.MappingFastJsonHttpMessageConverter;


@SpringBootApplication
//@EnableAsync
public class App {

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}
	
//	@Bean
//    public MappingFastJsonHttpMessageConverter mappingFastJsonHttpMessageConverter() {
//        return new MappingFastJsonHttpMessageConverter();
//    }
//	
//    @Bean
//    public HttpMessageConverters fastJsonHttpMessageConverters() {
//        //1、创建FastJson信息转换对象 
//        FastJsonHttpMessageConverter fastConverter=new FastJsonHttpMessageConverter();
//        //2、创建FastJsonConfig对象并设定序列化规则  序列化规则详见SerializerFeature类中，后面会讲
//        FastJsonConfig fastJsonConfig= new FastJsonConfig();
//        fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat,SerializerFeature.WriteNonStringKeyAsString);
//        //本人就坑在WriteNonStringKeyAsString 将不是String类型的key转换成String类型，否则前台无法将Json字符串转换成Json对象
//      
//        //3、中文乱码解决方案
//        List<MediaType> fastMedisTypes = new ArrayList<MediaType>();
//        fastMedisTypes.add(MediaType.APPLICATION_JSON_UTF8);//设定Json格式且编码为utf-8
//        fastConverter.setSupportedMediaTypes(fastMedisTypes);
//        //4、将转换规则应用于转换对象 
//        fastConverter.setFastJsonConfig(fastJsonConfig);
//        return new HttpMessageConverters(fastConverter);
//    }
}
