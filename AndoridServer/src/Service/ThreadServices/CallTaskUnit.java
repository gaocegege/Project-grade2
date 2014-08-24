package Service.ThreadServices;

import java.util.concurrent.Callable;

import Service.SimilarityServices.SimilarityService;

/**
 * 执行任务类
 * @author cece
 *
 */
public class CallTaskUnit implements Callable<Boolean>{
	private String a;
	private String b;
	
	
	
	public CallTaskUnit(String a, String b) {
		super();
		this.a = a;
		this.b = b;
	}

	public Boolean call() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("HAHA");
		SimilarityService similarityService = new SimilarityService();
		float re = similarityService.similarScore(a, b);
		if (re < 0.1)
			return false;
		else
			return true;
	}

}
