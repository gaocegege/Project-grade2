package Service.Test;

import java.util.List;

import Domain.Content;
import Service.JsonToJava;

public class JsonTest {
	private static JsonToJava jj;
	
	public void setJj(JsonToJava jj) {
		this.jj = jj;
	}

	public JsonToJava getJj() {
		return jj;
	}

	public static void main(String[] args)
	{
		jj = new JsonToJava();
		List<Content> testList = jj.transfer("[{\"success\": true,  \"total\":886,\"yi18\":[{\"title\":\"北京大雨冰雹来袭 半米长鱼跳出河面(组图)\",\"img\":\"img/top/20140702115325_881.jpg\",\"keywords\":\"北京大雨\",\"count\":0,\"from\":\"新浪新闻\",\"time\":\"Jul 2, 2014 11:53:23 AM\",\"id\":886}]}]");
		return ;
	}
}
