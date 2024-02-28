package modules.algorithmic_toolbox.bonus.greedy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JobScheduleTest {
    private JobSchedule jobScheduleSolver;

    // Job
    @Test
    public void cant_construct_job_object_with_negative_deadline() {
        try {
            new JobSchedule.Job(-1, 2);
        } catch (IllegalArgumentException e) {
            assertEquals("The value must be between 0 and 2,147,483,647.", e.getMessage());
        }
    }

    @Test
    public void cant_construct_job_object_with_negative_profit() {
        try {
            new JobSchedule.Job(1, -32);
        } catch (IllegalArgumentException e) {
            assertEquals("The value must be between 0 and 2,147,483,647.", e.getMessage());
        }
    }

    @Test
    public void can_construct_job_object_with_zero_values() {
        JobSchedule.Job job = new JobSchedule.Job(0, 0);
        assertEquals(0, job.getProfit());
        assertEquals(0, job.getDeadline());
    }

    @Test
    public void can_construct_job_object_with_max_integer_deadline() {
        JobSchedule.Job job = new JobSchedule.Job(Integer.MAX_VALUE, 0);
        assertEquals(0, job.getProfit());
        assertEquals(Integer.MAX_VALUE, job.getDeadline());
    }

    @Test
    public void can_construct_job_object_with_max_integer_profit() {
        JobSchedule.Job job = new JobSchedule.Job(3, Integer.MAX_VALUE);

        assertEquals(Integer.MAX_VALUE, job.getProfit());
        assertEquals(3, job.getDeadline());
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
        assertEquals(2, schedule.length);
        assertEquals(1, schedule[0].getDeadline());
        assertEquals(40, schedule[0].getProfit());
        assertEquals(2, schedule[1].getDeadline());
        assertEquals(30, schedule[1].getProfit());
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
        assertEquals(4, schedule.length);
        assertEquals(1, schedule[0].getDeadline());
        assertEquals(2, schedule[1].getDeadline());
        assertEquals(3, schedule[2].getDeadline());
        assertEquals(5, schedule[3].getDeadline());
    }

    @Test
    public void can_generate_optimal_schedule_for_single_job() {
        jobScheduleSolver = new JobSchedule();

        JobSchedule.Job[] jobs = new JobSchedule.Job[1];
        jobs[0] = new JobSchedule.Job(1, 20);

        JobSchedule.Job[] schedule = jobScheduleSolver.scheduleJobs(jobs);
        assertEquals(1, schedule.length);
        assertEquals(1, schedule[0].getDeadline());
        assertEquals(20, schedule[0].getProfit());
    }

    @Test
    public void throws_exception_for_null_jobs_input_parameter() {
        jobScheduleSolver = new JobSchedule();

        try {
            jobScheduleSolver.scheduleJobs(null);
        } catch (NullPointerException e) {
            assertEquals("The array must not be null.", e.getMessage());
        }
    }

    @Test
    public void throws_exception_for_empty_jobs_input_parameter() {
        jobScheduleSolver = new JobSchedule();

        try {
            jobScheduleSolver.scheduleJobs(new JobSchedule.Job[0]);
        } catch (IllegalArgumentException e) {
            assertEquals("The array must not be empty.", e.getMessage());
        }
    }
}
