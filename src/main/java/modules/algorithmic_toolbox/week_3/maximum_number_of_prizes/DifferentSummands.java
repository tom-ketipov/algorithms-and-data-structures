package modules.algorithmic_toolbox.week_3.maximum_number_of_prizes;

import org.apache.commons.lang3.Validate;
import utils.ValidationMessageUtility;

import java.util.ArrayList;
import java.util.List;

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
        int minValue = 1;
        int maxValue = Integer.MAX_VALUE;
        Validate.inclusiveBetween(minValue, maxValue, n, ValidationMessageUtility.getMessage("value_range_exception", minValue, maxValue));

        List<Integer> summands = new ArrayList<>();

        int index = 1, current = 0;
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
