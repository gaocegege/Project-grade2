package Domain;

import java.util.Set;

import org.apache.struts2.json.annotations.JSON;

public class Content {
	private String title;
	private String url;
	private String imageUrl;
	private String from;
	private String time;
	private int id;
	private int types;
	// one to one 
	private NewsContent newsContent;
	// one to many
	private Set<KeyWord> keyWord;
	
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
	public void setNewsContent(NewsContent newsContent) {
		this.newsContent = newsContent;
	}
	@JSON(serialize=false)
	public NewsContent getNewsContent() {
		return newsContent;
	}
	public void setKeyWord(Set<KeyWord> keyWord) {
		this.keyWord = keyWord;
	}
	@JSON(serialize=false)
	public Set<KeyWord> getKeyWord() {
		return keyWord;
	}
}
