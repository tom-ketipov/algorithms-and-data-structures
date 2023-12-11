package modules.algorithmic_toolbox.week_3.collecting_signatures;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

import static services.ValidationService.validateNotEmpty;
import static services.ValidationService.validateNotNull;

public class CoveringSegments {
    public final static String NON_NULL_SEGMENTS_EXCEPTION_MESSAGE = "The input array of segments must not be null.";
    public final static String NON_EMPTY_SEGMENTS_EXCEPTION_MESSAGE = "The input array of segments must not be empty.";

    /*
            Collecting Signatures problem
            You have to collect signatures from the tenants in the building.
            You know the times each tenant will be in the building (represented by the segments in the problem)
            and you want to minimize the number of visits and time spent at the building.
            Assume that the actual visit with the tenant will take no time.

            In other words, we have a bunch of line segments that may or may not overlap. We want to minimize the number of segments
            =========================================================================================================================
            Time complexity: 0(n log n)
     */

    public static class Segment {
        private int start, end;

        Segment(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public int[] optimalPoints(Segment[] segments) {
        validateNotNull(segments, NON_NULL_SEGMENTS_EXCEPTION_MESSAGE);
        validateNotEmpty(segments, NON_EMPTY_SEGMENTS_EXCEPTION_MESSAGE);

        Arrays.sort(segments, Comparator.comparing(segment -> segment.end));

        LinkedList<Integer> overlappingPointsList = new LinkedList<>();
        overlappingPointsList.add(segments[0].end);

        for (int i = 1; i < segments.length; i++) {
            int start = segments[i].start;
            int end = segments[i].end;

            if (overlappingPointsList.getLast() < start || overlappingPointsList.getLast() > end) {
                overlappingPointsList.add(end);
            }
        }
        return overlappingPointsList.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }
}
