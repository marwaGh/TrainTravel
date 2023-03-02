package com.company.train.mapper;

import com.company.train.model.CustomerSummariesReport;
import com.company.train.model.CustomersTapsReport;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import static com.company.train.Genrator.CustomerSummariesReportGenerator.getCustomerSummariesReport;
import static com.company.train.Genrator.CustomerTapsReportGenerator.getCustomerTapsReport;
import static org.junit.jupiter.api.Assertions.*;


class FileMapperTest {

    @Test
    void should_getCustomerTapsReportFromInputFile() {
        //Given
        String inputFilePath = "src/test/resources/filemapper/InputExample.txt";
        CustomersTapsReport expectedCustomerTapsReport = getCustomerTapsReport();
        FileMapper fileMapper = new FileMapper();
        ObjectMapper objectMapper = new ObjectMapper();
        //When
        CustomersTapsReport actualTapsReport = fileMapper.getCustomerTapsReportFromInputFile(inputFilePath, objectMapper);
        //Then
        assertNotNull(actualTapsReport);
        assertNotNull(actualTapsReport.getTaps());
        assertEquals(expectedCustomerTapsReport.getTaps().size(), actualTapsReport.getTaps().size());
        assertTrue(expectedCustomerTapsReport.getTaps().containsAll(actualTapsReport.getTaps()));
    }

    @Test
    void should_throwExceptionWhenGetCustomerTapsReportFromMissingInputFilePath() {
        //Given
        String inputFilePath = "src/test/resources/missing.txt";
        FileMapper fileMapper = new FileMapper();
        ObjectMapper objectMapper = new ObjectMapper();
        //When/Then
        assertThrows(RuntimeException.class, () ->
                fileMapper.getCustomerTapsReportFromInputFile(inputFilePath, objectMapper), "Error while parsing input file");
    }

    @Test
    void should_throwExceptionWhenGetCustomerTapsReportFromMalFormedFile() {
        //Given
        ObjectMapper objectMapper = new ObjectMapper();
        String inputFilePath = "src/test/resources/filemapper/MalFormedInputExample.txt";
        FileMapper fileMapper = new FileMapper();
        //When/Then
        assertThrows(RuntimeException.class, () ->
                fileMapper.getCustomerTapsReportFromInputFile(inputFilePath, objectMapper), "Error while parsing input file");
    }

    @Test
    void should_throwExceptionWhenGetCustomerTapsReportFromInputFilePathWithUnknownStation() {
        //Given
        ObjectMapper objectMapper = new ObjectMapper();
        String inputFilePath = "src/test/resources/filemapper/InputExampleWithUnknownStation.txt";
        FileMapper fileMapper = new FileMapper();
        //When/Then
        assertThrows(RuntimeException.class, () ->
                fileMapper.getCustomerTapsReportFromInputFile(inputFilePath, objectMapper), "Error while parsing input file");
    }

    @Test
    void should_writeCustomerSummaries() throws IOException {
        //Given
        String expectedOutputFilePath = "src/test/resources/filemapper/ExpectedCustomerSummaries.txt";
        String outputPath = "src/test/resources/filemapper/OutputSummaries.txt";
        CustomerSummariesReport customerSummariesReport = getCustomerSummariesReport();
        FileMapper fileMapper = new FileMapper();
        ObjectMapper objectMapper = new ObjectMapper();
        //When
        fileMapper.writeCustomerSummaries(outputPath, objectMapper, customerSummariesReport);
        //Then
        File expected = new File(expectedOutputFilePath);
        File output = new File(outputPath);
        assertLinesMatch(Files.lines(expected.toPath()), Files.lines(output.toPath()));
    }

    @Test
    void should_throwExceptionWhenWriteCustomerSummariesWhereNotFoundOutputFile() {
        //Given
        String outputPath = "resources/OutputSummaries.txt";
        FileMapper fileMapper = new FileMapper();
        ObjectMapper objectMapper = new ObjectMapper();
        CustomerSummariesReport customerSummariesReport = getCustomerSummariesReport();
        //When/Then
        assertThrows(RuntimeException.class, () ->
                fileMapper.writeCustomerSummaries(outputPath, objectMapper, customerSummariesReport), "Error while writing output file");
    }


}