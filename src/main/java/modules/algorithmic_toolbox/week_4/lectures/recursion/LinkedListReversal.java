package modules.algorithmic_toolbox.week_4.lectures.recursion;

import services.ValidationMessages;
import services.ValidationService;

import java.util.Iterator;
import java.util.LinkedList;

import static services.ValidationService.validateNotNull;

public class LinkedListReversal {
    public LinkedList<Integer> recursiveReversal(LinkedList<Integer> linkedList) {
        return recursiveReversal(linkedList, new LinkedList<>(), linkedList.size() - 1);
    }

    /**
     * Recursively reverses the elements of the input LinkedList and returns a new reversed LinkedList.
     *
     * @param linkedList The original LinkedList of integers.
     * @return A new LinkedList with elements in reverse order.
     * @throws IllegalArgumentException if input linkedList is null
     * @implNote Time Complexity: O(n)
     */
    private LinkedList<Integer> recursiveReversal(LinkedList<Integer> linkedList, LinkedList<Integer> resultLinkedList, int index) {
        validateNotNull(linkedList, ValidationMessages.NOT_NULL_LINKED_LIST_EXCEPTION_MESSAGE);

        if (index < 0) return resultLinkedList;

        resultLinkedList.add(linkedList.get(index));
        return recursiveReversal(linkedList, resultLinkedList, index - 1);
    }

    /**
     * Iteratively reverses the elements of the input LinkedList and returns a new reversed LinkedList.
     *
     * @param linkedList The input LinkedList of integers.
     * @return A new LinkedList with elements in reverse order.
     * @throws IllegalArgumentException if input linkedList is null
     * @implNote Time Complexity: O(n)
     */
    public LinkedList<Integer> iterativeReversal(LinkedList<Integer> linkedList) {
        validateNotNull(linkedList, ValidationMessages.NOT_NULL_LINKED_LIST_EXCEPTION_MESSAGE);

        LinkedList<Integer> reversedList = new LinkedList<>();
        Iterator<Integer> iterator = linkedList.descendingIterator();
        while (iterator.hasNext()) {
            reversedList.add(iterator.next());
        }
        return reversedList;
    }
}
