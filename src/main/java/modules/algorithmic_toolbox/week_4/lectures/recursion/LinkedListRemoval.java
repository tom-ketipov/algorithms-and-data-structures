package modules.algorithmic_toolbox.week_4.lectures.recursion;

import services.ValidationMessages;

import java.util.LinkedList;

import static services.ValidationService.validateNotNull;

public class LinkedListRemoval {
    public LinkedList<Integer> recursiveLinkedListElementRemovalImproved(LinkedList<Integer> linkedList, int targetElement) {
        return recursiveLinkedListElementRemovalImproved(linkedList, new LinkedList<>(), targetElement, 0);
    }

    /**
     * Recursively removes occurrences of the specified target element from the original LinkedList
     * and creates a new LinkedList without the specified elements.
     *
     * @param originalList  The original LinkedList of integers.
     * @param resultList    The resulting LinkedList without occurrences of the target element.
     * @param targetElement The element to be removed from the LinkedList.
     * @param index         The current index in the original LinkedList.
     * @return The new LinkedList without occurrences of the target element.
     * @implNote Time Complexity: O(n)
     */
    private LinkedList<Integer> recursiveLinkedListElementRemovalImproved(LinkedList<Integer> originalList, LinkedList<Integer> resultList, int targetElement, int index) {
        validateNotNull(originalList, ValidationMessages.NOT_NULL_LINKED_LIST_EXCEPTION_MESSAGE);

        if (index >= originalList.size()) return resultList;

        int currentElement = originalList.get(index);
        if (currentElement != targetElement) {
            resultList.add(currentElement);
        }
        return recursiveLinkedListElementRemovalImproved(originalList, resultList, targetElement, index + 1);
    }

    public LinkedList<Integer> recursiveLinkedListElementRemoval(LinkedList<Integer> linkedList, int targetElement) {
        return recursiveLinkedListElementRemoval(linkedList, targetElement, 0);
    }

    /**
     * Recursively removes occurrences of the specified target element from the LinkedList.
     *
     * @param linkedList    The input LinkedList of integers.
     * @param targetElement The element to be removed from the LinkedList.
     * @param index         The current index in the LinkedList.
     * @return The modified LinkedList after recursive removal.
     * @implNote Time Complexity: O(n^2)
     */
    private LinkedList<Integer> recursiveLinkedListElementRemoval(LinkedList<Integer> linkedList, int targetElement, int index) {
        validateNotNull(linkedList, ValidationMessages.NOT_NULL_LINKED_LIST_EXCEPTION_MESSAGE);

        if (index >= linkedList.size()) return linkedList;

        if (linkedList.get(index) == targetElement) linkedList.remove(index);
        return recursiveLinkedListElementRemoval(linkedList, targetElement, index + 1);
    }

    /**
     * Iteratively removes all occurrences of the specified target element from the LinkedList.
     *
     * @param linkedList    The input LinkedList of integers.
     * @param targetElement The element to be removed from the LinkedList.
     * @return The modified LinkedList after iterative removal.
     * @implNote Time Complexity: O(n)
     */
    public LinkedList<Integer> iterativeLinkedListElementRemoval(LinkedList<Integer> linkedList, int targetElement) {
        validateNotNull(linkedList, ValidationMessages.NOT_NULL_LINKED_LIST_EXCEPTION_MESSAGE);

        linkedList.removeIf(integer -> integer == targetElement);
        return linkedList;
    }
}
