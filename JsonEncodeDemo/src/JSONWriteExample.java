import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;


public class JSONWriteExample {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub

		JSONObject jsonObj = new JSONObject();
		jsonObj.put("firstname", "John");
		jsonObj.put("lastname", "smith");
		jsonObj.put("age", "25");
		
		//address first create linked HashMap
		Map Objmap = new LinkedHashMap(4);
		Objmap.put("StreetAddress", "202 A");
		Objmap.put("city", "Mumbai");
		Objmap.put("state", "NY");
		Objmap.put("postalCode", "80001");
		
		//putting address to json object
		jsonObj.put("address", Objmap);
		
		//for Phone number
		JSONArray jsonArray = new JSONArray();
		
		Objmap = new LinkedHashMap<>(2);
		Objmap.put("type", "phone");
		Objmap.put("number", "90890292");
		
		//adding map to list
		jsonArray.add(Objmap);
		
		Objmap = new LinkedHashMap(2);
		Objmap.put("type", "fax");
		Objmap.put("number", "656 3782 283");
		
		jsonArray.add(Objmap);
		jsonObj.put("phoneNumber", jsonArray);
		
		PrintWriter pw = new PrintWriter("person.json");
		pw.write(jsonObj.toJSONString());
		 
		pw.flush();
		pw.close();
		
		
		
	}

}
