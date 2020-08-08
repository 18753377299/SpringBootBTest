import static org.mockito.Matchers.doubleThat;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class ListTest {

	public static void main(String[] args) {
		BigDecimal bigDecimal=  new BigDecimal("1111");
		bigDecimal = bigDecimal.setScale(4, RoundingMode.HALF_UP);
//		Double double2 = new 
		System.out.println(bigDecimal.toString());
		// TODO Auto-generated method stub
		List<String> list = new ArrayList<String>();
		list.add("abc1");
		list.add("abc2");
		list.add("abc3");
		list.add("abc4");
		
		List<String> list2 = new ArrayList<String>();
		list.add("abc1");
		list.add("abc2");
		list.add("abc3");
		list.add("abc4");
		list.add("abc5");
		try {
			Iterator<String> it = list2.iterator();
			
			for (int i =0;i<list.size();i++) {
				String  value =  list.get(i);
				 while(it.hasNext()){
					 String value2 = it.next();  
					 System.out.println("=====>>"+value+"===>>"+value2);
//					 if(value.equals(value2)) {
//						 System.out.println("=====>>"+value+"===>>"+value2);
//					 }
				 }
			}
				 while(it.hasNext()){
					 String value2 = it.next();  
					 for (int i =0;i<list.size();i++) {
						String  value =  list.get(i);
						 if(value.equals(value2)) {
							 System.out.println("===222==>>"+value+"===>>"+value2);
						 }
					 }
					
				 }
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
