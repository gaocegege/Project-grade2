package Service;

import java.util.List;

import net.sf.json.JSONArray;
import domain.Content;
import DAO.ContentDAO;

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
	
	public String getContents(int id)
	{
		List<Content> result = contentDAO.getContents(id);
		JSONArray jsonArray = JSONArray.fromObject(result);
		System.out.println("HEHEHEHEHE:" + jsonArray.toString());
		return jsonArray.toString();
	}
}
