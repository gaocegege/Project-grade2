package Action;

import java.io.IOException;

import org.apache.struts2.json.annotations.JSON;

import Service.BaiduServices.BaiduService;

import com.opensymphony.xwork2.ActionSupport;


/**
 * 得到时间轴列表
 * @author Li Xu
 * 
 */

public class GetBaiduSum  extends ActionSupport{
	private String title;
	private String result;
	private BaiduService baiduService;
	
	@JSON(serialize=false)
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	@JSON(serialize=false)
	public BaiduService getBaiduService() {
		return baiduService;
	}
	public void setBaiduService(BaiduService baiduService) {
		this.baiduService = baiduService;
	}
	public String execute() throws IOException{
		String str=new String(title.getBytes("ISO-8859-1"),"UTF-8");
		result = baiduService.searchForSum(str);
		return SUCCESS;
	}
}
