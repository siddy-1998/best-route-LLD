import delivery.DeliveryOptimiser;
import delivery.strategy.ShortestTimeBasedRouting;
import entities.Customer;
import entities.DeliveryExecutive;
import entities.Restaurant;
import inputHandlers.InputHandler;
import inputHandlers.UserInputs;
import location.Location;

import java.util.List;

import static location.Utils.getListOfLocations;


public class Main {
    public static void main(String[] args) {

        InputHandler inputHandler = new InputHandler();
        UserInputs userInputs = inputHandler.getUserInputs();

        DeliveryExecutive deliveryExecutive = userInputs.getDeliveryExecutive();
        List<Restaurant> restaurants = userInputs.getRestaurants();
        List<Customer> customers = userInputs.getCustomers();

        List<Location> locations = getListOfLocations(deliveryExecutive, restaurants, customers);
        DeliveryOptimiser deliveryOptimiser = new DeliveryOptimiser(new ShortestTimeBasedRouting());
        deliveryOptimiser.calculateDistances(locations);
        deliveryOptimiser.setPreparationTimes(restaurants);

        deliveryOptimiser.findAndPrintOptimalRoute(locations);
    }
}