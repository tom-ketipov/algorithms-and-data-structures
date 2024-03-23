package modules.week_3.bonus;

import enums.ValidationMessageType;
import modules.algorithmic_toolbox.week_3.bonus.MealFreshnessOptimizer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MealFreshnessOptimizerTest {

    private MealFreshnessOptimizer mealFreshnessOptimizerSolver;

    @BeforeEach
    public void setUp() {
        mealFreshnessOptimizerSolver = new MealFreshnessOptimizer();
    }

    @Test
    public void can_construct_meal_with_positive_cooking_time() {
        MealFreshnessOptimizer.Meal meal = new MealFreshnessOptimizer.Meal(10, 26);

        Assertions.assertEquals(10, meal.getCookingTime());
    }

    @Test
    public void can_construct_meal_with_positive_due_time() {
        MealFreshnessOptimizer.Meal meal = new MealFreshnessOptimizer.Meal(123, 588);

        Assertions.assertEquals(588, meal.getDueTime());
    }

    @Test
    public void cant_construct_meal_with_negative_cooking_time() {
        try {
            new MealFreshnessOptimizer.Meal(-5, 12);
        } catch (IllegalArgumentException e) {
            Assertions.assertEquals(ValidationMessageType.BELOW_MINIMUM_ERROR.getMessage(0), e.getMessage());
        }
    }

    @Test
    public void cant_construct_meal_with_negative_due_time() {
        try {
            new MealFreshnessOptimizer.Meal(5, -12);
        } catch (IllegalArgumentException e) {
            Assertions.assertEquals(ValidationMessageType.BELOW_MINIMUM_ERROR.getMessage(0), e.getMessage());
        }
    }

    @Test
    public void can_detect_if_all_meals_can_be_fresh_at_the_same_time() {
        MealFreshnessOptimizer.Meal[] meals = new MealFreshnessOptimizer.Meal[3];
        meals[0] = new MealFreshnessOptimizer.Meal(10, 26);
        meals[1] = new MealFreshnessOptimizer.Meal(15, 11);
        meals[2] = new MealFreshnessOptimizer.Meal(10, 1);

        Assertions.assertTrue(mealFreshnessOptimizerSolver.canAllDishesBeFreshTogether(meals));
    }

    @Test
    public void can_detect_if_all_meals_cant_be_fresh_at_the_same_time() {
        MealFreshnessOptimizer.Meal[] meals = new MealFreshnessOptimizer.Meal[3];
        meals[0] = new MealFreshnessOptimizer.Meal(10, 26);
        meals[1] = new MealFreshnessOptimizer.Meal(16, 11);
        meals[2] = new MealFreshnessOptimizer.Meal(10, 1);

        Assertions.assertFalse(mealFreshnessOptimizerSolver.canAllDishesBeFreshTogether(meals));
    }

    @Test
    public void null_pointer_exception_is_returned_for_null_input_array() {

        try {
            mealFreshnessOptimizerSolver.canAllDishesBeFreshTogether(null);
        } catch (NullPointerException e) {
            Assertions.assertEquals(ValidationMessageType.NULL_VALUE_ERROR.getMessage(), e.getMessage());
        }
    }
}
