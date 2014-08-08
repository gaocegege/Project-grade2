package Action;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.apache.struts2.json.annotations.JSON;

import Domain.Content;
import Domain.Location;
import Service.DBService.ContentService;
import Service.DBService.LocationService;

import com.opensymphony.xwork2.ActionSupport;


/**
 * 得到地图所需要的信息
 * @author Li Xu
 * 
 */
public class GetLocationAction  extends ActionSupport{
	//内部类，方便接口；
	public class Loc{
		private String url;
		private int id;
		private String title;
		private float lat;
		private float lng;
		public String getUrl() {
			return url;
		}
		public void setUrl(String url) {
			this.url = url;
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public float getLat() {
			return lat;
		}
		public void setLat(float lat) {
			this.lat = lat;
		}
		public float getLng() {
			return lng;
		}
		public void setLng(float lng) {
			this.lng = lng;
		}
		public String getTitle() {
			return title;
		}
		public void setTitle(String title) {
			this.title = title;
		}	
	}
	private List<Loc> result;
	private float lat;
	private float lng;
	private float zoom;
	private int bound;
	private LocationService locationService;
	private ContentService contentService;
	
	
	public List<Loc> getResult() {
		return result;
	}
	public void setResult(List<Loc> result) {
		this.result = result;
	}
	@JSON(serialize = false)
	public float getLat() {
		return lat;
	}
	public void setLat(float lat) {
		this.lat = lat;
	}
	@JSON(serialize = false)
	public float getLng() {
		return lng;
	}
	public void setLng(float lng) {
		this.lng = lng;
	}
	@JSON(serialize = false)
	public float getZoom() {
		return zoom;
	}
	public void setZoom(float zoom) {
		this.zoom = zoom;
	}
	@JSON(serialize = false)
	public int getBound() {
		return bound;
	}
	public void setBound(int bound) {
		this.bound = bound;
	}
	@JSON(serialize = false)
	public LocationService getLocationService() {
		return locationService;
	}
	public void setLocationService(LocationService locationService) {
		this.locationService = locationService;
	}
	@JSON(serialize = false)
	public ContentService getContentService() {
		return contentService;
	}
	public void setContentService(ContentService contentService) {
		this.contentService = contentService;
	}
	public String execute() throws Exception{
		result = new ArrayList<Loc>();
		List<Location> addr = locationService.getLocationByAddr(lat, lng, zoom);
		Calendar c = Calendar.getInstance();
		int month = c.get(Calendar.MONTH)+1; 
		int date = c.get(Calendar.DATE);
		
		for(Location l:addr){
			int id = l.getNewsContent().getId();
			Content cur = contentService.getOneContent(id);
			String curdate = cur.getTime();
			int pos1 = curdate.indexOf("月");
			int pos2 = curdate.indexOf("日");
			int curmonth = Integer.parseInt(curdate.substring(0, pos1));
			int curday = Integer.parseInt(curdate.substring(pos1+1, pos2));
			if(month == curmonth && date==curday){
				Loc newloc = new Loc();
				newloc.setId(id);
				newloc.setLat(l.getLat());
				newloc.setLng(l.getLng());
				newloc.setTitle(cur.getTitle());
				newloc.setUrl(cur.getUrl());
				result.add(newloc);
			}
		}
		return SUCCESS;
	}
}
