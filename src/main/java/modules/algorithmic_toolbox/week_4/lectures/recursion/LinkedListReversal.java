package modules.algorithmic_toolbox.week_4.lectures.recursion;

import org.apache.commons.lang3.Validate;
import utils.ValidationMessageUtility;

import java.util.Iterator;
import java.util.LinkedList;

public class LinkedListReversal {
    public LinkedList<Integer> recursiveReversal(LinkedList<Integer> linkedList) {
        return recursiveReversal(linkedList, new LinkedList<>(), linkedList.size() - 1);
    }

    /**
     * Recursively reverses the elements of the input LinkedList and returns a new reversed LinkedList.
     *
     * @param linkedList The original LinkedList of integers.
     * @return A new LinkedList with elements in reverse order.
     * @throws NullPointerException if input linkedList is null
     * @implNote Time Complexity: O(n)
     */
    private LinkedList<Integer> recursiveReversal(LinkedList<Integer> linkedList, LinkedList<Integer> resultLinkedList, int index) {
        Validate.notNull(linkedList, ValidationMessageUtility.getMessage("not_null_array_exception"));

        if (index < 0) return resultLinkedList;

        resultLinkedList.add(linkedList.get(index));
        return recursiveReversal(linkedList, resultLinkedList, index - 1);
    }

    /**
     * Iteratively reverses the elements of the input LinkedList and returns a new reversed LinkedList.
     *
     * @param linkedList The input LinkedList of integers.
     * @return A new LinkedList with elements in reverse order.
     * @throws NullPointerException if input linkedList is null
     * @implNote Time Complexity: O(n)
     */
    public LinkedList<Integer> iterativeReversal(LinkedList<Integer> linkedList) {
        Validate.notNull(linkedList, ValidationMessageUtility.getMessage("not_null_array_exception"));

        LinkedList<Integer> reversedList = new LinkedList<>();
        Iterator<Integer> iterator = linkedList.descendingIterator();
        while (iterator.hasNext()) {
            reversedList.add(iterator.next());
        }
        return reversedList;
    }
}
