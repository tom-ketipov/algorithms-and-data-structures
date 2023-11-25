package week_3.maximum_salary;

import java.security.InvalidParameterException;
import java.util.Arrays;
import java.util.Comparator;

public class LargestNumber {
    public String largestNumber(String[] numbers) {
        // Validate input parameters
        if (numbers == null) {
            throw new InvalidParameterException("Numbers array cannot be null.");
        }

        Arrays.sort(numbers, new LargerNumberComparator());
        return String.join("", numbers);
    }

    private static class LargerNumberComparator implements Comparator<String> {
        @Override
        public int compare(String a, String b) {
            String order1 = a + b;
            String order2 = b + a;
            return order2.compareTo(order1);
        }
    }
}
