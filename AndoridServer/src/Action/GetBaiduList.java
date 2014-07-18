package Action;

import java.io.IOException;
import java.util.List;

import org.apache.struts2.json.annotations.JSON;

import Domain.Content;
import Service.BaiduService;
import Service.SearchFormat;

import com.opensymphony.xwork2.ActionSupport;

public class GetBaiduList extends ActionSupport {
	private int id;
	private int pid;
	private int types;
	private List<Content> result;
	private BaiduService baiduService;
	
	@JSON(serialize=false)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@JSON(serialize=false)
	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public List<Content> getResult() {
		return result;
	}

	public int getTypes() {
		return types;
	}

	public void setTypes(int types) {
		this.types = types;
	}

	public void setResult(List<Content> result) {
		this.result = result;
	}

	@JSON(serialize=false)
	public BaiduService getBaiduService() {
		return baiduService;
	}

	public void setBaiduService(BaiduService baiduService) {
		this.baiduService = baiduService;
	}

	public String execute() throws IOException
	{
		result = baiduService.searchByKey(id, pid);
		return SUCCESS;
	}
}
