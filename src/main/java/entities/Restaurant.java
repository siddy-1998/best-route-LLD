package entities;

import location.Location;

public class Restaurant extends Entity {

    private double avgPreparationTime;

    public Restaurant(String name, String id, Location location, double avgPreparationTime) {
        super(name, id, location);
        this.avgPreparationTime = avgPreparationTime;
    }

    public double getAvgPreparationTime() {
        return avgPreparationTime;
    }

    public void setAvgPreparationTime(double avgPreparationTime) {
        this.avgPreparationTime = avgPreparationTime;
    }
}
