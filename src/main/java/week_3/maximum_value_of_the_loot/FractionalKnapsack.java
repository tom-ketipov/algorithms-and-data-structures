package week_3.maximum_value_of_the_loot;

import java.security.InvalidParameterException;
import java.util.Arrays;
import java.util.Comparator;

public class FractionalKnapsack {

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
        // Validate input parameters
        if (capacity == 0) {
            throw new InvalidParameterException("Capacity cannot be equal to 0.");
        }

        if (values == null || weights == null) {
            throw new InvalidParameterException("Values/weights cannot be null.");
        }

        if (values.length == 0 || weights.length == 0) {
            throw new InvalidParameterException("Values/weights cannot be empty.");
        }

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
