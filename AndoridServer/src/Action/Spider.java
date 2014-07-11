package Action;

import java.util.List;

import Domain.Content;
import Service.ContentService;
import Service.HtmlService;
import Service.SpiderService;

import com.opensymphony.xwork2.ActionSupport;

public class Spider extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private SpiderService spiderService;
	private ContentService contentService;
	private HtmlService htmlService;
	private String ContentChina;
	private String ContentWorld;
	private String ContentSociety;

	// private JsonToJava jsonToJava;

	public void setSpiderService(SpiderService spiderService) {
		this.spiderService = spiderService;
	}

	public SpiderService getSpiderService() {
		return spiderService;
	}

	public void setContentChina(String contentchina) {
		this.ContentChina = contentchina;
	}

	public String getContentChina() {
		return ContentChina;
	}

	public void setContentWorld(String contentworld) {
		this.ContentWorld = contentworld;
	}

	public String getContentWorld() {
		return ContentWorld;
	}

	public String getContentSociety() {
		return ContentSociety;
	}

	public void setContentSociety(String contentSociety) {
		ContentSociety = contentSociety;
	}

	public ContentService getContentService() {
		return contentService;
	}

	public void setContentService(ContentService contentService) {
		this.contentService = contentService;
	}

	public HtmlService getHtmlService() {
		return htmlService;
	}

	public void setHtmlService(HtmlService htmlService) {
		this.htmlService = htmlService;
	}

	public String execute() {
		String URLChina = "http://news.sina.com.cn/china/";
		String URLWorld = "http://news.sina.com.cn/world/";
		String URLSociety = "http://news.sina.com.cn/society/";
		
		List<Content> newsChina = htmlService.parseHtml(URLChina);
		for (int i = 0; i < newsChina.size(); i++){
			contentService.addContent(newsChina.get(i));
		}
		
		List<Content> newsWorld =  htmlService.parseHtml(URLChina);
		for (int i = 0; i < newsWorld.size(); i++){
			contentService.addContent(newsWorld.get(i));
		}
		
		List<Content> newsSociety =  htmlService.parseHtml(URLChina);
		for (int i = 0; i < newsSociety.size(); i++){
			contentService.addContent(newsSociety.get(i));
		}

		return SUCCESS;
	}

}
