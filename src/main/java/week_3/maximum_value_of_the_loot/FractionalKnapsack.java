package week_3.maximum_value_of_the_loot;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class FractionalKnapsack {
//    /*
//        Task: You are a looter with ability to steal capacity amount of goods.
//        At your looting location you find items with the following characteristics: values, weights.
//        ============================================================================================
//        Steps to conquer:
//        1. Find the itemValue for all values
//        2. Start filling capacity with values until full
//
//        Initial time complexity: O(n^2)
//     */
//
//    private static double[] calculateItemValues(int[] values, int[] weights) {
//        double[] perItemValues = new double[values.length];
//
//        for (int i = 0; i < values.length; i++) {
//            perItemValues[i] = values[i] / (double) weights[i];
//        }
//        return perItemValues;
//    }
//
//    private static int getMaxValueIndex(double[] itemValues) {
//        int maxValueIndex = 0;
//        double maxValue = 0;
//
//        for (int i = 0; i < itemValues.length; i++) {
//            if (itemValues[i] > maxValue) {
//                maxValue = itemValues[i];
//                maxValueIndex = i;
//            }
//        }
//        return maxValueIndex;
//    }
//
//    public static double getOptimalValue(int capacity, int[] values, int[] weights) {
//        double[] itemValues = calculateItemValues(values, weights);
//
//        double value = 0;
//        while (capacity > 0) {
//            int itemIndex = getMaxValueIndex(itemValues);
//            int itemWeight = weights[itemIndex];
//
//            int takenWeight = Math.min(capacity, itemWeight);
//            capacity -= takenWeight;
//
//            value += (itemValues[itemIndex] * takenWeight);
//            itemValues[itemIndex] = -1;
//        }
//        return value;
//    }
//
//    /*
//     ============================================================================================
//
//     Updated algorithm complexity: O(n log n)
//     */

    private static class Item {
        int value;
        int weight;
        double ratio;

        public Item(int value, int weight) {
            this.value = value;
            this.weight = weight;
            this.ratio = (double) value / weight;
        }
    }

    private static Item[] getItemRatios(int[] values, int[] weights) {
        Item[] items = new Item[values.length];

        for (int i = 0; i < items.length; i++) {
            items[i] = new Item(values[i], weights[i]);
        }

        Arrays.sort(items, Comparator.comparing(item -> -item.ratio));
        return items;
    }

    public static double getOptimalValue(int capacity, int[] values, int[] weights) {
        Item[] items = getItemRatios(values, weights);

        double value = 0;
        for (Item item : items) {
            int weightTaken = Math.min(capacity, item.weight);

            value += weightTaken * item.ratio;
            capacity -= weightTaken;

            if (capacity == 0) break;
        }
        return value;
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int capacity = scanner.nextInt();
        int[] values = new int[n];
        int[] weights = new int[n];
        for (int i = 0; i < n; i++) {
            values[i] = scanner.nextInt();
            weights[i] = scanner.nextInt();
        }
        System.out.println(getOptimalValue(capacity, values, weights));
    }
}
