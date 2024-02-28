package modules.algorithmic_toolbox.week_4.lectures.recursion;

import org.apache.commons.lang3.Validate;
import utils.ValidationMessageUtility;

import java.util.LinkedList;

public class LinkedListMerger {

    /**
     * Merges two sorted linked lists into a single sorted linked list recursively.
     *
     * @param linkedListA The first sorted linked list to merge. Must not be null.
     * @param linkedListB The second sorted linked list to merge. Must not be null.
     * @return A new linked list containing all elements from both input lists, merged into
     * ascending order.
     * @throws NullPointerException If either of the input linked lists is null.
     * @implNote Time Complexity: O(n) -> n = linkedListA.size() + linkedListB.size()
     */
    public LinkedList<Integer> recursiveMerge(LinkedList<Integer> linkedListA, LinkedList<Integer> linkedListB) {
        Validate.notNull(linkedListA, ValidationMessageUtility.getMessage("not_null_array_exception"));
        Validate.notNull(linkedListB, ValidationMessageUtility.getMessage("not_null_array_exception"));

        if (linkedListA.isEmpty()) {
            return linkedListB;
        } else if (linkedListB.isEmpty()) {
            return linkedListA;
        }

        LinkedList<Integer> mergedLinkedList = new LinkedList<>();
        int a = linkedListA.getFirst(), b = linkedListB.getFirst();
        if (a < b) {
            mergedLinkedList.add(linkedListA.pollFirst());
            mergedLinkedList.addAll(recursiveMerge(linkedListA, linkedListB));
        } else {
            mergedLinkedList.add(linkedListB.pollFirst());
            mergedLinkedList.addAll(recursiveMerge(linkedListA, linkedListB));
        }

        return mergedLinkedList;
    }

    /**
     * Merges two sorted linked lists into a single sorted linked list.
     *
     * @param linkedListA The first sorted linked list to merge. Must not be null.
     * @param linkedListB The second sorted linked list to merge. Must not be null.
     * @return A new linked list containing all elements from both input lists, merged into
     * ascending order.
     * @throws NullPointerException If either of the input linked lists is null.
     * @implNote Time Complexity: O(n) -> n = linkedListA.size() + linkedListB.size()
     */
    public LinkedList<Integer> iterativeMerge(LinkedList<Integer> linkedListA, LinkedList<Integer> linkedListB) {
        Validate.notNull(linkedListA, ValidationMessageUtility.getMessage("not_null_array_exception"));
        Validate.notNull(linkedListB, ValidationMessageUtility.getMessage("not_null_array_exception"));

        LinkedList<Integer> mergedLinkedList = new LinkedList<>();
        while (!linkedListA.isEmpty() && !linkedListB.isEmpty()) {
            int a = linkedListA.getFirst(), b = linkedListB.getFirst();
            mergedLinkedList.add(a < b ? linkedListA.pollFirst() : linkedListB.pollFirst());
        }
        mergedLinkedList.addAll(linkedListA);
        mergedLinkedList.addAll(linkedListB);

        return mergedLinkedList;
    }
}
