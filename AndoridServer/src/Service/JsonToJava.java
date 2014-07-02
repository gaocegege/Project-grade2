package Service;

import java.util.ArrayList;  
import java.util.Collection;  
import java.util.Iterator;  
import java.util.List;  

import domain.Content;
import domain.OriginContent;
  
import net.sf.json.JSONArray;  
import net.sf.json.JSONObject;  

public class JsonToJava {
	private List<Content> bufList;
	
	public List<Content> transfer(String JsonContent)
	{
		JSONArray ja = JSONArray.fromObject(JsonContent);
		List<OriginContent> originBufList = JSONArray.fromObject(JsonContent).toList(ja, OriginContent.class);
		ja = originBufList.get(0).getYi18();
		bufList = JSONArray.toList(ja, Content.class);
		return bufList;
	}
}
