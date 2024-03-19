package modules.algorithmic_toolbox.week_3.bonus;

import enums.ValidationMessageType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CookingDinnerTest {

    private CookingDinner cookingDinnerSolver;

    @BeforeEach
    public void setUp() {
        cookingDinnerSolver = new CookingDinner();
    }

    @Test
    public void can_construct_meal_with_positive_cooking_time() {
        CookingDinner.Meal meal = new CookingDinner.Meal(10, 26);

        Assertions.assertEquals(10, meal.getCookingTime());
    }

    @Test
    public void can_construct_meal_with_positive_due_time() {
        CookingDinner.Meal meal = new CookingDinner.Meal(123, 588);

        Assertions.assertEquals(588, meal.getDueTime());
    }

    @Test
    public void cant_construct_meal_with_negative_cooking_time() {
        try {
            new CookingDinner.Meal(-5, 12);
        } catch (IllegalArgumentException e) {
            Assertions.assertEquals(ValidationMessageType.BELOW_MINIMUM_ERROR.getMessage(0), e.getMessage());
        }
    }

    @Test
    public void cant_construct_meal_with_negative_due_time() {
        try {
            new CookingDinner.Meal(5, -12);
        } catch (IllegalArgumentException e) {
            Assertions.assertEquals(ValidationMessageType.BELOW_MINIMUM_ERROR.getMessage(0), e.getMessage());
        }
    }

    @Test
    public void can_detect_if_all_meals_can_be_fresh_at_the_same_time() {
        CookingDinner.Meal[] meals = new CookingDinner.Meal[3];
        meals[0] = new CookingDinner.Meal(10, 26);
        meals[1] = new CookingDinner.Meal(15, 11);
        meals[2] = new CookingDinner.Meal(10, 1);

        Assertions.assertTrue(cookingDinnerSolver.isFreshnessAlignmentFeasible(meals));
    }

    @Test
    public void can_detect_if_all_meals_cant_be_fresh_at_the_same_time() {
        CookingDinner.Meal[] meals = new CookingDinner.Meal[3];
        meals[0] = new CookingDinner.Meal(10, 26);
        meals[1] = new CookingDinner.Meal(16, 11);
        meals[2] = new CookingDinner.Meal(10, 1);

        Assertions.assertFalse(cookingDinnerSolver.isFreshnessAlignmentFeasible(meals));
    }

    @Test
    public void null_pointer_exception_is_returned_for_null_input_array() {

        try {
            cookingDinnerSolver.isFreshnessAlignmentFeasible(null);
        } catch (NullPointerException e) {
            Assertions.assertEquals(ValidationMessageType.NULL_VALUE_ERROR.getMessage(), e.getMessage());
        }
    }
}
