package Action;

import java.io.IOException;
import java.util.List;

import org.apache.struts2.json.annotations.JSON;

import Domain.Content;
import Service.SearchFormat;
import Service.BaiduServices.BaiduService;
import Service.DBService.ContentService;
import Service.SimilarityServices.SimilarityService;
import Service.SimilarityServices.MySimilarityService;
import Service.ThreadServices.ThreadService;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 得到时间轴列表
 * @author Li Xu
 * 
 */
public class GetBaiduList extends ActionSupport {
	private int id;
	private int pid;
	private int types;
	private List<Content> result;
	private BaiduService baiduService;
	private SimilarityService similarityService;
	private MySimilarityService mySimilarityService;
	private ContentService contentService;
//	private ThreadService threadService;
//	
//	public void setThreadService(ThreadService threadService) {
//		this.threadService = threadService;
//	}
//	
//	@JSON(serialize=false)
//	public ThreadService getThreadService() {
//		return threadService;
//	}

	public void setMySimilarityService(MySimilarityService mySimilarityService) {
		this.mySimilarityService = mySimilarityService;
	}
	
	@JSON(serialize=false)
	public MySimilarityService getMySimilarityService() {
		return mySimilarityService;
	}

	@JSON(serialize=false)
	public ContentService getContentService() {
		return contentService;
	}

	public void setContentService(ContentService contentService) {
		this.contentService = contentService;
	}

	public void setSimilarityService(SimilarityService similarityService) {
		this.similarityService = similarityService;
	}
	
	@JSON(serialize=false)
	public SimilarityService getSimilarityService() {
		return similarityService;
	}

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

	public String execute() throws Exception
	{
		result = baiduService.searchHundread(id);
		for (int i = result.size() - 1; i >= 0; i--)
		{
//			float re = similarityService.similarScore(contentService.getOneContent(id).getTitle(), result.get(i).getTitle());
			//wait to be tested
			float re = mySimilarityService.calculateSimilarityLCS(contentService.getOneContent(id).getTitle(), result.get(i).getTitle());
			System.out.println("re:\t" + re);
			if (re < 0.1)
				result.remove(i);
		}
//		result = threadService.dealWithResults(contentService.getOneContent(id).getTitle(), bufList);
		return SUCCESS;
	}
}
