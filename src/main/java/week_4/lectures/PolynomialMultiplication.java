package week_4.lectures;

public class PolynomialMultiplication {

    // Time complexity: O(n^2)
    public int[] multiplyPolynomialsNaive(int[] coefficientsA, int[] coefficientsB) {
        int[] multipliedCoefficients = new int[coefficientsA.length + coefficientsB.length - 1];

        for (int i = 0; i < coefficientsA.length; i++) {
            for (int j = 0; j < coefficientsB.length; j++) {
                multipliedCoefficients[i + j] += coefficientsA[i] * coefficientsB[j];
            }
        }
        return multipliedCoefficients;
    }
}

