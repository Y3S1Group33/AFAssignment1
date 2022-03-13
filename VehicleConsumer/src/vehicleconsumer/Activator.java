package vehicleconsumer;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import vehiclepublisher.IVehicleService;

public class Activator implements BundleActivator {

	ServiceReference serviceReference;


	public void start(BundleContext context) throws Exception {
		System.out.println("Start Subscriber Service");
		//Register Consumer Service
		serviceReference = context.getServiceReference(IVehicleService.class.getName());
		@SuppressWarnings("unchecked")
		IVehicleService vehicle = (IVehicleService)context.getService(serviceReference);	
		displayVehicles(vehicle);
	}


	private void displayVehicles(IVehicleService vehicle) {
		
		vehicle.getAll();
		
	}


	public void stop(BundleContext context) throws Exception {
		System.out.println("Good Bye!");
		context.ungetService(serviceReference);
	}

}
