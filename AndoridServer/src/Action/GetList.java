package Action;

import java.util.Map;

import net.sf.json.JSONArray;

import org.apache.struts2.json.annotations.JSON;

import Service.ContentService;

import com.opensymphony.xwork2.ActionSupport;

public class GetList extends ActionSupport {
	private int id;
	private ContentService contentService;
	private JSONArray result;

	public void setContentService(ContentService contentService) {
		this.contentService = contentService;
	}
	
	@JSON(serialize=false)
	public ContentService getContentService() {
		return contentService;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	@JSON(serialize=false)
	public int getId() {
		return id;
	}
	
	public void setResult(JSONArray result) {
		this.result = result;
	}

	public JSONArray getResult() {
		return result;
	}

	public String execute()
	{
		result = contentService.getContents(id);
		return SUCCESS;
	}
}
