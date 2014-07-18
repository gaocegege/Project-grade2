package Action;

import java.util.List;
import java.util.Map;

import Domain.Content;
import net.sf.json.JSONArray;

import org.apache.struts2.json.annotations.JSON;

import Service.ContentService;

import com.opensymphony.xwork2.ActionSupport;

public class GetList extends ActionSupport {
	private int id;
	private int types;
	private int method;
	private List<Content> result;
	private ContentService contentService;

	public void setContentService(ContentService contentService) {
		this.contentService = contentService;
	}

	@JSON(serialize = false)
	public ContentService getContentService() {
		return contentService;
	}

	public void setResult(List<Content> result) {
		this.result = result;
	}

	public List<Content> getResult() {
		return result;
	}

	public void setId(int id) {
		this.id = id;
	}

	@JSON(serialize = false)
	public int getId() {
		return id;
	}

	@JSON(serialize = false)
	public int getTypes() {
		return types;
	}

	public void setTypes(int types) {
		this.types = types;
	}

	public String execute() {
		result = contentService.getContents(id, types, method);
		return SUCCESS;
	}
}
