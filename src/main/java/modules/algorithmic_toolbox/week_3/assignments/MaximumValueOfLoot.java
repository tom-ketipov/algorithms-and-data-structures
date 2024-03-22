package modules.algorithmic_toolbox.week_3.assignments;

import enums.ValidationMessageType;
import org.apache.commons.lang3.Validate;

import java.util.Arrays;
import java.util.Comparator;

/*
      3.2.2 Maximizing the Value of the Loot Problem Find the maximal value of items that fit into the backpack.

      Input: The capacity of a back-pack W as well as the weights (w1,. . . , wn ) and costs (c1 , . . . , cn ) of n different compounds.
      Output: The maximum total value of fractions of items that fit into the backpack of the given ca-pacity: i.e.,
      the maximum value of c1 · f1 + · · · + cn · fn such that w1 ·f1 +· · ·+wn ·fn ≤ W and 0 ≤ fi ≤ 1 for all i (fi is the fraction of the i-th item taken to the backpack).
 */
public class MaximumValueOfLoot {

    /**
     * Represents a type of spice, characterized by its weight and cost.
     * The class also calculates and stores the price per item based on these values.
     */
    public static class Spice {
        private final int weight;
        private final int cost;
        private final double pricePerItem;

        /**
         * Constructs a new Spice instance with specified weight and cost.
         * Automatically calculates the price per item based on these values.
         *
         * @param weight the weight of the spice, must be non-negative.
         * @param cost   the cost of the spice, must be non-negative.
         * @throws IllegalArgumentException if either weight or cost is negative.
         */
        public Spice(int weight, int cost) {
            Validate.isTrue(weight >= 0, ValidationMessageType.BELOW_MINIMUM_ERROR.getMessage(0));
            Validate.isTrue(cost >= 0, ValidationMessageType.BELOW_MINIMUM_ERROR.getMessage(0));

            this.weight = weight;
            this.cost = cost;
            pricePerItem = (double) cost / weight;
        }

        public int getWeight() {
            return weight;
        }

        public int getCost() {
            return cost;
        }

        public double getPricePerItem() {
            return pricePerItem;
        }
    }

    /**
     * Calculates the maximum value of spices that can be carried in a backpack,
     * given its capacity and a list of available spices. This method applies a greedy algorithm,
     * prioritizing the inclusion of spices with the highest price per unit weight until the backpack's
     * capacity is reached or no more spices are available.
     *
     * @param backpackCapacity the maximum weight capacity of the backpack. Must be non-negative.
     * @param availableSpices  an array of Spice objects representing the available spices. Each spice has weight, cost, and price per item properties.
     * @return the maximum total value of the spices that can be accommodated within the given backpack capacity.
     * @throws IllegalArgumentException if the backpackCapacity is negative or the spices array is null.
     * @implNote Time complexity O(n log n)
     */
    public double maximizeLootValue(int backpackCapacity, Spice[] availableSpices) {
        Validate.isTrue(backpackCapacity >= 0, ValidationMessageType.BELOW_MINIMUM_ERROR.getMessage(0));
        Validate.notNull(availableSpices, ValidationMessageType.NULL_VALUE_ERROR.getMessage());

        // Sort the array by the pricePerItem value
        Arrays.sort(availableSpices, Comparator.comparing(spice -> spice.pricePerItem));

        double totalValue = 0;
        int spiceIndex = availableSpices.length - 1;

        while (backpackCapacity > 0 && spiceIndex >= 0) {
            Spice selectedSpice = availableSpices[spiceIndex];

            if (selectedSpice.getWeight() <= backpackCapacity) {
                backpackCapacity -= selectedSpice.getWeight();
                totalValue += selectedSpice.getCost();
            } else {
                totalValue += backpackCapacity * selectedSpice.getPricePerItem();
            }

            spiceIndex--;
        }
        return totalValue;
    }
}
