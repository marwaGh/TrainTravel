package com.company.train.Genrator;

import com.company.train.model.CustomerSummariesReport;
import com.company.train.model.CustomerSummary;
import com.company.train.model.Trip;
import com.company.train.model.enums.Station;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CustomerSummariesReportGenerator {

    public static CustomerSummariesReport getCustomerSummariesReport() {
        Trip trip1 = new Trip(Station.A, Station.D, 1L, 240, 1, 2);
        Trip trip2 = new Trip(Station.D, Station.A, 3L, 240, 2, 1);
        Trip trip3 = new Trip(Station.E, Station.H, 1L, 200, 3, 4);

        List<Trip> trips1 = new ArrayList<>(List.of(trip1, trip2));
        List<Trip> trips2 = new ArrayList<>(Collections.singletonList(trip3));

        CustomerSummary customerSummary1 = new CustomerSummary(1, 480, trips1);
        CustomerSummary customerSummary2 = new CustomerSummary(2, 200, trips2);

        List<CustomerSummary> customerSummaries = new ArrayList<>(List.of(customerSummary1, customerSummary2));

        CustomerSummariesReport customerSummariesReport = new CustomerSummariesReport();
        customerSummariesReport.setCustomerSummaries(customerSummaries);

        return customerSummariesReport;
    }

    public static CustomerSummary getCustomerSummary() {
        Trip trip1 = new Trip(Station.A, Station.D, 1L, 240, 1, 2);
        Trip trip2 = new Trip(Station.D, Station.A, 3L, 240, 2, 1);

        List<Trip> trips1 = new ArrayList<>(List.of(trip1, trip2));

        return new CustomerSummary(1, 480, trips1);

    }
}
