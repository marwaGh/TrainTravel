package com.company;

import com.company.train.model.CustomerSummariesReport;
import com.company.train.model.CustomersTapsReport;
import com.company.train.service.CustomerTapsService;
import com.company.train.mapper.FileMapper;
import com.company.train.validator.TapsFileValidator;
import com.fasterxml.jackson.databind.ObjectMapper;

public class TrainTravelApp {
    public static void main(String[] args) {
        if (args == null || args.length == 0) {
            throw new IllegalArgumentException("Missing both input and output files paths.");
        } else if (args.length == 1) {
            throw new IllegalArgumentException("Missing output file path.");
        }

        ObjectMapper objectMapper = new ObjectMapper();
        FileMapper fileMapper = new FileMapper();

        CustomersTapsReport tapsReport = fileMapper.getCustomerTapsReportFromInputFile(args[0], objectMapper);

        TapsFileValidator tapsFileValidator = new TapsFileValidator();
        tapsFileValidator.validateTaps(tapsReport.getTaps());

        CustomerTapsService customerTapsService = new CustomerTapsService();
        CustomerSummariesReport customerSummariesReport = customerTapsService.calculateCustomerSummaries(tapsReport);

        fileMapper.writeCustomerSummaries(args[1], objectMapper, customerSummariesReport);
    }


}