package Service.DBService;

import java.util.List;

import DAO.LocationDAO;
import Domain.Location;
/**
 * 数据库访问类
 * @author cece
 *
 */
public class LocationService {
	private LocationDAO locationDAO;

	public void setLocationDAO(LocationDAO locationDAO) {
		this.locationDAO = locationDAO;
	}

	public LocationDAO getLocationDAO() {
		return locationDAO;
	}
	
	public void addLocation(Location location)
	{
		locationDAO.addLocation(location);
	}
	
	/* @author lixu*/
	public List<Location> getLocationByAddr(float lat, float lng, float zoom){
		return locationDAO.getLocationByAddr(lat, lng, zoom);
	}
}
