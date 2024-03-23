package modules.week_3.assignments;


import enums.ValidationMessageType;
import modules.algorithmic_toolbox.week_3.assignments.LootMaximizer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LootMaximizerTest {
    private LootMaximizer lootMaximizerSolver;

    @BeforeEach
    public void setUp() {
        lootMaximizerSolver = new LootMaximizer();
    }

    @Test
    public void cant_construct_spice_with_negative_weight() {
        try {
            new LootMaximizer.Spice(-1, 50);
        } catch (IllegalArgumentException e) {
            Assertions.assertEquals(ValidationMessageType.BELOW_MINIMUM_ERROR.getMessage(0), e.getMessage());
        }
    }

    @Test
    public void cant_construct_spice_with_negative_cost() {
        try {
            new LootMaximizer.Spice(41, -23);
        } catch (IllegalArgumentException e) {
            Assertions.assertEquals(ValidationMessageType.BELOW_MINIMUM_ERROR.getMessage(0), e.getMessage());
        }
    }

    @Test
    public void cant_construct_spice_with_zero_weight_for_positive_cost() {
        try {
            new LootMaximizer.Spice(0, 10);
        } catch (IllegalArgumentException e) {
            Assertions.assertEquals(ValidationMessageType.BELOW_MINIMUM_ERROR.getMessage(0), e.getMessage());
        }
    }

    @Test
    public void can_construct_spice_with_zero_cost_for_positive_weight() {
        LootMaximizer.Spice spice = new LootMaximizer.Spice(20, 0);

        Assertions.assertEquals(spice.getWeight(), 20);
        Assertions.assertEquals(spice.getCost(), 0);
        Assertions.assertEquals(spice.getPricePerItem(), 0);
    }

    @Test
    public void can_construct_spice_with_positive_weight_and_cost() {
        LootMaximizer.Spice spice = new LootMaximizer.Spice(20, 40);

        Assertions.assertEquals(spice.getWeight(), 20);
        Assertions.assertEquals(spice.getCost(), 40);
        Assertions.assertEquals(spice.getPricePerItem(), 2);
    }

    @Test
    public void maximize_loot_value_returns_correct_value_when_there_is_a_single_backpack_capacity() {
        LootMaximizer.Spice spiceA = new LootMaximizer.Spice(10, 5);
        LootMaximizer.Spice spiceB = new LootMaximizer.Spice(20, 20);
        LootMaximizer.Spice spiceC = new LootMaximizer.Spice(100, 5);
        LootMaximizer.Spice spiceD = new LootMaximizer.Spice(1, 10);

        LootMaximizer.Spice[] spices = {spiceA, spiceB, spiceC, spiceD};

        Assertions.assertEquals(10, lootMaximizerSolver.maximizeLootValue(1, spices));
    }

    @Test
    public void maximize_loot_value_returns_correct_value_when_there_is_a_higher_backpack_capacity_than_available_spices() {
        LootMaximizer.Spice spiceA = new LootMaximizer.Spice(10, 5);
        LootMaximizer.Spice spiceB = new LootMaximizer.Spice(20, 20);
        LootMaximizer.Spice spiceC = new LootMaximizer.Spice(100, 5);
        LootMaximizer.Spice spiceD = new LootMaximizer.Spice(1, 10);

        LootMaximizer.Spice[] spices = {spiceA, spiceB, spiceC, spiceD};

        Assertions.assertEquals(40, lootMaximizerSolver.maximizeLootValue(150, spices));
    }

    @Test
    public void maximize_loot_value_returns_correct_value_for_empty_spices_array() {
        Assertions.assertEquals(0, lootMaximizerSolver.maximizeLootValue(150, new LootMaximizer.Spice[]{}));
    }

    @Test
    public void maximize_loot_Value_returns_null_pointer_exception_for_null_spices_input() {
        try {
            lootMaximizerSolver.maximizeLootValue(150, null);
        } catch (NullPointerException e) {
            Assertions.assertEquals(ValidationMessageType.NULL_VALUE_ERROR.getMessage(), e.getMessage());
        }
    }

    @Test
    public void maximize_loot_Value_returns_illegal_argument_exception_for_negative_backpack_capacity_input() {
        LootMaximizer.Spice spiceA = new LootMaximizer.Spice(5, 5);
        LootMaximizer.Spice spiceB = new LootMaximizer.Spice(22, 20);
        LootMaximizer.Spice spiceC = new LootMaximizer.Spice(123, 5);
        LootMaximizer.Spice spiceD = new LootMaximizer.Spice(51, 10);

        LootMaximizer.Spice[] spices = {spiceA, spiceB, spiceC, spiceD};

        try {
            lootMaximizerSolver.maximizeLootValue(-150, spices);
        } catch (IllegalArgumentException e) {
            Assertions.assertEquals(ValidationMessageType.BELOW_MINIMUM_ERROR.getMessage(0), e.getMessage());
        }
    }
}
