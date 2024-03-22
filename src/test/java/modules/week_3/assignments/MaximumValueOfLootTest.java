package modules.week_3.assignments;


import enums.ValidationMessageType;
import modules.algorithmic_toolbox.week_3.assignments.MaximumValueOfLoot;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MaximumValueOfLootTest {
    private MaximumValueOfLoot maximumValueOfLootSolver;

    @BeforeEach
    public void setUp() {
        maximumValueOfLootSolver = new MaximumValueOfLoot();
    }

    @Test
    public void cant_construct_spice_with_negative_weight() {
        try {
            new MaximumValueOfLoot.Spice(-1, 50);
        } catch (IllegalArgumentException e) {
            Assertions.assertEquals(ValidationMessageType.BELOW_MINIMUM_ERROR.getMessage(0), e.getMessage());
        }
    }

    @Test
    public void cant_construct_spice_with_negative_cost() {
        try {
            new MaximumValueOfLoot.Spice(41, -23);
        } catch (IllegalArgumentException e) {
            Assertions.assertEquals(ValidationMessageType.BELOW_MINIMUM_ERROR.getMessage(0), e.getMessage());
        }
    }

    @Test
    public void cant_construct_spice_with_zero_weight_for_positive_cost() {
        try {
            new MaximumValueOfLoot.Spice(0, 10);
        } catch (IllegalArgumentException e) {
            Assertions.assertEquals(ValidationMessageType.BELOW_MINIMUM_ERROR.getMessage(0), e.getMessage());
        }
    }

    @Test
    public void can_construct_spice_with_zero_cost_for_positive_weight() {
        MaximumValueOfLoot.Spice spice = new MaximumValueOfLoot.Spice(20, 0);

        Assertions.assertEquals(spice.getWeight(), 20);
        Assertions.assertEquals(spice.getCost(), 0);
        Assertions.assertEquals(spice.getPricePerItem(), 0);
    }

    @Test
    public void can_construct_spice_with_positive_weight_and_cost() {
        MaximumValueOfLoot.Spice spice = new MaximumValueOfLoot.Spice(20, 40);

        Assertions.assertEquals(spice.getWeight(), 20);
        Assertions.assertEquals(spice.getCost(), 40);
        Assertions.assertEquals(spice.getPricePerItem(), 2);
    }

    @Test
    public void maximize_loot_value_returns_correct_value_when_there_is_a_single_backpack_capacity() {
        MaximumValueOfLoot.Spice spiceA = new MaximumValueOfLoot.Spice(10, 5);
        MaximumValueOfLoot.Spice spiceB = new MaximumValueOfLoot.Spice(20, 20);
        MaximumValueOfLoot.Spice spiceC = new MaximumValueOfLoot.Spice(100, 5);
        MaximumValueOfLoot.Spice spiceD = new MaximumValueOfLoot.Spice(1, 10);

        MaximumValueOfLoot.Spice[] spices = {spiceA, spiceB, spiceC, spiceD};

        Assertions.assertEquals(10, maximumValueOfLootSolver.maximizeLootValue(1, spices));
    }

    @Test
    public void maximize_loot_value_returns_correct_value_when_there_is_a_higher_backpack_capacity_than_available_spices() {
        MaximumValueOfLoot.Spice spiceA = new MaximumValueOfLoot.Spice(10, 5);
        MaximumValueOfLoot.Spice spiceB = new MaximumValueOfLoot.Spice(20, 20);
        MaximumValueOfLoot.Spice spiceC = new MaximumValueOfLoot.Spice(100, 5);
        MaximumValueOfLoot.Spice spiceD = new MaximumValueOfLoot.Spice(1, 10);

        MaximumValueOfLoot.Spice[] spices = {spiceA, spiceB, spiceC, spiceD};

        Assertions.assertEquals(40, maximumValueOfLootSolver.maximizeLootValue(150, spices));
    }

    @Test
    public void maximize_loot_value_returns_correct_value_for_empty_spices_array() {
        Assertions.assertEquals(0, maximumValueOfLootSolver.maximizeLootValue(150, new MaximumValueOfLoot.Spice[]{}));
    }

    @Test
    public void maximize_loot_Value_returns_null_pointer_exception_for_null_spices_input() {
        try {
            maximumValueOfLootSolver.maximizeLootValue(150, null);
        } catch (NullPointerException e) {
            Assertions.assertEquals(ValidationMessageType.NULL_VALUE_ERROR.getMessage(), e.getMessage());
        }
    }

    @Test
    public void maximize_loot_Value_returns_illegal_argument_exception_for_negative_backpack_capacity_input() {
        MaximumValueOfLoot.Spice spiceA = new MaximumValueOfLoot.Spice(5, 5);
        MaximumValueOfLoot.Spice spiceB = new MaximumValueOfLoot.Spice(22, 20);
        MaximumValueOfLoot.Spice spiceC = new MaximumValueOfLoot.Spice(123, 5);
        MaximumValueOfLoot.Spice spiceD = new MaximumValueOfLoot.Spice(51, 10);

        MaximumValueOfLoot.Spice[] spices = {spiceA, spiceB, spiceC, spiceD};

        try {
            maximumValueOfLootSolver.maximizeLootValue(-150, spices);
        } catch (IllegalArgumentException e) {
            Assertions.assertEquals(ValidationMessageType.BELOW_MINIMUM_ERROR.getMessage(0), e.getMessage());
        }
    }
}
