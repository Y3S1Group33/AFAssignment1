package vehiclepublisher;
import java.sql.*;

import vehiclerentaldatabase.IVehicleRentalDb;
import vehiclerentaldatabase.VehicleRentalDb;

public class VehicleService implements IVehicleService {

	
	private Connection connection = null;
	private Statement statement = null;
	private  IVehicleRentalDb vehicleRentalDatabase;
	private ResultSet resultSet;
	

	public VehicleService() {
		super();
		vehicleRentalDatabase = (IVehicleRentalDb) new VehicleRentalDb();
		connection = vehicleRentalDatabase.connection();
	}
	@Override
	public void getAll() {
		System.out.println("returned from publisher");
		
	}

	@Override
	public void getById() {
		// TODO Auto-generated method stub
		
	}

}
