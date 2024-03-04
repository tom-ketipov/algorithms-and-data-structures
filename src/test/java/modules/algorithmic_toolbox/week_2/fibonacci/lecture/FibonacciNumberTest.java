package modules.algorithmic_toolbox.week_2.fibonacci.lecture;

import modules.algorithmic_toolbox.week_2.fibonacci.lecture.NaiveFibonacciNumber;
import modules.algorithmic_toolbox.week_2.fibonacci.lecture.RecursiveFibonacciNumber;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;

class FibonacciNumberTest {
    private NaiveFibonacciNumber naiveFibonacciNumberSolver;
    private RecursiveFibonacciNumber recursiveFibonacciNumberSolver;

    @BeforeEach
    void setUp() {
        naiveFibonacciNumberSolver = new NaiveFibonacciNumber();
        recursiveFibonacciNumberSolver = new RecursiveFibonacciNumber();
    }

    @Test
    public void can_find_first_fibonacci_number_with_naive_function() {
        Assertions.assertEquals(BigInteger.valueOf(1), naiveFibonacciNumberSolver.naiveFibonacciFinder(1));
    }

    @Test
    public void can_find_zero_fibonacci_number_with_naive_function() {
        Assertions.assertEquals(BigInteger.valueOf(0), naiveFibonacciNumberSolver.naiveFibonacciFinder(0));
    }

    @Test
    public void can_find_tenth_fibonacci_number_with_naive_function() {
        Assertions.assertEquals(BigInteger.valueOf(55), naiveFibonacciNumberSolver.naiveFibonacciFinder(10));
    }

    @Test
    public void can_find_hundred_fibonacci_number_with_naive_function() {
        BigInteger fibonacciExpected = new BigInteger("354224848179261915075");
        Assertions.assertEquals(fibonacciExpected, naiveFibonacciNumberSolver.naiveFibonacciFinder(100));
    }

    @Test
    public void can_find_five_hundred_fibonacci_number_with_naive_function() {
        BigInteger fibonacciExpected = new BigInteger("139423224561697880139724382870407283950070256587697307264108962948325571622863290691557658876222521294125");
        Assertions.assertEquals(fibonacciExpected, naiveFibonacciNumberSolver.naiveFibonacciFinder(500));
    }

    @Test
    public void can_find_thousand_fibonacci_number_with_naive_function() {
        BigInteger fibonacciExpected = new BigInteger("43466557686937456435688527675040625802564660517371780402481729089536555417949051890403879840079255169295922593080322634775209689623239873322471161642996440906533187938298969649928516003704476137795166849228875");
        Assertions.assertEquals(fibonacciExpected, naiveFibonacciNumberSolver.naiveFibonacciFinder(1000));
    }

    @Test
    public void can_handle_negative_input_with_naive_function() {
        try {
            naiveFibonacciNumberSolver.naiveFibonacciFinder(-1);
        } catch (IllegalArgumentException e) {
            Assertions.assertEquals("The validated expression is false", e.getMessage());
        }
    }

    @Test
    public void can_find_first_fibonacci_number_with_recursive_function() {
        Assertions.assertEquals(BigInteger.valueOf(1), recursiveFibonacciNumberSolver.recursiveFibonacciFinder(1));
    }

    @Test
    public void can_find_zero_fibonacci_number_with_recursive_function() {
        Assertions.assertEquals(BigInteger.valueOf(0), recursiveFibonacciNumberSolver.recursiveFibonacciFinder(0));
    }

    @Test
    public void can_find_tenth_fibonacci_number_with_recursive_function() {
        Assertions.assertEquals(BigInteger.valueOf(55), recursiveFibonacciNumberSolver.recursiveFibonacciFinder(10));
    }

    @Test
    public void can_handle_negative_input_with_recursive_function() {
        try {
            recursiveFibonacciNumberSolver.recursiveFibonacciFinder(-1);
        } catch (IllegalArgumentException e) {
            Assertions.assertEquals("The validated expression is false", e.getMessage());
        }
    }
}