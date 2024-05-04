package delivery.strategy;

import location.Location;

import java.util.List;
import java.util.Map;

/*
  Future perspective : give optimal route based on shortest distance
 */
public class ShortestDistanceBasedRouting implements RoutingStrategy {

    @Override
    public void findAndPrintOptimalRoute(List<Location> locations, Map<Location, Map<Location, Double>> distances, Map<Location, Double> preparationTimes) {

    }

    @Override
    public List<Location> findOptimalRoute(List<Location> locations, Map<Location, Map<Location, Double>> distances, Map<Location, Double> preparationTimes) {
        return List.of();
    }
}
