package modules.algorithmic_toolbox.bonus.greedy;

import org.apache.commons.lang3.Validate;
import utils.ValidationMessageUtility;

import java.util.Arrays;
import java.util.Comparator;

public class CookingDinner {

    protected static class Meal {
        private int cookingTime;
        private int dueTime;

        public Meal(int cookingTime, int dueTime) {
            int minValue = 0;
            int maxValue = Integer.MAX_VALUE;
            Validate.inclusiveBetween(minValue, maxValue, cookingTime, ValidationMessageUtility.getMessage("value_range_exception", minValue, maxValue));
            Validate.inclusiveBetween(minValue, maxValue, dueTime, ValidationMessageUtility.getMessage("value_range_exception", minValue, maxValue));

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

    public Meal[] generatePlan(int[] cookingTimes, int[] dueTimes) {
        Validate.notNull(cookingTimes, ValidationMessageUtility.getMessage("not_null_array_exception"));
        Validate.isTrue(cookingTimes.length > 0, ValidationMessageUtility.getMessage("not_empty_array_exception"));

        Validate.notNull(dueTimes, ValidationMessageUtility.getMessage("not_null_array_exception"));
        Validate.isTrue(dueTimes.length > 0, ValidationMessageUtility.getMessage("not_empty_array_exception"));

        Meal[] meals = generateMeals(cookingTimes, dueTimes);
        Arrays.sort(meals, Comparator.comparing(Meal::getDueTime, Comparator.reverseOrder()).thenComparing(Meal::getCookingTime, Comparator.reverseOrder()));

        int end = meals[0].getCookingTime();
        int minDue = meals[0].getCookingTime() + meals[0].getDueTime();
        for (int i = 1; i < meals.length; i++) {
            int pastDue = (end + meals[i - 1].getDueTime());
            end += meals[i].getCookingTime();
            int currentDue = end + meals[i].getDueTime();

            if (minDue > currentDue) {
                minDue = currentDue;
            }

            if (end >= pastDue || minDue <= end) {
                return new Meal[0];
            }
        }
        return meals;
    }

    private Meal[] generateMeals(int[] cookingTimes, int[] dueTimes) {
        Meal[] meals = new Meal[cookingTimes.length];

        for (int i = 0; i < cookingTimes.length; i++) {
            meals[i] = new Meal(cookingTimes[i], dueTimes[i]);
        }
        return meals;
    }
}
