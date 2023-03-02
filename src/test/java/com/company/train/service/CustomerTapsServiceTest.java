package com.company.train.service;

import com.company.train.model.*;
import com.company.train.model.enums.Station;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.junit.jupiter.api.Test;

import java.util.List;

import static com.company.train.Genrator.CustomerSummariesReportGenerator.getCustomerSummariesReport;
import static com.company.train.Genrator.CustomerSummariesReportGenerator.getCustomerSummary;
import static com.company.train.Genrator.CustomerTapsReportGenerator.getCustomerTapsReport;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class CustomerTapsServiceTest {

    @Test
    void should_getCosAndTripFromTwoTaps() {
        //Given
        Tap tap = new Tap(1L, 1, Station.A);
        Tap nextTap = new Tap(5L, 1, Station.D);
        Trip expectedTrip = new Trip(Station.A, Station.D, 1L, 240, 1, 2);
        ImmutablePair<Integer, Trip> expected = new ImmutablePair<>(240, expectedTrip);
        CustomerTapsService customerTapsService = new CustomerTapsService();
        //When
        ImmutablePair<Integer, Trip> actual = customerTapsService.getCosAndTripFromTwoTaps(tap, nextTap);
        //Then
        assertEquals(expected.left, actual.left);
        assertEquals(expected.right, actual.right);
    }

    @Test
    void should_createCustomerSummary() {
        //Given
        int id = 1;
        Tap tap1 = new Tap(1L, 1, Station.A);
        Tap tap2 = new Tap(2L, 1, Station.D);
        Tap tap3 = new Tap(3L, 1, Station.D);
        Tap tap4 = new Tap(4L, 1, Station.A);
        List<Tap> taps = List.of(tap1, tap2, tap3, tap4);

        CustomerSummary expected = getCustomerSummary();
        CustomerTapsService customerTapsService = new CustomerTapsService();
        //When
        CustomerSummary actual = customerTapsService.createCustomerSummary(id, taps);
        //Then
        assertNotNull(actual);
        assertEquals(expected, actual);
    }

    @Test
    void should_calculateCustomerSummaries() {
        //Given
        CustomerTapsService customerTapsService = new CustomerTapsService();
        CustomersTapsReport customersTapsReport = getCustomerTapsReport();
        CustomerSummariesReport expected = getCustomerSummariesReport();
        //When
        CustomerSummariesReport actual = customerTapsService.calculateCustomerSummaries(customersTapsReport);
        //Then
        assertNotNull(actual);
        assertNotNull(actual.getCustomerSummaries());
        assertEquals(expected.getCustomerSummaries().size(), actual.getCustomerSummaries().size());
        assertEquals(expected.getCustomerSummaries(), actual.getCustomerSummaries());
    }

}