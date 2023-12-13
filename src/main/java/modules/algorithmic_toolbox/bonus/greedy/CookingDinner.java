package modules.algorithmic_toolbox.bonus.greedy;

import services.ValidationMessages;

import java.util.Arrays;
import java.util.Comparator;

import static services.ValidationService.*;

public class CookingDinner {

    protected static class Meal {
        private int cookingTime;
        private int dueTime;

        public Meal(int cookingTime, int dueTime) {
            validateInRange(cookingTime, 0, Integer.MAX_VALUE, ValidationMessages.NOT_NEGATIVE_NUMBER_EXCEPTION_MESSAGE);
            validateInRange(dueTime, 0, Integer.MAX_VALUE, ValidationMessages.NOT_NEGATIVE_NUMBER_EXCEPTION_MESSAGE);

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
        validateNotNull(cookingTimes, ValidationMessages.NOT_NULL_ARRAY_EXCEPTION_MESSAGE);
        validateNotNull(dueTimes, ValidationMessages.NOT_NULL_ARRAY_EXCEPTION_MESSAGE);
        validateNotEmpty(cookingTimes, ValidationMessages.NOT_EMPTY_ARRAY_EXCEPTION_MESSAGE);
        validateNotEmpty(dueTimes, ValidationMessages.NOT_EMPTY_ARRAY_EXCEPTION_MESSAGE);

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
