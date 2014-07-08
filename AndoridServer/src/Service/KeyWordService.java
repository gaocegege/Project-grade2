package Service;

import java.util.Arrays;
import java.util.List;

import org.fnlp.app.keyword.AbstractExtractor;
import org.fnlp.app.keyword.WordExtract;

import edu.fudan.nlp.cn.tag.CWSTagger;
import edu.fudan.nlp.corpus.StopWords;
import edu.fudan.util.exception.LoadModelException;

public class KeyWordService 
{
	public List<String> getImportant(String content)
	{
		try {
			// get the stopwords
			StopWords sw= new StopWords("models/stopwords");
			CWSTagger seg;
			seg = new CWSTagger("models/seg.m");
			AbstractExtractor key = new WordExtract(seg,sw);
			
			String keyWords = key.extract(content, content.length() / 100, true);
			String[] buf = keyWords.substring(1, keyWords.length() - 1).split(",");
			List<String> result = Arrays.asList(buf);
			return result;
		} catch (LoadModelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public static void main(String[] args)
	{
		try {
			StopWords sw= new StopWords("models/stopwords");
			CWSTagger seg;
			seg = new CWSTagger("models/seg.m");
			AbstractExtractor key = new WordExtract(seg,sw);
			
			String keyWords = key.extract("新华社北京7月7日专电（记者钱春弦）空客直升机公司7日与我国三家通用航空企业签下总计123架直升机大单。直升机正成为我国通用航空市场迅速发展的新增长点。据悉，福建新美通用航空有限公司（新美）签署协议订购55架空客直升机轻型单发和轻型双发直升机，用于我国东部地区执行农业和公共任务。首批5架来自空客直升机小松鼠家族的AS350B3e直升机今年交付。余下50架由小松鼠家族和EC135家族轻型单发和轻型双发直升机组成，预计6年内交付。广东白云通用航空有限公司订购50架空客直升机产品，以满足其在河南、浙江和广东的直升机搜救和紧急医疗救护以及商务飞行服务。此订单包括来自于空客直升机小松鼠家族和EC135家族的轻型单发和轻型双发直升机。未来10个月中，白云通航将陆续接收1架EC130T2和3架EC135T2e，余下46架飞机预计在未来5年内交付。广东白云通航董事长张子轩说，我国幅员辽阔，人口众多，对直升机紧急医疗救护服务和搜救服务将有很大需求。白云通航的EC135T2e将装备全套相关的医疗系统和设备。此外，云南凤翔通用航空有限公司向空客直升机订购18架AS350B3e直升机。首批4架AS350B3e新机将在今年内交付。余下14架机将在今后两年内到达，以执行空中游览、商务飞行和医疗紧急救援等服务。空客直升机原名欧洲直升机公司，是空客集团全资控股子公司。", 2, true);
			//maybe wrong
			String[] hehe = keyWords.substring(1, keyWords.length() - 1).split(",");
			List<String> cece =  Arrays.asList(hehe);
			//处理已经分好词的句子
			//sw=null;
			//key = new WordExtract(seg,sw);
			//System.out.println(key.extract("新华社北京7月7日专电（记者钱春弦）空客直升机公司7日与我国三家通用航空企业签下总计123架直升机大单。直升机正成为我国通用航空市场迅速发展的新增长点。据悉，福建新美通用航空有限公司（新美）签署协议订购55架空客直升机轻型单发和轻型双发直升机，用于我国东部地区执行农业和公共任务。首批5架来自空客直升机小松鼠家族的AS350B3e直升机今年交付。余下50架由小松鼠家族和EC135家族轻型单发和轻型双发直升机组成，预计6年内交付。广东白云通用航空有限公司订购50架空客直升机产品，以满足其在河南、浙江和广东的直升机搜救和紧急医疗救护以及商务飞行服务。此订单包括来自于空客直升机小松鼠家族和EC135家族的轻型单发和轻型双发直升机。未来10个月中，白云通航将陆续接收1架EC130T2和3架EC135T2e，余下46架飞机预计在未来5年内交付。广东白云通航董事长张子轩说，我国幅员辽阔，人口众多，对直升机紧急医疗救护服务和搜救服务将有很大需求。白云通航的EC135T2e将装备全套相关的医疗系统和设备。此外，云南凤翔通用航空有限公司向空客直升机订购18架AS350B3e直升机。首批4架AS350B3e新机将在今年内交付。余下14架机将在今后两年内到达，以执行空中游览、商务飞行和医疗紧急救援等服务。空客直升机原名欧洲直升机公司，是空客集团全资控股子公司。", 20));
			//System.out.println(key.extract("赵嘉亿 是 好人 还是 坏人", 5));
			
			key = new WordExtract();
			System.out.println(key.extract("", 5));
		} catch (LoadModelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
