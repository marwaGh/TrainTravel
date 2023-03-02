package com.company.train.model.enums;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class PricingTest {
    static Stream<Arguments> arguments() {
        return Stream.of(
                Arguments.of(1, 1, 240),
                Arguments.of(1, 2, 240),
                Arguments.of(1, 3, 280),
                Arguments.of(1, 4, 300),
                Arguments.of(2, 1, 240),
                Arguments.of(2, 2, 240),
                Arguments.of(2, 3, 280),
                Arguments.of(2, 4, 300),
                Arguments.of(3, 1, 280),
                Arguments.of(3, 2, 280),
                Arguments.of(3, 3, 200),
                Arguments.of(3, 4, 200),
                Arguments.of(4, 1, 300),
                Arguments.of(4, 2, 300),
                Arguments.of(4, 3, 200),
                Arguments.of(4, 4, 200)

        );
    }

    @ParameterizedTest
    @MethodSource("arguments")
    void should_ValidatePriceByZones(int fromZone, int toZone, int price) {
        Pricing pricing = Pricing.getPricingFromTwoZones(fromZone, toZone);
        assertEquals(price, pricing.getPrice());
    }

    @Test
    void should_CheckPrincingElementsNumber() {
        assertEquals(16, Pricing.values().length);
    }

    @Test
    void should_GetPricingFromStations() {
        //Given
        int fromZone = 1;
        int toZone = 3;
        //When
        Pricing actual = Pricing.getPricingFromTwoZones(fromZone, toZone);
        //Then
        assertEquals(Pricing.ZONE1_ZONE3, actual);
    }

    @Test
    void should_ThrowExceptionWhenPricingFromStationsNotFound() {
        //Given
        int fromZone = 1;
        int toZone = 5;
        //When/Then
        assertThrows(IllegalArgumentException.class, () -> Pricing.getPricingFromTwoZones(fromZone, toZone),
                "No Pricing found for zone 1 to zone 5");
    }

    @Test
    void should_GetMinimumPricingBetweenStationsOfSameZone() {
        //Given
        Station fromStation = Station.A;
        Station toStation = Station.B;
        //When
        Pricing actual = Pricing.getPricingBetweenStations(fromStation, toStation);
        //Then
        assertEquals(Pricing.ZONE1_ZONE1, actual);
    }

    @Test
    void should_GetMinimumPricingBetweenStationsOfDifferentZones() {
        //Given
        Station fromStation = Station.A;
        Station toStation = Station.D;
        //When
        Pricing actual = Pricing.getPricingBetweenStations(fromStation, toStation);
        //Then
        assertEquals(Pricing.ZONE1_ZONE2, actual);
    }

    @Test
    void should_GetMinimumPricingBetweenStationsWithFromZoneOverlap() {
        //Given
        Station fromStation = Station.C;
        Station toStation = Station.A;
        //When
        Pricing actual = Pricing.getPricingBetweenStations(fromStation, toStation);
        //Then
        assertEquals(Pricing.ZONE2_ZONE1, actual);
    }

    @Test
    void should_GetMinimumPricingBetweenStationsWithToZoneOverlap() {
        //Given
        Station fromStation = Station.A;
        Station toStation = Station.C;
        //When
        Pricing actual = Pricing.getPricingBetweenStations(fromStation, toStation);
        //Then
        assertEquals(Pricing.ZONE1_ZONE2, actual);
    }


    @Test
    void should_GetMinimumPricingBetweenStationsWithBothZonesOverlaps() {
        //Given
        Station fromStation = Station.F;
        Station toStation = Station.C;
        //When
        Pricing actual = Pricing.getPricingBetweenStations(fromStation, toStation);
        //Then
        assertEquals(Pricing.ZONE3_ZONE3, actual);
    }

}