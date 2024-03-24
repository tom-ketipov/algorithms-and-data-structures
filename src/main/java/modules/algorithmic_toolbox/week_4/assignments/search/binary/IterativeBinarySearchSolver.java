package modules.algorithmic_toolbox.week_4.assignments.search.binary;

import enums.ValidationMessageType;
import org.apache.commons.lang3.Validate;

public class IterativeBinarySearchSolver {

    public int search(int target, int[] array) {
        Validate.notNull(array, ValidationMessageType.NULL_VALUE_ERROR.getMessage());

        int lowIndex = 0;
        int highIndex = array.length - 1;
        while (lowIndex <= highIndex) {
            int midIndex = lowIndex + (highIndex - lowIndex) / 2;

            if (array[midIndex] == target) {
                return midIndex;
            } else if (array[midIndex] > target) {
                highIndex = midIndex - 1;
            } else {
                lowIndex = midIndex + 1;
            }
        }
        return -1;
    }
}
