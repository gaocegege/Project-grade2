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
import Domain.Geo;
import Domain.KeyWord;
import Domain.Location;
import Domain.NewsContent;
import Service.BaiduServices.BaiduMapService;
import Service.DBService.ContentService;
import Service.DBService.KeyWordService;
import Service.DBService.LocationService;

public class HtmlService {
	private ContentService contentService;
	private KeyWordService keyWordService;
	private BaiduMapService baiduMapService;
	private LocationService locationService;
	private GetLocation getLocation;
	

	public LocationService getLocationService() {
		return locationService;
	}

	public void setLocationService(LocationService locationService) {
		this.locationService = locationService;
	}

	public GetLocation getGetLocation() {
		return getLocation;
	}

	public void setGetLocation(GetLocation getLocation) {
		this.getLocation = getLocation;
	}

	public void setBaiduMapService(BaiduMapService baiduMapService) {
		this.baiduMapService = baiduMapService;
	}

	public BaiduMapService getBaiduMapService() {
		return baiduMapService;
	}

	public void setContentService(ContentService contentService) {
		this.contentService = contentService;
	}

	public void setKeyWordService(KeyWordService keyWordService) {
		this.keyWordService = keyWordService;
	}

	public KeyWordService getKeyWordService() {
		return keyWordService;
	}

	public ContentService getContentService() {
		return contentService;
	}

	//get news from sina
	public void parseHtml(String queryUrl)
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
				return;
			}
			Document doc;
			doc = Jsoup.connect(queryUrl).get();
			Element news = doc.getElementById("subShowContent1_static");
			Elements newsList = news.getElementsByClass("news-item");
			// get the news by time
			for (int i = newsList.size() - 1; i >= 0; i--)
			{
				System.out.println("BBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBB");
				if (!newsList.get(i).attr("id").equals(""))
					continue;
				
				// the content item
				Content contentBuf = new Content();
				// the newsContent item
				NewsContent newsContent = new NewsContent();
				String time = newsList.get(i).getElementsByClass("time").text();
				String title = newsList.get(i).getElementsByTag("h2").get(0).getElementsByTag("a").get(0).text();
				String url = newsList.get(i).getElementsByTag("h2").get(0).getElementsByTag("a").get(0).attr("href").toString();
				//pass the video and slide
				if(url.contains("slide")||url.contains("video"))
					continue;
				//pass the dumplicate news
				if (contentService.hasContained(title))
				{
					continue;
				}
				System.out.println("Get Inside Html: Begin~");
				// get the content page
				Document docInside = Jsoup.connect(url).get();
				System.out.println("Get Inside Html: End~");
				Element newsbody = docInside.getElementById("artibody");
				// the content of the news
				String newsContentStr = newsbody.getElementsByTag("p").text();
<<<<<<< HEAD
				// fit the database
				if(newsContentStr.length()>=4000)
					continue;
				//lai yuan
=======
				// if the news are too long, continue (will be fixed in the future)
				// if it is, the code will be paused there
				if(newsContentStr.length()>=500)
				{
					System.out.println("The content is too long");
					continue;
				}
				//source of the news
>>>>>>> Cece-From-17
				String from = docInside.getElementById("media_name").text();
				System.out.println("From: " + from);
				Elements image = newsbody.getElementsByClass("img_wrapper");
				// get the url of the image(if it have)
				String imageUrl;
				if(image.size()==0)
				{
					imageUrl = null;
				}
				else
				{
					imageUrl = image.get(0).getElementsByTag("img").get(0).attr("src").toString();
				}
				System.out.println("Set the values");
				newsContent.setContents(newsContentStr);
				contentBuf.setImageUrl(imageUrl);
				contentBuf.setTitle(title);
				contentBuf.setTypes(types);
				contentBuf.setTime(time);
				contentBuf.setUrl(url);
				contentBuf.setFrom(from);
				newsContent.setContent(contentBuf);
				//to do---------------------------------------------------------------------------------
				System.out.println("Add Content: Begin~");
				contentBuf.setNewsContent(newsContent);
				contentService.addContent(contentBuf);
				System.out.println("Add Content: End~");
				
				Elements keyWordsContainer = docInside.getElementsByClass("art_keywords");
				System.out.println("Log for the keyWords: Begin");
				Elements keyWords = keyWordsContainer.get(0).getElementsByTag("a");
				for (int j = 0; j < keyWords.size(); j++)
				{
					//To DO
					KeyWord keyWord = new KeyWord();
					keyWord.setContent(contentBuf);
					keyWord.setKeyWord(keyWords.get(j).text());
					keyWordService.addKeyWord(keyWord);
					System.out.println(keyWords.get(j).text());
				}
				System.out.println("Log for the keyWords: End");
				
				//get all the location, and save it
				List<Location> locationList = getLocation.getLocation(newsContentStr);
				for (int j = 0; j < locationList.size(); j++)
				{
					locationList.get(j).setNewsContent(newsContent);
					System.out.println("FXXK:" + locationList.get(j).getLocation());
					locationService.addLocation(locationList.get(j));
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return;
	}
}
