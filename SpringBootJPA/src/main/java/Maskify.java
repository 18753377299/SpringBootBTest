import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public class Maskify {
	public static String maskify(String str) {
        StringBuffer returnObj = new StringBuffer("");
        try {
			if(str==""||str==null){
			  return returnObj.toString();
			}
			str =str.trim();
			if(str.length()<4){
			   return str;
			}
			for(int i =0;i<str.length()-4;i++){
			  returnObj.append("#");
			}
			returnObj.append(str.substring(str.length()-4,str.length()));
		} catch (Exception e) {
			e.printStackTrace();
		}
        return returnObj.toString();        
    }
    public static void main(String[]args){
        String  result =  maskify("64607935616");
        System.out.println(result);
        String size ="-1";
        int sizeNo = Integer.parseInt(size);
        System.out.println("=============>>"+sizeNo);
        JSON json= JSON.parseObject(result);
        JSONObject jsonObject = new JSONObject();
        JSONArray jsonArray =new JSONArray();
    }
}
