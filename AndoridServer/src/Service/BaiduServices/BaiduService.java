package Service.BaiduServices;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import DAO.ContentDAO;
import Domain.Content;
import Domain.KeyWord;
import Domain.NewsContent;

/**
 * 
 * @author Lixu
 *
 */
public class BaiduService {
	private ContentDAO contentDAO;
	
	public ContentDAO getContentDAO() {
		return contentDAO;
	}


	public void setContentDAO(ContentDAO contentDAO) {
		this.contentDAO = contentDAO;
	}
	
	/**
	 * 根据新闻标题获得100条相关新闻（如果存在）
	 * @param searchContext
	 * @return
	 * @throws IOException 
	 */
	public List<Content> searchHundread(String searchContext) throws IOException
	{
		List<Content> result = new ArrayList<Content>();
		for (int pid = 0; pid <100; pid += 20)
		{
			result.addAll(this.search(searchContext, pid));
		}
		System.out.println("HundreadResult's size is " + result.size());
		return result;
	}
	
	/**
	 * 根据id获得100条相关新闻（如果存在）
	 * @param id
	 * @return
	 * @throws IOException
	 */
	public List<Content> searchHundread(int id) throws IOException
	{
		List<Content> result = new ArrayList<Content>();
		for (int pid = 0; pid <100; pid += 20)
		{
			result.addAll(this.searchByKey(id, pid));
		}
		System.out.println("HundreadResult's size is " + result.size());
		return result;
	}
	
	/**
	 * 根据新闻关键字和id寻找相关新闻，id负责翻页（对应searchByKey的pid）
	 * @param searchContext
	 * @param id
	 * @return
	 * @throws IOException
	 */
	public List<Content> search(String searchContext, int id)
			throws IOException {
		System.out.println(searchContext);
		List<Content> result = new ArrayList<Content>();
		String urlA = "http://news.baidu.com/ns?word=";
		String urlB = "&tn=newstitle&from=news&cl=2&rn=20&ct=0";
		
		/*
		 * id用来实现翻页，20为一页，20，40，60递增
		 */
		String url = urlA + searchContext + urlB + "&pn=" + id;
		Document doc;
		doc = Jsoup.connect(url).get();
		Element news = doc.getElementById("content_left");
		//Elements newsList = news.getElementsByTag("li");
		Elements newsList = news.getElementsByClass("result");
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
	
	/**
	 * 根据新闻的id，和pid取得相关新闻，pid负责翻页
	 * @param id
	 * @param pid
	 * @return
	 * @throws IOException
	 */
	public List<Content> searchByKey(int id, int pid)
			throws IOException {
		Content cur = contentDAO.getOneContent(id);
		String searchContext = "";
		for(KeyWord kw:cur.getKeyWord()){
			searchContext += " "+kw.getKeyWord();
		}

		List<Content> result = new ArrayList<Content>();
		String urlA = "http://news.baidu.com/ns?word=";
		String urlB = "&tn=news&from=news&cl=2&rn=20&ct=0&clk=sortbytime";
		
		String url = urlA + searchContext + urlB + "&pn=" + pid;
		System.out.println(url);
		Document doc;
		doc = Jsoup.connect(url).get();
		Element news = doc.getElementById("content_left");
		//Elements newsList = news.getElementsByTag("li");
		Elements newsList = news.getElementsByClass("result");
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
			String imageUrl = null;
			Elements pic = newsList.get(i).getElementsByTag("img");
			if(pic.size()!=0)
				imageUrl = pic.get(0).attr("src");
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
			buf.setImageUrl(imageUrl);
			result.add(buf);
		}
		return result;
	}
	
	/**
	 * 不知道跟search有何区别~
	 * @param searchContext
	 * @param id
	 * @return
	 * @throws IOException
	 */
	public List<Content> searchByWords(String searchContext,int id)
			throws IOException {
		List<Content> result = new ArrayList<Content>();
		String urlA = "http://news.baidu.com/ns?word=";
		String urlB = "&tn=news&from=news&cl=2&rn=50&ct=0";
		
		String url = urlA + searchContext + urlB + "&pn=" + id;
		System.out.println(url);
		Document doc;
		doc = Jsoup.connect(url).get();
		Element news = doc.getElementById("content_left");
		//Elements newsList = news.getElementsByTag("li");
		Elements newsList = news.getElementsByClass("result");
		if(newsList == null)
			return null;
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

			String author_time = newsList.get(i).getElementsByTag("span")
					.text();
			String imageUrl = null;
			Elements pic = newsList.get(i).getElementsByTag("img");
			if(pic.size()!=0)
				imageUrl = pic.get(0).attr("src");
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
			buf.setImageUrl(imageUrl);
			result.add(buf);
		}
		return result;
	}
	
	/**
	 * main函数
	 * @param args
	 * @throws IOException
	 */
	public static void main(String args[]) throws IOException {
		String searchContext = "广东 可疑男子";
		int id = 0;
		List<Content> result = new ArrayList<Content>();
		String urlA = "http://news.baidu.com/ns?word=";
		String urlB = "&tn=news&from=news&cl=2&rn=20&ct=0&clk=sortbytime";
		
		String url = urlA + searchContext + urlB;
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
			String imageUrl = null;
			Elements pic = newsList.get(i).getElementsByTag("img");
			if(pic.size()!=0)
				imageUrl = pic.get(0).attr("src");
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
			buf.setImageUrl(imageUrl);
			result.add(buf);
		}
	}
}
