package com.corelogic.condosafe.staging.sources;

public enum LandingSourceType {

    EXCEL(1),
    ACCESS(2),
    CSV(3),
    TXT(4);

    private final int seq;

    private LandingSourceType(int sequence) {
        this.seq = sequence;
    }

    public int sequence() {
        return seq;
    }

}
