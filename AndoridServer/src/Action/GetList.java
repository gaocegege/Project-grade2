package Action;

import org.apache.struts2.json.annotations.JSON;

import Service.ContentService;

import com.opensymphony.xwork2.ActionSupport;

public class GetList extends ActionSupport {
	private int id;
	private String result;
	private ContentService contentService;

	public void setContentService(ContentService contentService) {
		this.contentService = contentService;
	}
	
	@JSON(serialize=false)
	public ContentService getContentService() {
		return contentService;
	}
	
	public void setResult(String result) {
		this.result = result;
	}

	public String getResult() {
		return result;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	@JSON(serialize=false)
	public int getId() {
		return id;
	}

	public String execute()
	{
		result = contentService.getContents(id);
		return SUCCESS;
	}
}
