package Service.JsonParserService;

import java.util.ArrayList;
import java.util.List;

import util.UnicodeDecoder;

import net.sf.json.JSONObject;

import Domain.Geo;

public class JsonToGeos {
	public Geo tranfer(String JsonStr)
	{
		Geo buf = new Geo();
		JsonStr = UnicodeDecoder.decodeUnicode(JsonStr);
		JSONObject obj = JSONObject.fromObject(JsonStr);
		System.out.println(obj);
		if (obj.getString("status").equals("0"))
		{
			System.out.println("Status: 0");
			JSONObject re = obj.getJSONObject("result").getJSONObject("location");
			//BUG~?
			buf.setLat((float) re.getDouble("lat"));
			buf.setLng((float) re.getDouble("lng"));
		}
		else
		{
			System.out.println("Status: 1");
			buf = null;
		}
		return buf;
	}
}
