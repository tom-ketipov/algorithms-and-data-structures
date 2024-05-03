package modules.algorithmic_toolbox.week_4.bonus.recursion.w3resources;

import enums.ValidationMessageType;
import org.apache.commons.lang3.Validate;

public class FibonacciSolver {

    public int getLowerBoundary() {
        return 0;
    }

    public int getUpperBoundary() {
        return 20;
    }

    /**
     * Calculates the value of the nth term in the Fibonacci sequence.
     *
     * @param termIndex the index of the term to be calculated
     * @return the value of the nth term in the Fibonacci sequence
     * @throws IllegalArgumentException if the term index is not within the range of 0 to 20 (inclusive)
     */
    public int findNthTerm(int termIndex) {
        Validate.inclusiveBetween(getLowerBoundary(), getUpperBoundary(), termIndex, ValidationMessageType.OUT_OF_RANGE_ERROR.getMessage(getLowerBoundary(), getUpperBoundary()));

        if (termIndex == 0) return 0;
        if (termIndex <= 2) return 1;

        return findNthTerm(termIndex - 1) + findNthTerm(termIndex - 2);
    }
}
