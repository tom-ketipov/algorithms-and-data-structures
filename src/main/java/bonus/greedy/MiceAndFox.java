package bonus.greedy;

import java.util.Arrays;

/*
        Mice and a Fox Problem
        Given positions of n mice and n holes on a line, find an optimal hiding strategy for mice.
        ===========================================================================================>
        Time Complexity: O(n log n)
 */
public class MiceAndFox {

    public int hide(int[] micePositions, int[] holesPositons) {
        Arrays.sort(micePositions);
        Arrays.sort(holesPositons);

        int maxHidingTime = 0;
        for (int i = 0; i < micePositions.length; i++) {
            int timeToHide = Math.abs(micePositions[i] - holesPositons[i]);
            maxHidingTime = Math.max(maxHidingTime, timeToHide);
        }
        return maxHidingTime;
    }
}
