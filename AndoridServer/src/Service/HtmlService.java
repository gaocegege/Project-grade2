package Service;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class HtmlService {
	public String parseHtml(int id)
	{
		try {
			Document doc = Jsoup.connect("http://top.yi18.net/show/" + id).get();
			Elements article_body = doc.getElementsByClass("article-body");
			System.out.println(article_body.text());
			return article_body.text();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static void main(String args[])
	{
		//parseHtml(979);
	}
}
