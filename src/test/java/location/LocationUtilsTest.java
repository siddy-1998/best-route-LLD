package location;

import entities.Customer;
import entities.DeliveryExecutive;
import entities.Restaurant;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LocationUtilsTest {

    @Test
    void testGetListOfLocations() {
        Location location = new Location(10.0d, 10.0d, "Name", LocationType.RESTAURANT);
        DeliveryExecutive deliveryExecutive = new DeliveryExecutive("Name", "42", location);
        ArrayList<Restaurant> restaurants = new ArrayList<>();
        List<Location> actualListOfLocations = Utils.getListOfLocations(deliveryExecutive, restaurants, new ArrayList<>());

        assertEquals(1, actualListOfLocations.size());
        assertSame(location, actualListOfLocations.get(0));
    }

    @Test
    void testGetListOfLocations2() {
        List<Location> actualListOfLocations = Utils.getListOfLocations(null, null, null);
        assertTrue(actualListOfLocations.isEmpty());
    }

    @Test
    void testGetListOfLocations3() {
        Customer customer = new Customer("Name", "42", new Location(10.0d, 10.0d, "Name", LocationType.RESTAURANT));
        customer.setLocation(null);
        ArrayList<Customer> customers = new ArrayList<>();
        customers.add(customer);
        List<Location> actualListOfLocations = Utils.getListOfLocations(null, null, customers);

        assertTrue(actualListOfLocations.isEmpty());
    }

    @Test
    void testGetListOfLocations4() {
        Restaurant restaurant = new Restaurant("Name", "42", new Location(10.0d, 10.0d, "Name", LocationType.RESTAURANT),
                10.0d);
        restaurant.setLocation(null);
        ArrayList<Restaurant> restaurants = new ArrayList<>();
        restaurants.add(restaurant);
        List<Location> actualListOfLocations = Utils.getListOfLocations(null, restaurants, null);

        assertTrue(actualListOfLocations.isEmpty());
    }

    @Test
    void testGetListOfLocations5() {
        List<Location> actualListOfLocations = Utils.getListOfLocations(
                new DeliveryExecutive("Name", "42", new Location(10.0d, 10.0d, "Name", LocationType.RESTAURANT)), null, null);

        assertTrue(actualListOfLocations.isEmpty());
    }

    @Test
    void testGetListOfLocations6() {
        DeliveryExecutive deliveryExecutive = new DeliveryExecutive("Name", "42",
                new Location(10.0d, 10.0d, "Name", LocationType.RESTAURANT));
        List<Location> actualListOfLocations = Utils.getListOfLocations(deliveryExecutive, new ArrayList<>(), null);

        assertTrue(actualListOfLocations.isEmpty());
    }

    @Test
    void testGetListOfLocations7() {
        Location location = new Location(10.0d, 10.0d, "Name", LocationType.RESTAURANT);
        DeliveryExecutive deliveryExecutive = new DeliveryExecutive("Name", "42", location);
        ArrayList<Restaurant> restaurants = new ArrayList<>();
        Customer customer = new Customer("Name", "42", new Location(10.0d, 10.0d, "Name", LocationType.RESTAURANT));
        customer.setLocation(null);
        ArrayList<Customer> customers = new ArrayList<>();
        customers.add(customer);
        List<Location> actualListOfLocations = Utils.getListOfLocations(deliveryExecutive, restaurants, customers);

        assertEquals(1, actualListOfLocations.size());
        assertSame(location, actualListOfLocations.get(0));
    }

    @Test
    void testGetListOfLocations8() {
        DeliveryExecutive deliveryExecutive = new DeliveryExecutive("Name", "42",
                new Location(10.0d, 10.0d, "Name", LocationType.RESTAURANT));
        ArrayList<Restaurant> restaurants = new ArrayList<>();
        Customer customer = new Customer("Name", "42", new Location(10.0d, 10.0d, "Name", LocationType.RESTAURANT));
        Location location = new Location(10.0d, 10.0d, "Name", LocationType.RESTAURANT);
        customer.setLocation(location);
        ArrayList<Customer> customers = new ArrayList<>();
        customers.add(customer);
        List<Location> actualListOfLocations = Utils.getListOfLocations(deliveryExecutive, restaurants, customers);

        assertEquals(2, actualListOfLocations.size());
        assertSame(location, actualListOfLocations.get(1));
    }

    @Test
    void testGetListOfLocations9() {
        Location location = new Location(10.0d, 10.0d, "Name", LocationType.RESTAURANT);
        DeliveryExecutive deliveryExecutive = new DeliveryExecutive("Name", "42", location);
        Restaurant restaurant = new Restaurant("Name", "42", new Location(10.0d, 10.0d, "Name", LocationType.RESTAURANT),
                10.0d);
        restaurant.setLocation(null);
        ArrayList<Restaurant> restaurants = new ArrayList<>();
        restaurants.add(restaurant);
        List<Location> actualListOfLocations = Utils.getListOfLocations(deliveryExecutive, restaurants, new ArrayList<>());

        assertEquals(1, actualListOfLocations.size());
        assertSame(location, actualListOfLocations.get(0));
    }

    @Test
    void testGetListOfLocations10() {
        DeliveryExecutive deliveryExecutive = new DeliveryExecutive("Name", "42",
                new Location(10.0d, 10.0d, "Name", LocationType.RESTAURANT));
        Restaurant restaurant = new Restaurant("Name", "42", new Location(10.0d, 10.0d, "Name", LocationType.RESTAURANT),
                10.0d);
        Location location = new Location(10.0d, 10.0d, "Name", LocationType.RESTAURANT);
        restaurant.setLocation(location);
        ArrayList<Restaurant> restaurants = new ArrayList<>();
        restaurants.add(restaurant);
        List<Location> actualListOfLocations = Utils.getListOfLocations(deliveryExecutive, restaurants, new ArrayList<>());

        assertEquals(2, actualListOfLocations.size());
        assertSame(location, actualListOfLocations.get(1));
    }

    @Test
    void testGetListOfLocations11() {
        DeliveryExecutive deliveryExecutive = new DeliveryExecutive("Name", "42",
                new Location(10.0d, 10.0d, "Name", LocationType.RESTAURANT));
        deliveryExecutive.setLocation(null);
        ArrayList<Restaurant> restaurants = new ArrayList<>();
        List<Location> actualListOfLocations = Utils.getListOfLocations(deliveryExecutive, restaurants, new ArrayList<>());

        assertTrue(actualListOfLocations.isEmpty());
    }

}
