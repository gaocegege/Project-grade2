package Domain;

public class NewsContent {
	private int id;
	private String contents;
	private Content content;
	
	public void setContents(String contents) {
		this.contents = contents;
	}
	public String getContents() {
		return contents;
	}
	public void setContent(Content content) {
		this.content = content;
	}
	public Content getContent() {
		return content;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getId() {
		return id;
	}
}
