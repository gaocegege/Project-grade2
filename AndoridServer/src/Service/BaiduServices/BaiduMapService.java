package Service.BaiduServices;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;

import util.UnicodeDecoder;

import Domain.Geo;
import Service.JsonParserService.JsonToGeos;

/**
 * 调用百度API获得位置的服务类
 * @author cece
 *
 */
public class BaiduMapService {
	
	public Geo getGeo(String str) throws IOException
	{
		String api_key = "udpeucLuDMXbgAwAKNyOnnaF";
		String callBack = "showLocation";
		String format = "json";
		String text = URLEncoder.encode(UnicodeDecoder.decodeUnicode(str), "utf-8");

		URL url = new URL("http://api.map.baidu.com/geocoder/v2/?address=" + text +
				"&output=" + format + "&ak=" + api_key + "&callback=" + callBack);
		URLConnection conn = url.openConnection();
		conn.connect();

		BufferedReader innet = new BufferedReader(new InputStreamReader(
				conn.getInputStream(), "utf-8"));
		String line = "", cur;
		while ((cur = innet.readLine()) != null) {
			line += cur;
		}
		innet.close();

		//line = line.replaceAll("\\s*", "");
		//line = line.substring(2, line.length() - 2);
		//to do
		if(line.length() == 0)
			return null;
		line = line.substring(0, line.length() - 1);
		//System.out.println(line);
		for (int i = 0; i < line.length(); i++)
		{
			//System.out.println(i);
			if (line.charAt(i) == '(')
			{
				line = line.substring(i + 1);
				break;
			}
		}
		//System.out.println(line);
		
		JsonToGeos j = new JsonToGeos();
		Geo result = j.tranfer(line);
		return result;
	}
}
