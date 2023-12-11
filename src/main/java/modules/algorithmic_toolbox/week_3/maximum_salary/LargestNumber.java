package modules.algorithmic_toolbox.week_3.maximum_salary;

import services.ValidationMessages;

import java.util.Arrays;
import java.util.Comparator;

import static services.ValidationService.validateNotNull;

public class LargestNumber {

    public String largestNumber(String[] numbers) {
        validateNotNull(numbers, ValidationMessages.NON_NULL_ARRAY_EXCEPTION_MESSAGE);

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
