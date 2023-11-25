package week_3.maximum_number_of_prizes;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
    Distinct Summands Problem
    Represent a positive integer as the sum of the maximum number of pairwise distinct positive
    integers.

    Resources: https://discrete-math-puzzles.github.io/puzzles/balls-in-boxes/index.html
    ===========================================================================================>
    Time complexity: O(sqrt(n))
 */

public class DifferentSummands {
    public List<Integer> optimalSummands(int n) {
        // Validate input parameters
        if (n <= 0) {
            throw new InvalidParameterException("'N' cannot be less or equal to 0.");
        }

        List<Integer> summands = new ArrayList<>();
        int index = 1;
        int current = 0;

        while (current < n) {
            if (current + index > n) {
                int lastSummand = summands.size() - 1;
                summands.set(lastSummand, n - (current - summands.get(lastSummand)));
                break;
            }

            summands.add(index++);
            current += summands.get(summands.size() - 1);
        }
        return summands;
    }
}
