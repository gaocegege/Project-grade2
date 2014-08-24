package Service.SimilarityServices;

public class MySimilarityService {
	private final String content_regex = "(?i)[^a-zA-Z0-9\u4E00-\u9FA5]";
	 
	 /**
	  * 判断两段正文相似度
	  * @param content1
	  * @param content2
	  * @return
	  */
	 private float calculateContentSimilarity(String content1, String content2){
	  
	  String s1 = content1.replaceAll("content_regex", "").trim(); 
	  String s2 = content2.replaceAll("content_regex", "").trim();
	  
	  if(s1.equals(s2)){
	   return 1.00f;
	  }else {
	   if (s1.length() > s2.length() ? (s1.indexOf(s2) > -1)
	     : (s2.indexOf(s1) > 0)) {
	    return s1.length() > s2.length() ? ((float) s2
	      .length() / (float) s1.length()) : ((float) s1
	      .length() / (float) s2.length());
	   }
	  }
	  
	//  return calculateSimilarityLCS(s1, s2);
	  
	  return calculateContentSimilarityD(content1, content2);
	 }
	 
	 /**
	  * 判断两段正文相似度
	  * @param content1
	  * @param content2
	  * @return
	  */
	 private float calculateContentSimilarityD(String content1, String content2){
	  
	  String[] s1 = content1.trim().split("。"); 
	  String[] s2 = content2.trim().split("。"); 
	  
	  if(s1.length < s2.length){
	   String[] temp = s1;   
	   s1 = s2;
	   s2 = temp;
	  }
	  
	  float totalWeight = 0;
	  for (int i = 0; i < s2.length; i++) {
	   float unitWeight = 0;
	   for (int j = 0; j < s1.length; j++) {
	    if(content2.indexOf(s2[i]) > -1){
	     unitWeight = 1.00f;
	     break;
	    }
	    float weight = calculateSimilarityLCS(s2[i], s1[j]);
	    if (unitWeight < weight) {
	     unitWeight = weight;
	    }
	   }
	   totalWeight += unitWeight;
	  }
	  
	  return (totalWeight/s2.length) * (s2.length/s1.length);
	  
	 }
	 
	 
	 /**
	  * 判断两段文本相似度
	  * @param value1
	  * @param value2
	  * @return
	  */
	 public float calculateSimilarityLCS(String s1, String s2) {
	  int[][] d = new int[s1.length()][s2.length()];
	  int index = 0;
	  int length = 0;
	  for (int i = 0; i < s1.length(); i++) {
	   for (int j = 0; j < s2.length(); j++) {
	    int n = i - 1 >= 0 && j - 1 >= 0 ? d[i - 1][j - 1] : 0;
	    d[i][j] = s1.charAt(i) == s2.charAt(j) ? 1 + n : 0;
	    if (d[i][j] > length) {
	     length = d[i][j];
	     index = i;
	    }
	   }
	  }
	  
	  int begin = index - length + 1;   
	  String simword = s1.substring(begin, begin + length) ;
	  return s1.length() > s2.length() ? ((float) simword
	    .length() / (float) s1.length()) : ((float) simword
	    .length() / (float) s2.length());
	 }
}
