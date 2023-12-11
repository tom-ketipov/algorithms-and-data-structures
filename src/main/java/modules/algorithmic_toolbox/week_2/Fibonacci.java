package modules.algorithmic_toolbox.week_2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Fibonacci {
    private static long getFibonacciIndex(int indexes) {
        if (indexes <= 1) return indexes;

        List<Long> sequence = new ArrayList<>();

        for (long i = 1; i <= indexes; i++) {
            if (sequence.size() >= 2) {
                sequence.add(sequence.get(sequence.size() - 2) + sequence.get(sequence.size() - 1));
            } else {
                sequence.add(1L);
            }
        }
        return sequence.get(sequence.size() - 1);
    }

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        System.out.println(getFibonacciIndex(n));
    }
}
