package com.company.train.service;

import com.company.train.mapper.TripMapper;
import com.company.train.model.*;
import com.company.train.model.enums.Pricing;
import com.company.train.model.enums.Station;
import org.apache.commons.lang3.tuple.ImmutablePair;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CustomerTapsService {

    public CustomerSummariesReport calculateCustomerSummaries(CustomersTapsReport tapsReport) {

        List<CustomerSummary> customerSummaries = new ArrayList<>();
        tapsReport.getTaps()
                .stream()
                .collect(Collectors.groupingBy(Tap::getCustomerId))
                .forEach((id, taps) -> {
                    CustomerSummary customerSummary = createCustomerSummary(id, taps);
                    customerSummaries.add(customerSummary);
                });

        return new CustomerSummariesReport(customerSummaries);
    }

    public CustomerSummary createCustomerSummary(Integer id, List<Tap> taps) {
        int tapsSize = taps.size();
        int totalCostInCents = 0;
        List<Trip> trips = new ArrayList<>();
        for (int i = 0; i < tapsSize; i += 2) {
            Tap tap = taps.get(i);
            Tap nextTap = taps.get(i + 1);
            ImmutablePair<Integer, Trip> totalCostAndTrips = getCosAndTripFromTwoTaps(tap, nextTap);
            totalCostInCents += totalCostAndTrips.left;
            trips.add(totalCostAndTrips.right);
        }
        return new CustomerSummary(id, totalCostInCents, trips);

    }

    public ImmutablePair<Integer, Trip> getCosAndTripFromTwoTaps(Tap tap, Tap nextTap) {
        Station stationFrom = tap.getStation();
        Station stationTo = nextTap.getStation();

        Pricing pricing = Pricing.getPricingBetweenStations(stationFrom, stationTo);
        int cost = pricing.getPrice();

        Trip trip =  new TripMapper().mapToTrip(stationFrom, stationTo, tap.getUnixTimestamp(), pricing);

        return new ImmutablePair<>(cost, trip);
    }
}
