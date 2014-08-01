package Service.Test;

import Service.SimilarityServices.SimilarityService;

public class SimilarityTest {
	public static void main(String args[]) throws Exception
	{
		String a = "高雄多处燃气爆炸 民众当场被炸飞";
		String b = "高雄多条街道发生燃气爆炸 灾害应变中心已成立";
		SimilarityService similarityService = new SimilarityService();
		float buf = similarityService.similarScore(a, b);
		System.out.println("Buf:" + buf);
	}
}
