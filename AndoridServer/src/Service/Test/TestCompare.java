package Service.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import Domain.Content;
import Service.CompareService;
import Service.BaiduServices.BaiduService;

public class TestCompare {
	public static void main(String args[]) throws IOException{/*
		BaiduService bs = new BaiduService();
		CompareService cs = new CompareService();
		List<Content> result = bs.search("中国女游客", 0);
		List<Content> result2 = new ArrayList<Content>();
		Content cp = result.get(0);
		result2.add(cp);
		for(int i=1;i<result.size();i++){
			//System.out.println(cs.compare(result.get(i-1),result.get(i) ));
			int cur = cs.compare(cp,result.get(i));
			if(cur == 0 || cur == -1)
				continue;
			else if(cur == 1){
				result2.remove(result2.size()-1);
				result2.add(result.get(i));
				break;
			}
			else
				result2.add(result.get(i));
		}
		for(Content c:result2){
			System.out.println(c.getTitle());
		}
		*/
		Document doc;
		doc = Jsoup.connect("http://travel.iqilu.com/xinwen/guonei/2014/0715/2064242.shtml").get();
		System.out.println(doc.text());
	}
}
