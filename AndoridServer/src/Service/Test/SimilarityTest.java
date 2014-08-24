package Service.Test;

import Service.SimilarityServices.MySimilarityService;
import Service.SimilarityServices.SimilarityService;

public class SimilarityTest {
	public static void main(String args[]) throws Exception
	{
		String a = "高雄多处燃气爆炸 民众当场被炸飞";
		String b = "高雄燃气爆炸:汽车被炸飞到三楼 伤者被抛至楼顶 ";
		SimilarityService similarityService = new SimilarityService();
		MySimilarityService  mySimilarityService = new MySimilarityService();
		System.out.println("My:" + mySimilarityService.calculateSimilarityLCS(a, b));
		
		long startTime=System.currentTimeMillis();
		float buf = similarityService.similarScore(a, b);
		long endTime=System.currentTimeMillis(); //获取结束时间
		System.out.println("程序运行时间： "+(endTime-startTime)+"ms");
		System.out.println("Buf:" + buf);
	}
}