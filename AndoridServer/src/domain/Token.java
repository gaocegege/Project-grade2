package Domain;

import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONArray;

/**
 * API得到的单元
 * @author Lixu
 *
 */
public class Token {
	private int id;
	private String cont;
	private String pos;
	// jigou or renming
	private String ne;
	private int parent;
	private String relate;
	private List<Arg> arg = new ArrayList<Arg>();
	
	public String toString(){
		return id+" "+cont+" "+pos+" "+ne+" "+parent+" "+relate;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	public int getId() {
		return id;
	}
	
	public void setCont(String cont) {
		this.cont = cont;
	}
	public String getCont() {
		return cont;
	}
	
	public void setPos(String pos) {
		this.pos = pos;
	}
	public String getPos() {
		return pos;
	}
	
	public void setNe(String ne) {
		this.ne = ne;
	}
	public String getNe() {
		return ne;
	}
	
	public void setParent(int parent) {
		this.parent = parent;
	}
	public int getParent() {
		return parent;
	}
	
	public void setRelate(String relate) {
		this.relate = relate;
	}
	public String getRelate() {
		return relate;
	}
	/*
	public void setArg(String arg) {
		JSONArray ja = JSONArray.fromObject(arg);
		this.arg = JSONArray.fromObject(arg).toList(ja,Arg.class);
	}*/
	public void setArg(List<Arg> arg) {
		JSONArray ja = JSONArray.fromObject(arg);
		this.arg = JSONArray.toList(ja, Arg.class);
	}
	public List<Arg> getArg() {
		return arg;
	}
}
