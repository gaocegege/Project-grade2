package domain;

import net.sf.json.JSONArray;

public class OriginContent {
	private Boolean success;
	private int total;
	private JSONArray yi18;
	public void setSuccess(Boolean success) {
		this.success = success;
	}
	public Boolean getSuccess() {
		return success;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int getTotal() {
		return total;
	}
	public void setYi18(JSONArray yi18) {
		this.yi18 = yi18;
	}
	public JSONArray getYi18() {
		return yi18;
	}
}
