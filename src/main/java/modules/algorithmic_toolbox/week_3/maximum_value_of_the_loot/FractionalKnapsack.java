package modules.algorithmic_toolbox.week_3.maximum_value_of_the_loot;

import org.apache.commons.lang3.Validate;
import utils.ValidationMessageUtility;

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
        int minValue = 1;
        int maxValue = Integer.MAX_VALUE;
        Validate.inclusiveBetween(minValue, maxValue, capacity, ValidationMessageUtility.getMessage("value_range_exception", minValue, maxValue));

        Validate.notNull(weights, ValidationMessageUtility.getMessage("not_null_array_exception"));
        Validate.isTrue(weights.length > 0, ValidationMessageUtility.getMessage("not_empty_array_exception"));

        Validate.notNull(values, ValidationMessageUtility.getMessage("not_null_array_exception"));
        Validate.isTrue(values.length > 0, ValidationMessageUtility.getMessage("not_empty_array_exception"));

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
