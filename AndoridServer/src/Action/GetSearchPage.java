package Action;

import java.io.IOException;
import java.util.List;

import org.apache.struts2.json.annotations.JSON;

import DAO.ContentDAO;
import Domain.Content;
import Service.FormatSearchURL;
import Service.SearchFormat;

import com.opensymphony.xwork2.ActionSupport;

public class GetSearchPage extends ActionSupport{
	private int id;
	private int types;
	private String result;
	private FormatSearchURL formatSearchURL;
	public void setId(int id) {
		this.id = id;
	}
	
	@JSON(serialize=false)
	public int getId() {
		return id;
	}
	
	public void setFormatSearchURL(FormatSearchURL f){
		this.formatSearchURL = f;
	}
	@JSON(serialize=false)
	public FormatSearchURL getFormatSearchURL(){
		return formatSearchURL;
	}
	
	public void setResult(String result) {
		this.result = result;
	}

	public String getResult() {
		return result;
	}
	
	public int getTypes() {
		return types;
	}

	public void setTypes(int types) {
		this.types = types;
	}

	public String execute() throws IOException{
		result = formatSearchURL.format(id,types);
		return SUCCESS;
	}
}
