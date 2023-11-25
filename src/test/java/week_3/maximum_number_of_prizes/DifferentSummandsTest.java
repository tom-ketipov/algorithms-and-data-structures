package week_3.maximum_number_of_prizes;

import org.junit.Assert;
import org.junit.Test;

import java.security.InvalidParameterException;
import java.util.List;

public class DifferentSummandsTest {
    private DifferentSummands differentSummandsSolver;

    @Test
    public void can_find_arithmetic_sequence_summands() {
        differentSummandsSolver = new DifferentSummands();

        int max = 6;

        List<Integer> summands = differentSummandsSolver.optimalSummands(max);
        Assert.assertEquals(3, summands.size());
        Assert.assertEquals(1, summands.get(0).intValue());
        Assert.assertEquals(2, summands.get(1).intValue());
        Assert.assertEquals(3, summands.get(2).intValue());
    }

    @Test
    public void can_find_sequence_with_bigger_last_number_summands() {
        differentSummandsSolver = new DifferentSummands();

        int max = 8;

        List<Integer> summands = differentSummandsSolver.optimalSummands(max);
        Assert.assertEquals(3, summands.size());
        Assert.assertEquals(1, summands.get(0).intValue());
        Assert.assertEquals(2, summands.get(1).intValue());
        Assert.assertEquals(5, summands.get(2).intValue());
    }

    @Test
    public void throws_exception_for_zero_input_parameter() {
        differentSummandsSolver = new DifferentSummands();

        int max = 0;

        try {
            differentSummandsSolver.optimalSummands(max);
        } catch (InvalidParameterException e) {
            Assert.assertEquals("'N' cannot be less or equal to 0.", e.getMessage());
        }
    }

    @Test
    public void throws_exception_for_negative_input_parameter() {
        differentSummandsSolver = new DifferentSummands();

        int max = -23;

        try {
            differentSummandsSolver.optimalSummands(max);
        } catch (InvalidParameterException e) {
            Assert.assertEquals("'N' cannot be less or equal to 0.", e.getMessage());
        }
    }
}
