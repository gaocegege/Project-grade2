package Service.Test;

import Service.SimilarityServices.SimilarityService;

public class SimilarityTest {
	public static void main(String args[]) throws Exception
	{
		String a = "���۶ദȼ����ը ���ڵ�����ը��";
		String b = "���۶����ֵ�����ȼ����ը �ֺ�Ӧ�������ѳ���";
		SimilarityService similarityService = new SimilarityService();
		float buf = similarityService.similarScore(a, b);
		System.out.println("Buf:" + buf);
	}
}
