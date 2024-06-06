package modules.algorithmic_toolbox.week_5;

import enums.ValidationMessageType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CoinChangeSolverTest {
    private CoinChangeSolver coinChangeSolver;

    @BeforeEach
    public void setUp() {
        coinChangeSolver = new CoinChangeSolver();
    }

    @Test
    public void should_calculate_min_amount_of_coins_needed_to_change_a_value_with_valid_coin_denominations() {
        int[] coinDenominations = {1, 8, 20};
        int totalMoney = 24;
        Assertions.assertEquals(3, coinChangeSolver.calculateMinCoins(totalMoney, coinDenominations));
    }

    @Test
    public void should_return_one_when_given_value_is_present_in_coin_denominations_array() {
        int[] coinDenominations = {8, 7, 1, 20};
        int totalMoney = 8;
        Assertions.assertEquals(1, coinChangeSolver.calculateMinCoins(totalMoney, coinDenominations));
    }

    @Test
    public void should_return_zero_when_value_cannot_be_changed_with_provided_coin_denominations() {
        int[] coinDenominations = {121, 83, 25};
        int totalMoney = 24;
        Assertions.assertEquals(0, coinChangeSolver.calculateMinCoins(totalMoney, coinDenominations));
    }

    @Test
    public void calculateMinCoins_should_throw_null_pointer_exception_for_null_array_input() {
        int totalMoney = 24;

        try {
            coinChangeSolver.calculateMinCoins(totalMoney, null);
        } catch (NullPointerException e) {
            Assertions.assertEquals(ValidationMessageType.NULL_VALUE_ERROR.getMessage(), e.getMessage());
        }
    }

    @Test
    public void calculateMinCoins_should_throw_illegal_argument_exception_for_empty_array_input() {
        int[] coinDenominations = {};
        int totalMoney = 24;

        try {
            coinChangeSolver.calculateMinCoins(totalMoney, coinDenominations);
        } catch (IllegalArgumentException e) {
            Assertions.assertEquals(ValidationMessageType.BELOW_MINIMUM_ERROR.getMessage(1), e.getMessage());
        }
    }

    @Test
    public void calculateMinCoins_should_throw_illegal_argument_exception_for_non_positive_money() {
        int[] coinDenominations = {2, 4, 5, 6};
        int totalMoney = 0;

        try {
            coinChangeSolver.calculateMinCoins(totalMoney, coinDenominations);
        } catch (IllegalArgumentException e) {
            Assertions.assertEquals(ValidationMessageType.BELOW_MINIMUM_ERROR.getMessage(1), e.getMessage());
        }
    }
}
