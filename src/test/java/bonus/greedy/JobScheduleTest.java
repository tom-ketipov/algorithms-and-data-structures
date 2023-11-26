package bonus.greedy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class JobScheduleTest {
    private JobSchedule jobScheduleSolver;

    // Job
    @Test
    public void cant_construct_job_object_with_negative_deadline() {
        try {
            JobSchedule.Job job = new JobSchedule.Job(-1, 2);
        } catch (IllegalArgumentException e) {
            Assertions.assertEquals("Profit and deadline must be non-negative values.", e.getMessage());
        }
    }

    @Test
    public void cant_construct_job_object_with_negative_profit() {
        try {
            JobSchedule.Job job = new JobSchedule.Job(1, -32);
        } catch (IllegalArgumentException e) {
            Assertions.assertEquals("Profit and deadline must be non-negative values.", e.getMessage());
        }
    }

    @Test
    public void can_construct_job_object_with_zero_values() {
        JobSchedule.Job job = new JobSchedule.Job(0, 0);
        Assertions.assertEquals(0, job.getProfit());
        Assertions.assertEquals(0, job.getDeadline());
    }

    @Test
    public void can_construct_job_object_with_max_integer_deadline() {
        JobSchedule.Job job = new JobSchedule.Job(Integer.MAX_VALUE, 0);
        Assertions.assertEquals(0, job.getProfit());
        Assertions.assertEquals(Integer.MAX_VALUE, job.getDeadline());
    }

    @Test
    public void can_construct_job_object_with_max_integer_profit() {
        JobSchedule.Job job = new JobSchedule.Job(3, Integer.MAX_VALUE);

        Assertions.assertEquals(Integer.MAX_VALUE, job.getProfit());
        Assertions.assertEquals(3, job.getDeadline());
    }

    // Job Scheduler
    @Test
    public void can_generate_optimal_schedule_for_multiple_jobs_with_the_same_timeline() {
        jobScheduleSolver = new JobSchedule();

        JobSchedule.Job[] jobs = new JobSchedule.Job[4];
        jobs[0] = new JobSchedule.Job(1, 20);
        jobs[1] = new JobSchedule.Job(1, 10);
        jobs[2] = new JobSchedule.Job(1, 40);
        jobs[3] = new JobSchedule.Job(2, 30);

        JobSchedule.Job[] schedule = jobScheduleSolver.scheduleJobs(jobs);
        Assertions.assertEquals(2, schedule.length);
        Assertions.assertEquals(1, schedule[0].getDeadline());
        Assertions.assertEquals(40, schedule[0].getProfit());
        Assertions.assertEquals(2, schedule[1].getDeadline());
        Assertions.assertEquals(30, schedule[1].getProfit());
    }

    @Test
    public void can_generate_optimal_schedule_for_multiple_distinct_jobs() {
        jobScheduleSolver = new JobSchedule();

        JobSchedule.Job[] jobs = new JobSchedule.Job[4];
        jobs[0] = new JobSchedule.Job(1, 20);
        jobs[1] = new JobSchedule.Job(3, 10);
        jobs[2] = new JobSchedule.Job(2, 40);
        jobs[3] = new JobSchedule.Job(5, 30);

        JobSchedule.Job[] schedule = jobScheduleSolver.scheduleJobs(jobs);
        Assertions.assertEquals(4, schedule.length);
        Assertions.assertEquals(1, schedule[0].getDeadline());
        Assertions.assertEquals(2, schedule[1].getDeadline());
        Assertions.assertEquals(3, schedule[2].getDeadline());
        Assertions.assertEquals(5, schedule[3].getDeadline());
    }

    @Test
    public void can_generate_optimal_schedule_for_single_job() {
        jobScheduleSolver = new JobSchedule();

        JobSchedule.Job[] jobs = new JobSchedule.Job[1];
        jobs[0] = new JobSchedule.Job(1, 20);

        JobSchedule.Job[] schedule = jobScheduleSolver.scheduleJobs(jobs);
        Assertions.assertEquals(1, schedule.length);
        Assertions.assertEquals(1, schedule[0].getDeadline());
        Assertions.assertEquals(20, schedule[0].getProfit());
    }

    @Test
    public void throws_exception_for_null_jobs_input_parameter() {
        jobScheduleSolver = new JobSchedule();

        try {
            jobScheduleSolver.scheduleJobs(null);
        } catch (IllegalArgumentException e) {
            Assertions.assertEquals("Jobs cannot be null.", e.getMessage());
        }
    }

    @Test
    public void throws_exception_for_empty_jobs_input_parameter() {
        jobScheduleSolver = new JobSchedule();

        try {
            jobScheduleSolver.scheduleJobs(new JobSchedule.Job[0]);
        } catch (IllegalArgumentException e) {
            Assertions.assertEquals("Jobs cannot be empty.", e.getMessage());
        }
    }

    @Test
    public void throws_exception_for_empty_jobs_values_in_the_input_parameter() {
        jobScheduleSolver = new JobSchedule();

        JobSchedule.Job[] jobs = new JobSchedule.Job[10];
        jobs[0] = new JobSchedule.Job(1, 20);

        try {
            jobScheduleSolver.scheduleJobs(jobs);
        } catch (IllegalArgumentException e) {
            Assertions.assertEquals("Jobs must have deadline/profit data.", e.getMessage());
        }
    }
}
