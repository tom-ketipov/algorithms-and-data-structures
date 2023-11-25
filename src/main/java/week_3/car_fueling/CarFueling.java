package week_3.car_fueling;

import java.security.InvalidParameterException;
import java.util.Scanner;

public class CarFueling {
    /*
            Car Fueling Problem
            Compute the minimum number of gas tank re-fills to get from one city to another.

            Resources: https://discrete-math-puzzles.github.io/puzzles/car-fueling/
            ================================================================================
            0(n)
     */
    public int computeMinRefills(int totalDistance, int tankCapacity, int[] refillStations) {
        // Validate input parameters
        if (totalDistance <= 0 || tankCapacity <= 0) {
            throw new InvalidParameterException("Total distance/tank capacity cannot be less than 1.");
        }

        if (refillStations == null) {
            throw new InvalidParameterException("Refill stations cannot be null.");
        }

        if (refillStations.length == 0) {
            throw new InvalidParameterException("Refill stations cannot be less than 1.");
        }

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
