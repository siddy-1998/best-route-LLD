package inputHandlers;

import entities.Customer;
import entities.DeliveryExecutive;
import entities.Restaurant;
import inputHandlers.types.CustomerInputType;
import inputHandlers.types.DeliveryExecutiveInputType;
import inputHandlers.types.InputType;
import inputHandlers.types.RestaurantInputType;

import java.util.List;
import java.util.Scanner;

public class InputHandler {

    private final Scanner scanner;
    private final InputType<DeliveryExecutive> deliveryExecutiveInput;
    private final InputType<List<Restaurant>> restaurantInput;
    private final InputType<List<Customer>> customerInput;

    public InputHandler() {
        this.scanner = new Scanner(System.in);
        this.deliveryExecutiveInput = new DeliveryExecutiveInputType();
        this.restaurantInput = new RestaurantInputType();
        this.customerInput = new CustomerInputType();
    }

    public UserInputs getUserInputs() {
        DeliveryExecutive deliveryExecutive = deliveryExecutiveInput.handleInput(scanner);
        List<Restaurant> restaurants = restaurantInput.handleInput(scanner);
        List<Customer> customers = customerInput.handleInput(scanner);

        return new UserInputs(deliveryExecutive, customers, restaurants);
    }

}

