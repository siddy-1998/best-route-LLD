package location;

import entities.Customer;
import entities.DeliveryExecutive;
import entities.Restaurant;

import java.util.ArrayList;
import java.util.List;

public class Utils {
    public static List<Location> getListOfLocations(DeliveryExecutive deliveryExecutive, List<Restaurant> restaurants, List<Customer> customers) {

        if (deliveryExecutive == null || restaurants == null || customers == null) {
            return new ArrayList<>();
        }

        List<Location> locations = new ArrayList<>();

        Location executiveLocation = deliveryExecutive.getLocation();
        if (executiveLocation != null) {
            locations.add(executiveLocation);
        }

        for (Restaurant restaurant : restaurants) {
            Location restaurantLocation = restaurant.getLocation();
            if (restaurantLocation != null) {
                locations.add(restaurantLocation);
            }
        }

        for (Customer customer : customers) {
            Location customerLocation = customer.getLocation();
            if (customerLocation != null) {
                locations.add(customerLocation);
            }
        }

        return locations;
    }
}
