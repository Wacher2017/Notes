import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * list的排序，分组，合并
 */
public class ListHebing {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Map<String,Object>> listMap = new LinkedList<Map<String,Object>>();
		for(int i = 1; i <= 100; i++){
			Map<String, Object> map = new HashMap<String, Object>();
			for(int j = 1; j <= 5; j++){				
				if(i<=30){					
					map.put("protocol_name", "LV_ST");
					if(i<=10){
						map.put("id", 1122);
						map.put("data_name", "Active Energy");
					}else if(i<=20) {
						map.put("id", 1212);
						map.put("data_name", "Gas");
					}else{
						map.put("id", 1000*i+10*j+j);
						map.put("data_name", "Export Energy_"+i);
					}					
				}else if(i<=60){
					map.put("protocol_name", "IR_FRAHAM");
					if(i<=40){
						map.put("id", 1122);
						map.put("data_name", "Active Energy");
					}else if(i<=50) {
						map.put("id", 1212);
						map.put("data_name", "Gas");
					}else{
						map.put("id", 1000*i+10*j+j);
						map.put("data_name", "Power Active_"+i);
					}
				}else {
					map.put("protocol_name", "IR_FIS");
					if(i<=70){
						map.put("id", 1122);
						map.put("data_name", "Active Energy");
					}else{
						map.put("id", 1000*i+10*j+j);
						map.put("data_name", "Max Demand_"+i);
					}
				}
				if(!listMap.contains(map))
					listMap.add(map);
			}
		}
		System.out.println(listMap);
		System.out.println(listMap.size());
		
		
        // 按data_type排序
        sort(listMap);
 
        // 按data_type分组
        List<List<Map<String,Object>>> result = group(listMap);
        System.out.println(result);
        System.out.println(result.size());
        // 按data_type数据合并
        List<Map<String,Object>> resultList = hebing(result, protocolSize(listMap));

        Collections.sort(resultList, new Comparator<Map<String,Object>>() {
            public int compare(Map<String,Object> o1, Map<String,Object> o2) {
            	 if (o1.get("protocol_name").toString().compareTo(o2.get("protocol_name").toString()) != 0)
                    return o1.get("protocol_name").toString().compareTo(o2.get("protocol_name").toString());
                 else
                	return o1.get("id").toString().compareTo(o2.get("id").toString());
            }
        });
        System.out.println(resultList);
        System.out.println(resultList.size());
	}
	
	private static void sort(List<Map<String,Object>> data) {
        Collections.sort(data, new Comparator<Map<String,Object>>() {
            public int compare(Map<String,Object> o1, Map<String,Object> o2) {
                  return o1.get("id").toString().compareTo(o2.get("id").toString());
            }
        });
    }
	
	private static int protocolSize(List<Map<String,Object>> data) {
		Set<String> set = new HashSet<String>();
		for(int k = 0; k<data.size(); k++){
			Map<String, Object> map = data.get(k);
			set.add(map.get("protocol_name").toString());
		}
		return set.size();
    }
	
	private static List<Map<String,Object>> hebing(List<List<Map<String,Object>>> result, int num) {
        List<Map<String,Object>> data = new ArrayList<Map<String,Object>>();
        
        for (List<Map<String,Object>> tmp : result) {
        	if(tmp.size() == num){
        		String text = "";
                for (Map<String,Object> bean : tmp) {
                    text += bean.get("protocol_name").toString() + ",";
                }
                String[] t = text.split(",");
                Set<String> set=new HashSet<String>();
                for (int i = 0; i < t.length; i++) {
                	set.add(t[i]);
       		 	}
            	if (set.size()<=t.length){ //有重复 
            		 text = " [PUBLIC],";
            	}
            	if (set.size()==1){ //全部相同
            		 text = set.toString()+",";
            	}
                
                Map<String,Object> bean0 = tmp.get(0);
                bean0.put("protocol_name",text.substring(0, text.length() - 1));
                data.add(bean0);
        	}else{
        		data.addAll(tmp);
        	}
            
        }
        return data;
    }
	 
	private static List<List<Map<String,Object>>> group(List<Map<String,Object>> data) {
        List<List<Map<String,Object>>> result = new ArrayList<List<Map<String,Object>>>();
        String oldVal = "";
        List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
        for (Map<String,Object> bean : data) {
            String newVal = bean.get("id").toString();
            if (!oldVal.equalsIgnoreCase(newVal)) {
                if (!isNotNullOrBlank(list)) {
                    result.add(list);
                }
                list = null;
                oldVal = newVal;
            }
            if (list == null) {
                list = new ArrayList<Map<String,Object>>();
            }
            list.add(bean);
        }
        if (!isNotNullOrBlank(list)) {
            result.add(list);
        }
        return result;
	 }
	 
 	private static boolean isNotNullOrBlank(List<Map<String,Object>> list) {
 		return list == null || list.isEmpty();
    }

}