package week_4.assignment;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MajorityElementTest {
    private MajorityElement majorityElementSolver;

    @BeforeEach
    public void setUp() {
        majorityElementSolver = new MajorityElement();
    }

    @Test
    public void can_locate_majority_element_sequence_bigger_than_half_arr_length() {
        int[] elements = {-1, 1, 1, 1, 2, 1};
        assertEquals(1, majorityElementSolver.getMajorityElement(elements));
    }

    @Test
    public void cant_locate_majority_element_sequence_equal_to_half_of_arr_length() {
        int[] elements = {1, 2, 3, 1};
        assertEquals(0, majorityElementSolver.getMajorityElement(elements));
    }

    @Test
    public void can_locate_majority_element_sequence_for_array_with_three_elements() {
        int[] elements = {3, 2, 5};
        assertEquals(0, majorityElementSolver.getMajorityElement(elements));
    }

    @Test
    public void cant_locate_majority_in_single_element_array() {
        int[] elements = {3};
        assertEquals(0, majorityElementSolver.getMajorityElement(elements));
    }
}