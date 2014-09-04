package Service.SimilarityServices;

import util.MyPath;
import edu.fudan.nlp.cn.tag.POSTagger;
import edu.fudan.nlp.parser.dep.DependencyTree;
import edu.fudan.nlp.parser.dep.JointParser;
import edu.fudan.util.exception.LoadModelException;

/**
 * 封装分词生成树的类
 * @author cece
 *
 */
public class DepParserService {

	private JointParser parser;
	
	public DepParserService() throws Exception
	{
		parser = new JointParser(MyPath.path + "/dep.m");
	}
	
	public DependencyTree getTree(String str) throws Exception
	{
		POSTagger tag = new POSTagger(MyPath.path + "/seg.m",MyPath.path + "pos.m");
		String[][] s = tag.tag2Array(str);
		try {
			DependencyTree tree = parser.parse2T(s[0],s[1]);
			System.out.println("DependencyTree Get");
			return tree;
		} catch (Exception e) {			
			e.printStackTrace();
		}
		return null;
		
	}
}