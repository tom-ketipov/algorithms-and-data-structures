package modules.algorithmic_toolbox.bonus.greedy;

import services.ValidationMessages;

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
    public static class Job {
        private int profit;
        private int deadline;

        public Job(int deadline, int profit) {
            validateInRange(deadline, 0, Integer.MAX_VALUE, ValidationMessages.NON_NEGATIVE_NUMBER_EXCEPTION_MESSAGE);
            validateInRange(profit, 0, Integer.MAX_VALUE, ValidationMessages.NON_NEGATIVE_NUMBER_EXCEPTION_MESSAGE);

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
        validateNotNull(jobs, ValidationMessages.NON_NULL_ARRAY_EXCEPTION_MESSAGE);
        validateNotEmpty(jobs, ValidationMessages.NON_EMPTY_ARRAY_EXCEPTION_MESSAGE);

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
