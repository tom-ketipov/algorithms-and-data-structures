package modules.week_3.assignments;

import enums.ValidationMessageType;
import modules.algorithmic_toolbox.week_3.assignments.SegmentCoverageCalculator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SegmentCoverageCalculatorTest {
    private SegmentCoverageCalculator segmentCoverageCalculatorSolver;

    @BeforeEach
    public void setUp() {
        segmentCoverageCalculatorSolver = new SegmentCoverageCalculator();
    }

    @Test
    public void can_construct_segment_with_start_and_end_values_withing_allowed_ranges() {
        SegmentCoverageCalculator.Segment segment = new SegmentCoverageCalculator.Segment(50, 250);

        Assertions.assertEquals(50, segment.getStart());
        Assertions.assertEquals(250, segment.getEnd());
    }

    @Test
    public void illegal_argument_exception_is_thrown_when_constructing_segment_with_start_below_the_allowed_minimum() {
        try {
            new SegmentCoverageCalculator.Segment(-1, 250);
        } catch (IllegalArgumentException e) {
            Assertions.assertEquals(ValidationMessageType.OUT_OF_RANGE_ERROR.getMessage(0, 1000000000), e.getMessage());
        }
    }

    @Test
    public void illegal_argument_exception_is_thrown_when_constructing_segment_with_end_above_the_allowed_maximum() {
        try {
            new SegmentCoverageCalculator.Segment(1, 2000000000);
        } catch (IllegalArgumentException e) {
            Assertions.assertEquals(ValidationMessageType.OUT_OF_RANGE_ERROR.getMessage(0, 1000000000), e.getMessage());
        }
    }

    @Test
    public void illegal_argument_exception_is_thrown_when_constructing_segment_with_start_point_bigger_than_the_end_point() {
        try {
            new SegmentCoverageCalculator.Segment(250, 20);
        } catch (IllegalArgumentException e) {
            Assertions.assertEquals("The validated expression is false", e.getMessage());
        }
    }

    @Test
    public void can_find_minimum_number_of_points_to_touch_all_segments() {
        SegmentCoverageCalculator.Segment[] segments = new SegmentCoverageCalculator.Segment[4];
        segments[0] = new SegmentCoverageCalculator.Segment(9, 17);
        segments[1] = new SegmentCoverageCalculator.Segment(2, 5);
        segments[2] = new SegmentCoverageCalculator.Segment(1, 3);
        segments[3] = new SegmentCoverageCalculator.Segment(4, 7);

        Assertions.assertEquals(3, segmentCoverageCalculatorSolver.calculateMinimumCoveragePoints(segments));
    }

    @Test
    public void can_find_minimum_number_of_points_to_touch_all_segments_for_segments_where_none_of_the_segments_have_mutual_crossing_point() {
        SegmentCoverageCalculator.Segment[] segments = new SegmentCoverageCalculator.Segment[4];
        segments[0] = new SegmentCoverageCalculator.Segment(9, 17);
        segments[1] = new SegmentCoverageCalculator.Segment(6, 8);
        segments[2] = new SegmentCoverageCalculator.Segment(1, 3);
        segments[3] = new SegmentCoverageCalculator.Segment(4, 5);

        Assertions.assertEquals(4, segmentCoverageCalculatorSolver.calculateMinimumCoveragePoints(segments));
    }

    @Test
    public void can_find_minimum_number_of_points_to_touch_all_segments_for_a_single_segment() {
        SegmentCoverageCalculator.Segment[] segments = new SegmentCoverageCalculator.Segment[1];
        segments[0] = new SegmentCoverageCalculator.Segment(9, 17);

        Assertions.assertEquals(1, segmentCoverageCalculatorSolver.calculateMinimumCoveragePoints(segments));
    }

    @Test
    public void can_find_minimum_number_of_points_to_touch_all_segments_for_empty_segments_array() {
        Assertions.assertEquals(0, segmentCoverageCalculatorSolver.calculateMinimumCoveragePoints(new SegmentCoverageCalculator.Segment[0]));
    }

    @Test
    public void null_pointer_exception_is_thrown_for_null_input() {
        try {
            segmentCoverageCalculatorSolver.calculateMinimumCoveragePoints(null);
        } catch (NullPointerException e) {
            Assertions.assertEquals(ValidationMessageType.NULL_VALUE_ERROR.getMessage(), e.getMessage());
        }
    }

    @Test
    public void illegal_argument_exception_is_thrown_for_segments_array_with_more_than_hundred_segments() {
        try {
            segmentCoverageCalculatorSolver.calculateMinimumCoveragePoints(new SegmentCoverageCalculator.Segment[101]);
        } catch (IllegalArgumentException e) {
            Assertions.assertEquals("The validated expression is false", e.getMessage());
        }
    }
}
