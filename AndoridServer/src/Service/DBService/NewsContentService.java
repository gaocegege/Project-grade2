package Service.DBService;

import java.util.List;

import DAO.NewsContentDAO;
import Domain.Content;
import Domain.NewsContent;
/**
 * 数据库访问类
 * @author cece
 *
 */
public class NewsContentService {
	private NewsContentDAO newsContentDAO;

	public NewsContentDAO getNewsContentDAO() {
		return newsContentDAO;
	}

	public void setNewsContentDAO(NewsContentDAO newsContentDAO) {
		this.newsContentDAO = newsContentDAO;
	}
	
	public NewsContent getNewsContents(int id)
	{
		return newsContentDAO.getNewsContent(id);
	}
}
