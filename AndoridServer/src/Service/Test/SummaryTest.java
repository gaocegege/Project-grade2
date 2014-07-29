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
		String content = "　　总负重25公斤，徒步10公里，女特警一样不掉队。昨天上午，北京警方进行了今年以来第7次反恐演练，反恐、特警、警航、科信、交管等部门参与。与前几次不同，本次演练突出特警徒步集结能力并首次展示了野外生存技能。 　　现场1 　　特警雨中拉练 徒步10公里 　　昨早8时，特警部队在总队驻地集结。此时天降大雨，给演练带来一定难度。8时30分，演练队伍沿定泗路，京藏高速进京辅路，一路向北，最终抵达海淀区苏家坨镇。2架警用直升机在空中跟随车队前进，沿途承担空中图像传输职责。 　　据悉，这些特警分为十个方阵，每个方阵40人，每人都携带了武器和单兵特警双肩背包。其中，徒步方阵人员从温阳路口下车，徒步10公里行进至目的地。 　　据北京市公安局反恐怖总队副总队长卢正红介绍，特警双肩背包内装有防弹背心、钢盔、防雨用具和少量的水；枪支的种类包括防暴枪、95步枪和其他种类的微型冲锋枪。“每人背包重量在17公斤左右，总负重量在25公斤左右。” 　　负重过大是否会影响徒步？特警部队中仅有的两个女警之一米爽说，在平时的训练中，女警和男警的训练标准和训练量一样，因此这次她们才能坚持下来。“而且不管是刮风下雨我们都会正常训练，最长能走50公里。” 　　现场2 　　10分钟搭起中心指挥帐篷  　　两个小时的徒步行军后，队伍来到了扎营地点。在一处斜坡上，特警们从背包中拿出了搭建帐篷的器具，以十人一组开始工作。 　　一人平铺内帐，两人负责固定，两人连接绳索……特警们的工作井然有序。十分钟之内，一个个战地帐篷便搭建完毕；最大的中心指挥帐篷，在一众特警的努力下，只用了9分45秒便宣告成功。 　　对面的山坡上，后勤处的厨师们正在炊事车内紧张忙碌。“今天的荤菜是土豆炖牛肉，”一名厨师指着热气腾腾的牛肉锅向记者说道。 　　黑色的炊事车中，加热器、抽油烟口、盥洗池等设备齐全。一位后勤保障人员介绍，一辆炊事车保证能在两个半小时内为200人的警力提供充足的餐饮。 　　“这次演练更加具有实践的意义，通过实践徒步的拉动，让队伍在突发情况下，尤其是在野外生存的条件下更好地适应环境。”北京市反恐办副主任、北京市公安局反恐怖总队总队长张立民介绍说。 　　新京报记者 郭超 实习生 赵泽众 (原标题：北京特警徒步拉练 女警身负50斤装备)";
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
