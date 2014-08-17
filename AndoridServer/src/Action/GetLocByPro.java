package Action;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.json.annotations.JSON;

import com.opensymphony.xwork2.ActionSupport;

import Domain.Location;
import Service.DBService.LocationService;

/**
 * 以省份为单位获取新闻
 * 
 * @author Li Xu
 * 
 */
public class GetLocByPro extends ActionSupport{
	// 内部类，方便接口；
	public class Loc {
		private String url;
		private String title;

		public String getUrl() {
			return url;
		}

		public void setUrl(String url) {
			this.url = url;
		}

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}
	}
	private String province;
	private int bound;
	private List<Loc> result;
	private LocationService locationService;
	
	@JSON(serialize = false)
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	@JSON(serialize = false)
	public int getBound() {
		return bound;
	}
	public void setBound(int bound) {
		this.bound = bound;
	}
	public List<Loc> getResult() {
		return result;
	}
	public void setResult(List<Loc> result) {
		this.result = result;
	}
	@JSON(serialize = false)
	public LocationService getLocationService() {
		return locationService;
	}
	public void setLocationService(LocationService locationService) {
		this.locationService = locationService;
	}
	
	public String execute() throws UnsupportedEncodingException{
		result = new ArrayList<Loc>();
		String str=new String(province.getBytes("ISO-8859-1"),"UTF-8");
		System.out.println(str);
		System.out.println(province);
		List<Object[]> res = locationService.getLocByPro(str,bound);
		System.out.println(str);
		for(Object[] o:res){
			Loc l = new Loc();
			l.setTitle(o[0].toString());
			l.setUrl(o[1].toString());
			result.add(l);
		}
		return SUCCESS;
		
	}
}
