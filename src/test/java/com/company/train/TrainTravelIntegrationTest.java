package com.company.train;


import com.company.TrainTravelApp;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import static org.junit.jupiter.api.Assertions.assertLinesMatch;
import static org.junit.jupiter.api.Assertions.assertThrows;

class TrainTravelIntegrationTest {
    @Test
    void should_generateCustomerSummariesReport() throws IOException {
        //Given
        String expectedPath = "src/test/resources/ExpectedOutputExample.txt";
        String outputPath = "src/test/resources/OutputExample.txt";
        String inputFilePath = "src/test/resources/CandidateInputExample.txt";
        String[] args = {inputFilePath, outputPath};
        //When
        TrainTravelApp.main(args);
        //Then
        File expected = new File(expectedPath);
        File output = new File(outputPath);
        assertLinesMatch(Files.lines(expected.toPath()), Files.lines(output.toPath()));
    }

    @Test
    void should_throwExceptionWhenMissingOutputFile() {
        //Given
        String inputFilePath = "src/test/resources/CandidateInputExample.txt";
        String[] args = {inputFilePath};
        //When/Then
        assertThrows(IllegalArgumentException.class, () -> TrainTravelApp.main(args), "Missing output file path.");
    }

    @Test
    void should_throwExceptionWhenMissingAllArguments() {
        //Given
        String[] args = {};
        //When/Then
        assertThrows(IllegalArgumentException.class, () -> TrainTravelApp.main(args), "Missing both input and output files paths.");
    }
}