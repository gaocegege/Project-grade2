package Service.Test;

import java.io.IOException;

import Service.SearchFormat;

public class TestSearch {
	public static void main(String args[]) throws IOException{
		SearchFormat sf = new SearchFormat();
		System.out.println(sf.getSearchSent("信用卡用卡环境复杂%20遇盗刷应第一时间联系发卡行"));
	}
}
