package Service.DBService;

import java.util.List;

import net.sf.json.JSONArray;
import DAO.ContentDAO;
import Domain.Content;

/**
 * 数据库访问类
 * @author cece
 *
 */
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
	
	public List<Content> getContents(int id,int types,int method)
	{
		List<Content> result = contentDAO.getContents(id,types,method);
		//JSONArray jsonArray = JSONArray.fromObject(result);
		//System.out.println("HEHEHEHEHE:" + jsonArray.toString());
		//return jsonArray.toString();
		return result;
	}
	public Content getOneContent(int id)
	{
		return contentDAO.getOneContent(id);
	}
	
	public boolean hasContained(String str)
	{
		return contentDAO.hasContained(str);
	}
}
