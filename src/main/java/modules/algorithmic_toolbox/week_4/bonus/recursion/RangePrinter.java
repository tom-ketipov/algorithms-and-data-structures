package modules.algorithmic_toolbox.week_4.bonus.recursion;

/*
        Print 1 to n without using loops
        You are given an integer N. Print numbers from 1 to N without the help of loops.
 */
public class RangePrinter {

    /**
     * Prints integers within a specified range.
     *
     * @param from the starting integer of the range
     * @param to   the ending integer of the range
     */
    public static void printNumbersInRange(int from, int to) {
        if (from > to) {
            return;
        }

        System.out.println(from);
        printNumbersInRange(from + 1, to);
    }

    public static void main(String[] args) {
        printNumbersInRange(1, 5);
    }
}
