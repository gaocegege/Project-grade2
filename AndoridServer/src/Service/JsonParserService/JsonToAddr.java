package Service.JsonParserService;

import net.sf.json.JSONObject;
import Domain.AddressComponent;

/**
 * 把json转为Token的服务类
 * @author Lixu
 *
 */
public class JsonToAddr {
	
	public AddressComponent transfer(String JsonContent)
	{
		AddressComponent addressComponent = new AddressComponent();
		JSONObject obj = JSONObject.fromObject(JsonContent);
		JSONObject addr = obj.getJSONObject("result").getJSONObject("addressComponent");
		System.out.println(addr.toString());
		addressComponent.setCity(addr.getString("city"));
		addressComponent.setDistrict(addr.getString("district"));
		addressComponent.setProvince(addr.getString("province"));
		addressComponent.setStreet(addr.getString("street"));
		addressComponent.setStreet_number(addr.getString("street_number"));
		
		return addressComponent;
	}
}