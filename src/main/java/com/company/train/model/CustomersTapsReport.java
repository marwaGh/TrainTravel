package com.company.train.model;

import java.util.List;
import java.util.Objects;

public class CustomersTapsReport {

    private List<Tap> taps;


    public CustomersTapsReport() {
    }

    public List<Tap> getTaps() {
        return taps;
    }

    public void setTaps(List<Tap> taps) {
        this.taps = taps;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CustomersTapsReport that)) return false;
        return taps.equals(that.taps);
    }

    @Override
    public int hashCode() {
        return Objects.hash(taps);
    }
}
