package modules.algorithmic_toolbox.week_3.bonus;

import enums.ValidationMessageType;
import org.apache.commons.lang3.Validate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JobScheduler {
    public static class Job {
        private final int deadline;
        private final int profit;

        /**
         * Constructs a new Job instance with the specified deadline and profit.
         *
         * @param deadline The deadline for the job, represented as an integer.
         * @param profit   The profit associated with completing the job, also represented as an integer.
         * @throws IllegalArgumentException if either the deadline or the profit is less than or equal to zero.
         */
        public Job(int deadline, int profit) {
            Validate.isTrue(deadline > 0, ValidationMessageType.BELOW_MINIMUM_ERROR.getMessage(1));
            Validate.isTrue(profit > 0, ValidationMessageType.BELOW_MINIMUM_ERROR.getMessage(1));

            this.deadline = deadline;
            this.profit = profit;
        }

        public int getDeadline() {
            return deadline;
        }

        public int getProfit() {
            return profit;
        }
    }

    /**
     * Schedules jobs to maximize total profit while respecting job deadlines.
     *
     * @param jobs An array of Job objects to be scheduled. Each job has a deadline and a profit associated with it.
     *             The array must not be null, and no job within the array should be null.
     * @return A list of scheduled jobs that maximizes profit under the constraints of job deadlines.
     * @throws NullPointerException if the jobs array or any job within it is null.
     * @implNote Time Complexity: O(n log n)
     */
    public List<Job> scheduleForMaxProfit(Job[] jobs) {
        Validate.notNull(jobs, ValidationMessageType.NULL_VALUE_ERROR.getMessage());

        Arrays.sort(jobs, (firstJob, secondJob) -> {
            Validate.notNull(firstJob, ValidationMessageType.NULL_VALUE_ERROR.getMessage());
            Validate.notNull(secondJob, ValidationMessageType.NULL_VALUE_ERROR.getMessage());

            // First compare by deadline in ascending order
            int deadlineCompare = Integer.compare(firstJob.deadline, secondJob.deadline);
            if (deadlineCompare != 0) {
                return deadlineCompare;
            }
            // Then compare by profit in descending order
            return Integer.compare(secondJob.profit, firstJob.profit);
        });

        List<Job> scheduledJobs = new ArrayList<>();
        int timeSlot = 1;
        for (Job jobToSchedule : jobs) {
            if (!scheduledJobs.isEmpty() && jobToSchedule.getDeadline() == scheduledJobs.get(scheduledJobs.size() - 1).getDeadline()) {
                continue;
            }

            if (jobToSchedule.getDeadline() >= timeSlot) {
                scheduledJobs.add(jobToSchedule);
                timeSlot++;
            }
        }
        return scheduledJobs;
    }
}
