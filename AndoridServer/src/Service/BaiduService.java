package Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import Domain.Content;
import Domain.NewsContent;

public class BaiduService {

	public List<Content> search(String searchContext, int id)
			throws IOException {
		System.out.println(searchContext);
		List<Content> result = new ArrayList<Content>();
		String urlA = "http://news.baidu.com/ns?word=";
		String urlB = "&tn=newstitle&from=news&cl=2&rn=20&ct=0";
		
		String url = urlA + searchContext + urlB + "&pn=" + id;
		Document doc;
		doc = Jsoup.connect(url).get();
		Element news = doc.getElementById("content_left");
		Elements newsList = news.getElementsByTag("li");
		int num;
		if (newsList.size() > 20)
			num = 20;
		else
			num = newsList.size();
		for (int i = 0; i < num; i++) {
			Content buf = new Content();
			NewsContent newsContent = new NewsContent();
			String id_str = newsList.get(i).attr("id").toString();
			System.out.println(id_str);
			String title = newsList.get(i).getElementsByTag("h3").get(0).text();
			String newsUrl = newsList.get(i).getElementsByTag("h3").get(0)
					.getElementsByTag("a").get(0).attr("href");

			String author_time = newsList.get(i).getElementsByTag("span")
					.text();

			String f = author_time.substring(0, 1);
			String[] list = author_time.split(f);
			String from = list[1];
			if (from.equals(""))
				from = null;
			String time = list[2];
			System.out.println(title);
			buf.setFrom(from);
			buf.setId(Integer.parseInt(id_str));
			buf.setTime(time);
			buf.setTitle(title);
			buf.setUrl(newsUrl);
			result.add(buf);
		}
		return result;
	}

	public static void main(String args[]) throws IOException {
		String searchContext = "广东 可疑男子";
		int id = 0;
		String urlA = "http://news.baidu.com/ns?word=";
		String urlB = "&tn=newstitle&from=news&cl=2&rn=20&ct=0";
		String url = urlA + searchContext + urlB + "&pn=" + id;
		Document doc;
		doc = Jsoup.connect(url).get();

		Element news = doc.getElementById("content_left");
		Elements newsList = news.getElementsByTag("li");
		System.out.println(newsList.get(0).toString());
		int num;
		if (newsList.size() > 20)
			num = 20;
		else
			num = newsList.size();
		for (int i = 0; i < num; i++) {
			Content buf = new Content();
			NewsContent newsContent = new NewsContent();

			String id_str = newsList.get(i).attr("id").toString();
			String title = newsList.get(i).getElementsByTag("h3").get(0).text();
			String newsUrl = newsList.get(i).getElementsByTag("h3").get(0)
					.getElementsByTag("a").get(0).attr("href");
			System.out.println(newsUrl);
			String author_time = newsList.get(i).getElementsByTag("span")
					.text();
			// System.out.println(id_str);
			// System.out.println(title);
			// System.out.println(author_time);

			String f = author_time.substring(0, 1);
			String[] list = author_time.split(f);
			String from = list[1];
			if (from.equals(""))
				from = null;
			String time = list[2];
			System.out.println(time);
		}
	}
}
