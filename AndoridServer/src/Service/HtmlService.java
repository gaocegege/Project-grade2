package Service;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import Domain.Content;
import Domain.NewsContent;

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
		List<Content> results = new ArrayList<Content>();
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
				if (!newsList.get(i).attr("id").equals(""))
					continue;
				Content buf = new Content();
				NewsContent newsContent = new NewsContent();
				String time = newsList.get(i).getElementsByClass("time").text();
				String title = newsList.get(i).getElementsByTag("h2").get(0).getElementsByTag("a").get(0).text();
				String url = newsList.get(i).getElementsByTag("h2").get(0).getElementsByTag("a").get(0).attr("href").toString();
				if(url.contains("slide")||url.contains("video"))
					continue;
				Document docInside;
				docInside = Jsoup.connect(url).get();
				Element newsbody = docInside.getElementById("artibody");
				String newsContentStr = newsbody.getElementsByTag("p").text();
				String from = docInside.getElementById("media_name").text();
				Elements image = newsbody.getElementsByClass("img_wrapper");
				String imageUrl;
				if(image.size()==0){
					imageUrl = null;
				}else{
					imageUrl = image.get(0).getElementsByTag("img").get(0).attr("src").toString();
				}
				newsContent.setContents(newsContentStr);
				buf.setImageUrl(imageUrl);
				buf.setTitle(title);
				buf.setTypes(types);
				buf.setTime(time);
				buf.setUrl(url);
				buf.setFrom(from);
				newsContent.setContent(buf);
				buf.setNewsContent(newsContent);
				results.add(buf);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return results;
	}
	
	public static void main(String args[]) throws IOException
	{
		ContentService cs = new ContentService();
		String queryUrl = "http://news.sina.com.cn/china/";
		Document doc;
		doc = Jsoup.connect(queryUrl).get();
		Element news = doc.getElementById("subShowContent1_static");
		Elements newsList = news.getElementsByClass("news-item");
		Content buf = new Content();
		NewsContent newsContent = new NewsContent();
		String time = newsList.get(0).getElementsByClass("time").text();
		String title = newsList.get(0).getElementsByTag("h2").get(0).getElementsByTag("a").get(0).text();
		String url = newsList.get(0).getElementsByTag("h2").get(0).getElementsByTag("a").get(0).attr("href").toString();
		Document docInside;
		docInside = Jsoup.connect(url).get();
		Element newsbody = docInside.getElementById("artibody");
		String newsContentStr = newsbody.getElementsByTag("p").text();
		Elements image = newsbody.getElementsByClass("img_wrapper");
		String imageUrl;
		if(image.size()==0){
			imageUrl = null;
		}else{
			imageUrl = image.get(0).getElementsByTag("img").get(0).attr("src").toString();
		}
		newsContent.setContents(newsContentStr);
		buf.setImageUrl(imageUrl);
		buf.setTitle(title);
		buf.setTypes(0);
		buf.setTime(time);
		String url2 = new String(url.getBytes(),"utf-8");
		//System.out.println(new String(url.getBytes(), "utf-8"));
		buf.setUrl(url2);
		newsContent.setContent(buf);
		buf.setNewsContent(newsContent);

	}
}
