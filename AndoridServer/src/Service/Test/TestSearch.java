package Service.Test;

import java.io.IOException;

import Service.SearchFormat;

public class TestSearch {
	public static void main(String args[]) throws IOException{
		SearchFormat sf = new SearchFormat();
		System.out.println(sf.getSearchSent("���ÿ��ÿ���������%20����ˢӦ��һʱ����ϵ������"));
	}
}
