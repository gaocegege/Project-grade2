package Service.SimilarityServices;

import edu.fudan.nlp.parser.dep.DependencyTree;
import edu.fudan.nlp.similarity.TreeKernel;

/**
 * ���ƶ��б�ķ�����
 * @author cece
 *
 */
public class SimilarityService {
	private TreeKernel treeKernel;
	
	public SimilarityService()
	{
		treeKernel = new TreeKernel();
	}
	
	public float similarScore(String a, String b) throws Exception
	{
		DepParserService parserService = new DepParserService();
		DependencyTree treeA = parserService.getTree(a);
		DependencyTree treeB = parserService.getTree(b);
		
		return treeKernel.calc(treeA, treeB);
	}
}
