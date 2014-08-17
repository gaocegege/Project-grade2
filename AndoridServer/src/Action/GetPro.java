package Action;

import java.util.List;

import org.apache.struts2.json.annotations.JSON;

import Service.DBService.LocationService;

import com.opensymphony.xwork2.ActionSupport;


/**
 * 得到有新闻的省份
 * @author Li Xu
 * 
 */
public class GetPro  extends ActionSupport{

	
	private List<String>result;
	private LocationService locationService;
	private int bound;

	public List<String> getResult() {
		return result;
	}

	public void setResult(List<String> result) {
		this.result = result;
	}

	@JSON(serialize = false)
	public LocationService getLocationService() {
		return locationService;
	}

	public void setLocationService(LocationService locationService) {
		this.locationService = locationService;
	}
	@JSON(serialize = false)
	public int getBound() {
		return bound;
	}

	public void setBound(int bound) {
		this.bound = bound;
	}


	public String execute(){
	    result = locationService.getPro(bound); 
	  	return SUCCESS;
	}
}
