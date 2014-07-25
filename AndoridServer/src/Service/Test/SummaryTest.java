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
		String content = "昨天早晨7点21分，信阳市平桥区卫生局局长张柏成在区卫生局办公大楼跳楼自杀。目击者称，张柏成是从办公楼九楼的空调室外机上跳下去的，随后被120救护车拉走。据悉，张柏成于10天前的夜里，曾在办公室服用安眠药自杀，后被发现送往医院抢救。平桥区政府办发布消息称，经公安部门调查，排除他杀，亲属和同事反映，近期张有异常反应。在张办公室发现其生前留有遗书：“我在医院检查有严重抑郁症，非常痛苦，不能吃睡，生不如死。”并叮嘱爱人和孩子，坚强些，照顾好小外孙女。据中国青年报不完全统计，2013年1月1日至2014年4月10日期间，国内共有54名各级官员非正常死亡。其中23人是自杀身亡，占42.6%。自杀者中8人为跳楼自杀，其他的自杀方式有自缢、烧炭、喝农药等。在自杀原因中，抑郁症等精神疾病被认为是一大诱因。有专家在总结诱发官员抑郁症的原因时认为，压力是其中最根本的因素，包括对现状不满、工作压力大、遭遇或目睹不公平、个人升迁受挫、家庭压力、感情纠葛等。";
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
