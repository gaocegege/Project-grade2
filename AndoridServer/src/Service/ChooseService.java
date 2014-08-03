package Service;

import java.util.ArrayList;
import java.util.List;

import Domain.Content;

/**
 * 
 * @author Lixu
 *
 */
public class ChooseService {
	public List<Content> choose(List<Content>pro,List<String>title){
		List<Content> result = new ArrayList<Content>();
		for(Content c : pro){
			double count=0;
			String curTitle = c.getTitle();
			System.out.println(curTitle);
			for(String s: title){
				if(curTitle.contains(s))
					count++;
			}
			System.out.println(count+"  "+title.size());
			if((count/title.size())<0.4){
				System.out.println((count/title.size()));
				break;
			}
			result.add(c);
		}
		return result;
	}
}
