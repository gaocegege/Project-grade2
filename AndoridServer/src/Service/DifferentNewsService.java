package Service;
//TO DO
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class DifferentNewsService {
	public static List<String> getNews(String title) throws IOException
	{
		//String queryUrlB = "http://news.yodao.com/search?q=";
		//String queryUrlE = "&s=rank&tr=no_range&keyfrom=search.bytime&tl";
		//String queryUrl = queryUrlB + title + queryUrlE;
		
		String queryUrl = "http://api.ltp-cloud.com/analysis/?api_key=c1H8M0n9CrIK1q4yOaPzuK0d8Y7EgRzrYdhkhBzH&text="
			 + title + "&pattern=dp&format=json";
		
		Document doc = Jsoup.parse(new URL(queryUrl).openStream(), "UTF-8", queryUrl);
		//Element result = doc.getElementById("results");
		
		//String hehe = new String(doc.text().getBytes("utf-8"), "utf-8");
		
		Elements heheh = doc.getElementsByTag("pre");
		String asd = heheh.text();
		String hehe = doc.toString();
		
		
		return null;
	}
	
	public static void main(String[] args)
	{
		try {
			getNews("夺刀少年谈被省内高校录取:南昌大学第一个表态");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
