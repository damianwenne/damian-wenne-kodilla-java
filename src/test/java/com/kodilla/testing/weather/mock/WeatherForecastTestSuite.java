package com.kodilla.testing.weather.mock;

import com.kodilla.testing.weather.stub.Temperatures;
import org.junit.Test;

import static org.mockito.Mockito.mock;

public class WeatherForecastTestSuite {
    @Test
    public void testCalculateForectastWithMock() {
        //Given
        Temperatures temperaturesMock = mock(Temperatures.class);

    }
}
