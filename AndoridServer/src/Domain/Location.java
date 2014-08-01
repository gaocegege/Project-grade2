package Domain;

/**
 * 新闻地点类（数据库）
 * @author cece
 *
 */
public class Location {
	private int lid;
	private String location;
	private float lat;
	private float lng;
	private NewsContent newsContent;
	public void setLid(int lid) {
		this.lid = lid;
	}
	public int getLid() {
		return lid;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getLocation() {
		return location;
	}
	public void setLat(float lat) {
		this.lat = lat;
	}
	public float getLat() {
		return lat;
	}
	public void setLng(float lng) {
		this.lng = lng;
	}
	public float getLng() {
		return lng;
	}
	public void setNewsContent(NewsContent newsContent) {
		this.newsContent = newsContent;
	}
	public NewsContent getNewsContent() {
		return newsContent;
	}
}
