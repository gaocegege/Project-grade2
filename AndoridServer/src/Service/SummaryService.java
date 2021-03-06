package Service;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

import org.apache.struts2.ServletActionContext;

import util.MyPath;

import Domain.Importance;

import edu.fudan.ml.types.Dictionary;
import edu.fudan.nlp.cn.tag.CWSTagger;
import edu.fudan.util.exception.LoadModelException;

/**
 * 获得新闻摘要的服务类
 * @author cece
 *
 */
public class SummaryService {
	private List<String> sentence;

	public void setSentence(List<String> sentence) {
		this.sentence = sentence;
	}

	public List<String> getSentence() {
		return sentence;
	}
	
	private List<String> getAllSentences(String content)
	{
		int posB = 0;
		int posE = 0;
		List<String> result = new ArrayList<String>();
		
		for (int i = 0; i < content.length(); i++)
		{
			if (content.charAt(i) == '。' || content.charAt(i) == '？' || content.charAt(i) == '！')
			{
				posE = i;
				String buf = content.substring(posB, posE + 1);
				posB = i + 1;
				result.add(buf);
			}
		}
		
		return result;
	}
	
	public List<String> getSummary(List<Importance> important, String content) throws LoadModelException
	{
		Properties property = System.getProperties();
		String str = property.getProperty("user.dir");
		
		// can not find the seg.m
//		System.out.println(ServletActionContext.getServletContext().getRealPath("/"));
		// please replace the "./models/seg.m" with the absolute path!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
		CWSTagger tag;
		String a = ServletActionContext.getServletContext().getRealPath("/");
		tag = new CWSTagger(ServletActionContext.getServletContext().getRealPath("/") + MyPath.path + "/seg.m");
		List<String> sentenceList = getAllSentences(content);
		List<Integer> importantList = new ArrayList<Integer>();
		
		//initialized
		for (int i = 0; i < sentenceList.size(); i++)
		{
			importantList.add(0);
		}
		
		int lengthOfI = important.size();
		
		//i -> sen Num
		for (int i = 0; i < sentenceList.size(); i++)
		{
			String seperateWds = tag.tag(sentenceList.get(i));
			String[] bufS = seperateWds.split(" ");
			List<String> wordsList = Arrays.asList(bufS);
			int length = wordsList.size();
			
			//j -> word Num
			for (int j = 0; j < length; j++)
			{
				// k -> important word Num
				for (int k = 0; k < lengthOfI; k++)
				{
					if (wordsList.get(j).equals(important.get(k).getWord()))
					{
						int bufOfI = importantList.get(i) + important.get(k).getImportance();
						importantList.set(i, bufOfI);
					}
				}
			}
		}
		
		int firstNum = 0;
		int secondNum = 0;
		int thirdNum = 0;
		for (int i = 0; i < importantList.size(); i++)
		{
			if (importantList.get(i) > importantList.get(firstNum))
			{
				thirdNum = secondNum;
				secondNum = firstNum;
				firstNum = i;
				continue;
			}
			
			if (importantList.get(i) > importantList.get(secondNum))
			{
				thirdNum = secondNum;
				secondNum = i;
				continue;
			}
			
			if (importantList.get(i) > importantList.get(thirdNum))
			{
				thirdNum = i;
				continue;
			}
		}
		
		List<String> result = new ArrayList<String>();
		result.add(sentenceList.get(firstNum));
		result.add(sentenceList.get(secondNum));
		result.add(sentenceList.get(thirdNum));
		
		
		return result;
		
	}
}
