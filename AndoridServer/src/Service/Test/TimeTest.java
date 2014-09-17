package Service.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;


public class TimeTest {
	public static void main(String[] args) throws ParseException, IOException
	{

		String curdate = "7月25日 09:59";
		int pos1 = curdate.indexOf("月");
		int pos2 = curdate.indexOf("日");
		int curmonth = Integer.parseInt(curdate.substring(0, pos1));
		int curday = Integer.parseInt(curdate.substring(pos1+1, pos2));
		System.out.println(curmonth);
		System.out.println(curday);
		
		String url ="http://jerrylx.eicp.net:456/AndoridServer/getLocationAction?lat=30&lng=100";
		BufferedReader in = null;
		String jsonContext = "";
		URL realUrl = new URL(url);  
        URLConnection connection = realUrl.openConnection();  
        connection.connect();  
        in = new BufferedReader(new InputStreamReader(connection.getInputStream(), "utf8"));  
        String line;  
        while ((line = in.readLine()) != null) {  
            jsonContext += line;  
        }  
        System.out.println(jsonContext);
	}
}
