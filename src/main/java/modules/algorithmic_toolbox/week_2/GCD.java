package modules.algorithmic_toolbox.week_2;

import java.util.Scanner;

public class GCD {
    public static int euclideanGCD(int a, int b) {
        while (true) {
            int max = Math.max(a, b);
            int min = Math.min(a, b);
            int remainder = max % min;

            if (remainder == 0){
                return min;
            }

            a = min;
            b = remainder;
        }
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();

        System.out.println(euclideanGCD(a, b));
    }
}
