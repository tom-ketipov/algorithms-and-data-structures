package modules.algorithmic_toolbox.week_3.car_fueling;


import static services.ValidationService.*;

public class CarFueling {
    public final static String NON_NULL_REFILL_STATIONS_EXCEPTION_MESSAGE = "The input array of refill stations must not be null.";
    public final static String NON_EMPTY_REFILL_STATIONS_EXCEPTION_MESSAGE = "The input array of refill stations must not be empty.";
    public final static String NON_NEGATIVE_DISTANCE_EXCEPTION_MESSAGE = "The input distance must be higher than 1.";
    public final static String NON_NEGATIVE_CAPACITY_EXCEPTION_MESSAGE = "The input tank capacity must be higher than 1.";

    /*
            Car Fueling Problem
            Compute the minimum number of gas tank re-fills to get from one city to another.

            Resources: https://discrete-math-puzzles.github.io/puzzles/car-fueling/
            ================================================================================
            Time complexity: 0(n)
     */
    public int computeMinRefills(int totalDistance, int tankCapacity, int[] refillStations) {
        validateInRange(totalDistance, 1, Integer.MAX_VALUE, NON_NEGATIVE_DISTANCE_EXCEPTION_MESSAGE);
        validateInRange(tankCapacity, 1, Integer.MAX_VALUE, NON_NEGATIVE_CAPACITY_EXCEPTION_MESSAGE);
        validateNotNull(refillStations, NON_NULL_REFILL_STATIONS_EXCEPTION_MESSAGE);
        validateNotEmpty(refillStations, NON_EMPTY_REFILL_STATIONS_EXCEPTION_MESSAGE);

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
