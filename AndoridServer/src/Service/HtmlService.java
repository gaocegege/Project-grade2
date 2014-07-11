package Service;

import java.io.IOException;
import java.net.URL;
import java.util.List;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import Domain.Content;

public class HtmlService {
	private ContentService contentService;
	
	public void setContentService(ContentService contentService) {
		this.contentService = contentService;
	}

	public ContentService getContentService() {
		return contentService;
	}

	//get news from sina
	public List<Content> parseHtml(String queryUrl)
	{
		try {
			// get the types
			//china: 	0
			//world: 	1
			//society: 	2
			String[] urlC = queryUrl.split("/");
			if (urlC[1].equals("china"))
			{
				int types = 0;
			}
			Document doc;
			doc = Jsoup.connect(queryUrl).get();
			Element news = doc.getElementById("subShowContent1_static");
			Elements newsList = news.getElementsByClass("news-item");
			for (int i = 0; i < newsList.size(); i++)
			{
				Content buf = new Content();
				String time = newsList.get(i).getElementsByClass("time").toString();
				String title = newsList.get(i).getElementsByTag("h2").get(0).getElementsByTag("a").get(0).toString();
				String url = newsList.get(i).getElementsByTag("h2").get(0).getElementsByTag("a").get(0).attr("href");
				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String args[])
	{
		//parseHtml(979);
	}
}
