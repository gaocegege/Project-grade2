package Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.fnlp.app.keyword.AbstractExtractor;
import org.fnlp.app.keyword.WordExtract;

import Domain.Importance;

import edu.fudan.nlp.cn.tag.CWSTagger;
import edu.fudan.nlp.corpus.StopWords;
import edu.fudan.util.exception.LoadModelException;

// Useless: now we can get the key words from the webSite;
/**
 * 获得新闻关键词的服务类（基于复旦NLP）
 * @author cece
 */
public class KeyWordServiceOld 
{
	/**
	 * 
	 * @param 新闻题目
	 * @return
	 */
	public List<Importance> getImportant(String content)
	{
		try {
			// get the stopwords
			System.out.println("Get the key words: begin");
			// please replace the "./models/stopwords" with the absolute path!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
			StopWords sw= new StopWords("E:\\MyProject\\GitHub\\Project-grade2\\AndoridServer\\WebContent\\models\\stopwords");
			CWSTagger seg;
			// please replace the "./models/seg.m" with the absolute path!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
			seg = new CWSTagger("E:\\MyProject\\GitHub\\Project-grade2\\AndoridServer\\WebContent\\models\\seg.m");
			AbstractExtractor key = new WordExtract(seg,sw);
			
			List<Importance> result = new ArrayList<Importance>();
			
			String keyWords = key.extract(content, content.length() / 100, true);
			String[] buf = keyWords.substring(1, keyWords.length() - 1).split(", ");
			for (int i = 0; i < buf.length; i++)
			{
				Importance bufI = new Importance();
				String[] bufOfKey = buf[i].split("=");
				bufI.setWord(bufOfKey[0]);
				bufI.setImportance(Integer.parseInt(bufOfKey[1]));
				
				result.add(bufI);
			}
			
			for (int i = 0; i < result.size(); i++)
			{
				System.out.println(result.get(i).getWord() + ":V:" + result.get(i).getImportance());
			}
			
			System.out.println("Get Key Words : End");
			return result;
		} catch (LoadModelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public static void main(String[] args)
	{
//		String content = "新华社北京7月7日专电（记者钱春弦）空客直升机公司7日与我国三家通用航空企业签下总计123架直升机大单。直升机正成为我国通用航空市场迅速发展的新增长点。据悉，福建新美通用航空有限公司（新美）签署协议订购55架空客直升机轻型单发和轻型双发直升机，用于我国东部地区执行农业和公共任务。首批5架来自空客直升机小松鼠家族的AS350B3e直升机今年交付。余下50架由小松鼠家族和EC135家族轻型单发和轻型双发直升机组成，预计6年内交付。广东白云通用航空有限公司订购50架空客直升机产品，以满足其在河南、浙江和广东的直升机搜救和紧急医疗救护以及商务飞行服务。此订单包括来自于空客直升机小松鼠家族和EC135家族的轻型单发和轻型双发直升机。未来10个月中，白云通航将陆续接收1架EC130T2和3架EC135T2e，余下46架飞机预计在未来5年内交付。广东白云通航董事长张子轩说，我国幅员辽阔，人口众多，对直升机紧急医疗救护服务和搜救服务将有很大需求。白云通航的EC135T2e将装备全套相关的医疗系统和设备。此外，云南凤翔通用航空有限公司向空客直升机订购18架AS350B3e直升机。首批4架AS350B3e新机将在今年内交付。余下14架机将在今后两年内到达，以执行空中游览、商务飞行和医疗紧急救援等服务。空客直升机原名欧洲直升机公司，是空客集团全资控股子公司。";
//		getImportant(content);
	}
}
