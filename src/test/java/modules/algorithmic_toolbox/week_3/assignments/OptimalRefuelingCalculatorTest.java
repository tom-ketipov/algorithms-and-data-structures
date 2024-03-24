package modules.algorithmic_toolbox.week_3.assignments;

import enums.ValidationMessageType;
import modules.algorithmic_toolbox.week_3.assignments.OptimalRefuelingCalculator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OptimalRefuelingCalculatorTest {
    private OptimalRefuelingCalculator optimalRefuelingCalculatorSolver;

    @BeforeEach
    public void setUp() {
        optimalRefuelingCalculatorSolver = new OptimalRefuelingCalculator();
    }

    @Test
    public void correct_min_refill_stops_are_returned_for_route_with_enough_gas_station_stops() {
        int totalDistance = 12;
        int tankRange = 3;
        int[] gasStations = {1, 2, 4, 5, 8, 9, 10, 11};

        Assertions.assertEquals(4, optimalRefuelingCalculatorSolver.calculateMinRefillStops(totalDistance, tankRange, gasStations));
    }

    @Test
    public void correct_min_refill_stops_are_returned_when_there_are_not_enough_gas_station_stops_to_pass_the_route() {
        int totalDistance = 7;
        int tankRange = 3;
        int[] gasStations = {1, 2, 6};

        Assertions.assertEquals(-1, optimalRefuelingCalculatorSolver.calculateMinRefillStops(totalDistance, tankRange, gasStations));
    }

    @Test
    public void correct_min_refill_stops_are_returned_when_tank_capacity_is_smaller_than_the_first_station_stop() {
        int totalDistance = 50;
        int tankRange = 3;
        int[] gasStations = {4, 22, 36};

        Assertions.assertEquals(-1, optimalRefuelingCalculatorSolver.calculateMinRefillStops(totalDistance, tankRange, gasStations));
    }

    @Test
    public void correct_min_refill_stops_are_returned_when_tank_capacity_is_smaller_than_the_range_from_the_last_station_to_the_route_end() {
        int totalDistance = 10;
        int tankRange = 3;
        int[] gasStations = {2, 5, 6};

        Assertions.assertEquals(-1, optimalRefuelingCalculatorSolver.calculateMinRefillStops(totalDistance, tankRange, gasStations));
    }

    @Test
    public void correct_min_refill_stops_are_returned_when_tank_capacity_is_equal_to_the_range_from_the_last_station_to_the_route_end() {
        int totalDistance = 9;
        int tankRange = 3;
        int[] gasStations = {2, 5, 6};

        Assertions.assertEquals(3, optimalRefuelingCalculatorSolver.calculateMinRefillStops(totalDistance, tankRange, gasStations));
    }

    @Test
    public void correct_min_refill_stops_are_returned_for_route_with_gas_station_stops_on_each_step() {
        int totalDistance = 21;
        int tankRange = 1;
        int[] gasStations = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21};

        Assertions.assertEquals(20, optimalRefuelingCalculatorSolver.calculateMinRefillStops(totalDistance, tankRange, gasStations));
    }

    @Test
    public void null_pointer_exception_is_returned_for_null_station_locations_input() {
        int totalDistance = 21;
        int tankRange = 1;

        try {
            optimalRefuelingCalculatorSolver.calculateMinRefillStops(totalDistance, tankRange, null);
        } catch (NullPointerException e) {
            Assertions.assertEquals(ValidationMessageType.NULL_VALUE_ERROR.getMessage(), e.getMessage());
        }
    }

    @Test
    public void illegal_argument_exception_is_returned_for_station_locations_array_parameter_if_it_is_empty() {
        int totalDistance = 18;
        int tankRange = 4;
        int[] gasStations = {};

        try {
            optimalRefuelingCalculatorSolver.calculateMinRefillStops(totalDistance, tankRange, gasStations);
        } catch (IllegalArgumentException e) {
            Assertions.assertEquals(ValidationMessageType.OUT_OF_RANGE_ERROR.getMessage(1, 300), e.getMessage());
        }
    }

    @Test
    public void illegal_argument_exception_is_returned_for_station_locations_array_parameter_if_it_has_more_than_max_allowed_elements() {
        int totalDistance = 18;
        int tankRange = 4;
        int[] gasStations = new int[301];

        try {
            optimalRefuelingCalculatorSolver.calculateMinRefillStops(totalDistance, tankRange, gasStations);
        } catch (IllegalArgumentException e) {
            Assertions.assertEquals(ValidationMessageType.OUT_OF_RANGE_ERROR.getMessage(1, 300), e.getMessage());
        }
    }

    @Test
    public void illegal_argument_exception_is_returned_for_total_distance_parameter_that_is_zero() {
        int totalDistance = 0;
        int tankRange = 1;
        int[] gasStations = {2, 5, 6};

        try {
            optimalRefuelingCalculatorSolver.calculateMinRefillStops(totalDistance, tankRange, gasStations);
        } catch (IllegalArgumentException e) {
            Assertions.assertEquals(ValidationMessageType.OUT_OF_RANGE_ERROR.getMessage(1, 100000), e.getMessage());
        }
    }

    @Test
    public void illegal_argument_exception_is_returned_for_total_distance_parameter_that_is_negative() {
        int totalDistance = -10;
        int tankRange = 1;
        int[] gasStations = {2, 5, 6};

        try {
            optimalRefuelingCalculatorSolver.calculateMinRefillStops(totalDistance, tankRange, gasStations);
        } catch (IllegalArgumentException e) {
            Assertions.assertEquals(ValidationMessageType.OUT_OF_RANGE_ERROR.getMessage(1, 100000), e.getMessage());
        }
    }

    @Test
    public void illegal_argument_exception_is_returned_for_total_distance_parameter_that_is_more_than_max() {
        int totalDistance = 100001;
        int tankRange = 1;
        int[] gasStations = {2, 5, 6};

        try {
            optimalRefuelingCalculatorSolver.calculateMinRefillStops(totalDistance, tankRange, gasStations);
        } catch (IllegalArgumentException e) {
            Assertions.assertEquals(ValidationMessageType.OUT_OF_RANGE_ERROR.getMessage(1, 100000), e.getMessage());
        }
    }

    @Test
    public void illegal_argument_exception_is_returned_for_max_distance_per_tank_parameter_that_is_zero() {
        int totalDistance = 18;
        int tankRange = 0;
        int[] gasStations = {2, 5, 6};

        try {
            optimalRefuelingCalculatorSolver.calculateMinRefillStops(totalDistance, tankRange, gasStations);
        } catch (IllegalArgumentException e) {
            Assertions.assertEquals(ValidationMessageType.OUT_OF_RANGE_ERROR.getMessage(1, 400), e.getMessage());
        }
    }

    @Test
    public void illegal_argument_exception_is_returned_for_max_distance_per_tank_parameter_that_is_negative() {
        int totalDistance = 18;
        int tankRange = -32;
        int[] gasStations = {2, 5, 6};

        try {
            optimalRefuelingCalculatorSolver.calculateMinRefillStops(totalDistance, tankRange, gasStations);
        } catch (IllegalArgumentException e) {
            Assertions.assertEquals(ValidationMessageType.OUT_OF_RANGE_ERROR.getMessage(1, 400), e.getMessage());
        }
    }

    @Test
    public void illegal_argument_exception_is_returned_for_max_distance_per_tank_parameter_that_is_more_than_max() {
        int totalDistance = 18;
        int tankRange = 401;
        int[] gasStations = {2, 5, 6};

        try {
            optimalRefuelingCalculatorSolver.calculateMinRefillStops(totalDistance, tankRange, gasStations);
        } catch (IllegalArgumentException e) {
            Assertions.assertEquals(ValidationMessageType.OUT_OF_RANGE_ERROR.getMessage(1, 400), e.getMessage());
        }
    }
}
