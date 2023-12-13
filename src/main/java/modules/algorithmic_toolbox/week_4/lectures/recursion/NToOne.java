package modules.algorithmic_toolbox.week_4.lectures.recursion;

public class NToOne {
    private static void printNToOne(int n) {
        if (n == 0) return;
        System.out.print(n + " ");
        printNToOne(n - 1);
    }

    private static void printOneToN(int n) {
        if (n > 0) {
            printOneToN(n - 1);
            System.out.print(n + " ");
        }
    }


    public static void main(String[] args) {
        printNToOne(10);
        System.out.println("\n");
        printOneToN(10);
    }
}
