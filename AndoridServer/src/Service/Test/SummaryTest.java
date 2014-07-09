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
		summaryService.getAllSentences("遗传算法的运算对象是表示个体的符号串，所以必须把变量 x1, x2 编码为一种符号串。本题中，用无符号二进制整数来表示。");
	}
}
