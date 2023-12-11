package modules.algorithmic_toolbox.week_4.lectures;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTest {
    private BinarySearch binarySearchSolver;
    private RecursiveBinarySearch recursiveBinarySearchSolver;

    @Test
    public void can_find_element_located_in_exact_mid_position_with_linear_binary_search() {
        binarySearchSolver = new BinarySearch();

        int[] numbers = {1, 5, 8, 12, 15, 21, 22, 25, 29};
        int target = 15;
        assertEquals(4, binarySearchSolver.binarySearch(numbers, target));
    }

    @Test
    public void can_find_element_located_in_the_first_position_with_linear_binary_search() {
        binarySearchSolver = new BinarySearch();

        int[] numbers = {1, 5, 8, 12, 15, 21, 22, 25, 29};
        int target = 1;
        assertEquals(0, binarySearchSolver.binarySearch(numbers, target));
    }

    @Test
    public void can_find_element_located_in_the_last_position_with_linear_binary_search() {
        binarySearchSolver = new BinarySearch();

        int[] numbers = {1, 5, 8, 12, 15, 21, 22, 25, 29};
        int target = 29;
        assertEquals(numbers.length - 1, binarySearchSolver.binarySearch(numbers, target));
    }

    @Test
    public void can_handle_non_existing_elements_with_linear_binary_search() {
        binarySearchSolver = new BinarySearch();

        int[] numbers = {1, 5, 8, 12, 15, 21, 22, 25, 29};
        int target = 44;
        assertEquals(-1, binarySearchSolver.binarySearch(numbers, target));
    }

    @Test
    public void can_find_element_located_in_exact_mid_position_with_recursive_binary_search() {
        recursiveBinarySearchSolver = new RecursiveBinarySearch();

        int[] numbers = {1, 5, 8, 12, 15, 21, 22, 25, 29};
        int target = 15;
        int low = 0;
        int high = numbers.length;
        assertEquals(4, recursiveBinarySearchSolver.recursiveBinarySearch(numbers, target, low, high));
    }

    @Test
    public void can_find_element_located_in_the_first_position_with_recursive_binary_search() {
        recursiveBinarySearchSolver = new RecursiveBinarySearch();

        int[] numbers = {1, 5, 8, 12, 15, 21, 22, 25, 29};
        int target = 1;
        int low = 0;
        int high = numbers.length;
        assertEquals(0, recursiveBinarySearchSolver.recursiveBinarySearch(numbers, target, low, high));
    }

    @Test
    public void can_find_element_located_in_the_last_position_with_recursive_binary_search() {
        recursiveBinarySearchSolver = new RecursiveBinarySearch();

        int[] numbers = {1, 5, 8, 12, 15, 21, 22, 25, 29};
        int target = 29;
        int low = 0;
        int high = numbers.length;
        assertEquals(numbers.length - 1, recursiveBinarySearchSolver.recursiveBinarySearch(numbers, target, low, high));
    }

    @Test
    public void can_handle_non_existing_elements_with_recursive_binary_search() {
        recursiveBinarySearchSolver = new RecursiveBinarySearch();

        int[] numbers = {1, 5, 8, 12, 15, 21, 22, 25, 29};
        int target = 44;
        int low = 0;
        int high = numbers.length;
        assertEquals(-1, recursiveBinarySearchSolver.recursiveBinarySearch(numbers, target, low, high));
    }
}