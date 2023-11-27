package bonus.greedy;

import core.BaseSolver;

import java.util.Arrays;

public class ConnectTwoRopes extends BaseSolver {

    public int connectRopes(int[] ropes) {
        validateNonNegative(ropes);

        Arrays.sort(ropes);

        int end = ropes.length - 1;
        int start = 0;
        int price = 0;

        while (end >= start) {
            if (end == start) {
                price += ropes[end];
                break;
            }
            price += ropes[start++] + ropes[end--];
        }

        return price;
    }
}
