package Action;

import java.util.List;

import org.apache.struts2.json.annotations.JSON;

import Domain.Content;
import Service.SpiderService;
import Service.DBService.ContentService;
import Service.JsonParserService.JsonToJava;

import com.opensymphony.xwork2.ActionSupport;

public class Test extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private SpiderService spiderService;
	private String jsonContent;
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
		JsonToJava jsonToJava = new JsonToJava();
		List<Content> TestList = jsonToJava.transfer(jsonContent);
		for (int i = 0; i < TestList.size(); i++)
		{
			contentService.addContent(TestList.get(i));
		}
		return SUCCESS;
	}
}
