package Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import Domain.Geo;
import Domain.Location;
import Domain.Token;
import Service.BaiduServices.BaiduMapService;

public class GetLocation {
	private SplitService splitService;
	private BaiduMapService baiduMapService;
	
	public BaiduMapService getBaiduMapService() {
		return baiduMapService;
	}

	public void setBaiduMapService(BaiduMapService baiduMapService) {
		this.baiduMapService = baiduMapService;
	}

	public void setSplitService(SplitService splitService) {
		this.splitService = splitService;
	}

	public SplitService getSplitService() {
		return splitService;
	}

	public List<Location> getLocation(String str) throws IOException
	{
		List<Token> tkns = splitService.split(str);
		List<Location> result = new ArrayList<Location>();
		for (int i = 0; i < tkns.size(); i++)
		{
//			System.out.println(tkns.get(i).getCont());
			//None
			if (tkns.get(i).getNe().equals("O"))
				continue;
			//name, location or organization
			else
			{
				//name
				if (tkns.get(i).getNe().equals("S-Nh"))
				{
					continue;
				}
				else if (tkns.get(i).getNe().equals("S-Ns"))
				{
					Location e = new Location();
					e.setLocation(tkns.get(i).getCont());
					//to do:get the lat and lng
					Geo buf = baiduMapService.getGeo(e.getLocation());
					if (buf == null)
					{
						continue;
					}
					System.out.println(e.getLocation());
					e.setLat(buf.getLat());
					e.setLng(buf.getLng());
					result.add(e);
				}
				//organization
				else if (tkns.get(i).getNe().equals("B-Ni"))
				{
					Location e = new Location();
					String strBuf = "";
					for (int j = i; j < tkns.size(); j++)
					{
						// B-I----I-E or B
						if (tkns.get(j).getNe().equals("E-Ni") || tkns.get(j).getNe().equals("I-Ni") || tkns.get(j).getNe().equals("B-Ni"))
							strBuf += tkns.get(j).getCont();
						else
							break;
					}
					e.setLocation(strBuf);
					Geo buf = baiduMapService.getGeo(e.getLocation());
					if (buf == null)
					{
						continue;
					}
					System.out.println(e.getLocation());
					e.setLat(buf.getLat());
					e.setLng(buf.getLng());
					result.add(e);
				}
			}
		}
		return result;
	}
}