package Action;

import Service.KeyWordService;
import Service.SummaryService;

import com.opensymphony.xwork2.ActionSupport;

public class getSum extends ActionSupport {
	private SummaryService summaryService;
	private KeyWordService keyWordService;

	public void setSummaryService(SummaryService summaryService) {
		this.summaryService = summaryService;
	}

	public SummaryService getSummaryService() {
		return summaryService;
	}

	public void setKeyWordService(KeyWordService keyWordService) {
		this.keyWordService = keyWordService;
	}

	public KeyWordService getKeyWordService() {
		return keyWordService;
	}
	
	//get the summary by id
}
