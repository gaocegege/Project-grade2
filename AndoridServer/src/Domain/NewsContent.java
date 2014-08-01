package Domain;

import java.util.Set;

import org.apache.struts2.json.annotations.JSON;

/**
 * 新闻正文类（数据库）
 * @author cece
 *
 */
public class NewsContent {
	private int id;
	private String contents;
	private Content content;
	private Set<Location> location;
	
	public void setContents(String contents) {
		this.contents = contents;
	}
	
	public String getContents() {
		return contents;
	}
	public void setContent(Content content) {
		this.content = content;
	}
	@JSON(serialize=false)
	public Content getContent() {
		return content;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getId() {
		return id;
	}

	public void setLocation(Set<Location> location) {
		this.location = location;
	}

	public Set<Location> getLocation() {
		return location;
	}
}
