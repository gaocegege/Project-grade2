package Domain;

/**
 * 关键词重要性类
 * @author cece
 *
 */
public class Importance {
	//key word class
	private String word;
	private int importance;
	public void setWord(String word) {
		this.word = word;
	}
	public String getWord() {
		return word;
	}
	public void setImportance(int importance) {
		this.importance = importance;
	}
	public int getImportance() {
		return importance;
	}
}
