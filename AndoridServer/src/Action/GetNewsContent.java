package Action;

import org.apache.struts2.json.annotations.JSON;

import Service.DBService.ContentService;
import Service.DBService.NewsContentService;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 得到新闻正文
 * @author cece
 *
 */
public class GetNewsContent extends ActionSupport {
	private int id;
	private String result;
	private NewsContentService newsContentService;
	
	@JSON(serialize = false)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	@JSON(serialize = false)
	public NewsContentService getNewsContentService() {
		return newsContentService;
	}

	public void setNewsContentService(NewsContentService newsContentService) {
		this.newsContentService = newsContentService;
	}
	
	public String execute() {
		result = newsContentService.getNewsContents(id).getContents();
		return SUCCESS;
	}

}
