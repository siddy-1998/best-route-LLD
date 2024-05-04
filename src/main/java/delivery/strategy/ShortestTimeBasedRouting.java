package delivery.strategy;

import delivery.Utils;
import location.Location;
import location.LocationType;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static constants.Constants.AVG_SPEED;
import static distance.Utils.calculateTravelTime;

/*
   gives optimal route based on shortest time
 */
public class ShortestTimeBasedRouting implements RoutingStrategy {

    // Find the optimal route and print the result
    @Override
    public void findAndPrintOptimalRoute(List<Location> locations, Map<Location, Map<Location, Double>> distances, Map<Location, Double> preparationTimes) {
        List<Location> optimalRoute = findOptimalRoute(locations, distances, preparationTimes);
        double optimalTime = calculateTotalTime(optimalRoute, distances, preparationTimes);
        printOptimalRoute(optimalRoute, optimalTime);
    }

    // Print the optimal route and total time
    public void printOptimalRoute(List<Location> route, double totalTime) {
        System.out.println("Optimal route: " + route.stream()
                .map(Location::getName)
                .collect(Collectors.joining(" -> ")));
        System.out.println("Total time: " + String.format("%.2f", totalTime) + " hours");
    }


    @Override
    public List<Location> findOptimalRoute(List<Location> locations, Map<Location, Map<Location, Double>> distances, Map<Location, Double> preparationTimes) {
        List<List<Location>> validRoutes = Utils.generateValidPermutations(locations);
        double optimalTime = Double.MAX_VALUE;
        List<Location> optimalRoute = null;

        for (List<Location> route : validRoutes) {
            double totalTime = calculateTotalTime(route, distances, preparationTimes);
            if (totalTime < optimalTime) {
                optimalTime = totalTime;
                optimalRoute = route;
            }
        }

        return optimalRoute;
    }

    public double calculateTotalTime(List<Location> route, Map<Location, Map<Location, Double>> distances, Map<Location, Double> preparationTimes) {
        double totalTime = 0;

        for (int i = 0; i < route.size() - 1; i++) {
            Location fromLoc = route.get(i);
            Location toLoc = route.get(i + 1);
            double travelDistance = distances.get(fromLoc).get(toLoc);
            totalTime += calculateTravelTime(travelDistance, AVG_SPEED);

            // Checking if DE is going from resturant to customer, if order is not prepared he needs to wait
            if (fromLoc.getLocationType().equals(LocationType.RESTAURANT) &&
                    toLoc.getLocationType().equals(LocationType.CUSTOMER)) {

                double preparationTime = preparationTimes.get(fromLoc);
                if (totalTime < preparationTime) {
                    totalTime += preparationTime - totalTime;
                }
            }
        }
        return totalTime;
    }

}
