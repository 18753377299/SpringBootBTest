package com.example.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.common.utils.DateUtils;
import com.example.service.RiskMapService;

@RestController
public class RiskMapApi {
	@Autowired
	private RiskMapService riskMapService;
	
	@GetMapping(value="/generateTyphoonFile")
	public String generateTyphoonFile(@RequestParam String startDate,
			@RequestParam String endDate) {
		String path =riskMapService.gainWeatherTyphoonData(startDate, endDate);
		return path;
	}
	@GetMapping(value="/generateRainSHFile")
	public String generateRainSHFile(@RequestParam String rainDate,
			@RequestParam int day,@RequestParam int hour) {
//		yyyyMMddHHmm
		//		Date  newDate=DateUtils.getNextStringDate(dateOld);
		String path=null;
		try {
			SimpleDateFormat  sdf_YMD = new SimpleDateFormat("yyyyMMddHHmmss");
			Date newDate =sdf_YMD.parse(rainDate);
			path = riskMapService.gainWeatherRainData(newDate, day, hour);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return path;
	}
	
	@GetMapping(value="/generateRainYJFile")
	public List<String> generateRainYJFile(@RequestParam String rainDate,
			@RequestParam int day,@RequestParam int hour) {
//		yyyyMMddHHmm
		List<String> path = null;
		try {
			SimpleDateFormat  sdf_YMD = new SimpleDateFormat("yyyyMMddHHmmss");
			Date date =sdf_YMD.parse(rainDate);
			Date  newDate=DateUtils.getNextStringDate(rainDate);
			path = riskMapService.gainWeatherRainYJData(newDate, day, hour);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return path;
	}
	
}
