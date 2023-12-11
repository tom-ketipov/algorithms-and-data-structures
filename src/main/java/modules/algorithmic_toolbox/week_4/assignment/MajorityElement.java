package modules.algorithmic_toolbox.week_4.assignment;

import java.util.Arrays;

public class MajorityElement {

    public int getMajorityElement(int[] elements) {
        Arrays.sort(elements);

        int maxOccurances = 1;
        for (int i = 0; i < elements.length - 1; i++) {
            if (elements[i] == elements[i + 1]) {
                maxOccurances++;
            } else {
                maxOccurances = 1;
            }

            if (maxOccurances == (elements.length / 2) + 1) return 1;
        }
        return 0;
    }
}
