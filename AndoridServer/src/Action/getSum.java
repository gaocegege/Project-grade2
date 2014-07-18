package Action;

import Service.KeyWordServiceOld;
import Service.SummaryService;

import com.opensymphony.xwork2.ActionSupport;

public class getSum extends ActionSupport {
	private SummaryService summaryService;
	private KeyWordServiceOld keyWordService;

	public void setSummaryService(SummaryService summaryService) {
		this.summaryService = summaryService;
	}

	public SummaryService getSummaryService() {
		return summaryService;
	}

	public void setKeyWordService(KeyWordServiceOld keyWordService) {
		this.keyWordService = keyWordService;
	}

	public KeyWordServiceOld getKeyWordService() {
		return keyWordService;
	}
	
	//get the summary by id
}
