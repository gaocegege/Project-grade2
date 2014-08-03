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
		String content = "�����ܸ���25���ͽ��10���Ů�ؾ�һ�������ӡ��������磬�������������˽���������7�η������������֡��ؾ������������š����ܵȲ��Ų��롣��ǰ���β�ͬ����������ͻ���ؾ�ͽ�������������״�չʾ��Ұ�����漼�ܡ� �����ֳ�1 �����ؾ��������� ͽ��10���� ��������8ʱ���ؾ��������ܶ�פ�ؼ��ᡣ��ʱ�콵���꣬����������һ���Ѷȡ�8ʱ30�֣����������ض���·�����ظ��ٽ�����·��һ·�򱱣����յִﺣ�����ռ�����2�ܾ���ֱ�����ڿ��и��泵��ǰ������;�е�����ͼ����ְ�� ������Ϥ����Щ�ؾ���Ϊʮ������ÿ������40�ˣ�ÿ�˶�Я���������͵����ؾ�˫�米�������У�ͽ��������Ա������·���³���ͽ��10�����н���Ŀ�ĵء� �����ݱ����й����ַ��ֲ��ܶӸ��ܶӳ�¬������ܣ��ؾ�˫�米����װ�з������ġ��ֿ��������þߺ�������ˮ��ǹ֧�������������ǹ��95��ǹ�����������΢�ͳ��ǹ����ÿ�˱���������17�������ң��ܸ�������25�������ҡ��� �������ع����Ƿ��Ӱ��ͽ�����ؾ������н��е�����Ů��֮һ��ˬ˵����ƽʱ��ѵ���У�Ů�����о���ѵ����׼��ѵ����һ�������������ǲ��ܼ�������������Ҳ����ǹη��������Ƕ�������ѵ���������50����� �����ֳ�2 ����10���Ӵ�������ָ������  ��������Сʱ��ͽ���о��󣬶�����������Ӫ�ص㡣��һ��б���ϣ��ؾ��Ǵӱ������ó��˴��������ߣ���ʮ��һ�鿪ʼ������ ����һ��ƽ�����ʣ����˸���̶��������������������ؾ��ǵĹ�����Ȼ����ʮ����֮�ڣ�һ����ս���������ϣ���������ָ��������һ���ؾ���Ŭ���£�ֻ����9��45�������ɹ��� ���������ɽ���ϣ����ڴ��ĳ�ʦ�����ڴ��³��ڽ���æµ��������Ļ����������ţ�⣬��һ����ʦָ���������ڵ�ţ��������˵���� ������ɫ�Ĵ��³��У��������������̿ڡ���ϴ�ص��豸��ȫ��һλ���ڱ�����Ա���ܣ�һ�����³���֤����������Сʱ��Ϊ200�˵ľ����ṩ����Ĳ����� ����������������Ӿ���ʵ�������壬ͨ��ʵ��ͽ�����������ö�����ͻ������£���������Ұ������������¸��õ���Ӧ�������������з��ְ츱���Ρ������й����ַ��ֲ��ܶ��ܶӳ����������˵�� �����¾������� ���� ʵϰ�� ������ (ԭ���⣺�����ؾ�ͽ������ Ů����50��װ��)";
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
