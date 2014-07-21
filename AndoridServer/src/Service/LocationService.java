package Service;

import DAO.LocationDAO;
import Domain.Location;

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
}
