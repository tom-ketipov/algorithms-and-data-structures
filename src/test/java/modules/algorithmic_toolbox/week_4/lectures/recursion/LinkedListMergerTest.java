package modules.algorithmic_toolbox.week_4.lectures.recursion;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListMergerTest {
    private LinkedListMerger linkedListMergerSolver;

    @BeforeEach
    public void setUp() {
        linkedListMergerSolver = new LinkedListMerger();
    }

    @Test
    public void can_merge_two_sorted_linked_lists_with_iterative_function() {
        LinkedList<Integer> linkedListA = new LinkedList<>();
        linkedListA.add(1);
        linkedListA.add(5);
        linkedListA.add(42);

        LinkedList<Integer> linkedListB = new LinkedList<>();
        linkedListB.add(2);
        linkedListB.add(3);
        linkedListB.add(4);

        LinkedList<Integer> mergedLinkedList = linkedListMergerSolver.iterativeMerge(linkedListA, linkedListB);
        assertEquals(1, mergedLinkedList.get(0));
        assertEquals(2, mergedLinkedList.get(1));
        assertEquals(3, mergedLinkedList.get(2));
        assertEquals(4, mergedLinkedList.get(3));
        assertEquals(5, mergedLinkedList.get(4));
        assertEquals(42, mergedLinkedList.get(5));
    }

    @Test
    public void can_merge_two_sorted_linked_lists_with_recursive_function() {
        LinkedList<Integer> linkedListA = new LinkedList<>();
        linkedListA.add(1);
        linkedListA.add(5);
        linkedListA.add(42);

        LinkedList<Integer> linkedListB = new LinkedList<>();
        linkedListB.add(2);
        linkedListB.add(3);
        linkedListB.add(4);

        LinkedList<Integer> mergedLinkedList = linkedListMergerSolver.recursiveMerge(linkedListA, linkedListB);
        System.out.println(mergedLinkedList);
        assertEquals(1, mergedLinkedList.get(0));
        assertEquals(2, mergedLinkedList.get(1));
        assertEquals(3, mergedLinkedList.get(2));
        assertEquals(4, mergedLinkedList.get(3));
        assertEquals(5, mergedLinkedList.get(4));
        assertEquals(42, mergedLinkedList.get(5));
    }
}