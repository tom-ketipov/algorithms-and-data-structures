package bonus.greedy;

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
            // Validate constructor parameters
            if (profit < 0 || deadline < 0) {
                throw new IllegalArgumentException("Profit and deadline must be non-negative values.");
            }
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
        validateJobs(jobs);
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

    private void validateJobs(Job[] jobs) {
        // Validate input parameters
        if (jobs == null) {
            throw new IllegalArgumentException("Jobs cannot be null.");
        }

        if (jobs.length == 0) {
            throw new IllegalArgumentException("Jobs cannot be empty.");
        }

        // Validate job indexes
        for (Job job : jobs) {
            if (job == null) throw new IllegalArgumentException("Jobs must have deadline/profit data.");
        }
    }
}
