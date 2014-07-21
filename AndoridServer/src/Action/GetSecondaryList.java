package Action;

import java.io.IOException;
import java.util.List;

import org.apache.struts2.json.annotations.JSON;

import com.opensymphony.xwork2.ActionSupport;

import Domain.Content;
import Service.BaiduService;
import Service.SearchFormat;

public class GetSecondaryList extends ActionSupport{
	private int pid;
	private String title;
	private List<Content> result;
	private BaiduService baiduService;
	private SearchFormat searchFormat;
	
	@JSON(serialize = false)
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	@JSON(serialize = false)
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public List<Content> getResult() {
		return result;
	}
	public void setResult(List<Content> result) {
		this.result = result;
	}
	@JSON(serialize = false)
	public BaiduService getBaiduService() {
		return baiduService;
	}
	public void setBaiduService(BaiduService baiduService) {
		this.baiduService = baiduService;
	}
	@JSON(serialize = false)
	public SearchFormat getSearchFormat() {
		return searchFormat;
	}
	public void setSearchFormat(SearchFormat searchFormat) {
		this.searchFormat = searchFormat;
	}
	public String execute() throws IOException{
		System.out.println(title);
		String str=new String(title.getBytes("ISO-8859-1"),"UTF-8");
		System.out.println(str);
		String searchContext = searchFormat.getSearchSent(str);
		result = baiduService.search(searchContext, pid);
		return SUCCESS;
	}
}
