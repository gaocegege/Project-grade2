package Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import Domain.Content;
import Domain.Token;

public class CompareService {
	private SplitService splitService;
	private Content content1;
	private Content content2;

	public SplitService getSplitService() {
		return splitService;
	}

	public void setSplitService(SplitService splitService) {
		this.splitService = splitService;
	}

	public Content getContent1() {
		return content1;
	}

	public void setContent1(Content content1) {
		this.content1 = content1;
	}

	public Content getContent2() {
		return content2;
	}

	public void setContent2(Content content2) {
		this.content2 = content2;
	}
	
	public int compare(Content c1, Content c2) throws IOException{
		this.setContent1(c1);
		this.setContent2(c2);
		return this.compare();
	}

	public int compare() throws IOException{
		//0  相等
		//1 content1《 content2
		//-1 content1 > content2
		//2 不相等
		List<Token> content1_title = splitService.split(content1.getTitle());
		List<Token> content2_title = splitService.split(content2.getTitle());
		List<String> content1_noun = new ArrayList<String>();
		List<String> content2_noun = new ArrayList<String>();
		
		String url1 = content1.getUrl();
		String url2 = content2.getUrl();
		
		Document doc;
		doc = Jsoup.connect(url1).get();
		String urlcontent1 = doc.text();
		doc = Jsoup.connect(url1).get();
		String urlcontent2 = doc.text();
		
		if(!(content1.getNewsContent()==null || content1.getNewsContent().getContents()==null 
				|| content1.getNewsContent().getContents().equals("")))
			urlcontent1 = content1.getNewsContent().getContents();
		if(!(content2.getNewsContent()==null || content2.getNewsContent().getContents()==null 
				|| content2.getNewsContent().getContents().equals("")))
			urlcontent2 = content2.getNewsContent().getContents();
		
		String title1 = content1.getTitle();
		String title2 = content2.getTitle();
		for(int i=0;i<content1_title.size();i++){
			if(content1_title.get(i).getPos().contains("n")){
				content1_noun.add(content1_title.get(i).getCont());
			}
		}
		for(int i=0;i<content2_title.size();i++){
			if(content2_title.get(i).getPos().contains("n")){
				content2_noun.add(content2_title.get(i).getCont());
			}
		}
		Boolean compare1 = true,compare2 = true;
		for (String s : content1_noun) {   
			if(!title2.contains(s) && !urlcontent2.contains(s)){
				compare1 = false;
				break;
			}
		}
		for (String s : content2_noun) {   
			if(!title1.contains(s) && !urlcontent1.contains(s)){
				compare2 = false;
				break;
			}
		}
		if(compare1 && compare2)
			return 0;
		if(compare1)
			return -1;
		if(compare2)
			return 1;
		return 2;
	}
}
