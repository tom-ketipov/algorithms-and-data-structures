package bonus.greedy;

import org.junit.Assert;
import org.junit.Test;

import java.lang.management.ManagementFactory;
import java.lang.management.MemoryPoolMXBean;
import java.lang.management.MemoryUsage;
import java.lang.management.ThreadMXBean;

public class JobScheduleTest {
    private JobSchedule jobScheduleSolver;

    // Job
    @Test
    public void cant_construct_job_object_with_negative_deadline() {
        try {
            JobSchedule.Job job = new JobSchedule.Job(-1, 2);
        } catch (IllegalArgumentException e) {
            Assert.assertEquals("Profit and deadline must be non-negative values.", e.getMessage());
        }
    }

    @Test
    public void cant_construct_job_object_with_negative_profit() {
        try {
            JobSchedule.Job job = new JobSchedule.Job(1, -32);
        } catch (IllegalArgumentException e) {
            Assert.assertEquals("Profit and deadline must be non-negative values.", e.getMessage());
        }
    }

    @Test
    public void can_construct_job_object_with_zero_values() {
        JobSchedule.Job job = new JobSchedule.Job(0, 0);
        Assert.assertEquals(0, job.getProfit());
        Assert.assertEquals(0, job.getDeadline());
    }

    @Test
    public void can_construct_job_object_with_max_integer_deadline() {
        JobSchedule.Job job = new JobSchedule.Job(Integer.MAX_VALUE, 0);
        Assert.assertEquals(0, job.getProfit());
        Assert.assertEquals(Integer.MAX_VALUE, job.getDeadline());
    }

    @Test
    public void can_construct_job_object_with_max_integer_profit() {
        JobSchedule.Job job = new JobSchedule.Job(3, Integer.MAX_VALUE);

        Assert.assertEquals(Integer.MAX_VALUE, job.getProfit());
        Assert.assertEquals(3, job.getDeadline());
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
        Assert.assertEquals(2, schedule.length);
        Assert.assertEquals(1, schedule[0].getDeadline());
        Assert.assertEquals(40, schedule[0].getProfit());
        Assert.assertEquals(2, schedule[1].getDeadline());
        Assert.assertEquals(30, schedule[1].getProfit());
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
        Assert.assertEquals(4, schedule.length);
        Assert.assertEquals(1, schedule[0].getDeadline());
        Assert.assertEquals(2, schedule[1].getDeadline());
        Assert.assertEquals(3, schedule[2].getDeadline());
        Assert.assertEquals(5, schedule[3].getDeadline());
    }

    @Test
    public void can_generate_optimal_schedule_for_single_job() {
        jobScheduleSolver = new JobSchedule();

        JobSchedule.Job[] jobs = new JobSchedule.Job[1];
        jobs[0] = new JobSchedule.Job(1, 20);

        JobSchedule.Job[] schedule = jobScheduleSolver.scheduleJobs(jobs);
        Assert.assertEquals(1, schedule.length);
        Assert.assertEquals(1, schedule[0].getDeadline());
        Assert.assertEquals(20, schedule[0].getProfit());
    }

    @Test
    public void throws_exception_for_null_jobs_input_parameter() {
        jobScheduleSolver = new JobSchedule();

        try {
            jobScheduleSolver.scheduleJobs(null);
        } catch (IllegalArgumentException e) {
            Assert.assertEquals("Jobs cannot be null.", e.getMessage());
        }
    }

    @Test
    public void throws_exception_for_empty_jobs_input_parameter() {
        jobScheduleSolver = new JobSchedule();

        try {
            jobScheduleSolver.scheduleJobs(new JobSchedule.Job[0]);
        } catch (IllegalArgumentException e) {
            Assert.assertEquals("Jobs cannot be empty.", e.getMessage());
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
            Assert.assertEquals("Jobs must have deadline/profit data.", e.getMessage());
        }
    }
}
