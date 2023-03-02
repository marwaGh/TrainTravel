package com.company.train.model;

import com.company.train.model.enums.Station;

import java.util.Objects;

public class Tap {

    private Long unixTimestamp;

    private Integer customerId;

    private Station station;

    public Tap() {
    }

    public Tap(Long unixTimestamp, Integer customerId, Station station) {
        this.unixTimestamp = unixTimestamp;
        this.customerId = customerId;
        this.station = station;
    }

    public Long getUnixTimestamp() {
        return unixTimestamp;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public Station getStation() {
        return station;
    }


    public void setUnixTimestamp(Long unixTimestamp) {
        this.unixTimestamp = unixTimestamp;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public void setStation(Station station) {
        this.station = station;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tap tap = (Tap) o;
        return unixTimestamp.equals(tap.unixTimestamp) && customerId.equals(tap.customerId) && station == tap.station;
    }

    @Override
    public int hashCode() {
        return Objects.hash(unixTimestamp, customerId, station);
    }
}
