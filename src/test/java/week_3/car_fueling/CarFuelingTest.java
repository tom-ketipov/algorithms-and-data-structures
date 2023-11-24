package week_3.car_fueling;

import org.junit.Assert;
import org.junit.Test;

public class CarFuelingTest {
    private CarFueling carFuelingSolver;

    @Test
    public void can_reach_endpoint_with_minimum_stops_for_valid_route() {
        carFuelingSolver = new CarFueling();

        int distance = 960;
        int tank = 400;
        int[] stops = {200, 375, 550, 750};
        Assert.assertEquals(2, carFuelingSolver.computeMinRefills(distance, tank, stops));
    }

    @Test
    public void cant_reach_endpoint_for_invalid_route() {
        carFuelingSolver = new CarFueling();

        int distance = 10;
        int tank = 3;
        int[] stops = {1, 2, 5, 9};
        Assert.assertEquals(-1, carFuelingSolver.computeMinRefills(distance, tank, stops));
    }

    @Test
    public void cant_reach_endpoint_without_stops() {
        carFuelingSolver = new CarFueling();

        int distance = 200;
        int tank = 250;
        int[] stops = {100, 150};
        Assert.assertEquals(0, carFuelingSolver.computeMinRefills(distance, tank, stops));
    }

    // TODO: Add input validation @Tests
}
