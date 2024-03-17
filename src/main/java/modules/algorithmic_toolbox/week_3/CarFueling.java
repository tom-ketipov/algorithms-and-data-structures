package modules.algorithmic_toolbox.week_3;

import enums.ValidationMessageType;
import org.apache.commons.lang3.Validate;

/*
        Car Fueling Problem
        Compute the minimum number of gas tank re-fills to get from one city to another.

        Input: Integers d and m, as well as a sequence of integers stop1 < stop2 < · · · < stopn.
        Output: The minimum number of refills to get from one city to another if a car can travel at most m miles on a full tank.
        The distance between the cities is d miles and there are gas stations at distances stop1 , stop2 , . . . , stopn along the way. We assume that a car starts with a full tank.

        Constraints. 1 ≤ d ≤ 10^5 . 1 ≤ m ≤ 400. 1 ≤ n ≤ 300. 0 < stop1 < stop2 <· · · < stopn < d.
 */
public class CarFueling {

    /**
     * Calculates the minimum number of refills needed to travel from one city to another.
     * The method assumes the car starts with a full tank and can only travel a maximum distance per tank.
     * It checks the sequence of gas stations along the way and determines the minimum number of stops required for refueling.
     *
     * @param totalDistance      the total distance between the starting city and the destination city.
     * @param maxDistancePerTank the maximum distance the car can travel on a full tank.
     * @param stationLocations   an array of integers representing the distances of gas stations from the starting city.
     * @return the minimum number of refills needed to reach the destination. Returns -1 if it is impossible to reach the destination with the given conditions.
     * @implNote Time complexity O(n)
     */
    public int calculateMinRefillStops(int totalDistance, int maxDistancePerTank, int[] stationLocations) {
        Validate.inclusiveBetween(1, 100000, totalDistance, ValidationMessageType.OUT_OF_RANGE_ERROR.getMessage(1, 100000));
        Validate.inclusiveBetween(1, 400, maxDistancePerTank, ValidationMessageType.OUT_OF_RANGE_ERROR.getMessage(1, 400));
        Validate.notNull(stationLocations, ValidationMessageType.NULL_VALUE_ERROR.getMessage());
        Validate.inclusiveBetween(1, 300, stationLocations.length, ValidationMessageType.OUT_OF_RANGE_ERROR.getMessage(1, 300));

        // Early return checks for impossible or unnecessary refills
        if (totalDistance - stationLocations[stationLocations.length - 1] > maxDistancePerTank || stationLocations[0] > maxDistancePerTank)
            return -1;
        if (totalDistance < maxDistancePerTank) return 0;

        int refillCount = 0;
        int currentMaxReach = maxDistancePerTank;

        for (int i = 0; i < stationLocations.length; i++) {
            if (stationLocations[i] > currentMaxReach) {
                if (stationLocations[i] - stationLocations[i - 1] > maxDistancePerTank) return -1;

                currentMaxReach = stationLocations[i - 1] + maxDistancePerTank;
                refillCount++;
            }

            if (i == stationLocations.length - 1 && totalDistance > currentMaxReach) refillCount++;
        }
        return refillCount;
    }
}
