package Action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.json.annotations.JSON;

import com.opensymphony.xwork2.ActionSupport;

import Domain.Content;
import Service.SearchFormat;
import Service.BaiduServices.BaiduService;

/**
 * 得到二级列表
 * @author Lixu
 *
 */
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
		str = str.replaceAll(" ", "%20");
		String searchContext = searchFormat.getSearchSent(str);
		System.out.println(searchContext);
		result = baiduService.search(searchContext, pid);
		if(result == null)
			result = new ArrayList<Content>();
		return SUCCESS;
	}
}
