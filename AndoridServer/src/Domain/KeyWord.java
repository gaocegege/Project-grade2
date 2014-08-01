package Domain;

/**
 * 关键词类（数据库）
 * @author cece
 *
 */
public class KeyWord {
	private int kid;
	private String keyWord;
	// many to one 
	private Content content;
	
	public Content getContent() {
		return content;
	}
	public void setContent(Content content) {
		this.content = content;
	}
	public void setKeyWord(String keyWord) {
		this.keyWord = keyWord;
	}
	public String getKeyWord() {
		return keyWord;
	}
	public void setKid(int kid) {
		this.kid = kid;
	}
	public int getKid() {
		return kid;
	}
}
