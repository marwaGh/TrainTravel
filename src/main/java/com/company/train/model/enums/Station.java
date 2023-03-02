package com.company.train.model.enums;

import java.util.Collections;
import java.util.List;

public enum Station {
    A(Collections.singletonList(Zone.ZONE1)),

    B(Collections.singletonList(Zone.ZONE1)),

    C(List.of(Zone.ZONE2, Zone.ZONE3)),


    D(Collections.singletonList(Zone.ZONE2)),


    E(List.of(Zone.ZONE2, Zone.ZONE3)),

    F(List.of(Zone.ZONE3, Zone.ZONE4)),

    G(Collections.singletonList(Zone.ZONE4)),


    H(Collections.singletonList(Zone.ZONE4)),

    I(Collections.singletonList(Zone.ZONE4));

    private final List<Zone> zones;

    Station(List<Zone> zones) {
        this.zones = zones;
    }

    public List<Zone> getZones() {
        return zones;
    }

}
