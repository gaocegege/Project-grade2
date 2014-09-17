package Service.Test;

import java.io.IOException;

import Service.BaiduServices.BaiduMapService;

/**
 * @author Administrator
 *
 */
public class BaiduMapTest {
	public static void main(String args[]) throws IOException
	{
		BaiduMapService b = new BaiduMapService();
		String hehe = "ÁÉÄþÊ¡";
		System.out.println(hehe);
		b.getGeo(hehe);
		
	}
}
