package Action;

import Service.SpiderService;

import com.opensymphony.xwork2.ActionSupport;

public class Test extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private SpiderService spiderService;
	private String jsonContent;

	
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

	public String execute()
	{
		String URL = "http://api.yi18.net/top/list";
		jsonContent = "";
		jsonContent = spiderService.sendGet(URL);
		return SUCCESS;
	}
}
