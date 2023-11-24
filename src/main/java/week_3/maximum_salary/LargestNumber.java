package week_3.maximum_salary;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class LargestNumber {
    public static String largestNumber(String[] numbers) {
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

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String[] a = new String[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.next();
        }
        System.out.println(largestNumber(a));
    }
}
