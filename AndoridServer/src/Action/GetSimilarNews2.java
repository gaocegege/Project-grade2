package Action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.json.annotations.JSON;

import Domain.Content;
import Domain.Token;
import Service.ChooseService;
import Service.SplitService;
import Service.BaiduServices.BaiduService;
import Service.DBService.ContentService;

import com.opensymphony.xwork2.ActionSupport;

public class GetSimilarNews2 extends ActionSupport {
	private String title;
	private int pid;
	private List<Content> result;
	private BaiduService baiduService;

	private SplitService splitService;
	private ChooseService chooseService;
	
	@JSON(serialize=false)
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
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

	@JSON(serialize=false)
	public SplitService getSplitService() {
		return splitService;
	}
	public void setSplitService(SplitService splitService) {
		this.splitService = splitService;
	}
	@JSON(serialize=false)
	public ChooseService getChooseService() {
		return chooseService;
	}
	public void setChooseService(ChooseService chooseService) {
		this.chooseService = chooseService;
	}
	public String execute() throws IOException{	
		String str=new String(title.getBytes("ISO-8859-1"),"UTF-8");
		List<Token> context = splitService.split(str);
		List<String> context2 = new ArrayList<String>();
		String searchContext = "";
		for(Token s:context){
			if(!s.getPos().equals("wp")){
				System.out.println(s.getPos());
				searchContext += s.getCont()+" ";
				context2.add(s.getCont());
			}
		}
		System.out.println(searchContext);
		List<Content> baiduResult = baiduService.searchByWords(searchContext, pid);
		result = chooseService.choose(baiduResult, context2);
		return SUCCESS;
	}
}