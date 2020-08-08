import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;




public class Multiply {
    public static Double multiply(Double a, Double b) {
        return a * b;
    }
    public static void main(String []args){
    	try {
	    	Double mul = multiply(3.0,4.0);
	    	System.out.println(mul);
	    	Map  map =new HashMap<>();
//	    	map.size()
	    	String size = "9";
	    	int sizeNo = Integer.parseInt(size);
	    	System.out.println(map.size()+"====="+map.isEmpty());
	    	JSONObject audience = new JSONObject();
	    	audience.put("pattern", "name");
	//		audience.put("type", "fst");
			audience.put("type", "isRealFlag");
	//		SetEntry<String,Object>>  set  =  audience.entrySet();
			String pattern =  audience.getString("pattern");
			Object type =  audience.get("type");
			int aa = audience.getInt("");
			System.out.println("=============>>"+pattern+"==="+type);
		    Iterator iterator =  audience.keys();
			while(iterator.hasNext()){
				Object key = iterator.next();
			    Object value = audience.get(key.toString());
			   System.out.println(key+"================="+value);
			}
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		for(Map.Entry set : audience.entrySet()) {
//			set.getKey();
//		}
		Object object = new Object();
		Object object2 = new Object();
		JSONObject audience2 = new JSONObject();
		if(object.equals(object2)) {
			
		}
    			
    }
    public  JSONObject generateJson(String isRealFlag,String dataTime) {
		JSONObject audience = new JSONObject();
		try {
			String header = "";
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
//			platform.add(message);
			// 将数组添加到大对象中
			audience.put("files", platform);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return audience;
	}
}