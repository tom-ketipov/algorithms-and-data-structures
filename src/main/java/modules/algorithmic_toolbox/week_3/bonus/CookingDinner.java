package modules.algorithmic_toolbox.week_3.bonus;

import enums.ValidationMessageType;
import org.apache.commons.lang3.Validate;

import java.util.Arrays;
import java.util.Comparator;

public class CookingDinner {

    public static class Meal {
        private final int cookingTime;
        private final int dueTime;

        public Meal(int cookingTime, int dueTime) {
            Validate.isTrue(cookingTime >= 0, ValidationMessageType.BELOW_MINIMUM_ERROR.getMessage(0));
            Validate.isTrue(dueTime >= 0, ValidationMessageType.BELOW_MINIMUM_ERROR.getMessage(0));

            this.cookingTime = cookingTime;
            this.dueTime = dueTime;
        }

        public int getCookingTime() {
            return cookingTime;
        }

        public int getDueTime() {
            return dueTime;
        }
    }

    /**
     * Determines if there exists an order to cook the given array of dishes such that at some point,
     * all of them are fresh simultaneously.
     *
     * @param meals Array of Meal objects representing the meals to be cooked, where each Meal contains
     *              a cooking time and a due time (time it remains fresh).
     * @return true if there is an order of cooking that ensures all dishes are fresh at the same point in time;
     * false otherwise.
     * @throws NullPointerException if the dishes array is null.
     * @implNote Time Complexity: O(n log n)
     */
    public boolean isFreshnessAlignmentFeasible(Meal[] meals) {
        Validate.notNull(meals, ValidationMessageType.NULL_VALUE_ERROR.getMessage());

        Arrays.sort(meals, Comparator.comparing(Meal::getDueTime).reversed());

        int cumulativeCookingTime = meals[meals.length - 1].getCookingTime();
        for (int i = meals.length - 2; i >= 0; i--) {
            if (meals[i].getDueTime() - cumulativeCookingTime <= 0) return false;
            cumulativeCookingTime += meals[i].getCookingTime();
        }
        return true;
    }
}
