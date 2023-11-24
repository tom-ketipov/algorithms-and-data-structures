package week_3.car_fueling;

import java.util.Scanner;

public class CarFueling {
    /*
            Car Fueling Problem
            Compute the minimum number of gas tank re-fills to get from one city to another.

            Resources: https://discrete-math-puzzles.github.io/puzzles/car-fueling/
            ================================================================================
            0(n)
     */
    public static int computeMinRefills(int dist, int tank, int[] stops) {
        return validateRoute(stops, tank) ? dist / tank : -1;
    }

    private static boolean validateRoute(int[] stops, int tank) {
        if (stops[0] > tank) {
            return false;
        }

        for (int i = 1; i < stops.length; i++) {
            if (stops[i] - stops[i - 1] > tank) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int dist = scanner.nextInt();
        int tank = scanner.nextInt();
        int n = scanner.nextInt();
        int stops[] = new int[n];
        for (int i = 0; i < n; i++) {
            stops[i] = scanner.nextInt();
        }

        System.out.println(computeMinRefills(dist, tank, stops));
    }
}
