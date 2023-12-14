package modules.algorithmic_toolbox.week_4.lectures.recursion;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListReversalTest {
    private LinkedListReversal linkedListReversal;

    @BeforeEach
    public void setUp() {
        linkedListReversal = new LinkedListReversal();
    }

    @Test
    public void can_reverse_linked_list_with_iterative_function() {
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(11);
        linkedList.add(5);
        linkedList.add(4);
        linkedList.add(22);

        linkedList = linkedListReversal.iterativeReversal(linkedList);
        assertEquals(22, linkedList.get(0));
        assertEquals(4, linkedList.get(1));
        assertEquals(5, linkedList.get(2));
        assertEquals(11, linkedList.get(3));
    }

    @Test
    public void can_reverse_linked_list_with_recursive_function() {
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(11);
        linkedList.add(5);
        linkedList.add(4);
        linkedList.add(22);

        linkedList = linkedListReversal.recursiveReversal(linkedList);
        assertEquals(22, linkedList.get(0));
        assertEquals(4, linkedList.get(1));
        assertEquals(5, linkedList.get(2));
        assertEquals(11, linkedList.get(3));
    }
}