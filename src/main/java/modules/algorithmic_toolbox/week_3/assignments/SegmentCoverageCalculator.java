package modules.algorithmic_toolbox.week_3.assignments;

import enums.ValidationMessageType;
import org.apache.commons.lang3.Validate;

import java.util.Arrays;
import java.util.Comparator;

/*
        3.2.5 Covering Segments by Points Problem
        Find the minimum number of points needed to cover all given segments on a line.
 */
public class SegmentCoverageCalculator {

    public static class Segment {
        private final int start;  // The starting point of the segment
        private final int end;  // The ending point of the segment

        /**
         * Constructs a new Segment with specified start and end points.
         *
         * @param start The starting point of the segment. Must be non-negative and less than the end point.
         *              It should also be within the range [0, 1,000,000,000].
         * @param end   The ending point of the segment. Must be greater than the start point and non-negative.
         *              It should also be within the range [0, 1,000,000,000].
         * @throws IllegalArgumentException if the start or end points are out of the allowed range,
         *                                  or if the start point is not less than the end point.
         */
        public Segment(int start, int end) {
            Validate.inclusiveBetween(0, 1000000000, start, ValidationMessageType.OUT_OF_RANGE_ERROR.getMessage(0, 1000000000));
            Validate.inclusiveBetween(0, 1000000000, end, ValidationMessageType.OUT_OF_RANGE_ERROR.getMessage(0, 1000000000));
            Validate.isTrue(start < end);

            this.start = start;
            this.end = end;
        }

        public int getStart() {
            return start;
        }

        public int getEnd() {
            return end;
        }
    }

    /**
     * Calculates the minimum number of points needed to ensure each segment in the array has at least one point on it.
     *
     * @param segments An array of Segment objects representing the line segments.
     * @return The minimum number of points required to cover all segments.
     * @throws NullPointerException     if the segments array is null.
     * @throws IllegalArgumentException if the segments array contains more than 100 elements.
     * @implNote Time complexity: 0(n log n)
     */
    public int calculateMinimumCoveragePoints(Segment[] segments) {
        Validate.notNull(segments, ValidationMessageType.NULL_VALUE_ERROR.getMessage());
        Validate.isTrue(segments.length <= 100);

        Arrays.sort(segments, Comparator.comparing(segment -> segment.start));

        int totalPoitnsCount = 0; // Total number of points selected
        int crossingPoint = 0; // The point where current segment crosses the previous one
        for (int i = segments.length - 1; i >= 0; i--) {
            if (segments[i].getEnd() < crossingPoint || i == segments.length - 1) {
                crossingPoint = segments[i].getStart();
                totalPoitnsCount++;
            }
        }
        return totalPoitnsCount;
    }
}
