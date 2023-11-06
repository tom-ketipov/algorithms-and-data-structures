package week_2;

import java.util.ArrayList;
import java.util.List;

public class Fibonacci {
    public static List<Long> generateFibonacciSequence(int indexes) {
        List<Long> sequence = new ArrayList<>();

        while (sequence.size() < indexes) {
            if (sequence.size() >= 2) {
                sequence.add(sequence.get(sequence.size() - 2) + sequence.get(sequence.size() - 1));
            } else {
                sequence.add(1L);
            }
        }

        return sequence;
    }

    public static void main(String[] args) {
        long timePriorExecution = System.currentTimeMillis();

        System.out.println(generateFibonacciSequence(100));

        long timeAfterExecution = System.currentTimeMillis();
        System.out.println("The sequence was generated in: " + Math.subtractExact(timeAfterExecution, timePriorExecution) / (double) 1000 + " sec.");
    }
}