package modules.algorithmic_toolbox.week_3.assignments;

import enums.ValidationMessageType;
import modules.algorithmic_toolbox.week_3.bonus.JobScheduler;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class JobSchedulerTest {
    private JobScheduler jobSchedulerSolver;

    @BeforeEach
    public void setUp() {
        jobSchedulerSolver = new JobScheduler();
    }

    @Test
    public void can_construct_a_job_with_positive_profit_and_deadline() {
        JobScheduler.Job job = new JobScheduler.Job(10, 20);

        Assertions.assertEquals(10, job.getDeadline());
        Assertions.assertEquals(20, job.getProfit());
    }

    @Test
    public void illegal_argument_exception_is_returned_when_constructing_a_job_with_zero_deadline_and_positive_profit() {
        try {
            new JobScheduler.Job(0, 20);
        } catch (IllegalArgumentException e) {
            Assertions.assertEquals(ValidationMessageType.BELOW_MINIMUM_ERROR.getMessage(1), e.getMessage());
        }
    }

    @Test
    public void illegal_argument_exception_is_returned_when_constructing_a_job_with_zero_profit_and_positive_deadline() {
        try {
            new JobScheduler.Job(18, 0);
        } catch (IllegalArgumentException e) {
            Assertions.assertEquals(ValidationMessageType.BELOW_MINIMUM_ERROR.getMessage(1), e.getMessage());
        }
    }

    @Test
    public void illegal_argument_exception_is_returned_when_constructing_a_job_with_negative_profit() {
        try {
            new JobScheduler.Job(18, -1);
        } catch (IllegalArgumentException e) {
            Assertions.assertEquals(ValidationMessageType.BELOW_MINIMUM_ERROR.getMessage(1), e.getMessage());
        }
    }

    @Test
    public void illegal_argument_exception_is_returned_when_constructing_a_job_with_negative_deadline() {
        try {
            new JobScheduler.Job(-12, 890);
        } catch (IllegalArgumentException e) {
            Assertions.assertEquals(ValidationMessageType.BELOW_MINIMUM_ERROR.getMessage(1), e.getMessage());
        }
    }

    @Test
    public void correct_job_order_is_returned_for_multiple_jobs_input_where_the_jobs_are_not_initially_ordered() {
        JobScheduler.Job[] jobs = new JobScheduler.Job[5];
        jobs[0] = new JobScheduler.Job(5, 40);
        jobs[1] = new JobScheduler.Job(1, 505);
        jobs[2] = new JobScheduler.Job(3, 3000);
        jobs[3] = new JobScheduler.Job(4, 3500);
        jobs[4] = new JobScheduler.Job(2, 300);

        List<JobScheduler.Job> scheduledJobs = jobSchedulerSolver.scheduleForMaxProfit(jobs);

        Assertions.assertEquals(1, scheduledJobs.get(0).getDeadline());
        Assertions.assertEquals(2, scheduledJobs.get(1).getDeadline());
        Assertions.assertEquals(3, scheduledJobs.get(2).getDeadline());
        Assertions.assertEquals(4, scheduledJobs.get(3).getDeadline());
        Assertions.assertEquals(5, scheduledJobs.get(4).getDeadline());
    }

    @Test
    public void correct_job_order_is_returned_for_multiple_jobs_input_where_the_jobs_have_equal_profit_and_deadline() {
        JobScheduler.Job[] jobs = new JobScheduler.Job[5];
        jobs[0] = new JobScheduler.Job(1, 40);
        jobs[1] = new JobScheduler.Job(1, 505);
        jobs[2] = new JobScheduler.Job(2, 3000);
        jobs[3] = new JobScheduler.Job(2, 3500);
        jobs[4] = new JobScheduler.Job(3, 300);

        List<JobScheduler.Job> scheduledJobs = jobSchedulerSolver.scheduleForMaxProfit(jobs);

        Assertions.assertEquals(3, scheduledJobs.size());
        Assertions.assertEquals(505, scheduledJobs.get(0).getProfit());
        Assertions.assertEquals(3500, scheduledJobs.get(1).getProfit());
        Assertions.assertEquals(300, scheduledJobs.get(2).getProfit());
    }

    @Test
    public void correct_job_order_is_returned_for_multiple_jobs_input_where_the_jobs_have_equal_profit_but_incremental_deadline() {
        JobScheduler.Job[] jobs = new JobScheduler.Job[3];
        jobs[0] = new JobScheduler.Job(2, 3000);
        jobs[1] = new JobScheduler.Job(1, 3000);
        jobs[2] = new JobScheduler.Job(3, 3000);

        List<JobScheduler.Job> scheduledJobs = jobSchedulerSolver.scheduleForMaxProfit(jobs);

        Assertions.assertEquals(3, scheduledJobs.size());
        Assertions.assertEquals(1, scheduledJobs.get(0).getDeadline());
        Assertions.assertEquals(2, scheduledJobs.get(1).getDeadline());
        Assertions.assertEquals(3, scheduledJobs.get(2).getDeadline());
    }

    @Test
    public void correct_job_order_is_returned_for_multiple_jobs_input_where_the_jobs_have_equal_deadline_but_different_profit() {
        JobScheduler.Job[] jobs = new JobScheduler.Job[3];
        jobs[0] = new JobScheduler.Job(1, 241);
        jobs[1] = new JobScheduler.Job(1, 3566);
        jobs[2] = new JobScheduler.Job(1, 30);

        List<JobScheduler.Job> scheduledJobs = jobSchedulerSolver.scheduleForMaxProfit(jobs);

        Assertions.assertEquals(1, scheduledJobs.size());
        Assertions.assertEquals(3566, scheduledJobs.get(0).getProfit());
    }

    @Test
    public void the_input_array_is_returned_for_single_length_jobs_input() {
        JobScheduler.Job[] jobs = new JobScheduler.Job[1];
        jobs[0] = new JobScheduler.Job(3, 241);

        List<JobScheduler.Job> scheduledJobs = jobSchedulerSolver.scheduleForMaxProfit(jobs);

        Assertions.assertEquals(1, scheduledJobs.size());
        Assertions.assertEquals(241, scheduledJobs.get(0).getProfit());
        Assertions.assertEquals(3, scheduledJobs.get(0).getDeadline());
    }

    @Test
    public void the_input_array_is_returned_for_already_ordered_jobs_input() {
        JobScheduler.Job[] jobs = new JobScheduler.Job[3];
        jobs[0] = new JobScheduler.Job(1, 3000);
        jobs[1] = new JobScheduler.Job(2, 150);
        jobs[2] = new JobScheduler.Job(3, 2500);

        List<JobScheduler.Job> scheduledJobs = jobSchedulerSolver.scheduleForMaxProfit(jobs);

        Assertions.assertEquals(3, scheduledJobs.size());
        Assertions.assertEquals(1, scheduledJobs.get(0).getDeadline());
        Assertions.assertEquals(3000, scheduledJobs.get(0).getProfit());
        Assertions.assertEquals(2, scheduledJobs.get(1).getDeadline());
        Assertions.assertEquals(150, scheduledJobs.get(1).getProfit());
        Assertions.assertEquals(3, scheduledJobs.get(2).getDeadline());
        Assertions.assertEquals(2500, scheduledJobs.get(2).getProfit());
    }

    @Test
    public void empty_array_is_returned_for_empty_jobs_input() {
        JobScheduler.Job[] jobs = new JobScheduler.Job[0];

        List<JobScheduler.Job> scheduledJobs = jobSchedulerSolver.scheduleForMaxProfit(jobs);

        Assertions.assertEquals(0, scheduledJobs.size());
    }

    @Test
    public void null_pointer_exception_is_returned_for_null_input() {
        try {
            jobSchedulerSolver.scheduleForMaxProfit(null);
        } catch (NullPointerException e) {
            Assertions.assertEquals(ValidationMessageType.NULL_VALUE_ERROR.getMessage(), e.getMessage());
        }
    }

    @Test
    public void null_pointer_exception_is_returned_for_null_job_input() {
        try {
            JobScheduler.Job[] jobs = new JobScheduler.Job[3];
            jobs[0] = new JobScheduler.Job(1, 3000);
            jobs[1] = null;
            jobs[2] = new JobScheduler.Job(3, 2500);

            jobSchedulerSolver.scheduleForMaxProfit(jobs);
        } catch (NullPointerException e) {
            Assertions.assertEquals(ValidationMessageType.NULL_VALUE_ERROR.getMessage(), e.getMessage());
        }
    }
}
