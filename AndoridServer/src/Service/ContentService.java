package Service;

import java.util.List;

import net.sf.json.JSONArray;
import DAO.ContentDAO;
import Domain.Content;

public class ContentService {
	private ContentDAO contentDAO;

	public void setContentDAO(ContentDAO contentDAO) {
		this.contentDAO = contentDAO;
	}

	public ContentDAO getContentDAO() {
		return contentDAO;
	}
	
	public void addContent(Content content)
	{
		contentDAO.addContent(content);
	}
	
	public JSONArray getContents(int id, int types)
	{
		List<Content> result = contentDAO.getContents(id, types);
		JSONArray jsonArray = JSONArray.fromObject(result);
		return jsonArray;
	}
}
