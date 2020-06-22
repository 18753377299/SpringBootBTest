package com.example.common.utils;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;

import org.apache.commons.io.IOUtils;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public class HttpClientUtils {
	//获取地图配置文件信息
	private static final ResourceBundle bundleMap = ResourceBundle.getBundle("config.map",Locale.getDefault());
		
	/**
	 * @功能：执行一个带参数的HTTP GET请求，返回请求响应的JSON字符串
	 * @author liqiankun
	 * @param  url 请求的URL地址
	 * @return  返回请求响应的JSON字符串
	 * @throws Exception
	 * @时间：20190927
	 * @修改记录:
	 */
    public static String getTyphoonDataByGet(String url)  {
   	 StringBuffer sb = new StringBuffer();
   	 BufferedReader bufferReader = null;
       try {
		  URL realUrl = new URL(url);
			// 设置代理请求
		  String proxyHost = "10.130.67.170";
		  int proxyPort = 10011;
		  //设置代理本地
		  // String proxyHost = "Proxy.piccnet.com.cn";
		  // int proxyPort = 3128;
          Proxy proxy = new Proxy(Proxy.Type.HTTP,new InetSocketAddress(proxyHost,proxyPort));
          HttpURLConnection connection = (HttpURLConnection) realUrl.openConnection(proxy);
			// 打开和URL之间的连接
//			URLConnection connection = realUrl.openConnection();
//            HttpURLConnection connection = (HttpURLConnection) realUrl.openConnection();
			// 设置通用的请求属性
//			connection.setRequestProperty("accept", "*/*");
//			connection.setRequestProperty("connection", "Keep-Alive");
//			connection.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
			connection.setConnectTimeout(5000);
			connection.setReadTimeout(5000);
			// 建立实际的连接
			connection.connect();
			// 定义 BufferedReader输入流来读取URL的响应
			bufferReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			String line;
			while ((line = bufferReader.readLine()) != null) {
			    sb.append(line);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
           try {
        	   if(bufferReader!=null){
        		   bufferReader.close();
        	   }
           } catch (Exception ex) {
               return "0";
           }
       }
       return sb.toString();
   }
	 /**
	  * 发送Http post请求
     * @param xmlInfo
     *            json转化成的字符串
     * @param URL ：请求url
     * @return 返回信息
     */
    public static String getRainDataByHttpPost(String xmlInfo, String URL) {
        System.out.println("发起的数据:" + xmlInfo);
        byte[] xmlData = xmlInfo.getBytes();
        InputStream instr = null;
//        ByteArrayOutputStream out = null;
        DataOutputStream printout =null;
        try {
            URL url = new URL(URL);
            //设置代理生产
            String proxyHost = "10.130.67.170";
  		    int proxyPort = 10011;
  		    //设置代理本地
  		    // String proxyHost = "Proxy.piccnet.com.cn";
  			// int proxyPort = 3128;
            Proxy proxy = new Proxy(Proxy.Type.HTTP,new InetSocketAddress(proxyHost,proxyPort));
            HttpURLConnection urlCon = (HttpURLConnection) url.openConnection(proxy);
            
//            URLConnection urlCon = url.openConnection();
//            HttpURLConnection urlCon = (HttpURLConnection) url.openConnection();
         // 发送POST请求必须设置如下两行
            urlCon.setDoOutput(true);
            urlCon.setDoInput(true);
            
            urlCon.setUseCaches(false);
            // 测试本地环境post请求
            urlCon.setRequestProperty("Content-type", "application/json");
//            urlCon.setRequestProperty("jwtToken", jwtToken);
            
//            urlCon.setRequestProperty("Content-type", "application/text");
//            urlCon.setRequestProperty("secretuid", "433f3dd6-d9eb-11e9-9637-00163e30bfa0");
            urlCon.setRequestProperty("secretkey", "0vkEkKFm6BGNZ1v5");
//            urlCon.setRequestProperty("charset", "utf-8");
//            urlCon.setRequestProperty("Content-length",String.valueOf(xmlData.length));
//            System.out.println(String.valueOf(xmlData.length));
//            DataOutputStream printout = new DataOutputStream(urlCon.getOutputStream());
            printout = new DataOutputStream(urlCon.getOutputStream());
            printout.write(xmlData);
            printout.flush();
//            printout.close();
            instr = urlCon.getInputStream();
            byte[] bis = IOUtils.toByteArray(instr);
            String ResponseString = new String(bis, "UTF-8");
            if ((ResponseString == null) || ("".equals(ResponseString.trim()))) {
                System.out.println("返回空");
            }
            System.out.println("返回数据为:" + ResponseString);
            return ResponseString;

        } catch (Exception e) {
            e.printStackTrace();
            return "0";
        } finally {
            try {
//            	if(out!=null){
//            		out.close();
//            	}
                if(instr!=null){
                	instr.close();
                }
                if(printout!=null){
            		printout.close();
            	}
            } catch (Exception ex) {
                return "0";
            }
        }
    }
    /**
	 * @功能：组织调用气象局接口数据参数的组织
	 * @param 第一位传递是实况（obs）还是预报(fst)标志位，第二位传递时间(时间是加一天的)
	 * @return void
	 * @author liqiankun
	 * @时间：20190930
	 * @修改记录：
	 */	
	public static JSONObject generateJson(String isRealFlag,String dataTime) {
		JSONObject audience = new JSONObject();
		try {
			String header = "";
			if("fst".equals(isRealFlag)){
				// 预警
				header = bundleMap.getString("YJRain");
			}else if("obs".equals(isRealFlag)){
				//实况
				header = bundleMap.getString("SHRain");
			}
//			StringBuilder stringBuilder = new StringBuilder("Z_NWGD_C_BABJ_P_RFFC_SCMOC-ER24_");
			StringBuilder stringBuilder = new StringBuilder(header);
			stringBuilder.append(dataTime);
			stringBuilder.append(".json");
			audience.put("pattern", "name");
//			audience.put("type", "fst");
			audience.put("type", isRealFlag);
			//数组
			JSONArray platform = new JSONArray();
			//数组中对象
			JSONObject message = new JSONObject();
//			message.put("file_name", "Z_NWGD_C_BABJ_P_RFFC_SCMOC-ER24_201910160800.json");
			message.put("file_name", stringBuilder.toString());
			
			platform.add(message);
			// 将数组添加到大对象中
			audience.put("files", platform);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return audience;
	}
    
}
