package com.company.train.validator;

import com.company.train.model.Tap;
import com.company.train.model.enums.Station;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TapsFileValidatorTest {

    @Test
    void should_validateTaps() {
        //Given
        TapsFileValidator tapsFileValidator = new TapsFileValidator();
        Tap tap1 = new Tap(1L, 1, Station.A);
        Tap tap2 = new Tap(2L, 1, Station.D);
        Tap tap3 = new Tap(3L, 2, Station.H);
        Tap tap4 = new Tap(5L, 2, Station.B);
        List<Tap> taps = List.of(tap1, tap2, tap3, tap4);
        //When/Then
        tapsFileValidator.validateTaps(taps);
    }

    @Test
    void should_throwExceptionWhenMissingTaps() {
        //Given
        TapsFileValidator tapsFileValidator = new TapsFileValidator();
        //When/Then
        assertThrows(RuntimeException.class, () ->
                tapsFileValidator.validateTaps(null), "Missing taps");
    }

    @Test
    void should_throwExceptionWhenTotalTapsSizeIsOdd() {
        //Given
        TapsFileValidator tapsFileValidator = new TapsFileValidator();
        Tap tap1 = new Tap(1L, 1, Station.A);
        Tap tap2 = new Tap(5L, 2, Station.B);
        Tap tap3 = new Tap(3L, 2, Station.H);

        List<Tap> taps = List.of(tap1, tap2, tap3);
        //When/Then
        assertThrows(RuntimeException.class, () ->
                tapsFileValidator.validateTaps(taps), "Taps size should be even");
    }

    @Test
    void should_throwExceptionWhenACustomerTapsSizeIsOdd() {
        //Given
        TapsFileValidator tapsFileValidator = new TapsFileValidator();
        Tap tap1 = new Tap(1L, 1, Station.A);
        Tap tap2 = new Tap(3L, 2, Station.H);

        List<Tap> taps = List.of(tap1, tap2);
        //When/Then
        assertThrows(RuntimeException.class, () ->
                tapsFileValidator.validateTaps(taps), "Missing tap for customer 1");
    }

    @Test
    void should_throwExceptionWhenMissingCustomerId() {
        //Given
        TapsFileValidator tapsFileValidator = new TapsFileValidator();
        Tap tap1 = new Tap(1L, null, Station.A);
        Tap tap2 = new Tap(2L, 1, Station.D);

        List<Tap> taps = List.of(tap1, tap2);
        //When/Then
        assertThrows(RuntimeException.class, () ->
                tapsFileValidator.validateTaps(taps), "Missing customer Id.");
    }

    @Test
    void should_throwExceptionWhenMissingTimestamp() {
        //Given
        TapsFileValidator tapsFileValidator = new TapsFileValidator();
        Tap tap1 = new Tap(null, 1, Station.B);
        Tap tap2 = new Tap(2L, 1, Station.D);

        List<Tap> taps = List.of(tap1, tap2);
        //When/Then
        assertThrows(RuntimeException.class, () ->
                tapsFileValidator.validateTaps(taps), "Missing unixTimestamp for tap of customer with id 1");
    }

    @Test
    void should_throwExceptionWhenMissingStation() {
        //Given
        TapsFileValidator tapsFileValidator = new TapsFileValidator();
        Tap tap1 = new Tap(1L, 1, null);
        Tap tap2 = new Tap(2L, 1, Station.D);

        List<Tap> taps = List.of(tap1, tap2);
        //When/Then
        assertThrows(RuntimeException.class, () ->
                tapsFileValidator.validateTaps(taps), "Missing station for tap of customer with id 1 and unixTimestamp 1L");
    }

    @Test
    void should_checkIfTapsSizeIsOdd() {
        //Given
        TapsFileValidator tapsFileValidator = new TapsFileValidator();
        Tap tap1 = new Tap(1L, 1, Station.B);
        Tap tap2 = new Tap(2L, 1, Station.D);
        List<Tap> taps1 = List.of(tap1, tap2);
        List<Tap> taps2 = List.of(tap1);

        //When/Then
        assertTrue(tapsFileValidator.isTapsSizeOdd(taps2));
        assertFalse(tapsFileValidator.isTapsSizeOdd(taps1));

    }
}