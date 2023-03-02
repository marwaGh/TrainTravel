package com.company.train.mapper;

import com.company.train.model.Trip;
import com.company.train.model.enums.Pricing;
import com.company.train.model.enums.Station;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class TripMapperTest {

    @Test
    void mapToTrip() {
        //Given
        Station stationStart = Station.A;
        Station stationEnd = Station.D;
        Long timestamp = 1L;
        Pricing pricing = Pricing.ZONE1_ZONE2;
        Trip expected = new Trip(Station.A, Station.D, timestamp, pricing.getPrice(), 1, 2);
        TripMapper tripMapper = new TripMapper();
        //When
        Trip actual = tripMapper.mapToTrip(stationStart, stationEnd, timestamp, pricing);
        //Then
        assertNotNull(actual);
        assertEquals(expected, actual);
    }
}