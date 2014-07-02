package Action;

import Service.JsonToJava;
import Service.SpiderService;

import com.opensymphony.xwork2.ActionSupport;

public class Spider extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private SpiderService spiderService;
	private String jsonContent;
	private JsonToJava jsonToJava;

	
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


	public String execute()
	{
		String URL = "http://api.yi18.net/top/list";
		jsonContent = "";
		jsonContent = spiderService.sendGet(URL);
		jsonContent = "[" + jsonContent + "]";
		return SUCCESS;
	}
}
