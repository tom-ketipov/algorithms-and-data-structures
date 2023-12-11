package modules.algorithmic_toolbox.bonus.greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

import static services.ValidationService.*;

/*
    Job Scheduling Problem

    Given an array of jobs, where each job is associated with its profit and deadline,
    find an order-ing of all jobs that maximizes the profit.
    A job generates a profit only if it is completed before the deadline.
    ==================================================================================>
    Time Complexity: O(n log n)
 */

public class JobSchedule {
    public final static String NON_NULL_JOBS_EXCEPTION_MESSAGE = "The input array of jobs must not be null.";
    public final static String NON_EMPTY_JOBS_EXCEPTION_MESSAGE = "The input array of jobs must not be empty.";
    public final static String NON_NEGATIVE_DEADLINE_EXCEPTION_MESSAGE = "The deadline must be a non-negative value.";
    public final static String NON_NEGATIVE_PROFIT_EXCEPTION_MESSAGE = "The profit must be a non-negative value.";


    public static class Job {
        private int profit;
        private int deadline;

        public Job(int deadline, int profit) {
            validateInRange(deadline, 0, Integer.MAX_VALUE, NON_NEGATIVE_DEADLINE_EXCEPTION_MESSAGE);
            validateInRange(profit, 0, Integer.MAX_VALUE, NON_NEGATIVE_PROFIT_EXCEPTION_MESSAGE);

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
        validateNotNull(jobs, NON_NULL_JOBS_EXCEPTION_MESSAGE);
        validateNotEmpty(jobs, NON_EMPTY_JOBS_EXCEPTION_MESSAGE);

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
