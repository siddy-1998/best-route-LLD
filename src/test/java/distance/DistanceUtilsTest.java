package distance;

import location.Location;
import location.LocationType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class DistanceUtilsTest {
    @Test
    void testCalculateHaversineDistance() {
        Location loc1 = new Location(10.0d, 10.0d, "Name", LocationType.RESTAURANT);

        assertEquals(0.0d,
                Utils.calculateHaversineDistance(loc1, new Location(10.0d, 10.0d, "Name", LocationType.RESTAURANT)));
    }

    @Test
    void testCalculateHaversineDistance2() {
        assertThrows(IllegalArgumentException.class, () -> Utils.calculateHaversineDistance(null, null));
    }

    @Test
    void testCalculateHaversineDistance3() {
        assertThrows(IllegalArgumentException.class,
                () -> Utils.calculateHaversineDistance(new Location(10.0d, 10.0d, "Name", LocationType.RESTAURANT), null));
    }

    @Test
    void testCalculateTravelTime() {
        assertEquals(1.0d, Utils.calculateTravelTime(10.0d, 10.0d));
        assertEquals(0.05d, Utils.calculateTravelTime(0.5d, 10.0d));
        assertEquals(Double.NaN, Utils.calculateTravelTime(Double.NaN, 10.0d));
    }
}
