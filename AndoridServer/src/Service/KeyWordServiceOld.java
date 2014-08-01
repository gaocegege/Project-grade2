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
 * ������Źؼ��ʵķ����ࣨ���ڸ���NLP��
 * @author cece
 */
public class KeyWordServiceOld 
{
	/**
	 * 
	 * @param ������Ŀ
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
//		String content = "�»��籱��7��7��ר�磨����Ǯ���ң��տ�ֱ������˾7�����ҹ�����ͨ�ú�����ҵǩ���ܼ�123��ֱ�����󵥡�ֱ��������Ϊ�ҹ�ͨ�ú����г�Ѹ�ٷ�չ���������㡣��Ϥ����������ͨ�ú������޹�˾��������ǩ��Э�鶩��55�ܿտ�ֱ�������͵���������˫��ֱ�����������ҹ���������ִ��ũҵ�͹�����������5�����Կտ�ֱ����С��������AS350B3eֱ�������꽻��������50����С��������EC135�������͵���������˫��ֱ������ɣ�Ԥ��6���ڽ������㶫����ͨ�ú������޹�˾����50�ܿտ�ֱ������Ʒ�����������ں��ϡ��㽭�͹㶫��ֱ�����ѾȺͽ���ҽ�ƾȻ��Լ�������з��񡣴˶������������ڿտ�ֱ����С��������EC135��������͵���������˫��ֱ������δ��10�����У�����ͨ����½������1��EC130T2��3��EC135T2e������46�ܷɻ�Ԥ����δ��5���ڽ������㶫����ͨ�����³�������˵���ҹ���Ա�������˿��ڶ࣬��ֱ��������ҽ�ƾȻ�������Ѿȷ����кܴ����󡣰���ͨ����EC135T2e��װ��ȫ����ص�ҽ��ϵͳ���豸�����⣬���Ϸ���ͨ�ú������޹�˾��տ�ֱ��������18��AS350B3eֱ����������4��AS350B3e�»����ڽ����ڽ���������14�ܻ����ڽ�������ڵ����ִ�п���������������к�ҽ�ƽ�����Ԯ�ȷ��񡣿տ�ֱ����ԭ��ŷ��ֱ������˾���ǿտͼ���ȫ�ʿع��ӹ�˾��";
//		getImportant(content);
	}
}
