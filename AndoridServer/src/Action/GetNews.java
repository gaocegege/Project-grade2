package Action;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.json.annotations.JSON;

import Domain.Content;
import Service.DBService.ContentService;

import com.opensymphony.xwork2.ActionSupport;

public class GetNews extends ActionSupport{
	
	public class Loc {
		private String url;
		private String title;

		public String getUrl() {
			return url;
		}

		public void setUrl(String url) {
			this.url = url;
		}

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}
	}
	
	private String Idlist;
	private List<Loc> result;
	private ContentService contentService;
	
	
	@JSON(serialize = false)
	public String getIdlist() {
		return Idlist;
	}
	public void setIdlist(String idlist) {
		Idlist = idlist;
	}
	public List<Loc> getResult() {
		return result;
	}
	public void setResult(List<Loc> result) {
		this.result = result;
	}
	@JSON(serialize = false)
	public ContentService getContentService() {
		return contentService;
	}
	public void setContentService(ContentService contentService) {
		this.contentService = contentService;
	}
	public String execute(){
		String[] arr = Idlist.split(",");
		result = new ArrayList<Loc>();
		for(String s:arr){
			int id = Integer.parseInt(s);
			Content c = contentService.getOneContent(id);
			Loc cur = new Loc();
			cur.setTitle(c.getTitle());
			cur.setUrl(c.getUrl());
			result.add(cur);
		}
		return SUCCESS;
	}
}
