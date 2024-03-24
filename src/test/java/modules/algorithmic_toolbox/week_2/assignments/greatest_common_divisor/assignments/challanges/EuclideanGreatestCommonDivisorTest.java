package modules.algorithmic_toolbox.week_2.assignments.greatest_common_divisor.assignments.challanges;

import enums.ValidationMessageType;
import modules.algorithmic_toolbox.week_2.assignments.greatest_common_divisor.EuclideanGreatestCommonDivisor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;

class EuclideanGreatestCommonDivisorTest {
    private EuclideanGreatestCommonDivisor euclideanGreatestCommonDivisorSolver;

    @BeforeEach
    void setUp() {
        euclideanGreatestCommonDivisorSolver = new EuclideanGreatestCommonDivisor();
    }

    @Test
    public void can_find_gcd_with_euclidean_method_when_one_parameter_is_zero() {
        BigInteger a = new BigInteger("8151730571982730");
        BigInteger b = BigInteger.ZERO;
        Assertions.assertEquals(a, euclideanGreatestCommonDivisorSolver.findEuclideanGCD(a, b));
    }

    @Test
    public void can_find_gcd_with_euclidean_method_when_both_parameters_are_zero() {
        BigInteger a = BigInteger.ZERO;
        BigInteger b = BigInteger.ZERO;
        Assertions.assertEquals(a, euclideanGreatestCommonDivisorSolver.findEuclideanGCD(a, b));
    }

    @Test
    public void can_find_gcd_with_euclidean_method_when_one_parameter_is_one() {
        BigInteger a = BigInteger.ONE;
        BigInteger b = new BigInteger("774");
        Assertions.assertEquals(a, euclideanGreatestCommonDivisorSolver.findEuclideanGCD(a, b));
    }

    @Test
    public void can_find_gcd_with_euclidean_method_when_the_first_parameter_is_the_exact_half_of_the_second() {
        BigInteger a = new BigInteger("422");
        BigInteger b = new BigInteger("844");
        Assertions.assertEquals(a, euclideanGreatestCommonDivisorSolver.findEuclideanGCD(a, b));
    }

    @Test
    public void can_handle_negative_input_parameters_in_gcd_with_euclidean_method() {
        BigInteger a = new BigInteger("-12");
        BigInteger b = new BigInteger("-4");

        try {
            euclideanGreatestCommonDivisorSolver.findEuclideanGCD(a, b);
        } catch (IllegalArgumentException e) {
            Assertions.assertEquals(ValidationMessageType.BELOW_MINIMUM_ERROR.getMessage(0), e.getMessage());
        }
    }

    @Test
    public void can_find_gcd_with_euclidean_method_two_larger_even_fibonacci_numbers() {
        BigInteger a = new BigInteger("14439042678085716960949814193344874389229173904390155479167035660686299132233394232110487256988461740058540821749323293504381921966930093689990678578706673205517616552290959865878623899352072116206415394");
        BigInteger b = new BigInteger("61164766314391710035884829815943265224568052927769577329622759945237346639032672167677108820397521093126336764093707189513015791230614183821533954756601790054548991800671186110593262317807192235925106064");
        Assertions.assertEquals(BigInteger.TWO, euclideanGreatestCommonDivisorSolver.findEuclideanGCD(a, b));
    }

    @Test
    public void can_find_gcd_with_euclidean_method_two_larger_consecutive_fibonacci_numbers() {
        BigInteger a = new BigInteger("43466557686937456435688527675040625802564660517371780402481729089536555417949051890403879840079255169295922593080322634775209689623239873322471161642996440906533187938298969649928516003704476137795166849228875");
        BigInteger b = new BigInteger("70330367711422815821835254877183549770181269836358732742604905087154537118196933579742249494562611733487750449241765991088186363265450223647106012053374121273867339111198139373125598767690091902245245323403501");
        Assertions.assertEquals(BigInteger.ONE, euclideanGreatestCommonDivisorSolver.findEuclideanGCD(a, b));
    }

    @Test
    public void can_handle_null_input_for_first_parameter_with_the_euclidean_gcd_method() {
        try {
            euclideanGreatestCommonDivisorSolver.findEuclideanGCD(null, new BigInteger("332002"));
        } catch (NullPointerException e) {
            Assertions.assertEquals(ValidationMessageType.NULL_VALUE_ERROR.getMessage(), e.getMessage());
        }
    }

    @Test
    public void can_handle_null_input_for_second_parameter_with_the_euclidean_gcd_method() {
        try {
            euclideanGreatestCommonDivisorSolver.findEuclideanGCD(new BigInteger("56135521"), null);
        } catch (NullPointerException e) {
            Assertions.assertEquals(ValidationMessageType.NULL_VALUE_ERROR.getMessage(), e.getMessage());
        }
    }
}