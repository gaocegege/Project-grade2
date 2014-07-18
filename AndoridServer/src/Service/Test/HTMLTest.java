package Service.Test;

import Service.HtmlService;

public class HTMLTest {
	public static void main(String args[])
	{
		HtmlService htmlService = new HtmlService();
		htmlService.parseHtml("http://news.sina.com.cn/china/");
	}
}
