package Service.Test;

import java.io.IOException;

import Service.BaiduServices.BaiduMapService;

public class BaiduMapTest {
	public static void main(String args[]) throws IOException
	{
		BaiduMapService b = new BaiduMapService();
		String hehe = "∞Ÿ∂»¥Ûœ√";
		System.out.println(hehe);
		b.getGeo(hehe);
		
	}
}
