package modules.week_3.bonus;

import enums.ValidationMessageType;
import modules.algorithmic_toolbox.week_3.bonus.FriendsSeat;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FriendsSeatTest {

    private FriendsSeat friendsSeatSolver;

    @BeforeEach
    void setUp() {
        friendsSeatSolver = new FriendsSeat();
    }

    @Test
    public void should_calculate_total_number_of_seats_correctly_for_input_array_with_even_length() {
        int[] friendPositions = {3, 6, 9, 12, 15, 18};

        Assertions.assertEquals(18, friendsSeatSolver.changeSeats(friendPositions));
    }

    @Test
    public void should_calculate_total_number_of_seats_correctly_for_input_array_with_odd_length() {
        int[] friendPositions = {1, 3, 7};

        Assertions.assertEquals(4, friendsSeatSolver.changeSeats(friendPositions));
    }

    @Test
    public void should_calculate_total_number_of_seats_correctly_when_friends_are_already_next_to_each_other() {
        int[] friendPositions = {5, 6, 7};

        Assertions.assertEquals(0, friendsSeatSolver.changeSeats(friendPositions));
    }

    @Test
    public void should_throw_null_pointer_exception_for_null_input() {
        try {
            friendsSeatSolver.changeSeats(null);
        } catch (NullPointerException e) {
            Assertions.assertEquals(ValidationMessageType.NULL_VALUE_ERROR.getMessage(), e.getMessage());
        }
    }
}