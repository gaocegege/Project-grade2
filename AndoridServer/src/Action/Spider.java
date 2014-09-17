package Action;

import java.util.List;

import org.apache.struts2.json.annotations.JSON;

import Domain.Content;
import Service.HtmlService;
import Service.SpiderService;
import Service.DBService.ContentService;

import com.opensymphony.xwork2.ActionSupport;

/**
 * ÅÀÈ¡ÐÂÎÅ
 * @author cece
 *
 */
public class Spider extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private HtmlService htmlService;
	private String ContentChina;
	private String ContentWorld;
	private String ContentSociety;

	// private JsonToJava jsonToJava;


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

	@JSON(serialize=false)
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
		
		// HTML Service is responsible for get the contents from the URL
		htmlService.parseHtml(URLChina);
		
		System.out.println("china finish!");
		
		htmlService.parseHtml(URLWorld);
		
		System.out.println("world finish!");
		
		htmlService.parseHtml(URLSociety);

		System.out.println("all finish!");
		return SUCCESS;
	}

}
