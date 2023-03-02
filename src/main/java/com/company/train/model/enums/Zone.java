package com.company.train.model.enums;

public enum Zone {

    ZONE1(1),

    ZONE2(2),

    ZONE3(3),

    ZONE4(4);

    private final int code;

    Zone(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

}
