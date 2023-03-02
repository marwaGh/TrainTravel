package com.company.train.model.enums;

import java.util.Arrays;
import java.util.Comparator;

import static java.lang.String.format;

public enum Pricing {

    ZONE1_ZONE1(1, 1, 240),

    ZONE1_ZONE2(1, 2, 240),

    ZONE1_ZONE3(1, 3, 280),

    ZONE1_ZONE4(1, 4, 300),

    ZONE2_ZONE1(2, 1, 240),

    ZONE2_ZONE2(2, 2, 240),

    ZONE2_ZONE3(2, 3, 280),

    ZONE2_ZONE4(2, 4, 300),

    ZONE3_ZONE1(3, 1, 280),

    ZONE3_ZONE2(3, 2, 280),

    ZONE3_ZONE3(3, 3, 200),

    ZONE3_ZONE4(3, 4, 200),

    ZONE4_ZONE1(4, 1, 300),

    ZONE4_ZONE2(4, 2, 300),

    ZONE4_ZONE3(4, 3, 200),

    ZONE4_ZONE4(4, 4, 200);


    private final int stationFrom;

    private final int stationTo;

    private final int price;

    Pricing(int stationFrom, int stationTo, int price) {
        this.stationFrom = stationFrom;
        this.stationTo = stationTo;
        this.price = price;
    }

    public int getStationFrom() {
        return stationFrom;
    }

    public int getStationTo() {
        return stationTo;
    }

    public int getPrice() {
        return price;
    }

    public static Pricing getPricingBetweenStations(Station fromStation, Station toStation) {
        return fromStation.getZones().stream()
                .flatMap(
                        from -> toStation.getZones().stream()
                                .map(to -> getPricingFromTwoZones(from.getCode(), to.getCode())
                                )
                )
                .min(Comparator.comparingInt(Pricing::getPrice))
                .orElseThrow(() -> new IllegalStateException(format("No Pricing found from station %s to station %s", fromStation, toStation)));
    }

    public static Pricing getPricingFromTwoZones(int fromZone, int toZone) {
        return Arrays.stream(Pricing.values())
                .filter(pricing -> pricing.stationFrom == fromZone && pricing.stationTo == toZone)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(format("No Pricing found for zone %s to zone %s", fromZone, toZone)));
    }
}
