package com.company.train.mapper;

import com.company.train.model.Trip;
import com.company.train.model.enums.Pricing;
import com.company.train.model.enums.Station;

public class TripMapper {

    public Trip mapToTrip(Station stationStart, Station stationEnd, Long timestamp, Pricing pricing) {
        Trip trip = new Trip();
        trip.setStationStart(stationStart);
        trip.setStationEnd(stationEnd);
        trip.setStartedJourneyAt(timestamp);
        trip.setZoneFrom(pricing.getStationFrom());
        trip.setZoneTo(pricing.getStationTo());
        trip.setCostInCents(pricing.getPrice());
        return trip;
    }
}
