package Action;

import java.util.List;

import org.apache.struts2.json.annotations.JSON;

import Domain.Importance;
import Service.KeyWordServiceOld;
import Service.SummaryService;
import Service.DBService.ContentService;

import com.opensymphony.xwork2.ActionSupport;

import edu.fudan.util.exception.LoadModelException;

/**
 * µÃµ½ÕªÒª
 * @author cece
 *
 */
public class GetSum extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private SummaryService summaryService;
	private KeyWordServiceOld keyWordServiceOld;
	private ContentService contentService;
	private int id;
	private List<String> summary;
	
	public void setSummary(List<String> summary) {
		this.summary = summary;
	}

	public List<String> getSummary() {
		return summary;
	}

	@JSON(serialize=false)
	public ContentService getContentService() {
		return contentService;
	}

	public void setContentService(ContentService contentService) {
		this.contentService = contentService;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setSummaryService(SummaryService summaryService) {
		this.summaryService = summaryService;
	}
	
	@JSON(serialize=false)
	public SummaryService getSummaryService() {
		return summaryService;
	}

	public void setKeyWordServiceOld(KeyWordServiceOld keyWordServiceOld) {
		this.keyWordServiceOld = keyWordServiceOld;
	}
	
	@JSON(serialize=false)
	public KeyWordServiceOld getKeyWordServiceOld() {
		return keyWordServiceOld;
	}
	
	//get the summary by id
	public String execute()
	{
		try {
			String content  = contentService.getOneContent(id).getNewsContent().getContents();
			List<Importance> importance = keyWordServiceOld.getImportant(content);
			summary = summaryService.getSummary(importance, content);
			return SUCCESS;
		} catch (LoadModelException e) {
			System.out.println("GetSum: ERR!");
			e.printStackTrace();
		}
		return null;
	}
}
