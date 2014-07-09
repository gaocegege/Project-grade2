package Service;

import java.util.ArrayList;
import java.util.List;

import edu.fudan.ml.types.Dictionary;
import edu.fudan.nlp.cn.tag.CWSTagger;
import edu.fudan.util.exception.LoadModelException;


public class SummaryService {
	private List<String> sentence;

	public void setSentence(List<String> sentence) {
		this.sentence = sentence;
	}

	public List<String> getSentence() {
		return sentence;
	}
	
	public List<String> getAllSentences(String content)
	{
		int posB = 0;
		int posE = 0;
		List<String> result = new ArrayList<String>();
		
		for (int i = 0; i < content.length(); i++)
		{
			if (content.charAt(i) == '¡£' || content.charAt(i) == '£¿' || content.charAt(i) == '£¡')
			{
				posE = i;
				String buf = content.substring(posB, posE + 1);
				posB = i + 1;
				result.add(buf);
			}
		}
		
		return result;
	}
	
	public List<String> getSummary(List<String> important, String content) throws LoadModelException
	{
		CWSTagger tag = new CWSTagger("./models/seg.m");
		List<String> bufList = getAllSentences(content);
		
		String seperateWords = tag.tag(content);
		return null;
		
	}
}
