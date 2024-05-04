package inputHandlers;

import entities.Customer;
import entities.DeliveryExecutive;
import entities.Restaurant;

import java.util.List;

public class UserInputs {

    private DeliveryExecutive deliveryExecutive;
    private List<Customer> customers;
    private List<Restaurant> restaurants;

    public UserInputs(DeliveryExecutive deliveryExecutive, List<Customer> customers, List<Restaurant> restaurants) {
        this.deliveryExecutive = deliveryExecutive;
        this.customers = customers;
        this.restaurants = restaurants;
    }

    public DeliveryExecutive getDeliveryExecutive() {
        return deliveryExecutive;
    }

    public void setDeliveryExecutive(DeliveryExecutive deliveryExecutive) {
        this.deliveryExecutive = deliveryExecutive;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }

    public List<Restaurant> getRestaurants() {
        return restaurants;
    }

    public void setRestaurants(List<Restaurant> restaurants) {
        this.restaurants = restaurants;
    }

}
