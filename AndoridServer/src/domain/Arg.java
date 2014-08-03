package Domain;

/**
 * 
 * @author Lixu
 *
 */
public class Arg {
	private int id;
	private String type;
	private int beg;
	private int end;
	
	
	public void setId(int id){
		this.id = id;
	}
	public int getId(){
		return id;
	}
	
	public void setType(String type){
		this.type = type;
	}
	public String getType(){
		return type;
	}
	
	public void setBeg(int beg){
		this.beg = beg;
	}
	public int getBeg(){
		return beg;
	}
	
	public void setEnd(int end){
		this.end = end;
	}
	public int getEnd(){
		return end;
	}
}
