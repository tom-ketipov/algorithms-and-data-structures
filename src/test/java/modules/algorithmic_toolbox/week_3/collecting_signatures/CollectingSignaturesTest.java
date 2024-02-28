package modules.algorithmic_toolbox.week_3.collecting_signatures;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CollectingSignaturesTest {
    private CoveringSegments coveringSegmentsSolver;

    @Test
    public void can_detect_single_overlapping_point() {
        coveringSegmentsSolver = new CoveringSegments();

        CoveringSegments.Segment[] segments = new CoveringSegments.Segment[3];
        segments[0] = new CoveringSegments.Segment(1, 3);
        segments[1] = new CoveringSegments.Segment(2, 5);
        segments[2] = new CoveringSegments.Segment(3, 6);

        assertArrayEquals(new int[]{3}, coveringSegmentsSolver.optimalPoints(segments));
    }

    @Test
    public void can_detect_multiple_overlapping_points() {
        coveringSegmentsSolver = new CoveringSegments();

        CoveringSegments.Segment[] segments = new CoveringSegments.Segment[4];
        segments[0] = new CoveringSegments.Segment(1, 3);
        segments[1] = new CoveringSegments.Segment(4, 7);
        segments[2] = new CoveringSegments.Segment(2, 5);
        segments[3] = new CoveringSegments.Segment(5, 6);

        assertArrayEquals(new int[]{3, 6}, coveringSegmentsSolver.optimalPoints(segments));
    }

    @Test
    public void can_handle_single_segment() {
        coveringSegmentsSolver = new CoveringSegments();

        CoveringSegments.Segment[] segments = new CoveringSegments.Segment[1];
        segments[0] = new CoveringSegments.Segment(0, 3);

        assertTrue(coveringSegmentsSolver.optimalPoints(segments)[0] >= 0);
        assertTrue(coveringSegmentsSolver.optimalPoints(segments)[0] <= 3);
    }

    @Test
    public void throws_exception_for_null_parameter_input() {
        coveringSegmentsSolver = new CoveringSegments();

        try {
            coveringSegmentsSolver.optimalPoints(null);
        } catch (NullPointerException e) {
            assertEquals("The array must not be null.", e.getMessage());
        }
    }

    @Test
    public void throws_exception_for_empty_segment_array_input() {
        coveringSegmentsSolver = new CoveringSegments();

        try {
            coveringSegmentsSolver.optimalPoints(new CoveringSegments.Segment[]{});
        } catch (IllegalArgumentException e) {
            assertEquals("The array must not be empty.", e.getMessage());
        }
    }
}
