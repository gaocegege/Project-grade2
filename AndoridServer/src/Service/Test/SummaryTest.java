package Service.Test;

import Service.SummaryService;

public class SummaryTest {
	private static SummaryService summaryService;

	public void setSummarySerice(SummaryService summarySerice) {
		this.summaryService = summarySerice;
	}

	public SummaryService getSummarySerice() {
		return summaryService;
	}
	
	public static void main(String args[])
	{
		summaryService = new SummaryService();
		summaryService.getAllSentences("�Ŵ��㷨����������Ǳ�ʾ����ķ��Ŵ������Ա���ѱ��� x1, x2 ����Ϊһ�ַ��Ŵ��������У����޷��Ŷ�������������ʾ��");
	}
}
