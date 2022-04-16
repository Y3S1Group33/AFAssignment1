package driverconsumer;

import java.util.Scanner;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import driverpublisher.IDriverService;

public class Activator implements BundleActivator {

	ServiceReference serviceReference;


	public void start(BundleContext context) throws Exception {
		System.out.println("Start Subscriber Service");
		//Register Consumer Service
		serviceReference = context.getServiceReference(IDriverService.class.getName());
		@SuppressWarnings("unchecked")
		IDriverService driver = (IDriverService)context.getService(serviceReference);	
		displayDrivers(driver);
		
	}
	
	public void stop(BundleContext context) throws Exception {
		System.out.println("Good Bye!");
		context.ungetService(serviceReference);
	}


	private void displayDrivers(IDriverService driver) {
		
		
		int option;
		String subOption = "y";
		String subOption1 = "y";
		
		Scanner scan = new Scanner(System.in);
		System.out.println("\n\n\n");
		System.out.println("----------Driver Management Section ----------\n");
		System.out.println("1  - Add Driver to the Database");
		System.out.println("2  - Get all Drivers in the Database");
		System.out.println("3  - Get Driver By the Id ");
		System.out.println("4  - Delete Driver by the Id");
		System.out.println("\n--------------------------------------------------");
		System.out.println("\n--------------------------------------------------");
		
		System.out.print("\n\nChoose an option : \n\n");
		
		option = Integer.parseInt(scan.nextLine().trim());
		
		switch(option) {
			case 1:
				driver.addDriver();
				
				while(subOption.equals("y")) {
					System.out.println("\n\nDo you want to Add Another Driver (y/n)");
					subOption = scan.nextLine().trim();
		
					if(subOption.equals("y")||subOption.equals("Y")) {
						driver.addDriver();
					}
				}
				System.out.println("\n\nDo you want to continue with another service(y/n)");
				subOption1 = scan.nextLine().trim();

				if(subOption1.equals("y")||subOption.equals("Y")) {
					displayDrivers(driver);
				}
				break;
			case 2:
				driver.getAll();
				System.out.println("\n\nDo you want to continue with another service(y/n)");
				subOption1 = scan.nextLine().trim();

				if(subOption1.equals("y")||subOption.equals("Y")) {
					displayDrivers(driver);
				}
				break;
			case 3:
				driver.getById();
				System.out.println("\n\nDo you want to continue with another service(y/n)");
				subOption1 = scan.nextLine().trim();

				if(subOption1.equals("y")||subOption.equals("Y")) {
					displayDrivers(driver);
				}
				break;
			case 4:
				driver.deleteDriver();
				System.out.println("\n\nDo you want to continue with another service(y/n)");
				subOption1 = scan.nextLine().trim();

				if(subOption1.equals("y")||subOption.equals("Y")) {
					displayDrivers(driver);
				}
				break;
			
			default:
				System.out.println("Incorrect Input. Try Again...");
				System.out.println("\n\nDo you want to continue with another service(y/n)");
				subOption1 = scan.nextLine().trim();

				if(subOption1.equals("y")||subOption.equals("Y")) {
					displayDrivers(driver);
				}
		}
		
		
	
	}


	

}
