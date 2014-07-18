package Service;

import java.io.IOException;
import java.util.List;



import DAO.ContentDAO;
import Domain.Content;

public class FormatSearchURL {
	private SearchFormat searchFormat;
	private ContentDAO contentDAO ;
	
	
	public SearchFormat getSearchFormat(){
		return searchFormat;
	}
	public void setSearchFormat(SearchFormat searchformat){
		this.searchFormat = searchformat;
	}
	
	public void setContentDAO(ContentDAO contentDAO) {
		this.contentDAO = contentDAO;
	}

	public ContentDAO getContentDAO() {
		return contentDAO;
	}
	
	public String format(int id) throws IOException{
		Content cur = contentDAO.getOneContent(id);
		String title = cur.getTitle();
		
		String urlA = "http://news.baidu.com/ns?word=";
		String urlB = "&tn=newstitle&from=news&cl=2&rn=20&ct=0";
		String SearchContext = searchFormat.getSearchSent(title);
		//return urlA + SearchContext + urlB;
		return SearchContext;
	}
}
