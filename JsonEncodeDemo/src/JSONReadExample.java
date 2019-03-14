import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JSONReadExample {
	public static void main(String[] args) throws FileNotFoundException,
			IOException, ParseException {

		Object obj = new JSONParser().parse(new FileReader("person.json"));
		JSONObject jsonObj = (JSONObject) obj;

		String firstname = (String) jsonObj.get("firstname");
		String lastname = (String) jsonObj.get("lastname");
		String age = (String) jsonObj.get("age");

		System.out.println(firstname + lastname + age);

		Map objMap = new LinkedHashMap<>();
		objMap = (Map) jsonObj.get("address");
		System.out.println(objMap.toString());
		
		Iterator<Map.Entry> itr = objMap.entrySet().iterator();
		while(itr.hasNext()){
			Map.Entry pair = itr.next();
			System.out.println(pair.getKey() + " ---" + pair.getValue());
		}
		
		JSONArray jsonarrayObj = (JSONArray) jsonObj.get("phoneNumber");
		System.out.println(jsonarrayObj);

		Iterator itr_phoneNum = jsonarrayObj.iterator();
		
		while(itr_phoneNum.hasNext()){
			itr = ((Map)itr_phoneNum.next()).entrySet().iterator();
			while(itr.hasNext()){
				Map.Entry phone_PairObj = itr.next();
				System.out.println(phone_PairObj.getKey() + " : " + phone_PairObj.getValue());
			}
		}

	}
}
