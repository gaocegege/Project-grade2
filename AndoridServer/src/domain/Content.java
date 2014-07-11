package Domain;

public class Content {
	private String title;
	private String url;
	private String imageUrl;
	private String from;
	private String time;
	private int id;
	private int types;
	public void setTitle(String title) {
		this.title = title;
	}
	public String getTitle() {
		return title;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getFrom() {
		return from;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getTime() {
		return time;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getId() {
		return id;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getUrl() {
		return url;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setTypes(int types) {
		this.types = types;
	}
	public int getTypes() {
		return types;
	}
}
