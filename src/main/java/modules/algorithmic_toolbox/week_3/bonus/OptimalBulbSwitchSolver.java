package modules.algorithmic_toolbox.week_3.bonus;

import enums.ValidationMessageType;
import org.apache.commons.lang3.Validate;

/*
        3.3.7 Bulb Switching Problem
        Given a binary vector representing an initial state of n bulbs connected by wires into a linear sequence, find the minimum number of switches
        to press for turning on all bulbs. Each bulb has a switch that changes the state of this bulb and all bulbs to the right of it.
*/
public class OptimalBulbSwitchSolver {

    /**
     * Calculates the minimum number of switch presses needed to turn all bulbs on.
     *
     * @param initialBulbStates An array of integers representing the initial states of the bulbs,
     *                          where 0 indicates a bulb is off and 1 indicates a bulb is on.
     * @return The minimum number of switch presses required to turn all bulbs on.
     * @throws NullPointerException if the initialBulbStates array is null.
     * @implNote Time Complexity: O(n)
     */
    public int calculateMinimumSwitchPresses(int[] initialBulbStates) {
        Validate.notNull(initialBulbStates, ValidationMessageType.NULL_VALUE_ERROR.getMessage());

        int switchPressesNeeded = 0;
        for (int bulbState : initialBulbStates) {
            bulbState = switchPressesNeeded % 2 == 1 ?
                    Math.abs(bulbState - 1) :
                    bulbState;

            if (bulbState == 0) switchPressesNeeded++;
        }
        return switchPressesNeeded;
    }
}
