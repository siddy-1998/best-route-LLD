package inputHandlers.types;

import entities.Restaurant;
import location.Location;
import location.LocationType;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

public class RestaurantInputType implements InputType<List<Restaurant>> {

    @Override
    public List<Restaurant> handleInput(Scanner scanner) {
        List<Restaurant> restaurants = new ArrayList<>();
        for (int i = 1; i <= 2; i++) {

            System.out.println("Enter restaurant " + i + " location : ");
            System.out.println("Latitude : ");
            double restLatitude = scanner.nextDouble();
            System.out.println("Longitude : ");
            double restLongitude = scanner.nextDouble();
            scanner.nextLine();

            System.out.println("Enter preparation time for restaurant " + i + " (in hours): ");
            double prepTime = scanner.nextDouble();
            scanner.nextLine();

            Location restaurantLocation = new Location(restLatitude, restLongitude, "R" + i, LocationType.RESTAURANT);
            String restaurantId = UUID.randomUUID().toString();
            Restaurant restaurant = new Restaurant("R" + i, restaurantId, restaurantLocation, prepTime);
            restaurants.add(restaurant);
        }
        return restaurants;
    }
}

