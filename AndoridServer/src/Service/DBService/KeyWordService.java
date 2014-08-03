package Service.DBService;

import DAO.KeyWordDAO;
import Domain.KeyWord;
/**
 * 数据库访问类
 * @author cece
 *
 */
public class KeyWordService {
	private KeyWordDAO keyWordDAO;

	public void setKeyWordDAO(KeyWordDAO keyWordDAO) {
		this.keyWordDAO = keyWordDAO;
	}

	public KeyWordDAO getKeyWordDAO() {
		return keyWordDAO;
	}
	
	public void addKeyWord(KeyWord keyWord)
	{
		keyWordDAO.addKeyWord(keyWord);
	}
}
