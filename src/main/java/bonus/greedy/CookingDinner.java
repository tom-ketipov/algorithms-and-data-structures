package bonus.greedy;

import core.BaseSolver;

import java.util.Arrays;
import java.util.Comparator;

public class CookingDinner extends BaseSolver {

    protected static class Meal {
        private int cookingTime;
        private int dueTime;

        public Meal(int cookingTime, int dueTime) {
            if (cookingTime < 0 || dueTime < 0) {
                throw new IllegalArgumentException("Cooking/Due times must be non-negative integers.");
            }
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
        validate(cookingTimes);
        validate(dueTimes);

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
