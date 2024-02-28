package modules.algorithmic_toolbox.bonus.greedy;

import org.apache.commons.lang3.Validate;
import utils.ValidationMessageUtility;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

/*
    Job Scheduling Problem

    Given an array of jobs, where each job is associated with its profit and deadline,
    find an order-ing of all jobs that maximizes the profit.
    A job generates a profit only if it is completed before the deadline.
    ==================================================================================>
    Time Complexity: O(n log n)
 */

public class JobSchedule {
    public static class Job {
        private int profit;
        private int deadline;

        public Job(int deadline, int profit) {
            int minValue = 0;
            int maxValue = Integer.MAX_VALUE;
            Validate.inclusiveBetween(minValue, maxValue, deadline, ValidationMessageUtility.getMessage("value_range_exception", minValue, maxValue));
            Validate.inclusiveBetween(minValue, maxValue, profit, ValidationMessageUtility.getMessage("value_range_exception", minValue, maxValue));

            this.profit = profit;
            this.deadline = deadline;
        }

        public int getProfit() {
            return profit;
        }

        public int getDeadline() {
            return deadline;
        }
    }

    public Job[] scheduleJobs(Job[] jobs) {
        Validate.notNull(jobs, ValidationMessageUtility.getMessage("not_null_array_exception"));
        Validate.isTrue(jobs.length > 0, ValidationMessageUtility.getMessage("not_empty_array_exception"));

        Arrays.sort(jobs, Comparator.comparing(Job::getDeadline).thenComparing((Job::getProfit), Comparator.reverseOrder()));

        LinkedList<Job> schedule = new LinkedList<>();
        for (Job job : jobs) {
            if (schedule.isEmpty()) {
                schedule.add(job);
                continue;
            }
            if (job.deadline != schedule.getLast().deadline) schedule.add(job);
        }
        return schedule.toArray(Job[]::new);
    }
}
