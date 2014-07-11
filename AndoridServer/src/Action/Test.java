package Action;

import java.util.List;

import org.apache.struts2.json.annotations.JSON;

import Domain.Content;
import Service.ContentService;
import Service.JsonToJava;
import Service.SpiderService;

import com.opensymphony.xwork2.ActionSupport;


public class Test extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private SpiderService spiderService;
	private String jsonContent;
	private JsonToJava jsonToJava;
	private ContentService contentService;

	
	public void setSpiderService(SpiderService spiderService) {
		this.spiderService = spiderService;
	}


	public SpiderService getSpiderService() {
		return spiderService;
	}
	
	public void setJsonContent(String jsonContent) {
		this.jsonContent = jsonContent;
	}


	public String getJsonContent() {
		return jsonContent;
	}
	
	public void setJsonToJava(JsonToJava jsonToJava) {
		this.jsonToJava = jsonToJava;
	}


	public JsonToJava getJsonToJava() {
		return jsonToJava;
	}

	public void setContentService(ContentService contentService) {
		this.contentService = contentService;
	}

	@JSON(serialize=false)
	public ContentService getContentService() {
		return contentService;
	}


	public String execute()
	{
		//System.out.println("Test action begins");
		String URL = "http://api.yi18.net/top/list";
		jsonContent = "";
		jsonContent = spiderService.sendGet(URL);
		jsonContent  = "[" + jsonContent + "]";
		List<Content> TestList = jsonToJava.transfer(jsonContent);
		for (int i = 0; i < TestList.size(); i++)
		{
			contentService.addContent(TestList.get(i));
		}
		contentService.getContents(0);
		return SUCCESS;
	}
}
