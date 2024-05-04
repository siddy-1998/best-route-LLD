package inputHandlers.types;

import entities.DeliveryExecutive;
import location.Location;
import location.LocationType;

import java.util.Scanner;
import java.util.UUID;

import static constants.Constants.DE_NAME;
import static constants.Constants.START_LOCATION_NAME;

public class DeliveryExecutiveInputType implements InputType<DeliveryExecutive> {

    @Override
    public DeliveryExecutive handleInput(Scanner scanner) {

        System.out.println("Enter the starting location of the delivery agent: ");
        System.out.println("Latitude : ");
        double agentLatitude = scanner.nextDouble();
        System.out.println("Longitude : ");
        double agentLongitude = scanner.nextDouble();
        scanner.nextLine();

        Location agentLocation = new Location(agentLatitude, agentLongitude, START_LOCATION_NAME, LocationType.DELIVERY_EXECUTIVE);
        String agentId = UUID.randomUUID().toString();

        return new DeliveryExecutive(DE_NAME, agentId, agentLocation);
    }
}

