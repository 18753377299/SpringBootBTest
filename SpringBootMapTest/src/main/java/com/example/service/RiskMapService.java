package com.example.service;

import java.util.Date;
import java.util.List;

public interface RiskMapService {
	public String gainWeatherTyphoonData(String startDate ,String endDate);
	
	public List<String> gainWeatherRainYJData(Date newDate,int day,int hour);
	
	public String gainWeatherRainData(Date newDate,int day,int hour);
}
