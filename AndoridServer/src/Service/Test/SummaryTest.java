package Service.Test;

import java.util.List;

import edu.fudan.util.exception.LoadModelException;

import Domain.Importance;
import Service.KeyWordServiceOld;
import Service.SummaryService;

public class SummaryTest {
	private static SummaryService summaryService;
	private static KeyWordServiceOld keyWordService;

	public void setSummarySerice(SummaryService summarySerice) {
		this.summaryService = summarySerice;
	}

	public SummaryService getSummarySerice() {
		return summaryService;
	}
	
	public static void setKeyWordService(KeyWordServiceOld keyWordService) {
		SummaryTest.keyWordService = keyWordService;
	}

	public static KeyWordServiceOld getKeyWordService() {
		return keyWordService;
	}

	public static void main(String args[]) throws LoadModelException
	{
		String content = "�����糿7��21�֣�������ƽ���������־ֳ��Űس����������ְ칫��¥��¥��ɱ��Ŀ���߳ƣ��Űس��ǴӰ칫¥��¥�Ŀյ������������ȥ�ģ����120�Ȼ������ߡ���Ϥ���Űس���10��ǰ��ҹ����ڰ칫�ҷ��ð���ҩ��ɱ���󱻷�������ҽԺ���ȡ�ƽ���������췢����Ϣ�ƣ����������ŵ��飬�ų���ɱ��������ͬ�·�ӳ�����������쳣��Ӧ�����Ű칫�ҷ�������ǰ�������飺������ҽԺ�������������֢���ǳ�ʹ�࣬���ܳ�˯�����������������������˺ͺ��ӣ���ǿЩ���չ˺�С����Ů�����й����걨����ȫͳ�ƣ�2013��1��1����2014��4��10���ڼ䣬���ڹ���54��������Ա����������������23������ɱ������ռ42.6%����ɱ����8��Ϊ��¥��ɱ����������ɱ��ʽ�����ˡ���̿����ũҩ�ȡ�����ɱԭ���У�����֢�Ⱦ��񼲲�����Ϊ��һ��������ר�����ܽ��շ���Ա����֢��ԭ��ʱ��Ϊ��ѹ������������������أ���������״����������ѹ����������Ŀ�ò���ƽ��������Ǩ�ܴ졢��ͥѹ�����������ȡ�";
		summaryService = new SummaryService();
		keyWordService = new KeyWordServiceOld();
		List<Importance> importance = keyWordService.getImportant(content);
			List<String> result = summaryService.getSummary(importance, content);
			for (int i = 0; i < result.size(); i++)
			{
				System.out.println(i + ":" + result.get(i));
			}
	}
}
