package modules.algorithmic_toolbox.week_3.bonus;

import enums.ValidationMessageType;
import org.apache.commons.lang3.Validate;

import java.util.Arrays;

/*
        3.3.8 Friends Seat Together Problem
        Given positions of k friends in the first row of a theater, find the minimal number of moves to sit all friends together.
        In each move, a friend moves to a seat to the left or a seat to the right.
 */
public class FriendsSeat {

    /**
     * Calculates the minimal number of seat moves required for all friends to sit together.
     *
     * @param friendPositions An array of integers representing the initial seat positions of friends in the theater.
     * @return The minimal total number of moves required for all friends to sit consecutively.
     * @throws NullPointerException if friendPositions is null.
     * @implNote Time Complexity: O(n log n)
     */
    public int changeSeats(int[] friendPositions) {
        Validate.notNull(friendPositions, ValidationMessageType.NULL_VALUE_ERROR.getMessage());

        Arrays.sort(friendPositions);

        int centerPosition = friendPositions[friendPositions.length / 2];
        int totalSteps = 0;
        for (int i = 0; i < friendPositions.length; i++) {
            int desiredPosition = centerPosition + i - friendPositions.length / 2;
            totalSteps += Math.abs(friendPositions[i] - desiredPosition);
        }
        return totalSteps;
    }
}
