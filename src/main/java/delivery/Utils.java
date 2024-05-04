package delivery;

import location.Location;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static constants.Constants.*;


public class Utils {

    /*
       generate permutations ensuring R1 comes before C1 and R2 before C2
     */
    public static List<List<Location>> generateValidPermutations(List<Location> locations) {
        List<List<Location>> result = new ArrayList<>();
        permuteWithConstraint(locations, 1, result); // Start from index 1 to keep "start" fixed
        return result;
    }

    //Recursively generate permutations
    private static void permuteWithConstraint(List<Location> list, int index, List<List<Location>> result) {
        if (index == list.size() - 1) {
            if (isValidRoute(list)) {
                result.add(new ArrayList<>(list));
            }
            return;
        }

        for (int i = index; i < list.size(); i++) {
            Collections.swap(list, index, i);
            permuteWithConstraint(list, index + 1, result);
            Collections.swap(list, index, i);
        }
    }

    //Ensure R1 precedes C1 and R2 precedes C2
    public static boolean isValidRoute(List<Location> locations) {
        boolean valid = true;
        int r1Index = -1, c1Index = -1, r2Index = -1, c2Index = -1;

        for (int i = 0; i < locations.size(); i++) {
            Location location = locations.get(i);
            String name = location.getName();
            if (name.equals(RESTAURANT_NAME_1)) {
                r1Index = i;
            } else if (name.equals(CUSTOMER_NAME_1)) {
                c1Index = i;
            } else if (name.equals(RESTAURANT_NAME_2)) {
                r2Index = i;
            } else if (name.equals(CUSTOMER_NAME_2)) {
                c2Index = i;
            }
        }

        if (r1Index > c1Index || r2Index > c2Index) {
            valid = false;
        }

        return valid;
    }

}
