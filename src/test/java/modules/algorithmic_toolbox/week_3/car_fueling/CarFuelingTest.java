package modules.algorithmic_toolbox.week_3.car_fueling;

import org.junit.jupiter.api.Test;
import services.ValidationMessages;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CarFuelingTest {
    private CarFueling carFuelingSolver;

    @Test
    public void can_reach_endpoint_with_minimum_stops_for_valid_route() {
        carFuelingSolver = new CarFueling();

        int distance = 950;
        int tank = 400;
        int[] stops = {200, 375, 550, 750};
        assertEquals(2, carFuelingSolver.computeMinRefills(distance, tank, stops));
    }

    @Test
    public void can_reach_endpoint_with_minimum_stops_for_valid_route_2() {
        carFuelingSolver = new CarFueling();

        int distance = 48;
        int tank = 37;
        int[] stops = {16, 36, 45, 46};
        assertEquals(1, carFuelingSolver.computeMinRefills(distance, tank, stops));
    }

    @Test
    public void can_reach_endpoint_with_every_step_refueling() {
        carFuelingSolver = new CarFueling();

        int distance = 10;
        int tank = 4;
        int[] stops = {2, 5, 9};
        assertEquals(3, carFuelingSolver.computeMinRefills(distance, tank, stops));
    }

    @Test
    public void can_reach_endpoint_without_stops() {
        carFuelingSolver = new CarFueling();

        int distance = 200;
        int tank = 250;
        int[] stops = {100, 150};
        assertEquals(0, carFuelingSolver.computeMinRefills(distance, tank, stops));
    }

    @Test
    public void cant_reach_endpoint_if_distance_between_last_stop_and_dist_is_invalid() {
        carFuelingSolver = new CarFueling();

        int distance = 10;
        int tank = 3;
        int[] stops = {1, 2, 5, 9};
        assertEquals(-1, carFuelingSolver.computeMinRefills(distance, tank, stops));
    }

    @Test
    public void cant_reach_endpoint_for_invalid_route() {
        carFuelingSolver = new CarFueling();

        int distance = 10;
        int tank = 3;
        int[] stops = {1, 2, 5, 9};
        assertEquals(-1, carFuelingSolver.computeMinRefills(distance, tank, stops));
    }

    @Test
    public void throws_exception_for_zero_distance_value() {
        carFuelingSolver = new CarFueling();

        int distance = 0;
        int tank = 3;
        int[] stops = {1, 2, 5, 9};

        try {
            carFuelingSolver.computeMinRefills(distance, tank, stops);
        } catch (IllegalArgumentException e) {
            assertEquals(ValidationMessages.NOT_POSITIVE_NUMBER_EXCEPTION_MESSAGE, e.getMessage());
        }
    }

    @Test
    public void throws_exception_for_negative_distance_value() {
        carFuelingSolver = new CarFueling();

        int distance = -20;
        int tank = 3;
        int[] stops = {1, 2, 5, 9};

        try {
            carFuelingSolver.computeMinRefills(distance, tank, stops);
        } catch (IllegalArgumentException e) {
            assertEquals(ValidationMessages.NOT_POSITIVE_NUMBER_EXCEPTION_MESSAGE, e.getMessage());
        }
    }

    @Test
    public void throws_exception_for_zero_tank_capacity_value() {
        carFuelingSolver = new CarFueling();

        int distance = 10;
        int tank = 0;
        int[] stops = {1, 2, 5, 9};

        try {
            carFuelingSolver.computeMinRefills(distance, tank, stops);
        } catch (IllegalArgumentException e) {
            assertEquals(ValidationMessages.NOT_POSITIVE_NUMBER_EXCEPTION_MESSAGE, e.getMessage());
        }
    }

    @Test
    public void throws_exception_for_negative_tank_capacity_value() {
        carFuelingSolver = new CarFueling();

        int distance = 10;
        int tank = -3;
        int[] stops = {1, 2, 5, 9};

        try {
            carFuelingSolver.computeMinRefills(distance, tank, stops);
        } catch (IllegalArgumentException e) {
            assertEquals(ValidationMessages.NOT_POSITIVE_NUMBER_EXCEPTION_MESSAGE, e.getMessage());
        }
    }

    @Test
    public void throws_exception_for_invalid_length_refill_stations() {
        carFuelingSolver = new CarFueling();

        int distance = 10;
        int tank = 3;
        int[] stops = {};

        try {
            carFuelingSolver.computeMinRefills(distance, tank, stops);
        } catch (IllegalArgumentException e) {
            assertEquals(ValidationMessages.NOT_EMPTY_ARRAY_EXCEPTION_MESSAGE, e.getMessage());
        }
    }

    @Test
    public void throws_exception_for_null_refill_stations_parameter() {
        carFuelingSolver = new CarFueling();

        int distance = 10;
        int tank = 3;

        try {
            carFuelingSolver.computeMinRefills(distance, tank, null);
        } catch (IllegalArgumentException e) {
            assertEquals(ValidationMessages.NOT_NULL_ARRAY_EXCEPTION_MESSAGE, e.getMessage());
        }
    }
}
