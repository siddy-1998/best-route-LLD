package delivery;

import location.Location;
import location.LocationType;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DeliveryUtilsTest {

    @Test
    void testGenerateValidPermutations() {
        List<List<Location>> actualGenerateValidPermutationsResult = Utils.generateValidPermutations(new ArrayList<>());
        assertTrue(actualGenerateValidPermutationsResult.isEmpty());
    }

    @Test
    void testGenerateValidPermutations2() {
        ArrayList<Location> locations = new ArrayList<>();
        locations.add(new Location(10.0d, 10.0d, "Name", LocationType.RESTAURANT));
        List<List<Location>> actualGenerateValidPermutationsResult = Utils.generateValidPermutations(locations);

        assertTrue(actualGenerateValidPermutationsResult.isEmpty());
    }

    @Test
    void testGenerateValidPermutations3() {
        ArrayList<Location> locations = new ArrayList<>();
        locations.add(new Location(10.0d, 10.0d, "Name", LocationType.RESTAURANT));
        Location location = new Location(10.0d, 10.0d, "Name", LocationType.RESTAURANT);
        locations.add(location);
        List<List<Location>> actualGenerateValidPermutationsResult = Utils.generateValidPermutations(locations);

        assertEquals(1, actualGenerateValidPermutationsResult.size());
        List<Location> getResult = actualGenerateValidPermutationsResult.get(0);
        assertEquals(2, getResult.size());
        assertSame(location, getResult.get(1));
    }

    @Test
    void testGenerateValidPermutations4() {
        ArrayList<Location> locations = new ArrayList<>();
        locations.add(new Location(10.0d, 10.0d, "R1", LocationType.RESTAURANT));
        locations.add(new Location(10.0d, 10.0d, "Name", LocationType.RESTAURANT));
        locations.add(new Location(10.0d, 10.0d, "Name", LocationType.RESTAURANT));
        List<List<Location>> actualGenerateValidPermutationsResult = Utils.generateValidPermutations(locations);

        assertEquals(3, locations.size());
        assertTrue(actualGenerateValidPermutationsResult.isEmpty());
    }

    @Test
    void testGenerateValidPermutations5() {
        ArrayList<Location> locations = new ArrayList<>();
        locations.add(new Location(10.0d, 10.0d, "C1", LocationType.RESTAURANT));
        Location location = new Location(10.0d, 10.0d, "Name", LocationType.RESTAURANT);
        locations.add(location);
        List<List<Location>> actualGenerateValidPermutationsResult = Utils.generateValidPermutations(locations);

        assertEquals(1, actualGenerateValidPermutationsResult.size());
        List<Location> getResult = actualGenerateValidPermutationsResult.get(0);
        assertEquals(2, getResult.size());
        assertSame(location, getResult.get(1));
    }

    @Test
    void testGenerateValidPermutations6() {
        ArrayList<Location> locations = new ArrayList<>();
        locations.add(new Location(10.0d, 10.0d, "R2", LocationType.RESTAURANT));
        locations.add(new Location(10.0d, 10.0d, "Name", LocationType.RESTAURANT));
        List<List<Location>> actualGenerateValidPermutationsResult = Utils.generateValidPermutations(locations);

        assertTrue(actualGenerateValidPermutationsResult.isEmpty());
    }

    @Test
    void testGenerateValidPermutations7() {
        ArrayList<Location> locations = new ArrayList<>();
        locations.add(new Location(10.0d, 10.0d, "C2", LocationType.RESTAURANT));
        Location location = new Location(10.0d, 10.0d, "Name", LocationType.RESTAURANT);
        locations.add(location);
        List<List<Location>> actualGenerateValidPermutationsResult = Utils.generateValidPermutations(locations);

        assertEquals(1, actualGenerateValidPermutationsResult.size());
        List<Location> getResult = actualGenerateValidPermutationsResult.get(0);
        assertEquals(2, getResult.size());
        assertSame(location, getResult.get(1));
    }

    @Test
    void testIsValidRoute() {
        assertTrue(Utils.isValidRoute(new ArrayList<>()));
    }

    @Test
    void testIsValidRoute2() {
        ArrayList<Location> locations = new ArrayList<>();
        locations.add(new Location(10.0d, 10.0d, "Name", LocationType.RESTAURANT));

        assertTrue(Utils.isValidRoute(locations));
    }

    @Test
    void testIsValidRoute3() {
        ArrayList<Location> locations = new ArrayList<>();
        locations.add(new Location(10.0d, 10.0d, "R1", LocationType.RESTAURANT));
        locations.add(new Location(10.0d, 10.0d, "Name", LocationType.RESTAURANT));

        assertFalse(Utils.isValidRoute(locations));
    }

    @Test
    void testIsValidRoute4() {
        ArrayList<Location> locations = new ArrayList<>();
        locations.add(new Location(10.0d, 10.0d, "C1", LocationType.RESTAURANT));
        assertTrue(Utils.isValidRoute(locations));
    }
}
