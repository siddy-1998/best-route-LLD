package delivery.strategy;

import location.Location;
import location.LocationType;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class ShortestTimeBasedRoutingDiffblueTest {

    @Test
    void testPrintOptimalRoute() {
        ShortestTimeBasedRouting shortestTimeBasedRouting = new ShortestTimeBasedRouting();
        ArrayList<Location> route = new ArrayList<>();
        route.add(new Location(10.0d, 10.0d, " -> ", LocationType.RESTAURANT));

        shortestTimeBasedRouting.printOptimalRoute(route, 10.0d);
    }


    @Test
    void testFindOptimalRoute() {
        ShortestTimeBasedRouting shortestTimeBasedRouting = new ShortestTimeBasedRouting();
        ArrayList<Location> locations = new ArrayList<>();
        HashMap<Location, Map<Location, Double>> distances = new HashMap<>();

        assertNull(shortestTimeBasedRouting.findOptimalRoute(locations, distances, new HashMap<>()));
    }

    @Test
    void testFindOptimalRoute2() {
        ShortestTimeBasedRouting shortestTimeBasedRouting = new ShortestTimeBasedRouting();
        ArrayList<Location> locations = new ArrayList<>();
        locations.add(new Location(Double.MAX_VALUE, Double.MAX_VALUE, "Name", LocationType.RESTAURANT));
        HashMap<Location, Map<Location, Double>> distances = new HashMap<>();

        assertNull(shortestTimeBasedRouting.findOptimalRoute(locations, distances, new HashMap<>()));
    }

    @Test
    void testCalculateTotalTime() {
        ShortestTimeBasedRouting shortestTimeBasedRouting = new ShortestTimeBasedRouting();
        ArrayList<Location> route = new ArrayList<>();
        HashMap<Location, Map<Location, Double>> distances = new HashMap<>();

        assertEquals(0.0d, shortestTimeBasedRouting.calculateTotalTime(route, distances, new HashMap<>()));
    }

    @Test
    void testCalculateTotalTime2() {
        ShortestTimeBasedRouting shortestTimeBasedRouting = new ShortestTimeBasedRouting();
        ArrayList<Location> route = new ArrayList<>();
        route.add(new Location(10.0d, 10.0d, "Name", LocationType.RESTAURANT));
        HashMap<Location, Map<Location, Double>> distances = new HashMap<>();

        assertEquals(0.0d, shortestTimeBasedRouting.calculateTotalTime(route, distances, new HashMap<>()));
    }

}
