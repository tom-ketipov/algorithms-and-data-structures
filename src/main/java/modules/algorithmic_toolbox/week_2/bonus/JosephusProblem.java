package modules.algorithmic_toolbox.week_2.bonus;

/*
    2.3.1 Josephus Problem
    Find the position of the survivor in the vicious series of killings described by Flavius Josephus, the first-century historian and head of Jewish forces in Galilee.

    Input: Natural numbers n and k. They represent n rebels standing in a circle. Rebels are being eliminated in such a way that every k-th still alive rebel around the circle
    is killed until only one rebel left. Rebels are killed clockwise starting from rebel 0, i.e., rebel k − 1 is killed first.

    Output: The position of the survivor, denoted Josephus(n, k).
 */

import enums.ValidationMessageType;
import org.apache.commons.lang3.Validate;

public class JosephusProblem {

    /**
     * Calculates the safe position in the Josephus problem given the total number of rebels and the elimination step.
     *
     * @param totalRebels     the total number of rebels in the circle. Must be at least 1.
     * @param eliminationStep the step rate at which rebels are eliminated. Must be at least 1.
     * @return the position of the last remaining rebel, starting from 1.
     * @throws IllegalArgumentException if totalRebels < 1 or eliminationStep < 1.
     */
    public int josephus(int totalRebels, int eliminationStep) {
        Validate.isTrue(totalRebels >= 1, ValidationMessageType.BELOW_MINIMUM_ERROR.getMessage(1));
        Validate.isTrue(eliminationStep >= 1, ValidationMessageType.BELOW_MINIMUM_ERROR.getMessage(1));

        int result = 0;
        for (int i = 2; i <= totalRebels; i++) {
            result = (result + eliminationStep) % i;
        }
        return result + 1;
    }
}
