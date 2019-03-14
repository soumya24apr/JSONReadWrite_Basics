import java.io.StringWriter;

import org.json.simple.JSONObject;


public class JsonEncodeDemoExample {

	public static void main(String[] args) {
		JSONObject obj = new JSONObject();
		obj.put("name", "foo");
		obj.put("value", new Integer(100));
		
		StringWriter out = new StringWriter();
		out.append(obj.toJSONString());
		
		String jsonText = out.toString();
		System.out.println(jsonText);
	}
}
