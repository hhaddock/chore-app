package com.atlas.menter.constant;

public enum ChoreFrequency {
    DAILY("Daily"),
    WEEKLY("Weekly"),
    MONTHLY("Monthly"),
    QUARTERLY("Quarterly"),
    YEARLY("Yearly");

    public final String label;

    private ChoreFrequency(String label) {
        this.label = label;
    }
}
