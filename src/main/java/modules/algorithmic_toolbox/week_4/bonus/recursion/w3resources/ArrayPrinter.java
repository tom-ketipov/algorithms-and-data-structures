package modules.algorithmic_toolbox.week_4.bonus.recursion.w3resources;

public class ArrayPrinter {

    public static void printArray(int[] array) {
        printArray(array, 0);
    }

    private static void printArray(int[] array, int currentIndex) {
        if (currentIndex < array.length) {
            System.out.println(array[currentIndex]);
            printArray(array, currentIndex + 1);
        }
    }

    public static void main(String[] args) {
        int[] array = {1, 5, 8, 19};
        printArray(array);
    }
}