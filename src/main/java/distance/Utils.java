package distance;

import location.Location;

import static constants.Constants.EARTH_RADIUS;

public class Utils {

    public static double calculateHaversineDistance(Location loc1, Location loc2) {
        if (loc1 == null || loc2 == null) {
            throw new IllegalArgumentException("Locations cannot be null.");
        }

        Double lat1 = loc1.getLatitude();
        Double lon1 = loc1.getLongitude();
        Double lat2 = loc2.getLatitude();
        Double lon2 = loc2.getLongitude();

        if (lat1 == null || lon1 == null || lat2 == null || lon2 == null) {
            throw new IllegalArgumentException("Latitude and longitude values cannot be null.");
        }

        lat1 = Math.toRadians(lat1);
        lon1 = Math.toRadians(lon1);
        lat2 = Math.toRadians(lat2);
        lon2 = Math.toRadians(lon2);


        double diffLat = lat2 - lat1;
        double diffLon = lon2 - lon1;

        double a = Math.sin(diffLat / 2) * Math.sin(diffLat / 2) +
                Math.cos(lat1) * Math.cos(lat2) * Math.sin(diffLon / 2) * Math.sin(diffLon / 2);

        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        return EARTH_RADIUS * c;
    }

    public static double calculateTravelTime(double distance, double avgSpeed) {
        return distance / avgSpeed;
    }

}
