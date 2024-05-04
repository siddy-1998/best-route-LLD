package delivery;

import delivery.strategy.ShortestDistanceBasedRouting;
import entities.Restaurant;
import location.Location;
import location.LocationType;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class DeliveryOptimiserTest {

    @Test
    void testCalculateDistances() {
        DeliveryOptimiser deliveryOptimiser = new DeliveryOptimiser(new ShortestDistanceBasedRouting());
        deliveryOptimiser.calculateDistances(new ArrayList<>());
        assertTrue(deliveryOptimiser.distances.isEmpty());
        assertTrue(deliveryOptimiser.preparationTimes.isEmpty());
    }

    @Test
    void testCalculateDistances2() {
        DeliveryOptimiser deliveryOptimiser = new DeliveryOptimiser(new ShortestDistanceBasedRouting());
        deliveryOptimiser.distances = new HashMap<>();
        ArrayList<Location> locations = new ArrayList<>();
        locations.add(new Location(10.0d, 10.0d, "Name", LocationType.RESTAURANT));
        deliveryOptimiser.calculateDistances(locations);

        assertEquals(1, deliveryOptimiser.distances.size());
    }

    @Test
    void testCalculateDistances3() {
        DeliveryOptimiser deliveryOptimiser = new DeliveryOptimiser(new ShortestDistanceBasedRouting());
        deliveryOptimiser.distances = new HashMap<>();

        ArrayList<Location> locations = new ArrayList<>();
        locations.add(new Location(10.0d, 10.0d, "Name", LocationType.RESTAURANT));
        locations.add(new Location(10.0d, 10.0d, "Name", LocationType.RESTAURANT));
        locations.add(new Location(10.0d, 10.0d, "Name", LocationType.RESTAURANT));
        locations.add(new Location(10.0d, 10.0d, "Name", LocationType.RESTAURANT));
        locations.add(new Location(10.0d, 10.0d, "Name", LocationType.RESTAURANT));
        locations.add(new Location(10.0d, 10.0d, "Name", LocationType.RESTAURANT));
        locations.add(new Location(10.0d, 10.0d, "Name", LocationType.RESTAURANT));
        locations.add(new Location(10.0d, 10.0d, "Name", LocationType.RESTAURANT));
        locations.add(new Location(10.0d, 10.0d, "Name", LocationType.RESTAURANT));
        locations.add(new Location(10.0d, 10.0d, "Name", LocationType.RESTAURANT));
        locations.add(new Location(10.0d, 10.0d, "Name", LocationType.RESTAURANT));
        locations.add(new Location(10.0d, 10.0d, "Name", LocationType.RESTAURANT));
        locations.add(new Location(10.0d, 10.0d, "Name", LocationType.RESTAURANT));
        locations.add(new Location(10.0d, 10.0d, "Name", LocationType.RESTAURANT));
        locations.add(new Location(10.0d, 10.0d, "Name", LocationType.RESTAURANT));
        locations.add(new Location(10.0d, 10.0d, "Name", LocationType.RESTAURANT));
        locations.add(new Location(10.0d, 10.0d, "Name", LocationType.RESTAURANT));
        locations.add(new Location(10.0d, 10.0d, "Name", LocationType.RESTAURANT));
        locations.add(new Location(10.0d, 10.0d, "Name", LocationType.RESTAURANT));

        deliveryOptimiser.calculateDistances(locations);

        assertEquals(19, deliveryOptimiser.distances.size());
    }

    @Test
    void testCalculateDistances4() {
        DeliveryOptimiser deliveryOptimiser = new DeliveryOptimiser(new ShortestDistanceBasedRouting());
        ArrayList<Location> locations = new ArrayList<>();
        locations.add(new Location(10.0d, 10.0d, "Name", LocationType.RESTAURANT));
        locations.add(new Location(10.0d, 10.0d, "Name", LocationType.RESTAURANT));

        deliveryOptimiser.calculateDistances(locations);

        assertEquals(2, deliveryOptimiser.distances.size());
    }

    @Test
    void testSetPreparationTimes() {
        DeliveryOptimiser deliveryOptimiser = new DeliveryOptimiser(new ShortestDistanceBasedRouting());
        deliveryOptimiser.setPreparationTimes(new ArrayList<>());

        assertTrue(deliveryOptimiser.distances.isEmpty());
        assertTrue(deliveryOptimiser.preparationTimes.isEmpty());
    }

    @Test
    void testSetPreparationTimes2() {
        DeliveryOptimiser deliveryOptimiser = new DeliveryOptimiser(new ShortestDistanceBasedRouting());
        ArrayList<Restaurant> restaurants = new ArrayList<>();
        restaurants.add(new Restaurant("Name", "42", new Location(10.0d, 10.0d, "Name", LocationType.RESTAURANT), 10.0d));
        deliveryOptimiser.setPreparationTimes(restaurants);

        assertEquals(1, deliveryOptimiser.preparationTimes.size());
    }

    @Test
    void testFindAndPrintOptimalRoute() {
        DeliveryOptimiser deliveryOptimiser = new DeliveryOptimiser(new ShortestDistanceBasedRouting());
        deliveryOptimiser.findAndPrintOptimalRoute(new ArrayList<>());

        assertTrue(deliveryOptimiser.distances.isEmpty());
        assertTrue(deliveryOptimiser.preparationTimes.isEmpty());
    }

    @Test
    void testFindAndPrintOptimalRoute2() {
        DeliveryOptimiser deliveryOptimiser = new DeliveryOptimiser(new ShortestDistanceBasedRouting());
        ArrayList<Location> locations = new ArrayList<>();
        locations.add(new Location(10.0d, 10.0d, "Name", LocationType.RESTAURANT));
        deliveryOptimiser.findAndPrintOptimalRoute(locations);

        assertTrue(deliveryOptimiser.distances.isEmpty());
        assertTrue(deliveryOptimiser.preparationTimes.isEmpty());
    }

    @Test
    void testFindAndPrintOptimalRoute3() {
        DeliveryOptimiser deliveryOptimiser = new DeliveryOptimiser(new ShortestDistanceBasedRouting());
        ArrayList<Location> locations = new ArrayList<>();
        locations.add(new Location(10.0d, 10.0d, "Name", LocationType.RESTAURANT));
        locations.add(new Location(10.0d, 10.0d, "Name", LocationType.RESTAURANT));
        deliveryOptimiser.findAndPrintOptimalRoute(locations);

        assertTrue(deliveryOptimiser.distances.isEmpty());
        assertTrue(deliveryOptimiser.preparationTimes.isEmpty());
    }
}
