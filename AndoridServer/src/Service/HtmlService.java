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
			int types;
			String[] urlC = queryUrl.split("/");
			if (urlC[3].equals("china"))
			{
				types = 0;
			}else if(urlC[3].equals("world")){
				types = 1;
			}else if(urlC[3].equals("society")){
				types = 2;
			}else{
				types = -1;
				return null;
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
				Document docInside;
				docInside = Jsoup.connect(url).get();
				Element newsbody = docInside.getElementById("artibody");
				String newsContent = newsbody.getElementsByTag("p").text();
				Elements image = newsbody.getElementsByClass("img_wrapper");
				String imageUrl;
				if(image.size()==0){
					imageUrl = null;
				}else{
					imageUrl = image.get(0).getElementsByTag("img").get(0).attr("src");
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public static void main(String args[]) throws IOException
	{
		String queryUrl = "http://news.sina.com.cn/china/";
		String url = "http://news.sina.com.cn/c/2014-07-11/115430505150.shtml";
		Document docInside;
		docInside = Jsoup.connect(url).get();
		Element newsbody = docInside.getElementById("artibody");
		String imgurl = newsbody.getElementsByClass("img_wrapper").get(0).getElementsByTag("img").get(0).attr("src");
		System.out.println(imgurl);
		//System.out.println(newsbody.text());
	}
}
