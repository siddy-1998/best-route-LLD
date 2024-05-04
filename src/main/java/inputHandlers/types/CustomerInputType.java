package inputHandlers.types;

import entities.Customer;
import location.Location;
import location.LocationType;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

public class CustomerInputType implements InputType<List<Customer>> {

    @Override
    public List<Customer> handleInput(Scanner scanner) {
        List<Customer> customers = new ArrayList<>();
        for (int i = 1; i <= 2; i++) {

            System.out.println("Enter customer " + i + " location : ");
            System.out.println("Latitude : ");
            double customerLatitude = scanner.nextDouble();
            System.out.println("Longitude : ");
            double customerLongitude = scanner.nextDouble();
            scanner.nextLine();

            Location customerLocation = new Location(customerLatitude, customerLongitude, "C" + i, LocationType.CUSTOMER);
            String customerId = UUID.randomUUID().toString();
            Customer customer = new Customer("C" + i, customerId, customerLocation);
            customers.add(customer);
        }
        return customers;
    }
}

