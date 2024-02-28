package modules.algorithmic_toolbox.week_3.maximum_salary;

import org.apache.commons.lang3.Validate;
import utils.ValidationMessageUtility;

import java.util.Arrays;
import java.util.Comparator;

public class LargestNumber {

    public String largestNumber(String[] numbers) {
        Validate.notNull(numbers, ValidationMessageUtility.getMessage("not_null_array_exception"));

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
