package com.company.train.mapper;

import com.company.train.exceptions.TrainTravelException;
import com.company.train.model.CustomerSummariesReport;
import com.company.train.model.CustomersTapsReport;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;

import static com.company.train.model.enums.TapsValidationExceptionType.INPUT_FILE_PARSING_ERROR;
import static com.company.train.model.enums.TapsValidationExceptionType.OUTPUT_FILE_WRITING_ERROR;

public class FileMapper {
    public CustomersTapsReport getCustomerTapsReportFromInputFile(String inputFilePath, ObjectMapper objectMapper) {
        try {
            File inputFile = new File(inputFilePath);
            return objectMapper.readValue(inputFile, CustomersTapsReport.class);
        } catch (Exception e) {
            throw new TrainTravelException(INPUT_FILE_PARSING_ERROR, e);
        }
    }

    public  void writeCustomerSummaries(String outputFilePath, ObjectMapper objectMapper, CustomerSummariesReport customerSummariesReport) {
        try {
            File outputFile = new File(outputFilePath);
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(outputFile, customerSummariesReport);
        } catch (Exception e) {
            throw new TrainTravelException(OUTPUT_FILE_WRITING_ERROR, e);
        }
    }
}
