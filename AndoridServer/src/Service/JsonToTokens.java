package Service;

import java.io.IOException;
import java.util.ArrayList;  
import java.util.Collection;  
import java.util.Iterator;  
import java.util.List;  

import Domain.OriginContent;
import Domain.Token;

  
import net.sf.json.JSONArray;  
import net.sf.json.JSONObject;  


public class JsonToTokens {
	private List<Token> bufList;
	
	public List<Token> transfer(String JsonContent)
	{
		JSONArray ja = JSONArray.fromObject(JsonContent);
		bufList = JSONArray.toList(ja, Token.class);
		
		return bufList;
	}
}
