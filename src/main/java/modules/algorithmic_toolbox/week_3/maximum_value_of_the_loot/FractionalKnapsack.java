package modules.algorithmic_toolbox.week_3.maximum_value_of_the_loot;

import java.util.Arrays;
import java.util.Comparator;

import static services.ValidationService.*;

public class FractionalKnapsack {
    public final static String NON_NULL_VALUES_EXCEPTION_MESSAGE = "The input array of values must not be null.";
    public final static String NON_EMPTY_VALUES_EXCEPTION_MESSAGE = "The input array of values must not be empty.";
    public final static String NON_NULL_WEIGHTS_EXCEPTION_MESSAGE = "The input array of weights must not be null.";
    public final static String NON_EMPTY_WEIGHTS_EXCEPTION_MESSAGE = "The input array of weights must not be empty.";
    public final static String NON_NEGATIVE_CAPACITY_EXCEPTION_MESSAGE = "The input of capacity must be non-negative value.";

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

    private Item[] getItemRatios(int[] values, int[] weights) {
        Item[] items = new Item[values.length];

        for (int i = 0; i < items.length; i++) {
            items[i] = new Item(values[i], weights[i]);
        }

        Arrays.sort(items, Comparator.comparing(item -> -item.ratio));
        return items;
    }

    public double getOptimalValue(int capacity, int[] values, int[] weights) {
        validateNotNull(values, NON_NULL_VALUES_EXCEPTION_MESSAGE);
        validateNotNull(weights, NON_NULL_WEIGHTS_EXCEPTION_MESSAGE);
        validateNotEmpty(values, NON_EMPTY_VALUES_EXCEPTION_MESSAGE);
        validateNotEmpty(weights, NON_EMPTY_WEIGHTS_EXCEPTION_MESSAGE);
        validateInRange(capacity, 1, Integer.MAX_VALUE, NON_NEGATIVE_CAPACITY_EXCEPTION_MESSAGE);

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
}
