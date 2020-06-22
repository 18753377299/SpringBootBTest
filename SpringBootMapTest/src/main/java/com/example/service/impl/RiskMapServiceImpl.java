package com.example.service.impl;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import com.example.common.utils.DateUtils;
import com.example.common.utils.FileUtils;
import com.example.common.utils.HttpClientUtils;
import com.example.service.RiskMapService;

@Service
public class RiskMapServiceImpl implements RiskMapService{
	//获取地图配置文件信息
	private static final ResourceBundle bundleMap = ResourceBundle.getBundle("config.map",Locale.getDefault());
	// 获取路径信息
	private static final ResourceBundle bundle = ResourceBundle.getBundle("config.savePath",Locale.getDefault());
		
	/**
	 * @功能：功能一：获取气象局台风数据
	 * @param 
	 * @return void
	 * @author liqiankun
	 * @时间：20190927
	 * @修改记录：
	 */	
	public String gainWeatherTyphoonData(String startDate ,String endDate){
		String filePath  = bundle.getString("saveRootPath")+bundle.getString("saveTypePath");
		try {
			// 组织调用气象局接口的url地址
			String typhoonUrl=bundleMap.getString("typhoonWeatherUrl")+"&startTime="+startDate+"&endTime="+endDate;
			// 根据http请求调用台风接口，获取台风数据,需要重新组织 地址信息
			String returnString =HttpClientUtils.getTyphoonDataByGet(typhoonUrl);
			//增加本地调用方式，读取文件内容
//			String returnString =FileUtils.readFileContent("D:/typhoon20200514064700_20200519064700.txt");
			System.out.println(returnString);
			if(StringUtils.isNotBlank(returnString)){
				// 将气象局中的数据转化成对象
//				TyphoonBaseInfo typhoonBaseInfo = JSON.parseObject(returnString, TyphoonBaseInfo.class);
				System.out.println("success");
			   /* 气象局数据组织并更新到数据库中*/
//				ajaxResult = this.updateTyphoonInfo(typhoonBaseInfo);
					//将生成的台风内容,以文本形式存储下来
				FileUtils.writeToFile(returnString,filePath+"/map/typhoon/typhoon"+startDate+"_"+endDate+".txt");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return filePath;
	}
	/**
	 * @功能：功能二：获取气象局降雨面数据,实况数据
	 * @param 
	 * @return void
	 * @author liqiankun
	 * @时间：20190930
	 * @修改记录：
	 */	
	public String gainWeatherRainData(Date newDate,int day,int hour){
		String filePath  = bundle.getString("saveRootPath")+bundle.getString("saveTypePath");
		try {
			String url=bundleMap.getString("rainWeatherUrl");
			/*获取某一日期的下几天天几点零分的日期,yyyyMMddHH*/
			String dataTime=  DateUtils.getNextDateEightHour(newDate,day,hour);
			String insertTimeForHis=  DateUtils.getCurrentDateFormat(newDate);
			// 存储到数据集中的日期格式是yyyyMMdd
			String dataTimeNew = DateUtils.getNextDateFormat(newDate,0);
//			String dataTime=  DateUtils.getNextDateEightHour(new Date(),1,8);
			//组织参数的json字符串
			String  jsonString = HttpClientUtils.generateJson("obs",dataTime).toString();
			/*发送Http post请求,调用气象局台风接口*/
			String responseJson =HttpClientUtils.getRainDataByHttpPost(jsonString, url);
			// 当接口调用不通的时候使用的临时数据
//			String responseJson = rainData;
			String sourceJson= "\"rings\"";
			String targetJson= "\"type\": \"Polygon\",\"coordinates\"";
			// 增加日期格式替换，在idesktop中增加数据,以及操作的时间
			String sourceJsonTwo= "\"attributes\":{";
			String targetJsonTwo= "\"attributes\":{ \"dataTime\":\""+dataTimeNew+"\",\"insertTimeForHis\":\""+insertTimeForHis+"\",";
			// 将气象局数据替换成超图所需的数格式
			responseJson =  responseJson.replace(sourceJson, targetJson);
			responseJson =  responseJson.replace(sourceJsonTwo, targetJsonTwo);	
			// 将气象局中的数据转化成对象
				/*对降雨文件信息进行备份*/
			
			filePath = filePath+"/map/Rain/RainSH_"+dataTime+".txt";
			FileUtils.writeToFile(responseJson,filePath);
			/* 气象局数据组织并更新到数据库中*/
		} catch (Exception e) {
			e.printStackTrace();
		}
		return filePath;
	}
	/**
	 * @功能：功能二-2：获取气象局降雨预警面数据，看当前时间是6,8,12： 8点；16,20:20点。
	 * @param  
	 * @return void
	 * @author liqiankun
	 * @时间：20190930
	 * @修改记录：
	 */	
	public List<String> gainWeatherRainYJData(Date newDate,int day,int hour){
		List<String>  pathList = new ArrayList<String>();
		String filePath  = bundle.getString("saveRootPath")+bundle.getString("saveTypePath");
		try {
			String url=bundleMap.getString("rainWeatherUrl");
			for (int  i=1;i<=day;i++){
				/*获取某一日期的下几天天几点零分的日期*/
				String dataTime=  DateUtils.getNextDateEightHourMinu(newDate,i,hour);
				String insertTimeForHis=  DateUtils.getCurrentDateFormat(newDate);
				// 存储到数据集中的日期格式是yyyyMMdd
				String dataTimeNew = DateUtils.getNextDateFormat(newDate,i);
				//组织参数的json字符串
				String  jsonString = HttpClientUtils.generateJson("fst",dataTime).toString();
				/*发送Http post请求,调用气象局台风接口*/
				String responseJson =HttpClientUtils.getRainDataByHttpPost(jsonString, url);
				// 当接口调用不通的时候使用的临时数据
//				String responseJson = rainData;
				String sourceJson= "\"rings\"";
				String targetJson= "\"type\": \"Polygon\",\"coordinates\"";
				// 增加日期格式替换，在idesktop中增加数据,以及操作的时间
				String sourceJsonTwo= "\"attributes\":{";
				String targetJsonTwo= "\"attributes\":{ \"dataTime\":\""+dataTimeNew+"\",\"insertTimeForHis\":\""+insertTimeForHis+"\",";
				// 将气象局数据替换成超图所需的数格式
				responseJson =  responseJson.replace(sourceJson, targetJson);
				responseJson =  responseJson.replace(sourceJsonTwo, targetJsonTwo);
				// 将气象局中的数据转化成对象
				filePath = filePath+"/map/Rain/RainYJ_"+dataTime+".txt";
				FileUtils.writeToFile(responseJson,filePath);
				pathList.add(filePath);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pathList;
	}
	
	
}
