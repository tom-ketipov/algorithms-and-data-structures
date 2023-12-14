package modules.algorithmic_toolbox.week_4.lectures.recursion;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import services.ValidationMessages;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListRemovalTest {
    private LinkedListRemoval linkedListRemovalSolver;

    @BeforeEach
    public void setUp() {
        linkedListRemovalSolver = new LinkedListRemoval();
    }

    @Test
    public void can_remove_all_elements_matching_target_element_from_linked_list_with_iterative_function() {
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(11);
        linkedList.add(5);
        linkedList.add(4);
        linkedList.add(22);
        linkedList.add(5);
        linkedList.add(189);
        linkedList.add(63);
        linkedList.add(5);

        int target = 5;
        linkedList = linkedListRemovalSolver.iterativeLinkedListElementRemoval(linkedList, target);
        assertFalse(linkedList.contains(target));
    }

    @Test
    public void iterative_function_throws_exception_for_null_linked_list_parameter_input() {
        int target = 5;
        try {
            linkedListRemovalSolver.iterativeLinkedListElementRemoval(null, target);
        } catch (IllegalArgumentException e) {
            assertEquals(ValidationMessages.NOT_NULL_LINKED_LIST_EXCEPTION_MESSAGE, e.getMessage());
        }
    }

    @Test
    public void can_remove_all_elements_matching_target_element_from_linked_list_with_recursive_function() {
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(11);
        linkedList.add(5);
        linkedList.add(4);
        linkedList.add(22);
        linkedList.add(5);
        linkedList.add(189);
        linkedList.add(63);
        linkedList.add(5);

        int target = 5;
        linkedList = linkedListRemovalSolver.recursiveLinkedListElementRemoval(linkedList, target);
        assertFalse(linkedList.contains(target));
    }

    @Test
    public void recursive_function_throws_exception_for_null_linked_list_parameter_input() {
        int target = 5;
        try {
            linkedListRemovalSolver.recursiveLinkedListElementRemoval(null, target);
        } catch (IllegalArgumentException e) {
            assertEquals(ValidationMessages.NOT_NULL_LINKED_LIST_EXCEPTION_MESSAGE, e.getMessage());
        }
    }

    @Test
    public void can_remove_all_elements_matching_target_element_from_linked_list_with_improved_recursive_function() {
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(11);
        linkedList.add(5);
        linkedList.add(4);
        linkedList.add(22);
        linkedList.add(5);
        linkedList.add(189);
        linkedList.add(63);
        linkedList.add(5);

        int target = 5;
        linkedList = linkedListRemovalSolver.recursiveLinkedListElementRemovalImproved(linkedList, target);
        assertFalse(linkedList.contains(target));
    }

    @Test
    public void improved_recursive_function_throws_exception_for_null_linked_list_parameter_input() {
        int target = 5;
        try {
            linkedListRemovalSolver.recursiveLinkedListElementRemovalImproved(null, target);
        } catch (IllegalArgumentException e) {
            assertEquals(ValidationMessages.NOT_NULL_LINKED_LIST_EXCEPTION_MESSAGE, e.getMessage());
        }
    }
}