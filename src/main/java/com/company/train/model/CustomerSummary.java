package com.company.train.model;

import java.util.List;
import java.util.Objects;

public class CustomerSummary {

    private Integer customerId;

    private Integer totalCostInCents;

    private List<Trip> trips;

    public CustomerSummary() {
    }

    public CustomerSummary(Integer customerId, Integer totalCostInCents, List<Trip> trips) {
        this.customerId = customerId;
        this.totalCostInCents = totalCostInCents;
        this.trips = trips;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public Integer getTotalCostInCents() {
        return totalCostInCents;
    }

    public List<Trip> getTrips() {
        return trips;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CustomerSummary that)) return false;
        return customerId.equals(that.customerId) && totalCostInCents.equals(that.totalCostInCents) && trips.equals(that.trips);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerId, totalCostInCents, trips);
    }
}
