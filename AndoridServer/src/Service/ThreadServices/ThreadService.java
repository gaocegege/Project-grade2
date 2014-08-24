package Service.ThreadServices;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import Domain.Content;

public class ThreadService {
	private ExecutorService executorService;
	
	private static int num = 20;
	
	public ThreadService()
	{
		executorService = Executors.newFixedThreadPool(num);
	}
	
	public List<Content> dealWithResults(String a, List<Content> originalResult) throws InterruptedException, ExecutionException
	{
		System.out.println("DealWithResults Begin");
		List<Future<Boolean>> bufList = new ArrayList<Future<Boolean>>();
		List<Content> resultList = originalResult;
		for (int i = 0; i < originalResult.size(); i++)
		{
			System.out.println("::::" + i);
			Future<Boolean> future = executorService.submit(new CallTaskUnit(a, originalResult.get(i).getTitle()));
			System.out.println(i + ":::");
			bufList.add(future);
		}
		
		for (int i = bufList.size() - 1; i >= 0; i--)
		{
			if (bufList.get(i).get() == false)
				resultList.remove(i);
		}
		System.out.println("DealWithResults End");
		return resultList;
	}
}
