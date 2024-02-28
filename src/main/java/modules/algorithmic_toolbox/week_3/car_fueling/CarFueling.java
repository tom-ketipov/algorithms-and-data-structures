package modules.algorithmic_toolbox.week_3.car_fueling;


import org.apache.commons.lang3.Validate;
import utils.ValidationMessageUtility;

public class CarFueling {
    /*
            Car Fueling Problem
            Compute the minimum number of gas tank re-fills to get from one city to another.

            Resources: https://discrete-math-puzzles.github.io/puzzles/car-fueling/
            ================================================================================
            Time complexity: 0(n)
     */
    public int computeMinRefills(int totalDistance, int tankCapacity, int[] refillStations) {
        int minValue = 1;
        int maxValue = Integer.MAX_VALUE;
        Validate.inclusiveBetween(minValue, maxValue, totalDistance, ValidationMessageUtility.getMessage("value_range_exception", minValue, maxValue));
        Validate.inclusiveBetween(minValue, maxValue, tankCapacity, ValidationMessageUtility.getMessage("value_range_exception", minValue, maxValue));

        Validate.notNull(refillStations, ValidationMessageUtility.getMessage("not_null_array_exception"));
        Validate.isTrue(refillStations.length > 0, ValidationMessageUtility.getMessage("not_empty_array_exception"));

        if (!validateRoute(totalDistance, tankCapacity, refillStations)) return -1;

        int refillStops = 0;
        int remainingFuel = tankCapacity;

        for (int i = 0; i < refillStations.length - 1; i++) {
            int currentStation = refillStations[i];
            int nextStation = refillStations[i + 1];
            int distanceBetweenStations = (i > 0) ? currentStation - refillStations[i - 1] : currentStation;

            remainingFuel -= distanceBetweenStations;

            if (remainingFuel <= 0 || (nextStation - currentStation) > remainingFuel) {
                remainingFuel = tankCapacity;
                refillStops++;
            }
        }

        int lastStationDistance = refillStations[refillStations.length - 1] - refillStations[refillStations.length - 2];
        int remainingDistance = totalDistance - refillStations[refillStations.length - 1];

        if (remainingFuel - lastStationDistance < remainingDistance) {
            refillStops++;
        }

        return refillStops;
    }

    private boolean validateRoute(int totalDistance, int tankCapacity, int[] refilStations) {
        if (refilStations[0] > tankCapacity || (totalDistance - refilStations[refilStations.length - 1]) > tankCapacity) {
            return false;
        }

        for (int i = 1; i < refilStations.length; i++) {
            if (refilStations[i] - refilStations[i - 1] > tankCapacity) {
                return false;
            }
        }
        return true;
    }

}
