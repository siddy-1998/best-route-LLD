package delivery;

import delivery.strategy.RoutingStrategy;
import entities.Customer;
import entities.DeliveryExecutive;
import entities.Restaurant;
import location.Location;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static distance.Utils.calculateHaversineDistance;
import static location.Utils.getListOfLocations;

public class DeliveryOptimiser {

    private final RoutingStrategy routingStrategy;
    public Map<Location, Map<Location, Double>> distances;
    public Map<Location, Double> preparationTimes;

    public DeliveryOptimiser(RoutingStrategy routingStrategy) {
        this.routingStrategy = routingStrategy;
        distances = new HashMap<>();
        preparationTimes = new HashMap<>();
    }

    public DeliveryOptimiser(RoutingStrategy routingStrategy, DeliveryExecutive deliveryExecutive, List<Restaurant> restaurants, List<Customer> customers) {
        this.routingStrategy = routingStrategy;
        List<Location> locations = getListOfLocations(deliveryExecutive, restaurants, customers);
        calculateDistances(locations);
        setPreparationTimes(restaurants);
    }

    public void calculateDistances(List<Location> locations) {
        for (Location loc : locations) {
            distances.put(loc, new HashMap<>());
        }

        for (int i = 0; i < locations.size(); i++) {
            for (int j = i + 1; j < locations.size(); j++) {
                Location loc1 = locations.get(i);
                Location loc2 = locations.get(j);
                double distance = calculateHaversineDistance(loc1, loc2);
                distances.get(loc1).put(loc2, distance);
                distances.get(loc2).put(loc1, distance);
            }
        }
    }

    // Set preparation times for the restaurants
    public void setPreparationTimes(List<Restaurant> restaurants) {
        for (Restaurant restaurant : restaurants) {
            preparationTimes.put(restaurant.getLocation(), restaurant.getAvgPreparationTime());
        }
    }

    public void findAndPrintOptimalRoute(List<Location> locations) {
        routingStrategy.findAndPrintOptimalRoute(locations, distances, preparationTimes);
    }


}
