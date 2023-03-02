package com.company.train.Genrator;

import com.company.train.model.CustomersTapsReport;
import com.company.train.model.Tap;
import com.company.train.model.enums.Station;

import java.util.ArrayList;
import java.util.List;

public class CustomerTapsReportGenerator {

    public static CustomersTapsReport getCustomerTapsReport() {
        CustomersTapsReport customerTapsReport = new CustomersTapsReport();

        Tap tap1 = new Tap(1L,1, Station.A);
        Tap tap2 = new Tap(2L,1, Station.D);
        Tap tap3 = new Tap(3L,1, Station.D);
        Tap tap4 = new Tap(4L,1, Station.A);
        Tap tap5 = new Tap(1L,2, Station.E);
        Tap tap6 = new Tap(2L,2, Station.H);

        List<Tap> taps = new ArrayList<>(List.of(tap1, tap2, tap3, tap4, tap5, tap6));
        customerTapsReport.setTaps(taps);
        return customerTapsReport;
    }
}
