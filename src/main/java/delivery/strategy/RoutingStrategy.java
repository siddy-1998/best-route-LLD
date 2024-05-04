package delivery.strategy;

import location.Location;

import java.util.List;
import java.util.Map;

public interface RoutingStrategy {

    List<Location> findOptimalRoute(
            List<Location> locations,
            Map<Location, Map<Location, Double>> distances,
            Map<Location, Double> preparationTimes);

    void findAndPrintOptimalRoute(
            List<Location> locations,
            Map<Location, Map<Location, Double>> distances,
            Map<Location, Double> preparationTimes);


}