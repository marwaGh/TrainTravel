package com.company.train.validator;

import com.company.train.exceptions.TrainTravelException;
import com.company.train.model.Tap;

import java.util.List;
import java.util.stream.Collectors;

import static com.company.train.model.enums.TapsValidationExceptionType.*;
import static java.lang.String.format;
import static java.util.Objects.isNull;

public class TapsFileValidator {

    public void validateTaps(List<Tap> taps) {
        if (isNull(taps)) {
            throw new TrainTravelException(MISSING_TAPS);
        }
        if (isTapsSizeOdd(taps)) {
            throw new TrainTravelException(INVALID_TOTAL_TAPS_SIZE);
        }
        taps.stream()
                .collect(Collectors.groupingBy(Tap::getCustomerId))
                .forEach((customersId, tapsList) -> {
                    if (isTapsSizeOdd(tapsList)) {
                        String message = format("Missing tap for customer %s", customersId);
                        throw new TrainTravelException(INVALID_CUSTOMER_TAPS_SIZE, message);
                    }
                    tapsList.forEach(this::validateTap);
                });
    }

    public boolean isTapsSizeOdd(List<Tap> taps) {
        return taps.size() % 2 != 0;
    }

    private void validateTap(Tap tap) {
        if (isNull(tap.getCustomerId())) {
            throw new TrainTravelException(MISSING_CUSTOMER_ID);
        }

        if (isNull(tap.getUnixTimestamp())) {
            String message = format("Missing unixTimestamp for tap of customer with id %s", tap.getCustomerId());
            throw new TrainTravelException(MISSING_STATION, message);
        }

        if (isNull(tap.getStation())) {
            String message = format("Missing station for tap of customer with id %s and unixTimestamp %s", tap.getCustomerId(), tap.getUnixTimestamp());
            throw new TrainTravelException(MISSING_STATION, message);
        }
    }

}
