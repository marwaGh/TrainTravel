package com.company.train.model;

import java.util.List;
import java.util.Objects;

public class CustomerSummariesReport {

    private List<CustomerSummary> customerSummaries;

    public CustomerSummariesReport() {
    }

    public CustomerSummariesReport(List<CustomerSummary> customerSummaries) {
        this.customerSummaries = customerSummaries;
    }

    public List<CustomerSummary> getCustomerSummaries() {
        return customerSummaries;
    }

    public void setCustomerSummaries(List<CustomerSummary> customerSummaries) {
        this.customerSummaries = customerSummaries;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CustomerSummariesReport that)) return false;
        return getCustomerSummaries().equals(that.getCustomerSummaries());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCustomerSummaries());
    }
}
