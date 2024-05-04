package entities;

import constants.Constants;
import location.Location;

public class DeliveryExecutive extends MovableEntity {

    public DeliveryExecutive(String name, String id, Location location) {
        super(name, id, location, Constants.AVG_SPEED);
    }
}
