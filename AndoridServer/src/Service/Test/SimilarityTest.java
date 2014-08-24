package Service.Test;

import Service.SimilarityServices.MySimilarityService;
import Service.SimilarityServices.SimilarityService;

public class SimilarityTest {
	public static void main(String args[]) throws Exception
	{
		String a = "���۶ദȼ����ը ���ڵ�����ը��";
		String b = "����ȼ����ը:������ը�ɵ���¥ ���߱�����¥�� ";
		SimilarityService similarityService = new SimilarityService();
		MySimilarityService  mySimilarityService = new MySimilarityService();
		System.out.println("My:" + mySimilarityService.calculateSimilarityLCS(a, b));
		
		long startTime=System.currentTimeMillis();
		float buf = similarityService.similarScore(a, b);
		long endTime=System.currentTimeMillis(); //��ȡ����ʱ��
		System.out.println("��������ʱ�䣺 "+(endTime-startTime)+"ms");
		System.out.println("Buf:" + buf);
	}
}