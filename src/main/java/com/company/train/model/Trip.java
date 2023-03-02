package com.company.train.model;

import com.company.train.model.enums.Station;

import java.util.Objects;

public class Trip {

    private Station stationStart;

    private Station stationEnd;

    private Long startedJourneyAt;

    private Integer costInCents;

    private Integer zoneFrom;

    private Integer zoneTo;

    public Trip() {
    }

    public Trip(Station stationStart, Station stationEnd, Long startedJourneyAt, Integer costInCents, Integer zoneFrom, Integer zoneTo) {
        this.stationStart = stationStart;
        this.stationEnd = stationEnd;
        this.startedJourneyAt = startedJourneyAt;
        this.costInCents = costInCents;
        this.zoneFrom = zoneFrom;
        this.zoneTo = zoneTo;
    }

    public Station getStationStart() {
        return stationStart;
    }

    public void setStationStart(Station stationStart) {
        this.stationStart = stationStart;
    }

    public Station getStationEnd() {
        return stationEnd;
    }

    public void setStationEnd(Station stationEnd) {
        this.stationEnd = stationEnd;
    }

    public Long getStartedJourneyAt() {
        return startedJourneyAt;
    }

    public void setStartedJourneyAt(Long startedJourneyAt) {
        this.startedJourneyAt = startedJourneyAt;
    }

    public Integer getCostInCents() {
        return costInCents;
    }

    public void setCostInCents(Integer costInCents) {
        this.costInCents = costInCents;
    }

    public Integer getZoneFrom() {
        return zoneFrom;
    }

    public void setZoneFrom(Integer zoneFrom) {
        this.zoneFrom = zoneFrom;
    }

    public Integer getZoneTo() {
        return zoneTo;
    }

    public void setZoneTo(Integer zoneTo) {
        this.zoneTo = zoneTo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Trip trip)) return false;
        return getStationStart() == trip.getStationStart() && getStationEnd() == trip.getStationEnd() && getStartedJourneyAt().equals(trip.getStartedJourneyAt()) && getCostInCents().equals(trip.getCostInCents()) && getZoneFrom().equals(trip.getZoneFrom()) && getZoneTo().equals(trip.getZoneTo());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getStationStart(), getStationEnd(), getStartedJourneyAt(), getCostInCents(), getZoneFrom(), getZoneTo());
    }
}
