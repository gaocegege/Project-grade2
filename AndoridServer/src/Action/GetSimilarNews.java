package Action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.json.annotations.JSON;

import Domain.Content;
import Domain.Token;
import Service.BaiduService;
import Service.ChooseService;
import Service.ContentService;
import Service.SplitService;

import com.opensymphony.xwork2.ActionSupport;

public class GetSimilarNews extends ActionSupport {
	private int id;
	private int pid;
	private List<Content> result;
	private BaiduService baiduService;
	private ContentService contentService;
	private SplitService splitService;
	private ChooseService chooseService;
	
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
	public ContentService getContentService() {
		return contentService;
	}
	public void setContentService(ContentService contentService) {
		this.contentService = contentService;
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
		Content cur = contentService.getOneContent(id);
		List<Token> context = splitService.split(cur.getTitle());
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
