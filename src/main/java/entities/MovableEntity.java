package entities;/*
   Parent of Delivery Executives Or maybe Drones in the future ;)
 */

import location.Location;

public abstract class MovableEntity extends Entity {

    private double avgSpeed;

    // live location etc. may be

    public MovableEntity(String name, String id, Location location, double avgSpeed) {
        super(name, id, location);
        this.avgSpeed = avgSpeed;
    }

    public double getAvgSpeed() {
        return avgSpeed;
    }

    public void setAvgSpeed(int avgSpeed) {
        this.avgSpeed = avgSpeed;
    }
}
