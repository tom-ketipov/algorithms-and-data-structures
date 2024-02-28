package modules.algorithmic_toolbox.bonus.greedy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CookingDinnerTest {
    private CookingDinner cookingDinnerSolver;

    @Test
    public void can_create_a_meal_with_positive_fields() {
        int cookingTime = 1;
        int dueTime = 5;

        CookingDinner.Meal meal = new CookingDinner.Meal(cookingTime, dueTime);
        assertEquals(cookingTime, meal.getCookingTime());
        assertEquals(dueTime, meal.getDueTime());
    }

    @Test
    public void can_create_a_meal_with_zero_cooking_time() {
        int cookingTime = 0;
        int dueTime = 5;

        CookingDinner.Meal meal = new CookingDinner.Meal(cookingTime, dueTime);
        assertEquals(cookingTime, meal.getCookingTime());
        assertEquals(dueTime, meal.getDueTime());
    }

    @Test
    public void can_create_a_meal_with_zero_due_time() {
        int cookingTime = 10;
        int dueTime = 0;

        CookingDinner.Meal meal = new CookingDinner.Meal(cookingTime, dueTime);
        assertEquals(cookingTime, meal.getCookingTime());
        assertEquals(dueTime, meal.getDueTime());
    }

    @Test
    public void can_generate_cooking_plan_for_valid_distinct_values() {
        cookingDinnerSolver = new CookingDinner();

        int[] cookingTimes = {4, 2, 3};
        int[] dueTimes = {6, 2, 4};

        CookingDinner.Meal[] cookingPlan = cookingDinnerSolver.generatePlan(cookingTimes, dueTimes);
        assertEquals(6, cookingPlan[0].getDueTime());
        assertEquals(4, cookingPlan[1].getDueTime());
        assertEquals(2, cookingPlan[2].getDueTime());
        assertEquals(4, cookingPlan[0].getCookingTime());
        assertEquals(3, cookingPlan[1].getCookingTime());
        assertEquals(2, cookingPlan[2].getCookingTime());
    }

    @Test
    public void can_generate_cooking_plan_for_valid_duplicate_cooking_times() {
        cookingDinnerSolver = new CookingDinner();

        int[] cookingTimes = {2, 2, 2};
        int[] dueTimes = {6, 2, 4};

        CookingDinner.Meal[] cookingPlan = cookingDinnerSolver.generatePlan(cookingTimes, dueTimes);
        assertEquals(6, cookingPlan[0].getDueTime());
        assertEquals(4, cookingPlan[1].getDueTime());
        assertEquals(2, cookingPlan[2].getDueTime());
        assertEquals(2, cookingPlan[0].getCookingTime());
        assertEquals(2, cookingPlan[1].getCookingTime());
        assertEquals(2, cookingPlan[2].getCookingTime());
    }

    @Test
    public void can_generate_cooking_plan_for_valid_duplicate_due_times() {
        cookingDinnerSolver = new CookingDinner();

        int[] cookingTimes = {4, 2, 3};
        int[] dueTimes = {6, 6, 6};

        CookingDinner.Meal[] cookingPlan = cookingDinnerSolver.generatePlan(cookingTimes, dueTimes);
        assertEquals(6, cookingPlan[0].getDueTime());
        assertEquals(6, cookingPlan[1].getDueTime());
        assertEquals(6, cookingPlan[2].getDueTime());
        assertEquals(4, cookingPlan[0].getCookingTime());
        assertEquals(3, cookingPlan[1].getCookingTime());
        assertEquals(2, cookingPlan[2].getCookingTime());
    }

    @Test
    public void cant_generate_cooking_plan_for_non_overlapping_due_times() {
        cookingDinnerSolver = new CookingDinner();

        int[] cookingTimes = {1, 3, 1};
        int[] dueTimes = {4, 2, 1};

        CookingDinner.Meal[] cookingPlan = cookingDinnerSolver.generatePlan(cookingTimes, dueTimes);
        assertEquals(0, cookingPlan.length);
    }

    @Test
    public void cant_create_a_meal_with_negative_cooking_time() {
        int cookingTime = -7;
        int dueTime = 1;

        try {
            new CookingDinner.Meal(cookingTime, dueTime);
        } catch (IllegalArgumentException e) {
            assertEquals("The value must be between 0 and 2,147,483,647.", e.getMessage());
        }
    }

    @Test
    public void cant_create_a_meal_with_negative_due_time() {
        int cookingTime = 10;
        int dueTime = -1;

        try {
            new CookingDinner.Meal(cookingTime, dueTime);
        } catch (IllegalArgumentException e) {
            assertEquals("The value must be between 0 and 2,147,483,647.", e.getMessage());
        }
    }

    @Test
    public void can_generate_cooking_plan_for_null_cooking_times() {
        cookingDinnerSolver = new CookingDinner();

        int[] dueTimes = {13, 44, 5, 17};

        try {
            cookingDinnerSolver.generatePlan(null, dueTimes);
        } catch (NullPointerException e) {
            assertEquals("The array must not be null.", e.getMessage());
        }
    }

    @Test
    public void can_generate_cooking_plan_for_empty_cooking_times() {
        cookingDinnerSolver = new CookingDinner();

        int[] dueTimes = {13, 44, 5, 17};

        try {
            cookingDinnerSolver.generatePlan(new int[0], dueTimes);
        } catch (IllegalArgumentException e) {
            assertEquals("The array must not be empty.", e.getMessage());
        }
    }

    @Test
    public void can_generate_cooking_plan_for_null_due_times() {
        cookingDinnerSolver = new CookingDinner();

        int[] cookingTimes = {13, 44, 5, 17};

        try {
            cookingDinnerSolver.generatePlan(cookingTimes, null);
        } catch (NullPointerException e) {
            assertEquals("The array must not be null.", e.getMessage());
        }
    }

    @Test
    public void can_generate_cooking_plan_for_empty_due_times() {
        cookingDinnerSolver = new CookingDinner();

        int[] cookingTimes = {13, 44, 5, 17};

        try {
            cookingDinnerSolver.generatePlan(cookingTimes, new int[0]);
        } catch (IllegalArgumentException e) {
            assertEquals("The array must not be empty.", e.getMessage());
        }
    }
}